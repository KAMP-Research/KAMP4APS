/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.palladiosimulator.pcm.core.composition.util.CompositionValidator;
import org.palladiosimulator.pcm.core.entity.util.EntityValidator;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.CollectionDataType;
import org.palladiosimulator.pcm.repository.CompleteComponentType;
import org.palladiosimulator.pcm.repository.ComponentType;
import org.palladiosimulator.pcm.repository.CompositeComponent;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.ExceptionType;
import org.palladiosimulator.pcm.repository.ImplementationComponentType;
import org.palladiosimulator.pcm.repository.InfrastructureInterface;
import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.repository.InnerDeclaration;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.ParameterModifier;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.repository.PrimitiveDataType;
import org.palladiosimulator.pcm.repository.PrimitiveTypeEnum;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.ProvidesComponentType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.RequiredCharacterisation;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Role;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see org.palladiosimulator.pcm.repository.RepositoryPackage
 * @generated
 */
public class RepositoryValidator extends EObjectValidator {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final RepositoryValidator INSTANCE = new RepositoryValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.palladiosimulator.pcm.repository";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Seff Type Used Twice' of 'Basic Component'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BASIC_COMPONENT__NO_SEFF_TYPE_USED_TWICE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Required
	 * Interfaces Have To Conform To Complete Type' of 'Implementation Component Type'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided
	 * Interfaces Have To Conform To Complete Type' of 'Implementation Component Type'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided
	 * Interface Have To Conform To Component Type' of 'Implementation Component Type'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provide
	 * Same Or More Interfaces As Complete Component Type' of 'Implementation Component Type'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Require
	 * Same Or Fewer Interfaces As Complete Component Type' of 'Implementation Component Type'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Protocol Type ID Used Twice' of 'Interface'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Names Have To Be Unique For ASignature' of 'Operation Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_SIGNATURE__PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signatures Have To Be Unique For An Interface' of 'Operation Interface'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_INTERFACE__SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Interface Has To Be Provided Or Required By AUsefull Complete Component Type' of 'Complete Component Type'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPLETE_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_OR_REQUIRED_BY_AUSEFULL_COMPLETE_COMPONENT_TYPE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided
	 * Interfaces Have To Conform To Provided Type2' of 'Complete Component Type'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int COMPLETE_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_PROVIDED_TYPE2 = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Interface Has To Be Provided By AUsefull Provides Component Type' of 'Provides Component Type'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROVIDES_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_BY_AUSEFULL_PROVIDES_COMPONENT_TYPE = 12;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 12;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositionValidator compositionValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityValidator entityValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryValidator() {
		super();
		compositionValidator = CompositionValidator.INSTANCE;
		entityValidator = EntityValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return RepositoryPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
		case RepositoryPackage.PASSIVE_RESOURCE:
			return validatePassiveResource((PassiveResource) value, diagnostics, context);
		case RepositoryPackage.BASIC_COMPONENT:
			return validateBasicComponent((BasicComponent) value, diagnostics, context);
		case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE:
			return validateImplementationComponentType((ImplementationComponentType) value, diagnostics, context);
		case RepositoryPackage.REPOSITORY_COMPONENT:
			return validateRepositoryComponent((RepositoryComponent) value, diagnostics, context);
		case RepositoryPackage.PROVIDED_ROLE:
			return validateProvidedRole((ProvidedRole) value, diagnostics, context);
		case RepositoryPackage.PARAMETER:
			return validateParameter((Parameter) value, diagnostics, context);
		case RepositoryPackage.DATA_TYPE:
			return validateDataType((DataType) value, diagnostics, context);
		case RepositoryPackage.REPOSITORY:
			return validateRepository((Repository) value, diagnostics, context);
		case RepositoryPackage.INTERFACE:
			return validateInterface((Interface) value, diagnostics, context);
		case RepositoryPackage.REQUIRED_CHARACTERISATION:
			return validateRequiredCharacterisation((RequiredCharacterisation) value, diagnostics, context);
		case RepositoryPackage.EVENT_GROUP:
			return validateEventGroup((EventGroup) value, diagnostics, context);
		case RepositoryPackage.EVENT_TYPE:
			return validateEventType((EventType) value, diagnostics, context);
		case RepositoryPackage.SIGNATURE:
			return validateSignature((Signature) value, diagnostics, context);
		case RepositoryPackage.EXCEPTION_TYPE:
			return validateExceptionType((ExceptionType) value, diagnostics, context);
		case RepositoryPackage.INFRASTRUCTURE_SIGNATURE:
			return validateInfrastructureSignature((InfrastructureSignature) value, diagnostics, context);
		case RepositoryPackage.INFRASTRUCTURE_INTERFACE:
			return validateInfrastructureInterface((InfrastructureInterface) value, diagnostics, context);
		case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE:
			return validateInfrastructureRequiredRole((InfrastructureRequiredRole) value, diagnostics, context);
		case RepositoryPackage.REQUIRED_ROLE:
			return validateRequiredRole((RequiredRole) value, diagnostics, context);
		case RepositoryPackage.OPERATION_SIGNATURE:
			return validateOperationSignature((OperationSignature) value, diagnostics, context);
		case RepositoryPackage.OPERATION_INTERFACE:
			return validateOperationInterface((OperationInterface) value, diagnostics, context);
		case RepositoryPackage.OPERATION_REQUIRED_ROLE:
			return validateOperationRequiredRole((OperationRequiredRole) value, diagnostics, context);
		case RepositoryPackage.SOURCE_ROLE:
			return validateSourceRole((SourceRole) value, diagnostics, context);
		case RepositoryPackage.SINK_ROLE:
			return validateSinkRole((SinkRole) value, diagnostics, context);
		case RepositoryPackage.OPERATION_PROVIDED_ROLE:
			return validateOperationProvidedRole((OperationProvidedRole) value, diagnostics, context);
		case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE:
			return validateInfrastructureProvidedRole((InfrastructureProvidedRole) value, diagnostics, context);
		case RepositoryPackage.COMPLETE_COMPONENT_TYPE:
			return validateCompleteComponentType((CompleteComponentType) value, diagnostics, context);
		case RepositoryPackage.PROVIDES_COMPONENT_TYPE:
			return validateProvidesComponentType((ProvidesComponentType) value, diagnostics, context);
		case RepositoryPackage.COMPOSITE_COMPONENT:
			return validateCompositeComponent((CompositeComponent) value, diagnostics, context);
		case RepositoryPackage.PRIMITIVE_DATA_TYPE:
			return validatePrimitiveDataType((PrimitiveDataType) value, diagnostics, context);
		case RepositoryPackage.COLLECTION_DATA_TYPE:
			return validateCollectionDataType((CollectionDataType) value, diagnostics, context);
		case RepositoryPackage.COMPOSITE_DATA_TYPE:
			return validateCompositeDataType((CompositeDataType) value, diagnostics, context);
		case RepositoryPackage.INNER_DECLARATION:
			return validateInnerDeclaration((InnerDeclaration) value, diagnostics, context);
		case RepositoryPackage.ROLE:
			return validateRole((Role) value, diagnostics, context);
		case RepositoryPackage.PARAMETER_MODIFIER:
			return validateParameterModifier((ParameterModifier) value, diagnostics, context);
		case RepositoryPackage.COMPONENT_TYPE:
			return validateComponentType((ComponentType) value, diagnostics, context);
		case RepositoryPackage.PRIMITIVE_TYPE_ENUM:
			return validatePrimitiveTypeEnum((PrimitiveTypeEnum) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePassiveResource(PassiveResource passiveResource, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(passiveResource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicComponent(BasicComponent basicComponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(basicComponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(basicComponent,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(basicComponent,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(basicComponent,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(
					basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(
					basicComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBasicComponent_NoSeffTypeUsedTwice(basicComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoSeffTypeUsedTwice constraint of '<em>Basic Component</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateBasicComponent_NoSeffTypeUsedTwice(BasicComponent basicComponent,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return basicComponent.NoSeffTypeUsedTwice(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType(ImplementationComponentType implementationComponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(implementationComponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(implementationComponentType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(
					implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(
					implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(
					implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(
					implementationComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(
					implementationComponentType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RequiredInterfacesHaveToConformToCompleteType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(
			ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return implementationComponentType.RequiredInterfacesHaveToConformToCompleteType(diagnostics, context);
	}

	/**
	 * Validates the providedInterfacesHaveToConformToCompleteType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(
			ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return implementationComponentType.providedInterfacesHaveToConformToCompleteType(diagnostics, context);
	}

	/**
	 * Validates the ProvidedInterfaceHaveToConformToComponentType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(
			ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return implementationComponentType.ProvidedInterfaceHaveToConformToComponentType(diagnostics, context);
	}

	/**
	 * Validates the ProvideSameOrMoreInterfacesAsCompleteComponentType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(
			ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return implementationComponentType.ProvideSameOrMoreInterfacesAsCompleteComponentType(diagnostics, context);
	}

	/**
	 * Validates the RequireSameOrFewerInterfacesAsCompleteComponentType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(
			ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return implementationComponentType.RequireSameOrFewerInterfacesAsCompleteComponentType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepositoryComponent(RepositoryComponent repositoryComponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(repositoryComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidedRole(ProvidedRole providedRole, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(providedRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository(Repository repository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(repository, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface(Interface interface_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(interface_, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInterface_NoProtocolTypeIDUsedTwice(interface_, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoProtocolTypeIDUsedTwice constraint of '<em>Interface</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateInterface_NoProtocolTypeIDUsedTwice(Interface interface_, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return interface_.NoProtocolTypeIDUsedTwice(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredCharacterisation(RequiredCharacterisation requiredCharacterisation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requiredCharacterisation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventGroup(EventGroup eventGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventGroup, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(eventGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInterface_NoProtocolTypeIDUsedTwice(eventGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventType(EventType eventType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignature(Signature signature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(signature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionType(ExceptionType exceptionType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exceptionType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureSignature(InfrastructureSignature infrastructureSignature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(infrastructureSignature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureInterface(InfrastructureInterface infrastructureInterface,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(infrastructureInterface, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInterface_NoProtocolTypeIDUsedTwice(infrastructureInterface, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureRequiredRole(InfrastructureRequiredRole infrastructureRequiredRole,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(infrastructureRequiredRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredRole(RequiredRole requiredRole, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requiredRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationSignature(OperationSignature operationSignature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationSignature, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(operationSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOperationSignature_ParameterNamesHaveToBeUniqueForASignature(operationSignature,
					diagnostics, context);
		return result;
	}

	/**
	 * Validates the ParameterNamesHaveToBeUniqueForASignature constraint of '<em>Operation Signature</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationSignature_ParameterNamesHaveToBeUniqueForASignature(
			OperationSignature operationSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationSignature.ParameterNamesHaveToBeUniqueForASignature(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationInterface(OperationInterface operationInterface, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationInterface, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInterface_NoProtocolTypeIDUsedTwice(operationInterface, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOperationInterface_SignaturesHaveToBeUniqueForAnInterface(operationInterface, diagnostics,
					context);
		return result;
	}

	/**
	 * Validates the SignaturesHaveToBeUniqueForAnInterface constraint of '<em>Operation Interface</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationInterface_SignaturesHaveToBeUniqueForAnInterface(
			OperationInterface operationInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationInterface.SignaturesHaveToBeUniqueForAnInterface(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationRequiredRole(OperationRequiredRole operationRequiredRole,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operationRequiredRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceRole(SourceRole sourceRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sourceRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSinkRole(SinkRole sinkRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sinkRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationProvidedRole(OperationProvidedRole operationProvidedRole,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operationProvidedRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfrastructureProvidedRole(InfrastructureProvidedRole infrastructureProvidedRole,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(infrastructureProvidedRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteComponentType(CompleteComponentType completeComponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(completeComponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(
					completeComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(
					completeComponentType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType
	 * constraint of '<em>Complete Component Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public boolean validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(
			CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return completeComponentType
				.AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(diagnostics, context);
	}

	/**
	 * Validates the providedInterfacesHaveToConformToProvidedType2 constraint of '<em>Complete Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(
			CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return completeComponentType.providedInterfacesHaveToConformToProvidedType2(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidesComponentType(ProvidesComponentType providesComponentType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(providesComponentType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(providesComponentType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(
					providesComponentType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType constraint of '<em>Provides Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(
			ProvidesComponentType providesComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return providesComponentType.AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeComponent(CompositeComponent compositeComponent, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(compositeComponent, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= compositionValidator.validateComposedStructure_MultipleConnectorsConstraint(compositeComponent,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= compositionValidator.validateComposedStructure_MultipleConnectorsConstraintForAssemblyConnectors(
					compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= entityValidator.validateComposedProvidingRequiringEntity_ProvidedRolesMustBeBound(
					compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(
					compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(
					compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(
					compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(
					compositeComponent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(
					compositeComponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveDataType(PrimitiveDataType primitiveDataType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionDataType(CollectionDataType collectionDataType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(collectionDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeDataType(CompositeDataType compositeDataType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compositeDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInnerDeclaration(InnerDeclaration innerDeclaration, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(innerDeclaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole(Role role, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(role, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterModifier(ParameterModifier parameterModifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentType(ComponentType componentType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveTypeEnum(PrimitiveTypeEnum primitiveTypeEnum, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // RepositoryValidator
