/**
 */
package org.gemoc.agro.simulation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.agro.exploitation.Exploitation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.agro.simulation.Simulation#getClimate <em>Climate</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.Simulation#getPlanning <em>Planning</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.Simulation#getExploitation <em>Exploitation</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.Simulation#getSchedulingStrategy <em>Scheduling Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.agro.simulation.SimulationPackage#getSimulation()
 * @model
 * @generated
 */
public interface Simulation extends EObject {
	/**
	 * Returns the value of the '<em><b>Climate</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.agro.simulation.ClimateDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Climate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Climate</em>' containment reference list.
	 * @see org.gemoc.agro.simulation.SimulationPackage#getSimulation_Climate()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClimateDefinition> getClimate();

	/**
	 * Returns the value of the '<em><b>Planning</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.agro.simulation.Day}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planning</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planning</em>' containment reference list.
	 * @see org.gemoc.agro.simulation.SimulationPackage#getSimulation_Planning()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Day> getPlanning();

	/**
	 * Returns the value of the '<em><b>Exploitation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exploitation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exploitation</em>' reference.
	 * @see #setExploitation(Exploitation)
	 * @see org.gemoc.agro.simulation.SimulationPackage#getSimulation_Exploitation()
	 * @model
	 * @generated
	 */
	Exploitation getExploitation();

	/**
	 * Sets the value of the '{@link org.gemoc.agro.simulation.Simulation#getExploitation <em>Exploitation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exploitation</em>' reference.
	 * @see #getExploitation()
	 * @generated
	 */
	void setExploitation(Exploitation value);

	/**
	 * Returns the value of the '<em><b>Scheduling Strategy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.agro.simulation.SchedulingStrategy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Strategy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Strategy</em>' attribute.
	 * @see org.gemoc.agro.simulation.SchedulingStrategy
	 * @see #setSchedulingStrategy(SchedulingStrategy)
	 * @see org.gemoc.agro.simulation.SimulationPackage#getSimulation_SchedulingStrategy()
	 * @model
	 * @generated
	 */
	SchedulingStrategy getSchedulingStrategy();

	/**
	 * Sets the value of the '{@link org.gemoc.agro.simulation.Simulation#getSchedulingStrategy <em>Scheduling Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Strategy</em>' attribute.
	 * @see org.gemoc.agro.simulation.SchedulingStrategy
	 * @see #getSchedulingStrategy()
	 * @generated
	 */
	void setSchedulingStrategy(SchedulingStrategy value);

} // Simulation
