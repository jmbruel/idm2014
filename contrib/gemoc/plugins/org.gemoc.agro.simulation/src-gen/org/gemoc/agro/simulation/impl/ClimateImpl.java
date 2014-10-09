/**
 */
package org.gemoc.agro.simulation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gemoc.agro.simulation.Climate;
import org.gemoc.agro.simulation.ClimateDefinition;
import org.gemoc.agro.simulation.SimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Climate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.agro.simulation.impl.ClimateImpl#getRain <em>Rain</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.ClimateImpl#getRay <em>Ray</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.ClimateImpl#getETp <em>ETp</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.ClimateImpl#getTemperature <em>Temperature</em>}</li>
 *   <li>{@link org.gemoc.agro.simulation.impl.ClimateImpl#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClimateImpl extends MinimalEObjectImpl.Container implements Climate {
	/**
	 * The default value of the '{@link #getRain() <em>Rain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRain()
	 * @generated
	 * @ordered
	 */
	protected static final int RAIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRain() <em>Rain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRain()
	 * @generated
	 * @ordered
	 */
	protected int rain = RAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRay() <em>Ray</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRay()
	 * @generated
	 * @ordered
	 */
	protected static final int RAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRay() <em>Ray</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRay()
	 * @generated
	 * @ordered
	 */
	protected int ray = RAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getETp() <em>ETp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getETp()
	 * @generated
	 * @ordered
	 */
	protected static final int ETP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getETp() <em>ETp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getETp()
	 * @generated
	 * @ordered
	 */
	protected int eTp = ETP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTemperature() <em>Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemperature()
	 * @generated
	 * @ordered
	 */
	protected static final int TEMPERATURE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTemperature() <em>Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemperature()
	 * @generated
	 * @ordered
	 */
	protected int temperature = TEMPERATURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected ClimateDefinition from;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClimateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationPackage.Literals.CLIMATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRain() {
		return rain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRain(int newRain) {
		int oldRain = rain;
		rain = newRain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.CLIMATE__RAIN, oldRain, rain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRay() {
		return ray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRay(int newRay) {
		int oldRay = ray;
		ray = newRay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.CLIMATE__RAY, oldRay, ray));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getETp() {
		return eTp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setETp(int newETp) {
		int oldETp = eTp;
		eTp = newETp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.CLIMATE__ETP, oldETp, eTp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperature(int newTemperature) {
		int oldTemperature = temperature;
		temperature = newTemperature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.CLIMATE__TEMPERATURE, oldTemperature, temperature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClimateDefinition getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject)from;
			from = (ClimateDefinition)eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationPackage.CLIMATE__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClimateDefinition basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(ClimateDefinition newFrom) {
		ClimateDefinition oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.CLIMATE__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationPackage.CLIMATE__RAIN:
				return getRain();
			case SimulationPackage.CLIMATE__RAY:
				return getRay();
			case SimulationPackage.CLIMATE__ETP:
				return getETp();
			case SimulationPackage.CLIMATE__TEMPERATURE:
				return getTemperature();
			case SimulationPackage.CLIMATE__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
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
			case SimulationPackage.CLIMATE__RAIN:
				setRain((Integer)newValue);
				return;
			case SimulationPackage.CLIMATE__RAY:
				setRay((Integer)newValue);
				return;
			case SimulationPackage.CLIMATE__ETP:
				setETp((Integer)newValue);
				return;
			case SimulationPackage.CLIMATE__TEMPERATURE:
				setTemperature((Integer)newValue);
				return;
			case SimulationPackage.CLIMATE__FROM:
				setFrom((ClimateDefinition)newValue);
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
			case SimulationPackage.CLIMATE__RAIN:
				setRain(RAIN_EDEFAULT);
				return;
			case SimulationPackage.CLIMATE__RAY:
				setRay(RAY_EDEFAULT);
				return;
			case SimulationPackage.CLIMATE__ETP:
				setETp(ETP_EDEFAULT);
				return;
			case SimulationPackage.CLIMATE__TEMPERATURE:
				setTemperature(TEMPERATURE_EDEFAULT);
				return;
			case SimulationPackage.CLIMATE__FROM:
				setFrom((ClimateDefinition)null);
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
			case SimulationPackage.CLIMATE__RAIN:
				return rain != RAIN_EDEFAULT;
			case SimulationPackage.CLIMATE__RAY:
				return ray != RAY_EDEFAULT;
			case SimulationPackage.CLIMATE__ETP:
				return eTp != ETP_EDEFAULT;
			case SimulationPackage.CLIMATE__TEMPERATURE:
				return temperature != TEMPERATURE_EDEFAULT;
			case SimulationPackage.CLIMATE__FROM:
				return from != null;
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
		result.append(" (rain: ");
		result.append(rain);
		result.append(", ray: ");
		result.append(ray);
		result.append(", ETp: ");
		result.append(eTp);
		result.append(", temperature: ");
		result.append(temperature);
		result.append(')');
		return result.toString();
	}

} //ClimateImpl
