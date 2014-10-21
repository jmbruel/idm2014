/**
 * @file src/OS_recolte.cpp
 * @author The RECORD Development Team (INRA)
 */

/*
 * Copyright (C) 2009 INRA
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

#include <vle/extension/fsa/Statechart.hpp>// correspond a l'extension DEVS utilise ici
#include <vle/extension/DifferenceEquation.hpp>// inclus ici car nous utilisons les Var comme evenement d'entree
#include <vle/utils/DateTime.hpp> //pour recuperer la date a partir du moteur de simulation de VLE
#include <vle/utils/i18n.hpp>
#include <iostream>
#include <StadesBle.hpp>

// raccourcis de nommage des namespaces frequement utilises
namespace vd = vle::devs;
namespace vv = vle::value;
namespace vu = vle::utils;
namespace ve = vle::extension;


//definition du namespace de la classe du modele
namespace modelisad {




class OS_recolte: public ve::fsa::Statechart {
public:
    enum State { IDLE, PROCESS };// liste des differents etat possibles de l'automate

    OS_recolte(const vd::DynamicsInit& atom, const vd::InitEventList& events) :
        ve::fsa::Statechart(atom, events), signal("")
    {
        //definition des etats possibles de l'automate
        states(this) << IDLE << PROCESS;

        //defini la reaction aux evenements d'entree
        eventInState(this, "act", &OS_recolte::act)
            >> IDLE;

        //Definition des transition entre les etats
        // "guard" defini la fonction de condition de declenchement de changement d'etat
        // "action" defini une action a mener dans le cas d'une transition
        // "send" defini un evenement sur un port de sortie dans le cas d'une transition
        transition(this, IDLE, PROCESS)
            << guard(&OS_recolte::signalRecu)
            << send(&OS_recolte::out);

        transition(this, PROCESS, IDLE)
            << action(&OS_recolte::clear);

        //etat initial de l'automate
        initialState(IDLE);
    }

    virtual ~OS_recolte()
    {

    }

private:
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Guard functions
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     *
     */
    bool signalRecu(const vd::Time& time)
    {
    	std::cout << std::setprecision(8) << time << " OS::signalRecu model:"
    			<< getModelName() << " " << not signal.empty() << std::endl;
        return not signal.empty();
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Send functions
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    void out(const vd::Time& time, vd::ExternalEventList& output) const
    {
    	if(signal == "stop"){
    		std::cout << std::setprecision(8) << time << " OS::out model:" << getModelName() << std::endl;
    		vd::ExternalEvent* evt = new vd::ExternalEvent("act");
    		evt->putAttribute("name", new vv::String("Stade"));
    		evt->putAttribute("value", new vv::Double(RECOLTE));
    		output.push_back(evt);
    	}
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Action functions
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    void clear(const vd::Time& time)
    {
        std::cout << std::setprecision(8) << time << " OS::clear model:" << getModelName()
        		<< " " << signal << std::endl;

    	signal.clear();
        std::cout << std::setprecision(8) << time << " OS::clear model:" << getModelName()
        		<< " " << signal << std::endl;

    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * evntInState functions
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    void act(const vd::Time& time, const vd::ExternalEvent* evt)
    {
        signal.assign(evt->getStringAttributeValue("signal"));
        std::cout << vle::utils::DateTime::toJulianDayNumber(time)
                << " OS::act model:" << getModelName()
                << " evt:" << *evt  << " signal=" << signal << std::endl;

    }

    std::string signal;
};

} //namespace

DECLARE_DYNAMICS(modelisad::OS_recolte)
