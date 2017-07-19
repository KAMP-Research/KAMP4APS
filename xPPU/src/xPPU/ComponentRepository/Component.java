/**
 */
package xPPU.ComponentRepository;

import org.eclipse.emf.common.util.EList;

import xPPU.Identifier.Identifier;

import xPPU.InterfaceRepository.Interface;

import xPPU.ModuleRepository.Module;

import xPPU.StructureRepository.Structure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xPPU.ComponentRepository.Component#getConnectedInterfaces <em>Connected Interfaces</em>}</li>
 *   <li>{@link xPPU.ComponentRepository.Component#getParent <em>Parent</em>}</li>
 *   <li>{@link xPPU.ComponentRepository.Component#getParentModule <em>Parent Module</em>}</li>
 * </ul>
 *
 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends Identifier {
	/**
	 * Returns the value of the '<em><b>Connected Interfaces</b></em>' reference list.
	 * The list contents are of type {@link xPPU.InterfaceRepository.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected Interfaces</em>' reference list.
	 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getComponent_ConnectedInterfaces()
	 * @model
	 * @generated
	 */
	EList<Interface> getConnectedInterfaces();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link xPPU.StructureRepository.Structure#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Structure)
	 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getComponent_Parent()
	 * @see xPPU.StructureRepository.Structure#getComponents
	 * @model opposite="components" transient="false"
	 * @generated
	 */
	Structure getParent();

	/**
	 * Sets the value of the '{@link xPPU.ComponentRepository.Component#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Structure value);

	/**
	 * Returns the value of the '<em><b>Parent Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link xPPU.ModuleRepository.Module#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Module</em>' reference.
	 * @see #setParentModule(Module)
	 * @see xPPU.ComponentRepository.ComponentRepositoryPackage#getComponent_ParentModule()
	 * @see xPPU.ModuleRepository.Module#getComponents
	 * @model opposite="components"
	 * @generated
	 */
	Module getParentModule();

	/**
	 * Sets the value of the '{@link xPPU.ComponentRepository.Component#getParentModule <em>Parent Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Module</em>' reference.
	 * @see #getParentModule()
	 * @generated
	 */
	void setParentModule(Module value);

} // Component
