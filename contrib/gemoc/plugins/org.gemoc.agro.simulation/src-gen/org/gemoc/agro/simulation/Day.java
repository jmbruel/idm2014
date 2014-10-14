/**
 */
package org.gemoc.agro.simulation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.agro.activitiesDSL.Month;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Day</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.agro.simulation.Day#getActivitiesWork <em>Activities Work</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.Day#getMonth <em>Month</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.Day#getDay <em>Day</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.Day#getClimate <em>Climate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.agro.simulation.SimulationPackage#getDay()
 * @model
 * @generated
 */
public interface Day extends EObject {
	/**
	 * Returns the value of the '<em><b>Activities Work</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.agro.simulation.ActivityWork}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities Work</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities Work</em>' containment reference list.
	 * @see org.gemoc.agro.simulation.SimulationPackage#getDay_ActivitiesWork()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActivityWork> getActivitiesWork();

	/**
	 * Returns the value of the '<em><b>Month</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.agro.activitiesDSL.Month}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' attribute.
	 * @see org.gemoc.agro.activitiesDSL.Month
	 * @see #setMonth(Month)
	 * @see org.gemoc.agro.simulation.SimulationPackage#getDay_Month()
	 * @model
	 * @generated
	 */
	Month getMonth();

	/**
	 * Sets the value of the '{@link org.gemoc.agro.simulation.Day#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see org.gemoc.agro.activitiesDSL.Month
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(Month value);

	/**
	 * Returns the value of the '<em><b>Day</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day</em>' attribute.
	 * @see #setDay(int)
	 * @see org.gemoc.agro.simulation.SimulationPackage#getDay_Day()
	 * @model default="1"
	 * @generated
	 */
	int getDay();

	/**
	 * Sets the value of the '{@link org.gemoc.agro.simulation.Day#getDay <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day</em>' attribute.
	 * @see #getDay()
	 * @generated
	 */
	void setDay(int value);

	/**
	 * Returns the value of the '<em><b>Climate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Climate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Climate</em>' containment reference.
	 * @see #setClimate(Climate)
	 * @see org.gemoc.agro.simulation.SimulationPackage#getDay_Climate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Climate getClimate();

	/**
	 * Sets the value of the '{@link org.gemoc.agro.simulation.Day#getClimate <em>Climate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Climate</em>' containment reference.
	 * @see #getClimate()
	 * @generated
	 */
	void setClimate(Climate value);

} // Day
