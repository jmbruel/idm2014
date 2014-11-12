/**
 */
package org.eclipse.papyrus.farming.farmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Action#getStartDateMin <em>Start Date Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Action#getEndDateMax <em>End Date Max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Action#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Action#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.Action#getBase_Action <em>Base Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Date Min</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date Min</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date Min</em>' containment reference.
	 * @see #setStartDateMin(Date)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getAction_StartDateMin()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Date getStartDateMin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Action#getStartDateMin <em>Start Date Min</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date Min</em>' containment reference.
	 * @see #getStartDateMin()
	 * @generated
	 */
	void setStartDateMin(Date value);

	/**
	 * Returns the value of the '<em><b>End Date Max</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Date Max</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Date Max</em>' containment reference.
	 * @see #setEndDateMax(Date)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getAction_EndDateMax()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Date getEndDateMax();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Action#getEndDateMax <em>End Date Max</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date Max</em>' containment reference.
	 * @see #getEndDateMax()
	 * @generated
	 */
	void setEndDateMax(Date value);

	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.farming.farmml.Frequency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see org.eclipse.papyrus.farming.farmml.Frequency
	 * @see #setFrequency(Frequency)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getAction_Frequency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Frequency getFrequency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Action#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' attribute.
	 * @see org.eclipse.papyrus.farming.farmml.Frequency
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(Frequency value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(int)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getAction_Duration()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getDuration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Action#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(int value);

	/**
	 * Returns the value of the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Action</em>' reference.
	 * @see #setBase_Action(org.eclipse.uml2.uml.Action)
	 * @see org.eclipse.papyrus.farming.farmml.FarmMLPackage#getAction_Base_Action()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Action getBase_Action();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.farming.farmml.Action#getBase_Action <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Action</em>' reference.
	 * @see #getBase_Action()
	 * @generated
	 */
	void setBase_Action(org.eclipse.uml2.uml.Action value);

} // Action
