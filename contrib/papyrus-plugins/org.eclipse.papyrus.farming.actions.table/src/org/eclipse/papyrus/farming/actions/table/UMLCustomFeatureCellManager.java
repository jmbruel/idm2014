package org.eclipse.papyrus.farming.actions.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.manager.cell.UMLFeatureCellManager;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Element;

public class UMLCustomFeatureCellManager extends UMLFeatureCellManager {

	public static final String PREFIX = "uml_custom_feature:/";

	public static final String GUARD = "guard";

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		List<Object> elements = organizeAndResolvedObjects(columnElement,
				rowElement, null);
		if (elements != null && elements.size() == 2) {
			return elements.get(0) instanceof Action
					&& elements.get(1).equals(PREFIX + GUARD);
		}
		return false;
	}

	@Override
	protected List<Object> organizeAndResolvedObjects(Object columnElement,
			Object rowElement, Map<?, ?> sharedMap) {
		List<Object> objects = null;
		final Object row = AxisUtils.getRepresentedElement(rowElement);
		final Object column = AxisUtils.getRepresentedElement(columnElement);
		if (row instanceof Element && column instanceof String) {
			objects = new ArrayList<Object>();
			objects.add(row);
			objects.add(column);
		} else if (column instanceof Element && row instanceof String) {
			objects = new ArrayList<Object>();
			objects.add(column);
			objects.add(row);
		}
		return objects;
	}

	@Override
	protected Object doGetValue(Object columnElement, Object rowElement,
			INattableModelManager tableManager) {
		List<Object> elements = organizeAndResolvedObjects(columnElement,
				rowElement, null);
		Action action = (Action) elements.get(0);
		List<ActivityEdge> ctrlFlows = action.getIncomings();
		List<Object> returnedValues = new ArrayList<Object>();
		for (ActivityEdge current : ctrlFlows) {
			returnedValues.add(current.getGuard());
		}
		// TODO Auto-generated method stub
		return returnedValues;
	}

	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement) {
		// TODO Auto-generated method stub
		return false;
	}

}
