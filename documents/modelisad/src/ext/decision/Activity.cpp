/*
 * @file ext/decision/Activity.cpp
 *
 * This file is part of VLE, a framework for multi-modeling, simulation
 * and analysis of complex dynamical systems
 * http://www.vle-project.org
 *
 * Copyright (c) 2003-2007 Gauthier Quesnel <quesnel@users.sourceforge.net>
 * Copyright (c) 2003-2010 ULCO http://www.univ-littoral.fr
 * Copyright (c) 2007-2010 INRA http://www.inra.fr
 *
 * See the AUTHORS or Authors.txt file for copyright owners and contributors
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


#include <ext/decision/Activity.hpp>
#include <vle/utils/Exception.hpp>
#include <vle/utils/i18n.hpp>
#include <boost/format.hpp>

namespace modelisad { namespace extension { namespace decision {

bool Activity::validRules() const
{
    if (not m_rules.empty()) {
       Rules::result_t result = m_rules.apply();
       return not result.empty();
    }
    return true;
}
bool Activity::validRulesFailure() const
{
    if (not m_rulesFailure.empty()) {
        Rules::result_t result = m_rulesFailure.apply();
        return not result.empty();
    }
    return false;
}

void Activity::initStartTimeFinishTime(const vle::devs::Time& start,
                                       const vle::devs::Time& finish)
{
    if (start > finish) {
        throw vle::utils::ModellingError(
            vle::fmt(_("Decision: temporal constraint expected : "
                    "start (%1%) before finish (%2%)"))
            % start % finish);
    }

    m_date = (DateType)(Activity::START | Activity::FINISH);
    m_start = start;
    m_finish = finish;
}

void Activity::initStartTimeFinishRange(const vle::devs::Time& start,
                                        const vle::devs::Time& minfinish,
                                        const vle::devs::Time& maxfinish)
{
    if (not (start < minfinish and minfinish < maxfinish)) {
        throw vle::utils::ModellingError(
            vle::fmt(_("Decision: temporal constraint expected : start (%1%) "
                    "before minfinish (%2%) before maxfinish (%3%)"))
            % start % minfinish % maxfinish);
    }

    m_date = (DateType)(Activity::START | Activity::MINF | Activity::MAXF);
    m_start = start;
    m_minfinish = minfinish;
    m_maxfinish = maxfinish;
}

void Activity::initStartRangeFinishTime(const vle::devs::Time& minstart,
                                        const vle::devs::Time& maxstart,
                                        const vle::devs::Time& finish)
{
    if (not (minstart < maxstart and maxstart < finish)) {
        throw vle::utils::ModellingError(
            vle::fmt(_("Decision: temporal constraint expected : minstart (%1%)"
                    " before maxstart (%2%) before finish (%3%)"))
            % minstart % maxstart % finish);
    }

    m_date = (DateType)(Activity::MINS | Activity::MAXS | Activity::FINISH);
    m_minstart = minstart;
    m_maxstart = maxstart;
    m_finish = finish;
}

void Activity::initStartRangeFinishRange(const vle::devs::Time& minstart,
                                         const vle::devs::Time& maxstart,
                                         const vle::devs::Time& minfinish,
                                         const vle::devs::Time& maxfinish)
{
    if (not (minstart < maxstart and minstart < maxfinish
             and minfinish < maxfinish)) {
        throw vle::utils::ModellingError(
            vle::fmt(_("Decision: temporal constraint expected : minstart (%1%)"
                    " before maxstart (%2%) and minfinish (%3%) before"
                    " maxfinish (%4%) and minstart (%1%) before"
                    " maxfinish (%4%)"))
            % minstart % maxstart % minfinish % maxfinish );
    }

    m_date = (DateType)(Activity::MINF | Activity::MAXF | Activity::MINS |
                        Activity::MAXS);
    m_minstart = minstart;
    m_maxstart = maxstart;
    m_minfinish = minfinish;
    m_maxfinish = maxfinish;
}

vle::devs::Time Activity::nextTime(const vle::devs::Time& time)
{
    vle::devs::Time result = vle::devs::Time::infinity;

    switch (m_state) {
    case WAIT:
    case STARTED:
    case FF:
        if (m_date & START and time <= m_start) {
            result = m_start;
        } else if (m_date & MINS and time <= m_minstart) {
            result = m_minstart;
        } else if (m_date & MAXS and time <= m_maxstart) {
            result = m_maxstart;
        } else {
            if (m_date & FINISH and time <= m_finish) {
                result = m_finish;
            } else if (m_date & MINF and time <= m_minfinish) {
                result = m_minfinish;
            } else if (m_date & MAXF and time <= m_maxfinish) {
                result = m_maxfinish;
            } else {
                result = vle::devs::Time::infinity;
            }
        }
        break;
    case DONE:
    case FAILED:
        result = vle::devs::Time::infinity;
        break;
    }

    return result;
}

bool Activity::isValidTimeConstraint(const vle::devs::Time& time) const
{
    switch (m_date & (START | FINISH | MINS | MAXS | MINF | MAXF)) {
    case START | FINISH:
        return m_start <= time and time <= m_finish;

    case START | MINF | MAXF:
        return m_start <= time and time <= m_maxfinish;

    case MINS | MAXS | FINISH:
        return m_minstart <= time and time <= m_maxfinish;

    case MINS | MAXS | MINF | MAXF:
        return m_minstart <= time and time <= m_maxfinish;

    default:
        break;
    }
    throw vle::utils::InternalError(vle::fmt(
            _("Decision: activity time type invalid: %1%")) % (int)m_date);
}

bool Activity::isBeforeTimeConstraint(const vle::devs::Time& time) const
{
    switch (m_date & (START | FINISH | MINS | MAXS | MINF | MAXF)) {
    case START | FINISH:
        return time < m_start;

    case START | MINF | MAXF:
        return time < m_start;

    case MINS | MAXS | FINISH :
        return time < m_minstart;

    case MINS | MAXS | MINF | MAXF:
        return time < m_minstart;

    default:
        break;
    }
    throw vle::utils::InternalError(vle::fmt(
            _("Decision: activity time type invalid: %1%")) % (int)m_date);
}

bool Activity::isAfterTimeConstraint(const vle::devs::Time& time) const
{
    switch (m_date & (START | FINISH | MINS | MAXS | MINF | MAXF)) {
    case START | FINISH:
        return m_finish < time;

    case START | MINF | MAXF:
        return m_maxfinish < time;

    case MINS | MAXS | FINISH:
        return m_finish < time;

    case MINS | MAXS | MINF | MAXF:
        return m_maxfinish < time;

    default:
        break;
    }
    throw vle::utils::InternalError(vle::fmt(
            _("Decision: activity time type invalid: %1%")) % (int)m_date);
}

}}} // namespace modelisad model decision

