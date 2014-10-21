/*
 * This file is part of VLE, a framework for multi-modeling, simulation and
 * analysis of complex dynamical systems
 * http://www.vle-project.org
 *
 * Copyright (c) 2003-2007 Gauthier Quesnel <quesnel@users.sourceforge.net>
 * Copyright (c) 2003-2010 ULCO http://www.univ-littoral.fr
 * Copyright (c) 2007-2010 INRA http://www.inra.fr
 *
 * See the AUTHORS or Authors.txt file for copyright owners and contributors
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - The name of the author may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

#include <algorithm>
#include <cmath>

#include <vle/value.hpp>
#include <vle/devs.hpp>
#include <vle/utils.hpp>

namespace vd = vle::devs;
namespace vv = vle::value;
namespace vu = vle::utils;

namespace modelisad {

/**
 *
 */
class ResourceManager : public vd::Dynamics
{
private:

    enum ResourceManagerState {ASSIGN, OUTPUT, PROCESS};

    typedef unsigned int ResourceID;
    typedef std::string ActivityTypeID;



    struct Activity
    {
        enum ActivityState {Ongoing, Deleted};
        Activity(const std::string& mnameActivity, double mduration,
            double mpriority, unsigned int mnbResources,
            vv::Value* mparameters): nameActivity(mnameActivity),
            duration(mduration), priority(mpriority), nbResources(mnbResources),
            parameters(mparameters), state(Ongoing)
        {
        }
        ~Activity()
        {
            if(parameters != 0){
                delete parameters;
            }
        }
        std::string nameActivity;
        double duration;
        double priority;
        unsigned int nbResources;
        vv::Value* parameters;
        ActivityState state;
    };

    typedef std::map<ActivityTypeID, Activity> Activities;

    struct Resource
    {
        Resource(const std::string& mtype, const vv::Set& comp):
            type(mtype), competences()
        {
            for(unsigned int i=0; i < comp.size(); i++){
                competences.push_back(comp.getString(i));
            }
            competences.push_back("_null");
        }
        std::string type;
        std::vector<ActivityTypeID> competences;
    };

    typedef std::vector<Resource> Resources;


    typedef std::vector<ActivityTypeID> AllResourcesAssignment;

    typedef std::vector<AllResourcesAssignment> PossibleAssignments;

    /**
     *
     */
    PossibleAssignments possibleAssignments;

    Activities activities;

    Resources resources;

    AllResourcesAssignment currAssignment;

    /**
     *
     */
    vd::Time lastWakeUp;
    /**
     *
     */
    vv::Map outputSignals;
    /**
     *
     */
    ResourceManagerState state;

    /**
     *
     */
    Activity& getActivity(const ActivityTypeID& id)
    {
        Activities::iterator i = activities.find(id);
        if(i == activities.end()){
            throw vu::InternalError(
                vle::fmt("[%1%] Activity type '%2%' does not exist")
            % getModelName() % id);
        }
        return i->second;
    }
    /**
     *
     */
    bool isIn(const ActivityTypeID& actType, const AllResourcesAssignment& ass)
    {
        AllResourcesAssignment::const_iterator ifa =
                std::find(ass.begin(),ass.end(),actType);
        return (ifa != ass.end());
    }
    /**
     *
     */
    bool isIn(const ActivityTypeID& actType, const Activities& act)
    {
        Activities::const_iterator ifa = act.find(actType);
        return (ifa != act.end());
    }
    /**
     *
     */
    bool validAssignment(const AllResourcesAssignment& ass)
    {
        //check competences
        for(ResourceID resId=0; resId != resources.size(); resId++){
            const ActivityTypeID& actId = ass[resId];
            Resource& res = resources[resId];
            if(std::find(res.competences.begin(), res.competences.end(), actId)
                == res.competences.end()){
                return false;
            }
        }
        //check nb resources
        typedef std::map<ActivityTypeID,unsigned int> tmpMap;
        tmpMap nbAssRes;
        for(ResourceID resId=0; resId != resources.size(); resId++){
            const ActivityTypeID& actId = ass[resId];
            tmpMap::iterator it = nbAssRes.find(actId);
            if(it == nbAssRes.end()){
                nbAssRes.insert(std::make_pair(actId,0));
                it = nbAssRes.find(actId);
            }
            it->second += 1;
        }
        tmpMap::iterator ib = nbAssRes.begin();
        tmpMap::iterator ie = nbAssRes.end();
        for(;ib!=ie;ib++){
            const ActivityTypeID& actId = ib->first;
            Activity& act = getActivity(actId);
            if((actId != "_null") && (act.nbResources != ib->second)){
                return false;
            }
        }
        return true;
    }
    /**
     *
     */
    bool betterAssignment(AllResourcesAssignment& curr,
        AllResourcesAssignment& best)
    {
        //first criterion : the priority
        std::vector<double> prioritiesCur;
        std::vector<double> prioritiesBest;
        for(unsigned int res = 0; res < resources.size(); res++){
            prioritiesCur.push_back(getActivity(curr[res]).priority);
            prioritiesBest.push_back(getActivity(best[res]).priority);
        }
        std::sort(prioritiesCur.begin(),prioritiesCur.end());
        std::sort(prioritiesBest.begin(),prioritiesBest.end());
        for(unsigned int res = 0; res < resources.size(); res++){
            if(prioritiesCur[res] < prioritiesBest[res]){
                return true;
            }
            if(prioritiesBest[res] < prioritiesCur[res]){
                return false;
            }
        }
        //Second criterion : check usage of resources
        unsigned int nbResCurr = 0;
        unsigned int nbResBest = 0;

        for(unsigned int res = 0; res < resources.size(); res++){
            if(curr[res] != "_null"){
                nbResCurr ++;
            }
            if(best[res] != "_null"){
                nbResBest ++;
            }
        }
        if(nbResBest < nbResCurr) return true;
        return false;
    }

