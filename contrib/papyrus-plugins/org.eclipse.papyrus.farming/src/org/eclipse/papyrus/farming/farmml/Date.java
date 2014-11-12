/**
 */
package org.eclipse.papyrus.farming.farmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Date</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Date#getDay <em>Day</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Date#getMonth <em>Month</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getDate()
 * @model
 * @generated
 */
public interface Date extends EObject {
	/**
	 * Returns the value of the '<em><b>Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day</em>' attribute.
	 * @see #setDay(int)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getDate_Day()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getDay();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Date#getDay <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day</em>' attribute.
	 * @see #getDay()
	 * @generated
	 */
	void setDay(int value);

	/**
	 * Returns the value of the '<em><b>Month</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.farming.farmml.Month}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' attribute.
	 * @see org.eclipse.papyrus.farming.farmml.Month
	 * @see #setMonth(Month)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getDate_Month()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Month getMonth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Date#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see org.eclipse.papyrus.farming.farmml.Month
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(Month value);

} // Date
