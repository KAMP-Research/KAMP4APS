/**
 */
package xPPU.ComponentRepository;

import xPPU.StructureRepository.ControlCabinet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xPPU.ComponentRepository.Controller#getPowersupply <em>Powersupply</em>}</li>
 *   <li>{@link xPPU.ComponentRepository.Controller#getControllerOf <em>Controller Of</em>}</li>
 * </ul>
 *
 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getController()
 * @model
 * @generated
 */
public interface Controller extends Component {
	/**
	 * Returns the value of the '<em><b>Powersupply</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Powersupply</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Powersupply</em>' reference.
	 * @see #setPowersupply(PowerSupply)
	 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getController_Powersupply()
	 * @model required="true"
	 * @generated
	 */
	PowerSupply getPowersupply();

	/**
	 * Sets the value of the '{@link xPPU.ComponentRepository.Controller#getPowersupply <em>Powersupply</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Powersupply</em>' reference.
	 * @see #getPowersupply()
	 * @generated
	 */
	void setPowersupply(PowerSupply value);

	/**
	 * Returns the value of the '<em><b>Controller Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link xPPU.StructureRepository.ControlCabinet#getController <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Of</em>' reference.
	 * @see #setControllerOf(ControlCabinet)
	 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getController_ControllerOf()
	 * @see xPPU.StructureRepository.ControlCabinet#getController
	 * @model opposite="controller" required="true"
	 * @generated
	 */
	ControlCabinet getControllerOf();

	/**
	 * Sets the value of the '{@link xPPU.ComponentRepository.Controller#getControllerOf <em>Controller Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Of</em>' reference.
	 * @see #getControllerOf()
	 * @generated
	 */
	void setControllerOf(ControlCabinet value);

} // Controller