    /**
     * @brief Sets the best assignment. First builds all possible assignments
     * by considering the pattern
     * found in a column in the matrix where columns are resources
     * and lines are assignments (vector of activities).
     * The column of index R (R^th resource) is :
     *  (alpha * A_1  + ... + alpha * A_Na ) * beta.
     *  whith alpha = Na^R and beta = Na^(Nr-(R+1))
     *  and Na is the number of activities and Nr the number of resources.
     */
    void assign()
    {
        //build all assignments
        unsigned int Nr = resources.size();
        unsigned int Na = activities.size();

//        std::cout << " bestAssigment Na " << Na << " Nr "<< Nr
//                << " Na^Nr="<< std::pow(Na,Nr) << std::endl;
        possibleAssignments.clear();
        possibleAssignments.resize(std::pow(Na,Nr));
//        std::cout << " bestAssigment size="<< possibleAssignments.size() << std::endl;
//        std::cout << " bestAssigment build resources="<< resources.size() << std::endl;
        PossibleAssignments::iterator ibPos = possibleAssignments.begin();
        PossibleAssignments::iterator iePos = possibleAssignments.end();
        for(;ibPos != iePos; ibPos++){
            ibPos->resize(resources.size());
        }

        for(ResourceID resId=0; resId != resources.size(); resId++){
//            std::cout << " bestAssigment build resId="<< resId << std::endl;
            ibPos = possibleAssignments.begin();
            for(unsigned nbSeq = 0 ; nbSeq < std::pow(Na,Nr -(resId+1)); nbSeq++){

                Activities::iterator ibAct = activities.begin();
                Activities::iterator ieAct = activities.end();
                for(;ibAct != ieAct; ibAct++){
                    for(unsigned nbElem = 0 ; nbElem < std::pow(Na,resId); nbElem++){
                        AllResourcesAssignment& curAss = *ibPos;
//                        std::cout << " bestAssigment build currAss size="<< curAss.size() << std::endl;
//                        std::cout << " bestAssigment build currAss resId="<< curAss[resId] << std::endl;
                        curAss[resId] = ibAct->first;
                        ibPos++;
                    }
                }
            }
        }

        //select the best valid one
        int bestAssId = -1;
        for(unsigned int assId = 0; assId != possibleAssignments.size();
                assId++){
            AllResourcesAssignment& ass = possibleAssignments[assId];
            if(validAssignment(ass)){
                if(bestAssId == -1){
                    bestAssId = assId;
                } else if(betterAssignment(ass,possibleAssignments[bestAssId])){
                    bestAssId = assId;
                }
            }
        }
        if(bestAssId == -1){
            throw vu::InternalError(
                vle::fmt("[%1%] No valid assignment found")
            % getModelName());
        }
        AllResourcesAssignment& ass = possibleAssignments[bestAssId];
        currAssignment.resize(resources.size());
        for(unsigned int i = 0; i < currAssignment.size(); i++){
            currAssignment[i] = ass[i];
        }

    }
    /**
     *
     */
    void process(const vd::Time& time)
    {
        std::set<std::string> assignedActivities;
        AllResourcesAssignment::iterator ib = currAssignment.begin();
        AllResourcesAssignment::iterator ie = currAssignment.end();
        for (; ib != ie; ib++) {
            std::string& actID = *ib;
            assignedActivities.insert(actID);
        }
        std::set<std::string>::iterator ib1 = assignedActivities.begin();
        std::set<std::string>::iterator ie1 = assignedActivities.end();
        for (; ib1 != ie1; ib1++) {
            const ActivityTypeID& actId = *ib1;
            Activity& act = getActivity(actId);
            act.duration -= (time - lastWakeUp);
            if(act.duration < 0){
                throw vu::InternalError(
                    vle::fmt("[%1%] Duration can't be less than 0 (%2%)")
                % getModelName() % act.duration);
            }
        }
    }

