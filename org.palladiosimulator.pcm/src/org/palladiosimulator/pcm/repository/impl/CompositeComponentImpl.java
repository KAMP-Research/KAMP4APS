/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.palladiosimulator.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.CompleteComponentType;
import org.palladiosimulator.pcm.repository.ComponentType;
import org.palladiosimulator.pcm.repository.CompositeComponent;
import org.palladiosimulator.pcm.repository.ImplementationComponentType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Composite Component</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeComponentImpl#getRepository__RepositoryComponent <em>Repository Repository Component</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeComponentImpl#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeComponentImpl#getComponentParameterUsage_ImplementationComponentType <em>Component Parameter Usage Implementation Component Type</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeComponentImpl#getComponentType <em>Component Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeComponentImpl extends ComposedProvidingRequiringEntityImpl implements CompositeComponent {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected static final ComponentType COMPONENT_TYPE_EDEFAULT = ComponentType.BUSINESS_COMPONENT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COMPOSITE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Repository getRepository__RepositoryComponent() {
		return (Repository) eDynamicGet(RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT,
				RepositoryPackage.Literals.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository__RepositoryComponent(Repository newRepository__RepositoryComponent,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRepository__RepositoryComponent,
				RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepository__RepositoryComponent(Repository newRepository__RepositoryComponent) {
		eDynamicSet(RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT,
				RepositoryPackage.Literals.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT,
				newRepository__RepositoryComponent);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<CompleteComponentType> getParentCompleteComponentTypes() {
		return (EList<CompleteComponentType>) eDynamicGet(
				RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES,
				RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<VariableUsage> getComponentParameterUsage_ImplementationComponentType() {
		return (EList<VariableUsage>) eDynamicGet(
				RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE,
				RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentType getComponentType() {
		return (ComponentType) eDynamicGet(RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE,
				RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComponentType(ComponentType newComponentType) {
		eDynamicSet(RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE,
				RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE, newComponentType);
	}

	/**
	 * The cached OCL expression body for the '
	 * {@link #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Required Interfaces Have To Conform To Complete Type</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationTypes required Interfaces have to be a subset\n"
			+ "-- of CompleteComponentType required Interfaces #\n" + "--\n"
			+ "-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\n" + "--\n"
			+ "-- Recursive Query for parent Interface IDs\n"
			+ "-- see 'lpar2005.pdf' (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\n"
			+ "--let parentInterfaces : Bag(Interface) =\n"
			+ "--	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc1 : Bag(Interface) = Bag{} |\n"
			+ "--		acc1->union(pt.requiredRoles->iterate(r : RequiredRole; acc2 : Bag(Interface) = Bag{} |\n"
			+ "--			acc2->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"
			+ "--		))\n" + "--	) in\n" + "--let anchestorInterfaces : Bag(Interface) =\n"
			+ "--	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc3 : Bag(Interface) = Bag{} |\n"
			+ "--		acc3->union(pt.requiredRoles->iterate(r : RequiredRole; acc4 : Bag(Interface) = Bag{} |\n"
			+ "--			acc4->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"
			+ "--		))\n" + "--	)->union( -- union with anchestors found in former recursion #\n"
			+ "--		self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc5 : Bag(Interface) = Bag{} |\n"
			+ "--			acc5->union(pt.requiredRoles->iterate(r : RequiredRole; acc6 : Bag(Interface) = Bag{} |\n"
			+ "--				acc6->union(r.requiredInterface.parentInterface.anchestorInterfaces) --already Set/Bag\n"
			+ "--			))\n" + "--		)\n" + "--	) in\n"
			+ "-- Directly required interfaces need to be a subset of required anchestorInterfaces of Supertype #\n"
			+ "--anchestorInterfaces.identifier.id->includesAll(\n"
			+ "--	self.requiredRoles->iterate(p : RequiredRole; acc7 : Bag(String) = Bag{} |\n"
			+ "--		acc7->union(p.requiredInterface.identifier.id->asBag())\n" + "--	)	\n" + "--)\n" + "true";

	/**
	 * The cached OCL invariant for the '
	 * {@link #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Required Interfaces Have To Conform To Complete Type</em>}' invariant operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(
								REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
								RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] { "RequiredInterfacesHaveToConformToCompleteType",
												EObjectValidator.getObjectLabel(this, context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '
	 * {@link #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Provided Interfaces Have To Conform To Complete Type</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ### EXACT COPY FROM ABOVE ###\n"
			+ "-- ImplementationComponentTypes provided Interfaces have to be a superset\n"
			+ "-- of CompleteComponentType provided Interfaces #\n" + "--\n"
			+ "-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\n" + "--\n"
			+ "-- Recursive Query for parent Interface IDs\n"
			+ "-- see 'lpar2005.pdf' (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\n"
			+ "--let parentInterfaces : Bag(Interface) =\n"
			+ "--	self.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |\n"
			+ "--		acc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"
			+ "--	) in\n" + "--let anchestorInterfaces : Bag(Interface) =\n"
			+ "--	self.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |\n"
			+ "--		acc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"
			+ "--	)->union( -- union with anchestors found in former recursion #\n"
			+ "--		self.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |\n"
			+ "--			acc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag\n"
			+ "--		)\n" + "--	) in\n"
			+ "	-- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #\n"
			+ "--	anchestorInterfaces.identifier.id->includesAll(\n"
			+ "--		self.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |\n"
			+ "--			pt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |\n"
			+ "--				acc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #\n"
			+ "--			)\n" + "--		)\n" + "--	)\n" + "true";

	/**
	 * The cached OCL invariant for the '
	 * {@link #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Provided Interfaces Have To Conform To Complete Type</em>}' invariant operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(
								PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
								RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] { "providedInterfacesHaveToConformToCompleteType",
												EObjectValidator.getObjectLabel(this, context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '
	 * {@link #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Provided Interface Have To Conform To Component Type</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- assures that InfrastructureComponents only have InfrastructureInterfaces and that BusinessComponents only have OperationInterfaces or EventGroups\n"
			+ "if self.componentType = ComponentType::INFRASTRUCTURE_COMPONENT then\n"
			+ "	self.providedRoles_InterfaceProvidingEntity->select(role | role.oclIsTypeOf(OperationInterface) or role.oclIsTypeOf(EventGroup))->size() = 0\n"
			+ "else if self.componentType = ComponentType::BUSINESS_COMPONENT then\n"
			+ "	self.providedRoles_InterfaceProvidingEntity->select(role | role.oclIsTypeOf(InfrastructureInterface))->size() = 0\n"
			+ "else\n" + "	1 = 0\n" + "endif\n" + "endif";

	/**
	 * The cached OCL invariant for the '
	 * {@link #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Provided Interface Have To Conform To Component Type</em>}' invariant operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean ProvidedInterfaceHaveToConformToComponentType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(
								PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
								RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] { "ProvidedInterfaceHaveToConformToComponentType",
												EObjectValidator.getObjectLabel(this, context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '
	 * {@link #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Provide Same Or More Interfaces As Complete Component Type</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationComponent has to provide the same or more interfaces like the CompleteComponentType (if set) #\n"
			+ "	if\n" + "		 -- apply constraint only for non-empty CompleteComponentTypes #\n"
			+ "		self.parentCompleteComponentTypes->notEmpty()\n" + "	then\n" + "		let\n"
			+ "			--own interfaces:\n" + "			ownInterfaces : Set(OperationInterface)\n"
			+ "			  = self.providedRoles_InterfaceProvidingEntity->select(pr|pr.oclIsTypeOf(OperationProvidedRole))->collect(pr : ProvidedRole | pr.oclAsType (OperationProvidedRole).providedInterface__OperationProvidedRole)->asSet()\n"
			+ "    in    \n" + "    	--complete type interfaces:\n"
			+ "    	self.parentCompleteComponentTypes->forAll\n" + "      ( p : CompleteComponentType |\n"
			+ "        (\n"
			+ "        	p.providedRoles_InterfaceProvidingEntity->select(pr|pr.oclIsTypeOf(OperationProvidedRole))->collect(pr : ProvidedRole | pr.oclAsType (OperationProvidedRole).providedInterface__OperationProvidedRole)->asSet()\n"
			+ "        	-\n" + "        	ownInterfaces\n" + "      	)->isEmpty()\n" + "    	)\n" + "	else\n"
			+ "		true\n" + "	endif";

	/**
	 * The cached OCL invariant for the '{@link #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provide Same Or More Interfaces As Complete Component Type</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean ProvideSameOrMoreInterfacesAsCompleteComponentType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(
								PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
								RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] { "ProvideSameOrMoreInterfacesAsCompleteComponentType",
												EObjectValidator.getObjectLabel(this, context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '
	 * {@link #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Require Same Or Fewer Interfaces As Complete Component Type</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationComponent has to require the same or fewer interfaces like the CompleteComponentType (if set) #\n"
			+ "	if\n" + "		-- apply constraint only for non-empty CompleteComponentTypes #\n"
			+ "		self.parentCompleteComponentTypes->notEmpty()\n" + "	then\n" + "	    let\n"
			+ "	      --own interfaces:\n" + "	      ownInterfaces : Set(OperationInterface) \n"
			+ "	        = self.requiredRoles_InterfaceRequiringEntity->select(rr|rr.oclIsTypeOf(OperationRequiredRole))->collect(rr : RequiredRole | rr.oclAsType (OperationRequiredRole).requiredInterface__OperationRequiredRole)->asSet()\n"
			+ "	    in\n" + "	      --complete type interfaces:\n"
			+ "	      self.parentCompleteComponentTypes->forAll\n" + "	      ( p : CompleteComponentType |\n"
			+ "	      	(\n" + "		      	ownInterfaces\n" + "		        -\n"
			+ "		        p.requiredRoles_InterfaceRequiringEntity->select(rr|rr.oclIsTypeOf(OperationRequiredRole))->collect(rr : RequiredRole | rr.oclAsType (OperationRequiredRole).requiredInterface__OperationRequiredRole)->asSet()\n"
			+ "	      	)->isEmpty()\n" + "	    	)\n" + "	else\n" + "		true\n" + "	endif";

	/**
	 * The cached OCL invariant for the '{@link #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Require Same Or Fewer Interfaces As Complete Component Type</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean RequireSameOrFewerInterfacesAsCompleteComponentType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(
								REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(
						REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
								RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] { "RequireSameOrFewerInterfacesAsCompleteComponentType",
												EObjectValidator.getObjectLabel(this, context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRepository__RepositoryComponent((Repository) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			return basicSetRepository__RepositoryComponent(null, msgs);
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
			return ((InternalEList<?>) getComponentParameterUsage_ImplementationComponentType()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY,
					Repository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			return getRepository__RepositoryComponent();
		case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
			return getParentCompleteComponentTypes();
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
			return getComponentParameterUsage_ImplementationComponentType();
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE:
			return getComponentType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			setRepository__RepositoryComponent((Repository) newValue);
			return;
		case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
			getParentCompleteComponentTypes().clear();
			getParentCompleteComponentTypes().addAll((Collection<? extends CompleteComponentType>) newValue);
			return;
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
			getComponentParameterUsage_ImplementationComponentType().clear();
			getComponentParameterUsage_ImplementationComponentType()
					.addAll((Collection<? extends VariableUsage>) newValue);
			return;
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE:
			setComponentType((ComponentType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			setRepository__RepositoryComponent((Repository) null);
			return;
		case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
			getParentCompleteComponentTypes().clear();
			return;
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
			getComponentParameterUsage_ImplementationComponentType().clear();
			return;
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE:
			setComponentType(COMPONENT_TYPE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
			return getRepository__RepositoryComponent() != null;
		case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
			return !getParentCompleteComponentTypes().isEmpty();
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
			return !getComponentParameterUsage_ImplementationComponentType().isEmpty();
		case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE:
			return getComponentType() != COMPONENT_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RepositoryComponent.class) {
			switch (derivedFeatureID) {
			case RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
				return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
			default:
				return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (derivedFeatureID) {
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
				return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE:
				return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RepositoryComponent.class) {
			switch (baseFeatureID) {
			case RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
				return RepositoryPackage.COMPOSITE_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
			default:
				return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (baseFeatureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				return RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES;
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE:
				return RepositoryPackage.COMPOSITE_COMPONENT__COMPONENT_TYPE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // CompositeComponentImpl
