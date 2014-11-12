/**
 */
package org.eclipse.papyrus.farming.farmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Surface#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Surface#isIrrigated <em>Irrigated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getSurface()
 * @model
 * @generated
 */
public interface Surface extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getSurface_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Surface#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Irrigated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Irrigated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Irrigated</em>' attribute.
	 * @see #setIrrigated(boolean)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getSurface_Irrigated()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIrrigated();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Surface#isIrrigated <em>Irrigated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Irrigated</em>' attribute.
	 * @see #isIrrigated()
	 * @generated
	 */
	void setIrrigated(boolean value);

} // Surface