    void cleanActivities()
    {
        std::set<std::string> removedActivities;
        Activities::iterator ib = activities.begin();
        Activities::iterator ie = activities.end();
        for (; ib != ie; ib++) {
            const std::string& actId = ib->first;
            Activity& act = ib->second;
            if (act.state == Activity::Deleted) {
                removedActivities.insert(actId);
            }
            if(act.duration == 0){
                removedActivities.insert(actId);
            }
            if(act.duration < 0){
                throw vu::InternalError(
                    vle::fmt("[%1%] Duration can't be less than 0 (%2%)")
                % getModelName() % act.duration);
            }
        }
        std::set<std::string>::iterator ib1 = removedActivities.begin();
        std::set<std::string>::iterator ie1 = removedActivities.end();
        for (; ib1 != ie1; ib1++) {
            activities.erase(*ib1);
        }
    }

    void fillOutputSignals(bool beforeAssign)
    {
        Activities::iterator iba = activities.begin();
        Activities::iterator iea = activities.end();
        for(;iba!=iea;iba++){
            const ActivityTypeID& actId = iba->first;
            const Activity& act = iba->second;
            if(act.state == Activity::Deleted){
                vv::Map& sigParam = outputSignals.addMap(actId);
                sigParam.addString("signal","failed");
            } else if(act.duration <= 0){
                vv::Map& sigParam = outputSignals.addMap(actId);
                sigParam.addString("signal","stop");
                sigParam.addString("ack",act.nameActivity);
            } else if(isIn(actId,currAssignment) ) {
                if(beforeAssign){
                    vv::Map& sigParam = outputSignals.addMap(actId);
                    sigParam.addString("signal","suspend");
                } else {
                    vv::Map::iterator ifs = outputSignals.find(actId);
                    if(ifs != outputSignals.end()){
                        vv::Map* sigParam = vv::toMapValue(ifs->second);
                        if(sigParam->getString("signal") != "suspend"){
                            throw vu::InternalError(
                                vle::fmt("[%1%] Unexpected signal before "
                                        "assignment '%2%'")
                            % getModelName() % sigParam->getString("signal"));
                        }
                        delete sigParam;
                        outputSignals.value().erase(ifs);
                    } else {
                        vv::Map& sigParam = outputSignals.addMap(actId);
                        sigParam.addString("signal","start");
                        if(act.parameters != 0){
                            sigParam.add("parameters",act.parameters->clone());
                        }
                    }
                }
            }
        }
    }

    vd::Time nextFinishDate() const
    {
        vd::Time min = vd::Time::infinity;
        AllResourcesAssignment::const_iterator ib = currAssignment.begin();
        AllResourcesAssignment::const_iterator ie = currAssignment.end();
        for (; ib != ie; ib++) {
            const std::string& actId = *ib;
            Activities::const_iterator ifa = activities.find(actId);

            if(ifa == activities.end()){
                throw vu::InternalError(
                    vle::fmt("[%1%] Activity '%2%' should be found ")
                % getModelName() % actId);
            }
            const Activity& act = ifa->second;
            std::cout << " ResManag::nextFinishDate " <<  actId << " "<< act.duration << std::endl ;
            if(act.duration < min){
                min = act.duration;
            }
        }
        return min;
    }

public:

