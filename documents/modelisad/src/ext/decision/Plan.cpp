/**
 * @file ext/decision/Plan.cpp
 * @author The VLE Development Team
 * See the AUTHORS or Authors.txt file
 */

/*
 * VLE Environment - the multimodeling and simulation environment
 * This file is a part of the VLE environment
 * http://www.vle-project.org
 *
 * Copyright (C) 2007-2010 INRA http://www.inra.fr
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


#include <ext/decision/Plan.hpp>
#include <ext/decision/KnowledgeBase.hpp>
#include <vle/utils/Parser.hpp>
#include <vle/utils/Debug.hpp>
#include <vle/utils/i18n.hpp>
#include <vle/utils/DateTime.hpp>
#include <string>
#include <istream>

namespace modelisad { namespace extension { namespace decision {

typedef vle::utils::Block UB;
typedef vle::utils::Block::Blocks UBB;
typedef vle::utils::Block::Strings UBS;
typedef vle::utils::Block::Reals UBR;

Plan::Plan(KnowledgeBase& kb, const std::string& buffer)
    : mKb(kb)
{
    try {
        std::istringstream in(buffer);
        vle::utils::Parser parser(in);
        fill(parser.root());
    } catch (const std::exception& e) {
        throw vle::utils::ArgError(vle::fmt(_("Decision plan error in %1%")) % e.what());
    }
}

Plan::Plan(KnowledgeBase& kb, std::istream& stream)
    : mKb(kb)
{
    try {
        vle::utils::Parser parser(stream);
        fill(parser.root());
    } catch (const std::exception& e) {
        throw vle::utils::ArgError(vle::fmt(_("Decision plan error: %1%")) % e.what());
    }
}

void Plan::fill(const std::string& buffer)
{
    try {
        std::istringstream in(buffer);
        vle::utils::Parser parser(in);
        fill(parser.root());
    } catch (const std::exception& e) {
        throw vle::utils::ArgError(vle::fmt(_("Decision plan error in %1%")) % e.what());
    }
}

void Plan::fill(std::istream& stream)
{
    try {
        vle::utils::Parser parser(stream);
        fill(parser.root());
    } catch (const std::exception& e) {
        throw vle::utils::ArgError(vle::fmt(_("Decision plan error: %1%")) % e.what());
    }
}

void Plan::fill(const vle::utils::Block& root)
{
    vle::utils::Block::BlocksResult mainrules, mainactivities, mainprecedences;

    mainrules = root.blocks.equal_range("rules");
    mainactivities = root.blocks.equal_range("activities");
    mainprecedences = root.blocks.equal_range("precedences");

    vle::utils::Block::Blocks::const_iterator it;

    for (it = mainrules.first; it != mainrules.second; ++it) {
        vle::utils::Block::BlocksResult rules;
        rules = it->second.blocks.equal_range("rule");
        fillRules(rules);
    }

    for (it = mainactivities.first; it != mainactivities.second; ++it) {
        vle::utils::Block::BlocksResult activities;
        activities = it->second.blocks.equal_range("activity");
        fillActivities(activities);
        vle::utils::Block::BlocksResult seqActivities;
        seqActivities = it->second.blocks.equal_range("sequence-activity");
        fillActivitiesSequence(seqActivities);
    }

    for (it = mainprecedences.first; it != mainprecedences.second; ++it) {
        vle::utils::Block::BlocksResult precedences;
        precedences = it->second.blocks.equal_range("precedence");
        fillPrecedences(precedences);
    }
}

void Plan::fillRules(const vle::utils::Block::BlocksResult& rules)
{
    for (UBB::const_iterator it = rules.first; it != rules.second; ++it) {
        const vle::utils::Block& block = it->second;

        UB::StringsResult id = block.strings.equal_range("id");
        if (id.first == id.second) {
            throw vle::utils::ArgError(_("Decision: rule needs id"));
        }

        Rule& rule = mRules.add(id.first->second);
        UB::StringsResult preds = block.strings.equal_range("predicates");

        for (UB::Strings::const_iterator jt = preds.first;
             jt != preds.second; ++jt) {
            rule.add((mKb.predicates().get(jt->second))->second);
        }
    }
}

void Plan::fillActivities(const vle::utils::Block::BlocksResult& acts)
{
    for (UBB::const_iterator it = acts.first; it != acts.second; ++it) {
        const vle::utils::Block& block = it->second;

        UB::StringsResult id = block.strings.equal_range("id");
        if (id.first == id.second) {
            throw vle::utils::ArgError(_("Decision: activity needs id"));
        }

        Activity& act = mActivities.add(id.first->second, Activity());

        UB::StringsResult rules = block.strings.equal_range("rules");
        for (UBS::const_iterator jt = rules.first; jt != rules.second; ++jt) {
            act.addRule(jt->second, mRules.get(jt->second));
        }

        UB::StringsResult rulesFail = block.strings.equal_range("rules-fail");
        for (UBS::const_iterator jt = rulesFail.first; jt != rulesFail.second; ++jt) {
            act.addRuleFailure(jt->second, mRules.get(jt->second));
        }

        UB::StringsResult ack = block.strings.equal_range("ack");
        if (ack.first != ack.second) {
            act.addAcknowledgeFunction((mKb.acknowledgeFunctions().get(
                        ack.first->second))->second);
        }

        UB::StringsResult out = block.strings.equal_range("output");
        if (out .first != out.second) {
            act.addOutputFunction((mKb.outputFunctions().get(
                        out.first->second))->second);
        }

        UB::StringsResult upd = block.strings.equal_range("update");
        if (upd.first != upd.second) {
            act.addUpdateFunction((mKb.updateFunctions().get(
                        upd.first->second))->second);
        }

        UB::BlocksResult temporal = block.blocks.equal_range("temporal");
        if (temporal.first != temporal.second) {
            fillTemporal(temporal, act);
        }
    }
}

void Plan::fillActivitiesSequence(const vle::utils::Block::BlocksResult& acts)
{
    for (UBB::const_iterator it = acts.first; it != acts.second; ++it) {
        const vle::utils::Block& block = it->second;

        UB::StringsResult id = block.strings.equal_range("id-prefix");
        if (id.first == id.second) {
            throw vle::utils::ArgError(_("Decision: sequence of activities needs "
                "an id-prefix"));
        }
        std::string idPrefix = id.first->second;
        std::stringstream idFirstActivity;
        idFirstActivity << idPrefix << "_1";

        Activity& act = mActivities.add(idFirstActivity.str(), Activity());
        vle::value::Map& params = act.parameters().addMap("__internal");

        UB::RealsResult number = block.reals.equal_range("number");
        bool hasNumber = (number.first != number.second);
        if (hasNumber) {
            params.addInt("recNumber", (int)number.first->second);
        } else {
            params.addInt("recNumber", -1);//Infinite recursion
        }

        UB::StringsResult rules = block.strings.equal_range("rules");
        for (UBS::const_iterator jt = rules.first; jt != rules.second; ++jt) {
            act.addRule(jt->second, mRules.get(jt->second));
        }

        UB::StringsResult rulesFail = block.strings.equal_range("rules-fail");
        for (UBS::const_iterator jt = rulesFail.first; jt != rulesFail.second; ++jt) {
            act.addRuleFailure(jt->second, mRules.get(jt->second));
        }

        UB::StringsResult ack = block.strings.equal_range("ack");
        if (ack.first != ack.second) {
            act.addAcknowledgeFunction((mKb.acknowledgeFunctions().get(
                        ack.first->second))->second);
        }

        UB::StringsResult out = block.strings.equal_range("output");
        if (out .first != out.second) {
            act.addOutputFunction((mKb.outputFunctions().get(
                        out.first->second))->second);
        }

        UB::StringsResult upd = block.strings.equal_range("update");
        if (upd.first != upd.second) {
            act.addUpdateFunction((mKb.updateFunctions().get(
                        upd.first->second))->second);
        }

        UB::BlocksResult temporal = block.blocks.equal_range("temporal");
        if (temporal.first != temporal.second) {
            fillTemporal(temporal, act);
        }
        UB::BlocksResult temporalSeq =
           block.blocks.equal_range("temporal-sequence");
        if (temporalSeq.first != temporalSeq.second) {
            fillTemporalSequence(temporalSeq, act);
        }
    }
}


void Plan::fillTemporal(const vle::utils::Block::BlocksResult& temps,
                        Activity& activity)
{
    for (UBB::const_iterator it = temps.first; it != temps.second; ++it) {
        const vle::utils::Block& block = it->second;
        DateResult start = getDate("start",block);
        DateResult mins = getDate("minstart",block);
        DateResult maxs = getDate("maxstart",block);
        DateResult finish = getDate("finish",block);
        DateResult minf = getDate("minfinish",block);
        DateResult maxf = getDate("maxfinish",block);

        if (start.first) {
            if (finish.first) {
                activity.initStartTimeFinishTime(start.second, finish.second);
            } else {
                double vmin, vmax;
                if (minf.first) {
                    if (maxf.first) {
                        vmin = minf.second;
                        vmax = maxf.second;
                    } else {
                        vmin = minf.second;
                        vmax = vle::devs::Time::infinity;
                    }
                } else {
                    if (maxf.first != maxf.second) {
                        vmin = 0;
                        vmax = maxf.second;
                    } else {
                        vmin = 0;
                        vmax = vle::devs::Time::infinity;
                    }
                }
                activity.initStartTimeFinishRange(start.second,vmin,vmax);
            }
        } else {
            double vmin, vmax;
            if (mins.first) {
                vmin = mins.second;
            } else {
                vmin = vle::devs::Time::negativeInfinity;
            }

            if (maxs.first) {
                vmax = maxs.second;
            } else {
                vmax = vle::devs::Time::infinity;
            }

            if (finish.first) {
                activity.initStartRangeFinishTime(vmin, vmax,finish.second);
            } else {
                double vminf, vmaxf;
                if (minf.first) {
                    if (maxf.first) {
                        vminf = minf.second;
                        vmaxf = maxf.second;
                    } else {
                        vminf = minf.second;
                        vmaxf = vle::devs::Time::infinity;
                    }
                } else {
                    if (maxf.first) {
                        vminf = 0;
                        vmaxf = maxf.second;
                    } else {
                        vminf = 0;
                        vmaxf = vle::devs::Time::infinity;
                    }
                }
                activity.initStartRangeFinishRange(
                    vmin, vmax, vminf, vmaxf);
            }
        }
    }
}


void Plan::fillTemporalSequence(const vle::utils::Block::BlocksResult& temps,
                        Activity& activity)
{
	//gets the precedences parameters of the current activity
	vle::value::Map& params = activity.parameters().getMap("__internal");
	if (!params.exist("precedences")) {
		params.addSet("precedences");
	}
	vle::value::Set& precConstraints = params.getSet("precedences");
	//for all blocks 'temporal-sequence'
	for (UBB::const_iterator it = temps.first; it != temps.second; ++it) {
		const vle::utils::Block& tempSeqBlock = it->second;
		UB::BlocksResult precBlocks =
				tempSeqBlock.blocks.equal_range("precedence");
		//for all blocks 'precedence'
		for (UBB::const_iterator it = precBlocks.first;
				it != precBlocks.second; ++it) {
			const vle::utils::Block& precBlock = it->second;
			UB::RealsResult mintl = precBlock.reals.equal_range("mintimelag");
			UB::RealsResult maxtl = precBlock.reals.equal_range("maxtimelag");
			UB::StringsResult type = precBlock.strings.equal_range("type");
			bool hasMintl = (mintl.first != mintl.second);
			bool hasMaxtl = (maxtl.first != maxtl.second);
			bool hasType = (type.first != type.second);
			double valuemintl = 0.0;
			double valuemaxtl = vle::devs::Time::infinity;
			std::string valueType = "FS";

			if (hasMintl) {
				valuemintl = mintl.first->second;
			}
			if (hasMaxtl) {
				valuemaxtl = maxtl.first->second;
			}
			if (hasType) {
				valueType = type.first->second;
			}
			if (valuemintl > valuemaxtl) {
				throw vle::utils::ArgError(vle::fmt(_(
						"Decision: mintimelag (%1%) > maxtimelag (%2%)"))
						%  valuemintl % valuemaxtl);
			}
			if ((valueType != "FS") && (valueType != "FF")
					&& (valueType != "SS")){
				throw vle::utils::ArgError(vle::fmt(_(
						"Decision: precedence constraint '%1%' unknown "))
						% valueType);
			}
			vle::value::Map& precConst = precConstraints.addMap();
			precConst.addDouble("mintimelag",valuemintl);
			precConst.addDouble("maxtimelag",valuemaxtl);
			precConst.addString("type",valueType);
		}
	}
}

void Plan::fillPrecedences(const vle::utils::Block::BlocksResult& preds)
{
    for (UBB::const_iterator it = preds.first; it != preds.second; ++it) {
        const vle::utils::Block& block = it->second;

        std::string valuefirst, valuesecond;
        double valuemintl = 0.0;
        double valuemaxtl = vle::devs::Time::infinity;

        UB::StringsResult first = block.strings.equal_range("first");
        if (first.first != first.second) {
            valuefirst = first.first->second;
        }

        UB::StringsResult second = block.strings.equal_range("second");
        if (second.first != second.second) {
            valuesecond = second.first->second;
        }

        UB::RealsResult mintl = block.reals.equal_range("mintimelag");
        if (mintl.first != mintl.second) {
            valuemintl = mintl.first->second;
        }

        UB::RealsResult maxtl = block.reals.equal_range("maxtimelag");
        if (maxtl.first != maxtl.second) {
            valuemaxtl = maxtl.first->second;
        }

        UB::StringsResult type = block.strings.equal_range("type");
        if (type.first != type.second) {
            if (type.first->second == "SS") {
                mActivities.addStartToStartConstraint(valuefirst, valuesecond,
                                                      valuemintl, valuemaxtl);
            } else if (type.first->second == "FS") {
                mActivities.addFinishToStartConstraint(valuefirst, valuesecond,
                                                       valuemintl, valuemaxtl);
            } else if (type.first->second == "FF") {
                mActivities.addFinishToFinishConstraint(valuefirst,
                                                        valuesecond,
                                                        valuemintl, valuemaxtl);
            } else {
                throw vle::utils::ArgError(vle::fmt(
                        _("Decision: precedence type `%1%' unknown")) %
                    type.first->second);
            }
        } else {
            throw vle::utils::ArgError(_("Decision: precedences type unknown"));
        }
    }
}

void Plan::manageRecursion(const std::string& name,
                           const Activity& act,
                           const vle::devs::Time& /*date*/)
{
  vle::value::Map::const_iterator ifInt = act.parameters().find("__internal");
  if (ifInt != act.parameters().end()){
    const vle::value::Map& internParams = ifInt->second->toMap();
    vle::value::Map::const_iterator ifNum = internParams.find("recNumber");
    if (ifNum != internParams.end()) {
      //add recursive activity in the plan with FF constraint
      const vle::value::Integer& recNum = ifNum->second->toInteger();
      if ((recNum.value() > 1) || (recNum.value() == -1)) {
        //builds the name of the new activity
        std::string newActName;
        {
          std::vector < std::string > splitVect;
          boost::split(splitVect, name, boost::is_any_of("_"));
          if (splitVect.size() < 2) {
            throw vle::utils::InternalError(vle::fmt(_(
               "Decision: activity '%1%' is not generated "
               " from a sequence")) % name);
          }
          unsigned int currIndex =
             boost::lexical_cast<int>(splitVect[splitVect.size()-1]);
          std::stringstream ss;
          for(unsigned int i=0; i< splitVect.size()-1; i++){
            ss << splitVect[i] << "_";
          }
          newActName = (boost::format("%1%%2%")
             % ss.str() % (currIndex+1)).str();
        }
        //builds the activity
        Activity& newAct = activities().add(newActName,Activity(act));
        //add precedence constraints with the source
        if (internParams.exist("precedences")) {
            const vle::value::Set& precConstraints =
                    internParams.getSet("precedences");
            for (unsigned int i = 0; i < precConstraints.size(); i++) {
                const vle::value::Map& precConstr = precConstraints.getMap(i);
                const std::string& type = precConstr.getString("type");
                double mintl = precConstr.getDouble("mintimelag");
                double maxtl = precConstr.getDouble("maxtimelag");
                if (type == "SS") {
                    mActivities.addStartToStartConstraint(
                        name,newActName,mintl,maxtl);
                } else if (type == "FF") {
                    mActivities.addFinishToFinishConstraint(
                        name,newActName,mintl,maxtl);
                } else if (type == "FS") {
                    mActivities.addFinishToStartConstraint(
                        name,newActName,mintl,maxtl);
                }
            }
        }
        //Decrease recursion parameter
        if(recNum.value() > 1){
          vle::value::Map& internParamsNew = newAct.parameters().getMap("__internal");
          internParamsNew.set("recNumber",vle::value::Integer(recNum.value()-1));
        }
      }
    }
  }
}

Plan::DateResult Plan::getDate(const std::string& dateName,
		const vle::utils::Block& block) const
{
	UB::RealsResult dateReal = block.reals.equal_range(dateName);
	UB::StringsResult dateString = block.strings.equal_range(dateName);
	bool hasRealDate = dateReal.first != dateReal.second;
	bool hasStringDate = dateString.first != dateString.second;
	if(hasRealDate && hasStringDate){
        throw vle::utils::ArgError(vle::fmt(_(
            "Decision: date '%1%' should not be given twice ")) % dateName);
	}
	if (hasRealDate){
		return DateResult(true, vle::devs::Time((double) dateReal.first->second));
	} else if (hasStringDate){
		return DateResult(true,vle::devs::Time(
          (int) vle::utils::DateTime::toJulianDayNumber(dateString.first->second)));
	} else {
		return DateResult(false,vle::devs::Time::infinity);
	}
}

}}} // namespace modelisad extension decision
