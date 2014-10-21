/**
 * @file ext/decision/Plan.hpp
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


#ifndef VLE_EXTENSION_DECISION_PLAN_HPP
#define VLE_EXTENSION_DECISION_PLAN_HPP 1

#include <ext/decision/Activities.hpp>
#include <ext/decision/Facts.hpp>
#include <ext/decision/Rules.hpp>
#include <vle/utils/Parser.hpp>
#include <string>
#include <istream>

namespace modelisad { namespace extension { namespace decision {

class KnowledgeBase;

/**
 * @brief A Plan stores Rules, Activites (with the PrecedencesGraph). The
 * functions Facts, Predicates, AcknowledgeFunctions, OutputFunctions and
 * UpdateFunctions must be defined.
 */
class Plan
{
	typedef std::pair<bool, vle::devs::Time> DateResult;

public:
    Plan(KnowledgeBase& kb)
        : mKb(kb)
    {}

    Plan(KnowledgeBase& kb, const std::string& buffer);

    Plan(KnowledgeBase& kb, std::istream& stream);

    void fill(const std::string& buffer);

    void fill(std::istream& stream);

    /**
     * @brief If required, adds to the plan a new activity after the change
     * of state of the source activity. Parameters of recursion are
     * stored in the parameters of the __internal map of the source activity.
     * @param name, the name of the source activity
     * @param act, the source activity
     * @param date, the date of the "done" acknowledge of act.
     */
    void manageRecursion(const std::string& name,
                         const Activity& act,
                         const vle::devs::Time& date);


    const Rules& rules() const { return mRules; }
    const Activities& activities() const { return mActivities; }
    Rules& rules() { return mRules; }
    Activities& activities() { return mActivities; }

private:
    void fill(const vle::utils::Block& root);
    void fillRules(const vle::utils::Block::BlocksResult& rules);
    void fillActivities(const vle::utils::Block::BlocksResult& activities);
    void fillActivitiesSequence(const vle::utils::Block::BlocksResult& seqActivities);
    void fillTemporal(const vle::utils::Block::BlocksResult& temporals,
                      Activity& activity);
    void fillTemporalSequence(const vle::utils::Block::BlocksResult& temporals,
                      Activity& activity);
    void fillPrecedences(const vle::utils::Block::BlocksResult& precedences);
    /**
     * @brief Get a date into a block with real format (e.g. julian day 2452132)
     * or a date format (e.g. 2001-08-10)
     * @param dateName, the name of the date to search (e.g. start, maxfinish)
     * @param block, the block where to seach
     */
    DateResult getDate(const std::string& dateName,
                       const vle::utils::Block& block) const;



    KnowledgeBase& mKb;
    Rules mRules;
    Activities mActivities;
};

}}} // namespace modelisad model decision

#endif
