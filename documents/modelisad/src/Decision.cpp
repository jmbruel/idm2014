/**
 * @file src/Decision.cpp
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

#include <sstream>
#include <numeric>
#include <iterator>

#include <ext/decision/Decision.hpp>
#include <vle/utils.hpp>

#include <StadesBle.hpp>

// raccourcis de nommage des namespaces frequement utilises
namespace vd = vle::devs;
namespace vv = vle::value;
namespace ved = modelisad::extension::decision;
namespace vu = vle::utils;

//definition du namespace de la classe du modele
namespace modelisad {

class Decision: public ved::Agent {
public:
    Decision(const vd::DynamicsInit& mdl, const vd::InitEventList& evts) :
        ved::Agent(mdl, evts)
    {
        // Lecture des valeurs de parametres dans les conditions du vpz
//        stockEau = evts.getDouble("stockEau");
//        apportEau = evts.getDouble("apportEau");
//        quantiteEauSolPortant = evts.getDouble("quantiteEauSolPortant");
//        quantiteEauPeriodeSeche = evts.getDouble("quantiteEauPeriodeSeche");
//        nbJoursAvantRetour = evts.getInt("nbJoursAvantRetour");



        //inititialisation du KnowledgeBase
        addFacts(this) +=
                F("Disponibilite_Herbe", &Decision::Disponibilite_Herbe),
                F("Stade_Ble", &Decision::Stade_Ble);

        addPredicates(this) +=
                P("stade1epi", &Decision::stade1epi),
                P("stade1epiPlus7jours", &Decision::stade1epiPlus7jours),
                P("stadeGonflement", &Decision::stadeGonflement),
                P("stadeGonflementPlus7jours", &Decision::stadeGonflementPlus7jours),
                P("stadeFloraison", &Decision::stadeFloraison),
                P("stadeFloraisonPlus5jours", &Decision::stadeFloraisonPlus5jours),
                P("disponibiliteHerbeInf10", &Decision::disponibiliteHerbeInf10);                             ;

        addOutputFunctions(this) +=
                O("out_semis", &Decision::out_semis),
                O("out_desherbageAutomne",&Decision::out_desherbageAutomne),
                O("out_apportAzote",&Decision::out_apportAzote),
                O("out_fongicide",&Decision::out_fongicide),
                O("out_recolte",&Decision::out_recolte),
                O("out_coupe",&Decision::out_coupe),
                O("out_fourrage",&Decision::out_fourrage);


        //Initalisation du plan
        std::string filePath = vu::Path::path().getExternalPackageDataFile(
            "modelisad", "DecisionPlan.txt");
        std::ifstream fileStream(filePath.c_str());
        KnowledgeBase::plan().fill(fileStream);

        //
        jourSemis = vd::Time::infinity;
        jourEpi_1 = vd::Time::infinity;
        jourGonflement = vd::Time::infinity;
        jourFloraison = vd::Time::infinity;
        disponibiliteHerbe = 0;
    }

    virtual ~Decision() {}

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Predicats
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * @brief stade1epi
     */
    bool stade1epi() const
    {
    	std::cout << " pred Stade_1 Epi " << currentTime() << " " << (stade >= EPI_1) << std::endl;

        return stade == EPI_1;
    }
    /**
     * @brief stade1epiPlus7jours
     */
    bool stade1epiPlus7jours() const
    {
    	if(jourEpi_1.isInfinity()){
    		return false;
    	} else {
    		return ((currentTime() - jourEpi_1) > 7);
    	}

    }
    /**
     * @brief stadeGonflement
     */
    bool stadeGonflement() const
    {
    	return stade == GONFLEMENT;
    }
    /**
     * @brief stadeGonflementPlus7jours
     */
    bool stadeGonflementPlus7jours() const
    {
    	if(jourGonflement.isInfinity()){
    		return false;
    	} else {
    		return ((currentTime() - jourGonflement) > 7);
    	}
    }
    /**
     * @brief stadeFloraison
     */
    bool stadeFloraison() const
    {
    	return stade == FLORAISON;
    }
    /**
     * @brief stadeFloraisonPlus5jours
     */
    bool stadeFloraisonPlus5jours() const
    {
    	if(jourFloraison.isInfinity()){
    		return false;
    	} else {
    		return ((currentTime() - jourFloraison) > 5);
    	}
    }
    /**
     * @brief disponibiliteHerbeInf10
     */
    bool disponibiliteHerbeInf10() const
    {
        return disponibiliteHerbe < 10;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Facts
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * @brief Disponibilite_Herbe
     */
    void Disponibilite_Herbe(const vv::Value& value)
    {
    	disponibiliteHerbe = value.toDouble().value();
    	std::cout << " Disponibilite_Herbe " << value << std::endl;
    }
    /**
     * @brief Stade_Ble
     */
    void Stade_Ble(const vv::Value& value)
    {
    	std::cout << " Stade_Ble " << value << std::endl;
    	stade = (StadeBle) value.toDouble().value();
    	if((stade == SEME) and (jourSemis == vd::Time::infinity)){
    		jourSemis = currentTime();
    	} else if((stade == EPI_1) and (jourEpi_1 == vd::Time::infinity)){
    		jourEpi_1 = currentTime();
    	} else if((stade == GONFLEMENT) and (jourGonflement == vd::Time::infinity)){
    		jourGonflement = currentTime();
    	} else if((stade == FLORAISON) and (jourFloraison == vd::Time::infinity)){
    		jourFloraison = currentTime();
    	}
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Output functions
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * @brief out_semerBle
     */
    void out_semis(const std::string& name, const ved::Activity& activity,
            vd::ExternalEventList& output)
    {
        if (activity.isInStartedState()) {
    		std::cout << vu::DateTime::toJulianDayNumber(currentTime())
    				<< " Decision out_semis " <<  name
    				<< std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("semis");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("create"));
            evt->putAttribute("duration", new vv::Double(5));
            evt->putAttribute("priority", new vv::Double(2));
            evt->putAttribute("resources", new vv::Integer(2));
            output.push_back(evt);
        } else if (activity.isInFailedState()){
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	 << " Decision out_semis failed " <<  name
        	 << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("semis");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
        }
    }
    /**
     * @brief out_desherbageAutomne
     */
    void out_desherbageAutomne(const std::string& name, const ved::Activity& activity,
            vd::ExternalEventList& output)
    {
        if (activity.isInStartedState()) {
    		std::cout << vu::DateTime::toJulianDayNumber(currentTime())
    				<< " Decision out_desherbageAutomne " <<  name
    				<< std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("desherbageAutomne");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("create"));
            evt->putAttribute("duration", new vv::Double(3));
            evt->putAttribute("priority", new vv::Double(2));
            evt->putAttribute("resources", new vv::Integer(1));
            output.push_back(evt);
        } else if (activity.isInFailedState()){
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	 << " Decision out_desherbageAutomne failed " <<  name
        	 << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("desherbageAutomne");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
        }
    }
    /**
     * @brief out_apportAzote
     */
    void out_apportAzote(const std::string& name, const ved::Activity& activity,
            vd::ExternalEventList& output)
    {
        if (activity.isInStartedState()) {
    		std::cout << vu::DateTime::toJulianDayNumber(currentTime())
    				<< " Decision out_apportAzote " <<  name
    				<< std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("apportAzote");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("create"));
            evt->putAttribute("duration", new vv::Double(3));
            evt->putAttribute("priority", new vv::Double(2));
            evt->putAttribute("resources", new vv::Integer(1));
            output.push_back(evt);
        } else if (activity.isInFailedState()){
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	 << " Decision out_apportAzote failed " <<  name
        	 << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("apportAzote");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
        }
    }
    /**
     * @brief out_recolterBle
     */
    void out_fongicide(const std::string& name, const ved::Activity& activity,
            vd::ExternalEventList& output)
    {
        if (activity.isInStartedState()) {
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	    				<< " Decision out_fongicide " <<  name
        	    				<< std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("fongicide");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("create"));
            evt->putAttribute("duration", new vv::Double(3));
            evt->putAttribute("priority", new vv::Double(2));
            evt->putAttribute("resources", new vv::Integer(1));
            output.push_back(evt);
        } else if (activity.isInFailedState()){
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	 << " Decision out_fongicide failed " <<  name
        	 << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("fongicide");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
        }
    }
    /**
     * @brief out_recolte
     */
    void out_recolte(const std::string& name, const ved::Activity& activity,
        vd::ExternalEventList& output)
    {
        if (activity.isInStartedState()) {
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
                << " Decision out_recolte " <<  name
        	    << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("recolte");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("create"));
            evt->putAttribute("duration", new vv::Double(10));
            evt->putAttribute("priority", new vv::Double(2));
            evt->putAttribute("resources", new vv::Integer(2));
            output.push_back(evt);
        } else if (activity.isInFailedState()){
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	 << " Decision out_recolte failed " <<  name
        	 << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("recolte");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
        }
    }

    /**
     * @brief out_coupe
     */
    void out_coupe(const std::string& name, const ved::Activity& activity,
    		vd::ExternalEventList& output)
    {
    	if (activity.isInStartedState()) {
    		std::cout << vu::DateTime::toJulianDayNumber(currentTime())
    		  << " Decision out_coupe " <<  name
    		  << std::endl ;
    		vd::ExternalEvent* evt = new vd::ExternalEvent("coupe");
    		evt->putAttribute("name", new vv::String(name));
    		evt->putAttribute("request", new vv::String("create"));
    		evt->putAttribute("duration", new vv::Double(7));
    		evt->putAttribute("priority", new vv::Double(1));
    		evt->putAttribute("resources", new vv::Integer(2));
    		output.push_back(evt);
    	} else if (activity.isInFailedState()){
        	std::cout << vu::DateTime::toJulianDayNumber(currentTime())
        	 << " Decision out_coupe failed " <<  name
        	 << std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("coupe");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
        }
    }

    /**
     * @brief out_fourrage
     */
    void out_fourrage(const std::string& name, const ved::Activity& activity,
    		vd::ExternalEventList& output)
    {
    	if (activity.isInStartedState()) {
    		std::cout << vu::DateTime::toJulianDay(currentTime()) << " "
    				<< " Decision out_fourrage " <<  name
    				<< std::endl ;
    		vd::ExternalEvent* evt = new vd::ExternalEvent("fourrage");
    		evt->putAttribute("name", new vv::String(name));
    		evt->putAttribute("request", new vv::String("create"));
    		evt->putAttribute("duration", new vv::Double(1));
    		evt->putAttribute("priority", new vv::Double(0));
    		evt->putAttribute("resources", new vv::Integer(1));
    		output.push_back(evt);
    	} else if (activity.isInFailedState()) {
    		std::cout << vu::DateTime::toJulianDay(currentTime()) << " "
    				<< " Decision out_fourrage " <<  name
    				<< std::endl ;
            vd::ExternalEvent* evt = new vd::ExternalEvent("fourrage");
            evt->putAttribute("name", new vv::String(name));
            evt->putAttribute("request", new vv::String("delete"));
            output.push_back(evt);
    	}
    }

//    /**
//     * @brief Fonction d'observation des activités et des prédicats
//     */
//    vv::Value* observation(const vle::devs::ObservationEvent& event) const
//    {
//        std::string port_name = event.getPortName();
//        if (activities().exist(port_name)) {
//            const ved::Activity& act = activite(port_name);
//            switch (act.state()) {
//            case ved::Activity::WAIT:
//                return new vv::String("wait");
//                break;
//            case ved::Activity::STARTED:
//                return new vv::String("started");
//                break;
//            case ved::Activity::FF:
//                return new vv::String("ff");
//                break;
//            case ved::Activity::DONE:
//                return new vv::String("done");
//                break;
//            case ved::Activity::FAILED:
//                return new vv::String("failed");
//                break;
//            }
//        }
//        return 0;
//    }



private:
    StadeBle stade;
    double disponibiliteHerbe;
    vd::Time jourSemis;
    vd::Time jourEpi_1;
    vd::Time jourGonflement;
    vd::Time jourFloraison;
};


} // namespaces

DECLARE_DYNAMICS(modelisad::Decision)
