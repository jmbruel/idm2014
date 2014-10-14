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

import org.gemoc.agro.activitiesDSL.Month;

import org.gemoc.agro.simulation.ActivityWork;
import org.gemoc.agro.simulation.Climate;
import org.gemoc.agro.simulation.Day;
import org.gemoc.agro.simulation.SimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Day</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.agro.simulation.impl.DayImpl#getActivitiesWork <em>Activities Work</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.DayImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.DayImpl#getDay <em>Day</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.DayImpl#getClimate <em>Climate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DayImpl extends MinimalEObjectImpl.Container implements Day {
	/**
	 * The cached value of the '{@link #getActivitiesWork() <em>Activities Work</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivitiesWork()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityWork> activitiesWork;

	/**
	 * The default value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected static final Month MONTH_EDEFAULT = Month.JAN;

	/**
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected Month month = MONTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDay() <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDay()
	 * @generated
	 * @ordered
	 */
	protected static final int DAY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getDay() <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDay()
	 * @generated
	 * @ordered
	 */
	protected int day = DAY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClimate() <em>Climate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClimate()
	 * @generated
	 * @ordered
	 */
	protected Climate climate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationPackage.Literals.DAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityWork> getActivitiesWork() {
		if (activitiesWork == null) {
			activitiesWork = new EObjectContainmentEList<ActivityWork>(ActivityWork.class, this, SimulationPackage.DAY__ACTIVITIES_WORK);
		}
		return activitiesWork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Month getMonth() {
		return month;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonth(Month newMonth) {
		Month oldMonth = month;
		month = newMonth == null ? MONTH_EDEFAULT : newMonth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.DAY__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDay() {
		return day;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDay(int newDay) {
		int oldDay = day;
		day = newDay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.DAY__DAY, oldDay, day));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Climate getClimate() {
		return climate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClimate(Climate newClimate, NotificationChain msgs) {
		Climate oldClimate = climate;
		climate = newClimate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulationPackage.DAY__CLIMATE, oldClimate, newClimate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClimate(Climate newClimate) {
		if (newClimate != climate) {
			NotificationChain msgs = null;
			if (climate != null)
				msgs = ((InternalEObject)climate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulationPackage.DAY__CLIMATE, null, msgs);
			if (newClimate != null)
				msgs = ((InternalEObject)newClimate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulationPackage.DAY__CLIMATE, null, msgs);
			msgs = basicSetClimate(newClimate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.DAY__CLIMATE, newClimate, newClimate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulationPackage.DAY__ACTIVITIES_WORK:
				return ((InternalEList<?>)getActivitiesWork()).basicRemove(otherEnd, msgs);
			case SimulationPackage.DAY__CLIMATE:
				return basicSetClimate(null, msgs);
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
			case SimulationPackage.DAY__ACTIVITIES_WORK:
				return getActivitiesWork();
			case SimulationPackage.DAY__MONTH:
				return getMonth();
			case SimulationPackage.DAY__DAY:
				return getDay();
			case SimulationPackage.DAY__CLIMATE:
				return getClimate();
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
			case SimulationPackage.DAY__ACTIVITIES_WORK:
				getActivitiesWork().clear();
				getActivitiesWork().addAll((Collection<? extends ActivityWork>)newValue);
				return;
			case SimulationPackage.DAY__MONTH:
				setMonth((Month)newValue);
				return;
			case SimulationPackage.DAY__DAY:
				setDay((Integer)newValue);
				return;
			case SimulationPackage.DAY__CLIMATE:
				setClimate((Climate)newValue);
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
			case SimulationPackage.DAY__ACTIVITIES_WORK:
				getActivitiesWork().clear();
				return;
			case SimulationPackage.DAY__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case SimulationPackage.DAY__DAY:
				setDay(DAY_EDEFAULT);
				return;
			case SimulationPackage.DAY__CLIMATE:
				setClimate((Climate)null);
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
			case SimulationPackage.DAY__ACTIVITIES_WORK:
				return activitiesWork != null && !activitiesWork.isEmpty();
			case SimulationPackage.DAY__MONTH:
				return month != MONTH_EDEFAULT;
			case SimulationPackage.DAY__DAY:
				return day != DAY_EDEFAULT;
			case SimulationPackage.DAY__CLIMATE:
				return climate != null;
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
		result.append(" (month: ");
		result.append(month);
		result.append(", day: ");
		result.append(day);
		result.append(')');
		return result.toString();
	}

} //DayImpl
