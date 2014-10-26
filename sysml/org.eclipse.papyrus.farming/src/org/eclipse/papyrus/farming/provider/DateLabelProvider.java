package org.eclipse.papyrus.farming.provider;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;

public class DateLabelProvider extends LabelProvider implements IFilteredLabelProvider {

	@Override
	public boolean accept(Object element) {
		EObject dateObject = getEObject(element);
		return accept(dateObject);
	}
	
	protected boolean accept(EObject eObject){
		if (eObject == null){
			return false;
		}

		EClass eClass = eObject.eClass();
		if ("Date".equals(eClass.getName())){
			return true;
		}
		
		return false;
	}
	
	protected EObject getEObject(Object element){
		if (element instanceof IStructuredSelection){
			IStructuredSelection selection = (IStructuredSelection)element;
			Iterator<?> it = selection.iterator();
			while (it.hasNext()){
				Object next = it.next();
				if (accept(EMFHelper.getEObject(next))){
					return EMFHelper.getEObject(next);
				}
			}
		} else {
			EObject eObject = EMFHelper.getEObject(element);
			if (accept(eObject)){
				return eObject;
			}
		}
		return null;
	}
	
	@Override
	public String getText(Object element) {
		EObject dateObject = getEObject(element);
		EStructuralFeature dayProperty = dateObject.eClass().getEStructuralFeature("day");
		Object day = dateObject.eGet(dayProperty);
		
		EStructuralFeature monthProperty = dateObject.eClass().getEStructuralFeature("month");
		Object month = dateObject.eGet(monthProperty);
		
		return day+"/"+month;
	}

}
