/**
 */
package xPPU.ElectronicComponents;

import xPPU.ComponentRepository.Component;

import xPPU.InterfaceRepository.PhysicalConnection;
import xPPU.InterfaceRepository.SignalInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Electronic Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xPPU.ElectronicComponents.ElectronicPart#getPin <em>Pin</em>}</li>
 *   <li>{@link xPPU.ElectronicComponents.ElectronicPart#getPhysicalconnection <em>Physicalconnection</em>}</li>
 * </ul>
 *
 * @see xPPU.ElectronicComponents.ElectronicComponentsPackage#getElectronicPart()
 * @model abstract="true"
 * @generated
 */
public interface ElectronicPart extends Component {
	/**
	 * Returns the value of the '<em><b>Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pin</em>' reference.
	 * @see #setPin(SignalInterface)
	 * @see xPPU.ElectronicComponents.ElectronicComponentsPackage#getElectronicPart_Pin()
	 * @model required="true"
	 * @generated
	 */
	SignalInterface getPin();

	/**
	 * Sets the value of the '{@link xPPU.ElectronicComponents.ElectronicPart#getPin <em>Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pin</em>' reference.
	 * @see #getPin()
	 * @generated
	 */
	void setPin(SignalInterface value);

	/**
	 * Returns the value of the '<em><b>Physicalconnection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physicalconnection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physicalconnection</em>' reference.
	 * @see #setPhysicalconnection(PhysicalConnection)
	 * @see xPPU.ElectronicComponents.ElectronicComponentsPackage#getElectronicPart_Physicalconnection()
	 * @model required="true"
	 * @generated
	 */
	PhysicalConnection getPhysicalconnection();

	/**
	 * Sets the value of the '{@link xPPU.ElectronicComponents.ElectronicPart#getPhysicalconnection <em>Physicalconnection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physicalconnection</em>' reference.
	 * @see #getPhysicalconnection()
	 * @generated
	 */
	void setPhysicalconnection(PhysicalConnection value);

} // ElectronicPart
