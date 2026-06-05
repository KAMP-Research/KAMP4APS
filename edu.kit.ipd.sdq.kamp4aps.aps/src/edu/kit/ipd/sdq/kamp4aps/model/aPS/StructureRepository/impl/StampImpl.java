/**
 */
package edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.impl;

import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.BistableCylinder;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.MonostableCylinder;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Sensor;

import edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Stamp;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.StructureRepositoryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stamp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.impl.StampImpl#getStampingCylinder <em>Stamping Cylinder</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.impl.StampImpl#getSlidingCylinder <em>Sliding Cylinder</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.impl.StampImpl#getSensors <em>Sensors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StampImpl extends StructureImpl implements Stamp {
	/**
	 * The cached value of the '{@link #getStampingCylinder() <em>Stamping Cylinder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStampingCylinder()
	 * @generated
	 * @ordered
	 */
	protected MonostableCylinder stampingCylinder;

	/**
	 * The cached value of the '{@link #getSlidingCylinder() <em>Sliding Cylinder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlidingCylinder()
	 * @generated
	 * @ordered
	 */
	protected BistableCylinder slidingCylinder;

	/**
	 * The cached value of the '{@link #getSensors() <em>Sensors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensors()
	 * @generated
	 * @ordered
	 */
	protected EList<Sensor> sensors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StampImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructureRepositoryPackage.Literals.STAMP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MonostableCylinder getStampingCylinder() {
		if (stampingCylinder != null && stampingCylinder.eIsProxy()) {
			InternalEObject oldStampingCylinder = (InternalEObject)stampingCylinder;
			stampingCylinder = (MonostableCylinder)eResolveProxy(oldStampingCylinder);
			if (stampingCylinder != oldStampingCylinder) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructureRepositoryPackage.STAMP__STAMPING_CYLINDER, oldStampingCylinder, stampingCylinder));
			}
		}
		return stampingCylinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonostableCylinder basicGetStampingCylinder() {
		return stampingCylinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStampingCylinder(MonostableCylinder newStampingCylinder) {
		MonostableCylinder oldStampingCylinder = stampingCylinder;
		stampingCylinder = newStampingCylinder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructureRepositoryPackage.STAMP__STAMPING_CYLINDER, oldStampingCylinder, stampingCylinder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BistableCylinder getSlidingCylinder() {
		if (slidingCylinder != null && slidingCylinder.eIsProxy()) {
			InternalEObject oldSlidingCylinder = (InternalEObject)slidingCylinder;
			slidingCylinder = (BistableCylinder)eResolveProxy(oldSlidingCylinder);
			if (slidingCylinder != oldSlidingCylinder) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructureRepositoryPackage.STAMP__SLIDING_CYLINDER, oldSlidingCylinder, slidingCylinder));
			}
		}
		return slidingCylinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BistableCylinder basicGetSlidingCylinder() {
		return slidingCylinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlidingCylinder(BistableCylinder newSlidingCylinder) {
		BistableCylinder oldSlidingCylinder = slidingCylinder;
		slidingCylinder = newSlidingCylinder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructureRepositoryPackage.STAMP__SLIDING_CYLINDER, oldSlidingCylinder, slidingCylinder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Sensor> getSensors() {
		if (sensors == null) {
			sensors = new EObjectResolvingEList<Sensor>(Sensor.class, this, StructureRepositoryPackage.STAMP__SENSORS);
		}
		return sensors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructureRepositoryPackage.STAMP__STAMPING_CYLINDER:
				if (resolve) return getStampingCylinder();
				return basicGetStampingCylinder();
			case StructureRepositoryPackage.STAMP__SLIDING_CYLINDER:
				if (resolve) return getSlidingCylinder();
				return basicGetSlidingCylinder();
			case StructureRepositoryPackage.STAMP__SENSORS:
				return getSensors();
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
			case StructureRepositoryPackage.STAMP__STAMPING_CYLINDER:
				setStampingCylinder((MonostableCylinder)newValue);
				return;
			case StructureRepositoryPackage.STAMP__SLIDING_CYLINDER:
				setSlidingCylinder((BistableCylinder)newValue);
				return;
			case StructureRepositoryPackage.STAMP__SENSORS:
				getSensors().clear();
				getSensors().addAll((Collection<? extends Sensor>)newValue);
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
			case StructureRepositoryPackage.STAMP__STAMPING_CYLINDER:
				setStampingCylinder((MonostableCylinder)null);
				return;
			case StructureRepositoryPackage.STAMP__SLIDING_CYLINDER:
				setSlidingCylinder((BistableCylinder)null);
				return;
			case StructureRepositoryPackage.STAMP__SENSORS:
				getSensors().clear();
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
			case StructureRepositoryPackage.STAMP__STAMPING_CYLINDER:
				return stampingCylinder != null;
			case StructureRepositoryPackage.STAMP__SLIDING_CYLINDER:
				return slidingCylinder != null;
			case StructureRepositoryPackage.STAMP__SENSORS:
				return sensors != null && !sensors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StampImpl
