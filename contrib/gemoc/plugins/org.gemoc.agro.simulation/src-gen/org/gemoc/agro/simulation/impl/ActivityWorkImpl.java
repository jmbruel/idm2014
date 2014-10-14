/**
 */
package org.gemoc.agro.simulation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gemoc.agro.activitiesDSL.ExploitationActivity;

import org.gemoc.agro.exploitation.Resource;

import org.gemoc.agro.simulation.ActivityWork;
import org.gemoc.agro.simulation.SimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Work</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.agro.simulation.impl.ActivityWorkImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.ActivityWorkImpl#getResourceAllocation <em>Resource Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityWorkImpl extends MinimalEObjectImpl.Container implements ActivityWork {
	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected ExploitationActivity activity;

	/**
	 * The cached value of the '{@link #getResourceAllocation() <em>Resource Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceAllocation()
	 * @generated
	 * @ordered
	 */
	protected Resource resourceAllocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityWorkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationPackage.Literals.ACTIVITY_WORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExploitationActivity getActivity() {
		if (activity != null && activity.eIsProxy()) {
			InternalEObject oldActivity = (InternalEObject)activity;
			activity = (ExploitationActivity)eResolveProxy(oldActivity);
			if (activity != oldActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationPackage.ACTIVITY_WORK__ACTIVITY, oldActivity, activity));
			}
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExploitationActivity basicGetActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(ExploitationActivity newActivity) {
		ExploitationActivity oldActivity = activity;
		activity = newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.ACTIVITY_WORK__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResourceAllocation() {
		if (resourceAllocation != null && resourceAllocation.eIsProxy()) {
			InternalEObject oldResourceAllocation = (InternalEObject)resourceAllocation;
			resourceAllocation = (Resource)eResolveProxy(oldResourceAllocation);
			if (resourceAllocation != oldResourceAllocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationPackage.ACTIVITY_WORK__RESOURCE_ALLOCATION, oldResourceAllocation, resourceAllocation));
			}
		}
		return resourceAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetResourceAllocation() {
		return resourceAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceAllocation(Resource newResourceAllocation) {
		Resource oldResourceAllocation = resourceAllocation;
		resourceAllocation = newResourceAllocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.ACTIVITY_WORK__RESOURCE_ALLOCATION, oldResourceAllocation, resourceAllocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationPackage.ACTIVITY_WORK__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case SimulationPackage.ACTIVITY_WORK__RESOURCE_ALLOCATION:
				if (resolve) return getResourceAllocation();
				return basicGetResourceAllocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulationPackage.ACTIVITY_WORK__ACTIVITY:
				setActivity((ExploitationActivity)newValue);
				return;
			case SimulationPackage.ACTIVITY_WORK__RESOURCE_ALLOCATION:
				setResourceAllocation((Resource)newValue);
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
			case SimulationPackage.ACTIVITY_WORK__ACTIVITY:
				setActivity((ExploitationActivity)null);
				return;
			case SimulationPackage.ACTIVITY_WORK__RESOURCE_ALLOCATION:
				setResourceAllocation((Resource)null);
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
			case SimulationPackage.ACTIVITY_WORK__ACTIVITY:
				return activity != null;
			case SimulationPackage.ACTIVITY_WORK__RESOURCE_ALLOCATION:
				return resourceAllocation != null;
		}
		return super.eIsSet(featureID);
	}

} //ActivityWorkImpl
