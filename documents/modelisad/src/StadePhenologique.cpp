/**
  * @file StadePhenologique.cpp
  * @author ...
  * ...
  * @@tag DifferenceEquationMultiple (generic)@@namespace:modelisad;class:StadePhenologique;par:;sync:Unite_dev|;nosync:@@end tag@@
  */

#include <vle/extension/DifferenceEquation.hpp>

//@@begin:includes@@
#include <StadesBle.hpp>//@@end:includes@@

namespace vd = vle::devs;
namespace ve = vle::extension;
namespace vv = vle::value;

namespace modelisad {

class StadePhenologique : public ve::DifferenceEquation::Multiple
{
public:
    StadePhenologique(
       const vd::DynamicsInit& atom,
       const vd::InitEventList& evts)
        : ve::DifferenceEquation::Multiple(atom, evts)
    {
        Stade = createVar("Stade");
        Som_UD_depuis_semis = createVar("Som_UD_depuis_semis");
        Som_UD_depuis_epi_1 = createVar("Som_UD_depuis_epi_1");
        Som_UD_depuis_gonflement = createVar("Som_UD_depuis_gonflement");
        Unite_dev = createSync("Unite_dev");
    }

    virtual ~StadePhenologique()
    {}

//@@begin:compute@@
virtual void compute(const vd::Time& time)
{

switch ((int) Stade(-1)) {
            case SOL_NU:
            	Som_UD_depuis_semis =  Som_UD_depuis_semis(-1);
            	Som_UD_depuis_epi_1 = Som_UD_depuis_epi_1(-1);
            	Som_UD_depuis_gonflement = Som_UD_depuis_gonflement(-1);
            	Stade = Stade(-1);
                break;
            case SEME:
            	Som_UD_depuis_semis =  Som_UD_depuis_semis(-1) + Unite_dev() - Unite_dev(-1) ;
            	Som_UD_depuis_epi_1 = Som_UD_depuis_epi_1(-1);
            	Som_UD_depuis_gonflement = Som_UD_depuis_gonflement(-1);
            	if(Som_UD_depuis_semis() <= 434){
            		Stade = Stade(-1);
            	} else {
            		Stade = EPI_1;
            	}
                break;
            case EPI_1:
            	Som_UD_depuis_semis =  Som_UD_depuis_semis(-1)+ Unite_dev() - Unite_dev(-1);
            	Som_UD_depuis_epi_1 = Som_UD_depuis_epi_1(-1) + Unite_dev() - Unite_dev(-1);
            	Som_UD_depuis_gonflement = Som_UD_depuis_gonflement(-1);
            	if(Som_UD_depuis_epi_1() <= 200){
            		Stade = Stade(-1);
            	} else {
            		Stade = GONFLEMENT;
            	}
            	break;
            case GONFLEMENT:
            	Som_UD_depuis_semis =  Som_UD_depuis_semis(-1) + Unite_dev() - Unite_dev(-1);
            	Som_UD_depuis_epi_1 = Som_UD_depuis_epi_1(-1) + Unite_dev() - Unite_dev(-1);
            	Som_UD_depuis_gonflement = Som_UD_depuis_gonflement(-1)+ Unite_dev() - Unite_dev(-1);
            	if(Som_UD_depuis_gonflement() <= 200){
            		Stade = Stade(-1);
            	} else {
            		Stade = FLORAISON;
            	}
            	break;
            case FLORAISON:
            case RECOLTE:
            	Som_UD_depuis_semis =  Som_UD_depuis_semis(-1);
            	Som_UD_depuis_epi_1 = Som_UD_depuis_epi_1(-1);
            	Som_UD_depuis_gonflement = Som_UD_depuis_gonflement(-1);
            	Stade = Stade(-1);
                break;
        }
std::cout << std::setprecision(8) << time << " Som_UD_depuis_semis:" << Som_UD_depuis_semis()
   		<< " " << std::endl;

std::cout << std::setprecision(8) << time << " Som_UD_depuis_epi_1:" << Som_UD_depuis_epi_1()
   		<< " " << std::endl;

std::cout << std::setprecision(8) << time << " Som_UD_depuis_gonflement:" << Som_UD_depuis_gonflement()
   		<< " " << std::endl;


std::cout << std::setprecision(8) << time << " Som_UD_depuis_gonflement:" << Som_UD_depuis_gonflement()
   		<< " " << std::endl;


}
//@@end:compute@@

//@@begin:initValue@@
virtual void initValue(const vd::Time& /*time*/)
{ }
//@@end:initValue@@

private:
//@@begin:user@@
//@@end:user@@

    Var Stade;
    Var Som_UD_depuis_semis;
    Var Som_UD_depuis_epi_1;
    Var Som_UD_depuis_gonflement;
    Sync Unite_dev;
};

} // namespace modelisad

DECLARE_DYNAMICS(modelisad::StadePhenologique)

