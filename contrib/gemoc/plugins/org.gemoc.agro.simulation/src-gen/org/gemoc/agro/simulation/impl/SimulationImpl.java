/**
 */
package org.gemoc.agro.simulation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.agro.exploitation.Exploitation;

import org.gemoc.agro.simulation.ClimateDefinition;
import org.gemoc.agro.simulation.Day;
import org.gemoc.agro.simulation.SchedulingStrategy;
import org.gemoc.agro.simulation.Simulation;
import org.gemoc.agro.simulation.SimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.agro.simulation.impl.SimulationImpl#getClimate <em>Climate</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.SimulationImpl#getPlanning <em>Planning</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.SimulationImpl#getExploitation <em>Exploitation</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.SimulationImpl#getSchedulingStrategy <em>Scheduling Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationImpl extends MinimalEObjectImpl.Container implements Simulation {
	/**
	 * The cached value of the '{@link #getClimate() <em>Climate</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClimate()
	 * @generated
	 * @ordered
	 */
	protected EList<ClimateDefinition> climate;

	/**
	 * The cached value of the '{@link #getPlanning() <em>Planning</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlanning()
	 * @generated
	 * @ordered
	 */
	protected EList<Day> planning;

	/**
	 * The cached value of the '{@link #getExploitation() <em>Exploitation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExploitation()
	 * @generated
	 * @ordered
	 */
	protected Exploitation exploitation;

	/**
	 * The default value of the '{@link #getSchedulingStrategy() <em>Scheduling Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingStrategy SCHEDULING_STRATEGY_EDEFAULT = SchedulingStrategy.RANDOM;

	/**
	 * The cached value of the '{@link #getSchedulingStrategy() <em>Scheduling Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingStrategy()
	 * @generated
	 * @ordered
	 */
	protected SchedulingStrategy schedulingStrategy = SCHEDULING_STRATEGY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationPackage.Literals.SIMULATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClimateDefinition> getClimate() {
		if (climate == null) {
			climate = new EObjectContainmentEList<ClimateDefinition>(ClimateDefinition.class, this, SimulationPackage.SIMULATION__CLIMATE);
		}
		return climate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Day> getPlanning() {
		if (planning == null) {
			planning = new EObjectContainmentEList<Day>(Day.class, this, SimulationPackage.SIMULATION__PLANNING);
		}
		return planning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exploitation getExploitation() {
		if (exploitation != null && exploitation.eIsProxy()) {
			InternalEObject oldExploitation = (InternalEObject)exploitation;
			exploitation = (Exploitation)eResolveProxy(oldExploitation);
			if (exploitation != oldExploitation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationPackage.SIMULATION__EXPLOITATION, oldExploitation, exploitation));
			}
		}
		return exploitation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exploitation basicGetExploitation() {
		return exploitation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExploitation(Exploitation newExploitation) {
		Exploitation oldExploitation = exploitation;
		exploitation = newExploitation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.SIMULATION__EXPLOITATION, oldExploitation, exploitation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingStrategy getSchedulingStrategy() {
		return schedulingStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulingStrategy(SchedulingStrategy newSchedulingStrategy) {
		SchedulingStrategy oldSchedulingStrategy = schedulingStrategy;
		schedulingStrategy = newSchedulingStrategy == null ? SCHEDULING_STRATEGY_EDEFAULT : newSchedulingStrategy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.SIMULATION__SCHEDULING_STRATEGY, oldSchedulingStrategy, schedulingStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulationPackage.SIMULATION__CLIMATE:
				return ((InternalEList<?>)getClimate()).basicRemove(otherEnd, msgs);
			case SimulationPackage.SIMULATION__PLANNING:
				return ((InternalEList<?>)getPlanning()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationPackage.SIMULATION__CLIMATE:
				return getClimate();
			case SimulationPackage.SIMULATION__PLANNING:
				return getPlanning();
			case SimulationPackage.SIMULATION__EXPLOITATION:
				if (resolve) return getExploitation();
				return basicGetExploitation();
			case SimulationPackage.SIMULATION__SCHEDULING_STRATEGY:
				return getSchedulingStrategy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulationPackage.SIMULATION__CLIMATE:
				getClimate().clear();
				getClimate().addAll((Collection<? extends ClimateDefinition>)newValue);
				return;
			case SimulationPackage.SIMULATION__PLANNING:
				getPlanning().clear();
				getPlanning().addAll((Collection<? extends Day>)newValue);
				return;
			case SimulationPackage.SIMULATION__EXPLOITATION:
				setExploitation((Exploitation)newValue);
				return;
			case SimulationPackage.SIMULATION__SCHEDULING_STRATEGY:
				setSchedulingStrategy((SchedulingStrategy)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimulationPackage.SIMULATION__CLIMATE:
				getClimate().clear();
				return;
			case SimulationPackage.SIMULATION__PLANNING:
				getPlanning().clear();
				return;
			case SimulationPackage.SIMULATION__EXPLOITATION:
				setExploitation((Exploitation)null);
				return;
			case SimulationPackage.SIMULATION__SCHEDULING_STRATEGY:
				setSchedulingStrategy(SCHEDULING_STRATEGY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimulationPackage.SIMULATION__CLIMATE:
				return climate != null && !climate.isEmpty();
			case SimulationPackage.SIMULATION__PLANNING:
				return planning != null && !planning.isEmpty();
			case SimulationPackage.SIMULATION__EXPLOITATION:
				return exploitation != null;
			case SimulationPackage.SIMULATION__SCHEDULING_STRATEGY:
				return schedulingStrategy != SCHEDULING_STRATEGY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (schedulingStrategy: ");
		result.append(schedulingStrategy);
		result.append(')');
		return result.toString();
	}

} //SimulationImpl
