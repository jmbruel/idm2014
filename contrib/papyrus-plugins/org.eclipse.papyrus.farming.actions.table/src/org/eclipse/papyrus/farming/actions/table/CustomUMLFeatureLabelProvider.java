package org.eclipse.papyrus.farming.actions.table;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.CellOverrideLabelAccumulator;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

public class CustomUMLFeatureLabelProvider extends
		EMFFeatureHeaderLabelProvider {
	String str = "uml_custom_feature:/guard";

	public CustomUMLFeatureLabelProvider() {

	}

	@Override
	public boolean accept(Object element) {
		if (element instanceof ILabelProviderContextElementWrapper) {
			final Object object = ((ILabelProviderContextElementWrapper) element)
					.getObject();
			return AxisUtils.getRepresentedElement(object).equals(str);
			// return object instanceof EStructuralFeature || object instanceof
			// EStructuralFeatureAxis;
		}
		return false;
		// return AxisUtils.getRepresentedElement(element).equals(str);
		// TODO Auto-generated method stub

	}

	// @Override
	// protected String getText(FeatureLabelProviderConfiguration featureConf,
	// IConfigRegistry configRegistry, String name, Object type,
	// boolean isDerived, int lowerBound, int upperBounds) {
	// // TODO Auto-generated method stub
	// return super.getText(featureConf, configRegistry, name, type, isDerived,
	// lowerBound, upperBounds);
	// }

	@Override
	protected String getTypeName(IConfigRegistry configRegistry, Object type) {
		// TODO Auto-generated method stub
		// return super.getTypeName(configRegistry, type);
		return "";
	}

	@Override
	public String getText(Object element) {
		final ILabelProviderContextElementWrapper wrapper = (ILabelProviderContextElementWrapper) element;
		final IConfigRegistry configRegistry = wrapper.getConfigRegistry();

		final Object value = wrapper.getObject();
		EStructuralFeature feature = null;
		String alias = "";//$NON-NLS-1$
		if (value instanceof IdAxis) {
			feature = UMLPackage.eINSTANCE.getActivityEdge_Guard();
			alias = ((IdAxis) value).getAlias();
		} else if (value instanceof EStructuralFeature) {
			feature = (EStructuralFeature) value;
		}

		String returnedValue = null;
		if (alias != null && !alias.isEmpty()) {
			returnedValue = alias;
		} else {
			returnedValue = feature.getName();
		}
		ILabelProviderConfiguration conf = null;
		if (wrapper instanceof LabelProviderCellContextElementWrapper) {
			conf = getLabelConfiguration((LabelProviderCellContextElementWrapper) wrapper);
		}
		if (conf instanceof ObjectLabelProviderConfiguration
				&& !((ObjectLabelProviderConfiguration) conf).isDisplayLabel()) {
			returnedValue = ""; //$NON-NLS-1$
		} else {
			if (conf instanceof FeatureLabelProviderConfiguration) {
				returnedValue = getText(
						(FeatureLabelProviderConfiguration) conf,
						configRegistry, returnedValue, feature.getEType(),
						true, 0, -1);
			}
		}
		return returnedValue;
	}

	@Override
	public Image getImage(Object element) {
		return EMFFeatureHeaderLabelProvider.getEReferenceImage(UMLPackage.eINSTANCE.getActivityEdge_Guard());
		// TODO Auto-generated method stub
//		 return super.getImage(element);
//		return null;
	}

}
