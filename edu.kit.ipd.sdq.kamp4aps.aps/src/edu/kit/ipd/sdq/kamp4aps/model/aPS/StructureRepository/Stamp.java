/**
 */
package edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository;

import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.BistableCylinder;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.MonostableCylinder;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Sensor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stamp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Stamp#getStampingCylinder <em>Stamping Cylinder</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Stamp#getSlidingCylinder <em>Sliding Cylinder</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Stamp#getSensors <em>Sensors</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.StructureRepositoryPackage#getStamp()
 * @model
 * @generated
 */
public interface Stamp extends Structure {
	/**
	 * Returns the value of the '<em><b>Stamping Cylinder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stamping Cylinder</em>' reference.
	 * @see #setStampingCylinder(MonostableCylinder)
	 * @see edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.StructureRepositoryPackage#getStamp_StampingCylinder()
	 * @model required="true"
	 * @generated
	 */
	MonostableCylinder getStampingCylinder();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Stamp#getStampingCylinder <em>Stamping Cylinder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stamping Cylinder</em>' reference.
	 * @see #getStampingCylinder()
	 * @generated
	 */
	void setStampingCylinder(MonostableCylinder value);

	/**
	 * Returns the value of the '<em><b>Sliding Cylinder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sliding Cylinder</em>' reference.
	 * @see #setSlidingCylinder(BistableCylinder)
	 * @see edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.StructureRepositoryPackage#getStamp_SlidingCylinder()
	 * @model required="true"
	 * @generated
	 */
	BistableCylinder getSlidingCylinder();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Stamp#getSlidingCylinder <em>Sliding Cylinder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sliding Cylinder</em>' reference.
	 * @see #getSlidingCylinder()
	 * @generated
	 */
	void setSlidingCylinder(BistableCylinder value);

	/**
	 * Returns the value of the '<em><b>Sensors</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Sensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensors</em>' reference list.
	 * @see edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.StructureRepositoryPackage#getStamp_Sensors()
	 * @model
	 * @generated
	 */
	EList<Sensor> getSensors();

} // Stamp
