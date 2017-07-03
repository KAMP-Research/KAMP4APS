/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.IECModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getCallsFunction <em>Calls Function</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getCallsFunctionBlock <em>Calls Function Block</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getName <em>Name</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getId <em>Id</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getType <em>Type</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getImplementsInterface <em>Implements Interface</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getDeclaresVariable <em>Declares Variable</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getUsesEnum <em>Uses Enum</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getAccessesProperty <em>Accesses Property</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getCallsMethod <em>Calls Method</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject {
	/**
	 * Returns the value of the '<em><b>Calls Function</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls Function</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls Function</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_CallsFunction()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getCallsFunction();

	/**
	 * Returns the value of the '<em><b>Calls Function Block</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.FunctionBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls Function Block</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls Function Block</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_CallsFunctionBlock()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionBlock> getCallsFunctionBlock();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(IECRepository.Program)
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_Type()
	 * @model required="true"
	 * @generated
	 */
	IECRepository.Program getType();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Program#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(IECRepository.Program value);

	/**
	 * Returns the value of the '<em><b>Implements Interface</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements Interface</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_ImplementsInterface()
	 * @model containment="true"
	 * @generated
	 */
	EList<IECInterface> getImplementsInterface();

	/**
	 * Returns the value of the '<em><b>Declares Variable</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.GlobalVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declares Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declares Variable</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_DeclaresVariable()
	 * @model containment="true"
	 * @generated
	 */
	EList<GlobalVariable> getDeclaresVariable();

	/**
	 * Returns the value of the '<em><b>Uses Enum</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.Enum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses Enum</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses Enum</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_UsesEnum()
	 * @model containment="true"
	 * @generated
	 */
	EList<edu.kit.ipd.sdq.kamp4iec.model.IECModel.Enum> getUsesEnum();

	/**
	 * Returns the value of the '<em><b>Accesses Property</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECPropertyImplementation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accesses Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accesses Property</em>' reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_AccessesProperty()
	 * @model
	 * @generated
	 */
	EList<IECPropertyImplementation> getAccessesProperty();

	/**
	 * Returns the value of the '<em><b>Calls Method</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECMethodImplementation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls Method</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls Method</em>' reference list.
	 * @see edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelPackage#getProgram_CallsMethod()
	 * @model
	 * @generated
	 */
	EList<IECMethodImplementation> getCallsMethod();

} // Program
