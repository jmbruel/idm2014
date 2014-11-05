package org.eclipse.papyrus.farming.actions.table;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class ActionAxisManager extends AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager<EObject> {

    /**
    * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#isInstanceOfRequiredStereotypeApplication(java.lang.Object)
    *
    * @param object
    * @return
    */
    @Override
    protected boolean isInstanceOfRequiredStereotypeApplication(Object object) {
                   EObject stereotypeApplication = (EObject) object;
                   if( stereotypeApplication.eClass().getName().equals("Action")) 
                	   return true;
                   else
                   return false;
    }

    /**
    * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#isAllowedAsBaseElement(org.eclipse.uml2.uml.Element)
    *
    * @param element
    * @return
    */
    @Override
    protected boolean isAllowedAsBaseElement(Element element) {
                   return element instanceof Action;
    }

    /**
    * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeApplication(org.eclipse.uml2.uml.Element)
    *
    * @param element
    * @return
    */
    @Override
    protected EObject getStereotypeApplication(Element element) {
                   String name = "Action";
                   // element.getApplicableStereotype(arg0);
                   Stereotype arg0 = element.getApplicableStereotype(name);
                   return element.getStereotypeApplication(arg0);
                   
    }

    /**
    * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeApplicationBasePropertyName()
    *
    * @return
    */
    @Override
    protected String getStereotypeApplicationBasePropertyName() {
                   return "base_Action";
                   // TODO Auto-generated method stub
                   // return null;
    }

}
