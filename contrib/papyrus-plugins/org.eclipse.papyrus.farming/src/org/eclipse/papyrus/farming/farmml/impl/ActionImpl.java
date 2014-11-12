/**
 */
package org.eclipse.papyrus.farming.farmml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.farming.farmml.Action;
import org.eclipse.papyrus.farming.farmml.Date;
import org.eclipse.papyrus.farming.farmml.FarmMLPackage;
import org.eclipse.papyrus.farming.farmml.Frequency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl#getStartDateMin <em>Start Date Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl#getEndDateMax <em>End Date Max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.farming.farmml.impl.ActionImpl#getBase_Action <em>Base Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends MinimalEObjectImpl.Container implements Action {
	/**
	 * The cached value of the '{@link #getStartDateMin() <em>Start Date Min</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDateMin()
	 * @generated
	 * @ordered
	 */
	protected Date startDateMin;

	/**
	 * The cached value of the '{@link #getEndDateMax() <em>End Date Max</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDateMax()
	 * @generated
	 * @ordered
	 */
	protected Date endDateMax;

	/**
	 * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final Frequency FREQUENCY_EDEFAULT = Frequency.ONCE;

	/**
	 * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected Frequency frequency = FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected int duration = DURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Action() <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Action()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Action base_Action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FarmMLPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDateMin() {
		return startDateMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartDateMin(Date newStartDateMin, NotificationChain msgs) {
		Date oldStartDateMin = startDateMin;
		startDateMin = newStartDateMin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__START_DATE_MIN, oldStartDateMin, newStartDateMin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDateMin(Date newStartDateMin) {
		if (newStartDateMin != startDateMin) {
			NotificationChain msgs = null;
			if (startDateMin != null)
				msgs = ((InternalEObject)startDateMin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FarmMLPackage.ACTION__START_DATE_MIN, null, msgs);
			if (newStartDateMin != null)
				msgs = ((InternalEObject)newStartDateMin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FarmMLPackage.ACTION__START_DATE_MIN, null, msgs);
			msgs = basicSetStartDateMin(newStartDateMin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__START_DATE_MIN, newStartDateMin, newStartDateMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDateMax() {
		return endDateMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndDateMax(Date newEndDateMax, NotificationChain msgs) {
		Date oldEndDateMax = endDateMax;
		endDateMax = newEndDateMax;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__END_DATE_MAX, oldEndDateMax, newEndDateMax);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDateMax(Date newEndDateMax) {
		if (newEndDateMax != endDateMax) {
			NotificationChain msgs = null;
			if (endDateMax != null)
				msgs = ((InternalEObject)endDateMax).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FarmMLPackage.ACTION__END_DATE_MAX, null, msgs);
			if (newEndDateMax != null)
				msgs = ((InternalEObject)newEndDateMax).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FarmMLPackage.ACTION__END_DATE_MAX, null, msgs);
			msgs = basicSetEndDateMax(newEndDateMax, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__END_DATE_MAX, newEndDateMax, newEndDateMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Frequency getFrequency() {
		return frequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequency(Frequency newFrequency) {
		Frequency oldFrequency = frequency;
		frequency = newFrequency == null ? FREQUENCY_EDEFAULT : newFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__FREQUENCY, oldFrequency, frequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(int newDuration) {
		int oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Action getBase_Action() {
		if (base_Action != null && base_Action.eIsProxy()) {
			InternalEObject oldBase_Action = (InternalEObject)base_Action;
			base_Action = (org.eclipse.uml2.uml.Action)eResolveProxy(oldBase_Action);
			if (base_Action != oldBase_Action) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FarmMLPackage.ACTION__BASE_ACTION, oldBase_Action, base_Action));
			}
		}
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Action basicGetBase_Action() {
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Action(org.eclipse.uml2.uml.Action newBase_Action) {
		org.eclipse.uml2.uml.Action oldBase_Action = base_Action;
		base_Action = newBase_Action;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FarmMLPackage.ACTION__BASE_ACTION, oldBase_Action, base_Action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FarmMLPackage.ACTION__START_DATE_MIN:
				return basicSetStartDateMin(null, msgs);
			case FarmMLPackage.ACTION__END_DATE_MAX:
				return basicSetEndDateMax(null, msgs);
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
			case FarmMLPackage.ACTION__START_DATE_MIN:
				return getStartDateMin();
			case FarmMLPackage.ACTION__END_DATE_MAX:
				return getEndDateMax();
			case FarmMLPackage.ACTION__FREQUENCY:
				return getFrequency();
			case FarmMLPackage.ACTION__DURATION:
				return getDuration();
			case FarmMLPackage.ACTION__BASE_ACTION:
				if (resolve) return getBase_Action();
				return basicGetBase_Action();
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
			case FarmMLPackage.ACTION__START_DATE_MIN:
				setStartDateMin((Date)newValue);
				return;
			case FarmMLPackage.ACTION__END_DATE_MAX:
				setEndDateMax((Date)newValue);
				return;
			case FarmMLPackage.ACTION__FREQUENCY:
				setFrequency((Frequency)newValue);
				return;
			case FarmMLPackage.ACTION__DURATION:
				setDuration((Integer)newValue);
				return;
			case FarmMLPackage.ACTION__BASE_ACTION:
				setBase_Action((org.eclipse.uml2.uml.Action)newValue);
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
			case FarmMLPackage.ACTION__START_DATE_MIN:
				setStartDateMin((Date)null);
				return;
			case FarmMLPackage.ACTION__END_DATE_MAX:
				setEndDateMax((Date)null);
				return;
			case FarmMLPackage.ACTION__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case FarmMLPackage.ACTION__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case FarmMLPackage.ACTION__BASE_ACTION:
				setBase_Action((org.eclipse.uml2.uml.Action)null);
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
			case FarmMLPackage.ACTION__START_DATE_MIN:
				return startDateMin != null;
			case FarmMLPackage.ACTION__END_DATE_MAX:
				return endDateMax != null;
			case FarmMLPackage.ACTION__FREQUENCY:
				return frequency != FREQUENCY_EDEFAULT;
			case FarmMLPackage.ACTION__DURATION:
				return duration != DURATION_EDEFAULT;
			case FarmMLPackage.ACTION__BASE_ACTION:
				return base_Action != null;
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
		result.append(" (frequency: ");
		result.append(frequency);
		result.append(", duration: ");
		result.append(duration);
		result.append(')');
		return result.toString();
	}

} //ActionImpl
