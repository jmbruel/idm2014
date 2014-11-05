package org.eclipse.papyrus.farming.actions.table;

import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLElementAxisManager;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLFeatureAxisManager;

public class UMLCustomFeatureAxisManager extends UMLFeatureAxisManager {

	@Override
	public boolean isAllowedContents(Object object) {
		// TODO Auto-generated method stub
		return super.isAllowedContents(object);
	}

	@Override
	public boolean canCreateAxisElement(String elementId) {
		// TODO Auto-generated method stub
		return super.canCreateAxisElement(elementId);
	}

	@Override
	public IRestrictedContentProvider createPossibleAxisContentProvider(
			boolean isRestricted) {
		// TODO Auto-generated method stub
		return null;//super.createPossibleAxisContentProvider(isRestricted);
	}

	
}