    /**
     *
     */
    ResourceManager(const vd::DynamicsInit& init,
        const vd::InitEventList& events) : vd::Dynamics(init, events),
        possibleAssignments(),activities(), resources(),currAssignment(),
        lastWakeUp(0),outputSignals(),state(PROCESS)
    {
        const vv::Map& resourcesP = events.getMap("resources");
        vv::Map::const_iterator ib = resourcesP.begin();
        vv::Map::const_iterator ie = resourcesP.end();
        for(;ib!=ie;ib++){
            const std::string& resourceType = ib->first;
            const vv::Value& resourceParam = *(ib->second);
            if(!resourceParam.isMap()){
                throw vu::ModellingError(
                    vle::fmt("[%1%] The resource '%2%' should be "
                        "parametrized with a map. ")
                % getModelName() % resourceType);
            }
            const vv::Map& resParamMap = resourceParam.toMap();
            unsigned int nb = 1;
            vv::Map::const_iterator ifn = resParamMap.find("number");
            if((ifn != resParamMap.end()) && (ifn->second->isInteger())){
                nb = ifn->second->toInteger().value();
            }
            ifn = resParamMap.find("competences");
            if(ifn == resParamMap.end()){
                throw vu::ModellingError(
                    vle::fmt("[%1%] Missing competences for resource "
                            "type '%2%'")
                % getModelName() % resourceType);
            }
            const vv::Set& comp = ifn->second->toSet();
            for(unsigned int i =0; i < nb; i++){
                resources.push_back(Resource(resourceType,comp));
            }
        }
        activities.insert(std::make_pair("_null",
            Activity("_null",vd::Time::infinity,vd::Time::infinity,1,0)));
        currAssignment.resize(resources.size());
        for(unsigned int i = 0; i < resources.size(); i++){
            currAssignment[i] = "_null";
        }

    }
    /**
     *
     */
    virtual ~ResourceManager()
    {
    }
    /**
     *
     */
    virtual vd::Time init(const vd::Time& time)
    {
        lastWakeUp = time;
        return vd::Time::infinity;
    }
    /**
     *
     */
    virtual void output(const vd::Time& /*time*/,
                        vd::ExternalEventList& output) const
    {
        if(state == OUTPUT){
        	 std::cout << " ResManag output " <<  outputSignals << std::endl ;
            vv::Map::const_iterator ibs = outputSignals.begin();
            vv::Map::const_iterator ies = outputSignals.end();
            for(;ibs!=ies;ibs++){
                const ActivityTypeID& actId = ibs->first;
                if(actId != "_null"){
                    const vv::Map& sigParam = ibs->second->toMap();
                    const std::string& sig = sigParam.getString("signal");
                    vd::ExternalEvent* signal = new vd::ExternalEvent(actId);
                    signal->putAttribute("signal", new vv::String(sig));
                    output.push_back(signal);
                    if(sig == "stop"){
                        vd::ExternalEvent* ack = new vd::ExternalEvent("ack");
                        ack->putAttribute("name",
                            new vv::String(sigParam.getString("ack")));
                        ack->putAttribute("value", new vv::String("done"));
                        output.push_back(ack);
                    }
                }
            }
        }
    }
    /**
     *
     */
    virtual vd::Time timeAdvance() const
    {
        vd::Time ta = vd::Time::infinity;
        switch(state){
        case ASSIGN:
        {
            ta = 0;
            std::cout << " ResManag timeAdvance ASSIGN " <<  ta << std::endl;
            break;
        }
        case OUTPUT:
        {
            ta = 0;
            std::cout << " ResManag timeAdvance OUTPUT " <<  ta << std::endl;
            break;
        }
        case PROCESS:
        {
            ta = nextFinishDate();
            std::cout << " ResManag timeAdvance PROCESS " <<  ta << std::endl;
            break;
        }
        }
        return ta;
    }
    /**
     *
     */
    virtual void internalTransition(const vd::Time& time)
    {
        std::cout << std::setprecision(8) << " ResManag internalTransition " <<  state << " time=" << time << std::endl;
        switch(state){
        case PROCESS:
            process(time);
            state = ASSIGN;
            break;
        case ASSIGN:
            fillOutputSignals(true);
            cleanActivities();
            assign();
            fillOutputSignals(false);
            state = OUTPUT;
            break;
        case OUTPUT:
            outputSignals.clear();
            state = PROCESS;
            lastWakeUp = time;
            break;
        }
    }
    /**
     *
     */
    virtual void externalTransition(const vd::ExternalEventList& event,
                                    const vd::Time& time)
    {
        switch (state){
        case PROCESS:
        {
            process(time);
            std::string activitytype;
            std::string name;
            std::string request;
            double duration;
            double priority;
            unsigned int nbResources;
            vv::Value* parameters = 0;

            vd::ExternalEventList::const_iterator itb = event.begin();
            vd::ExternalEventList::const_iterator ite = event.end();

            for (; itb != ite; itb++) {
                const vd::ExternalEvent& e = *(*itb);
                std::cout << " ResManag externalTransition ";
                std::cout << e << std::endl;
                activitytype = e.getPortName();
                if (!e.existAttributeValue("name")) {
                    throw vu::ModellingError(vle::fmt("[%1%] The name of "
                        "activity for activity type '%2%'")
                    % getModelName() % activitytype);
                }
                name = e.getStringAttributeValue("name");

                if (!e.existAttributeValue("request")) {
                    throw vu::ModellingError(vle::fmt("[%1%] The type of "
                        "request is not given for activity type '%2%'")
                    % getModelName() % activitytype);
                }
                request = e.getStringAttributeValue("request");
                if (request == "create") {
                    if (isIn(activitytype,activities)) {
                        throw vu::ModellingError(vle::fmt("[%1%] Activity of "
                            "type %2% already declared")
                        % getModelName() % activitytype);
                    }
                    if (!e.existAttributeValue("duration")) {
                        throw vu::ModellingError(vle::fmt("[%1%] Duration "
                            "missing for activity of type %2%")
                        % getModelName() % activitytype);
                    }
                    duration = e.getDoubleAttributeValue("duration");
                    if (duration <= 0) {
                        throw vu::ModellingError(vle::fmt("[%1%] Duration "
                            "must be above 0 (type=%2%,duration=%3%)")
                        % getModelName() % activitytype % duration);
                    }
                    if (!e.existAttributeValue("priority")) {
                        throw vu::ModellingError(vle::fmt("[%1%] Priority "
                            "missing for activity of type %2%")
                        % getModelName() % activitytype);
                    }
                    priority = e.getDoubleAttributeValue("priority");
                    nbResources = 1;
                    if (e.existAttributeValue("resources")) {
                        nbResources = e.getIntegerAttributeValue("resources");
                    }
                    parameters = 0;
                    if (e.existAttributeValue("parameters")) {
                        parameters =
                                e.getMapAttributeValue("parameters").clone();
                    }
                    activities.insert(std::make_pair(activitytype,
                        Activity(name,duration,priority,
                            nbResources,parameters)));
                } else if (request == "delete") {
                    Activities::iterator ifa = activities.find(activitytype);
                    if (ifa != activities.end()) {
                    	ifa->second.state = Activity::Deleted;
                    }
                } else {
                    throw vu::ModellingError(vle::fmt("[%1%] Request unknown "
                        "('%2')") % getModelName() % request);
                }
            }
            state = ASSIGN;
            break;
        }
        case ASSIGN:
        case OUTPUT:
            throw vu::InternalError(
                vle::fmt("[%1%] DEVS state unhandled on external transition")
            % getModelName());
            break;
        }

    }

    virtual void confluentTransitions(const vd::Time& time,
                                      const vd::ExternalEventList& events)
    {
        internalTransition(time);
        externalTransition(events, time);
    }

    virtual void request(const vd::RequestEvent& /*event*/,
                         const vd::Time& /*time*/,
                         vd::ExternalEventList& /*output*/) const
    {
    }

    virtual vv::Value* observation(const vd::ObservationEvent& event) const
    {
        const std::string& resType = event.getPortName();
        vv::Set* assigned = new vv::Set();
        for(unsigned int j =0; j<currAssignment.size(); j++){
            const Resource& r = resources[j];
            if(r.type == resType){
                assigned->addString(currAssignment[j]);
            }
        }
        return assigned;

    }

    virtual void finish()
    {
    }
};

} // namespace vle modelisad

DECLARE_DYNAMICS(modelisad::ResourceManager)
