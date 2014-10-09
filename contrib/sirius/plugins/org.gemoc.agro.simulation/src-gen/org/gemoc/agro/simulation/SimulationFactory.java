/**
 */
package org.gemoc.agro.simulation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.agro.simulation.SimulationPackage
 * @generated
 */
public interface SimulationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulationFactory eINSTANCE = org.gemoc.agro.simulation.impl.SimulationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Climate Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Climate Definition</em>'.
	 * @generated
	 */
	ClimateDefinition createClimateDefinition();

	/**
	 * Returns a new object of class '<em>Simulation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation</em>'.
	 * @generated
	 */
	Simulation createSimulation();

	/**
	 * Returns a new object of class '<em>Activity Work</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Work</em>'.
	 * @generated
	 */
	ActivityWork createActivityWork();

	/**
	 * Returns a new object of class '<em>Climate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Climate</em>'.
	 * @generated
	 */
	Climate createClimate();

	/**
	 * Returns a new object of class '<em>Day</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Day</em>'.
	 * @generated
	 */
	Day createDay();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimulationPackage getSimulationPackage();

} //SimulationFactory
