/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourcetype.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.core.entity.ResourceInterfaceProvidingEntity;
import org.palladiosimulator.pcm.resourcetype.CommunicationLinkResourceType;
import org.palladiosimulator.pcm.resourcetype.ProcessingResourceType;
import org.palladiosimulator.pcm.resourcetype.ResourceInterface;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.ResourceSignature;
import org.palladiosimulator.pcm.resourcetype.ResourceType;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import org.palladiosimulator.pcm.resourcetype.SchedulingPolicy;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.units.UnitCarryingElement;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see org.palladiosimulator.pcm.resourcetype.ResourcetypePackage
 * @generated
 */
public class ResourcetypeAdapterFactory extends AdapterFactoryImpl {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResourcetypePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcetypeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ResourcetypePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc
	 * --> This implementation returns <code>true</code> if the object is either the model's package
	 * or is an instance object of the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected ResourcetypeSwitch<Adapter> modelSwitch = new ResourcetypeSwitch<Adapter>() {
		@Override
		public Adapter caseResourceSignature(ResourceSignature object) {
			return createResourceSignatureAdapter();
		}

		@Override
		public Adapter caseProcessingResourceType(ProcessingResourceType object) {
			return createProcessingResourceTypeAdapter();
		}

		@Override
		public Adapter caseResourceType(ResourceType object) {
			return createResourceTypeAdapter();
		}

		@Override
		public Adapter caseResourceRepository(ResourceRepository object) {
			return createResourceRepositoryAdapter();
		}

		@Override
		public Adapter caseSchedulingPolicy(SchedulingPolicy object) {
			return createSchedulingPolicyAdapter();
		}

		@Override
		public Adapter caseCommunicationLinkResourceType(CommunicationLinkResourceType object) {
			return createCommunicationLinkResourceTypeAdapter();
		}

		@Override
		public Adapter caseResourceInterface(ResourceInterface object) {
			return createResourceInterfaceAdapter();
		}

		@Override
		public Adapter caseIdentifier(Identifier object) {
			return createIdentifierAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseEntity(Entity object) {
			return createEntityAdapter();
		}

		@Override
		public Adapter caseUnitCarryingElement(UnitCarryingElement object) {
			return createUnitCarryingElementAdapter();
		}

		@Override
		public Adapter caseResourceInterfaceProvidingEntity(ResourceInterfaceProvidingEntity object) {
			return createResourceInterfaceProvidingEntityAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.resourcetype.ResourceSignature <em>Resource Signature</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	         * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	         * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.ResourceSignature
	 * @generated
	 */
	public Adapter createResourceSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.resourcetype.ProcessingResourceType <em>Processing Resource Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation
	         * returns null so that we can easily ignore cases; it's useful to ignore a case when
	         * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.ProcessingResourceType
	 * @generated
	 */
	public Adapter createProcessingResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.palladiosimulator.pcm.resourcetype.ResourceType <em>Resource Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.ResourceType
	 * @generated
	 */
	public Adapter createResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.resourcetype.ResourceRepository <em>Resource Repository</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns
	         * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	         * catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.ResourceRepository
	 * @generated
	 */
	public Adapter createResourceRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.resourcetype.SchedulingPolicy <em>Scheduling Policy</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.SchedulingPolicy
	 * @generated
	 */
	public Adapter createSchedulingPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.resourcetype.CommunicationLinkResourceType <em>Communication Link Resource Type</em>}'.
	 * <!-- begin-user-doc --> This default
	         * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	         * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.CommunicationLinkResourceType
	 * @generated
	 */
	public Adapter createCommunicationLinkResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.resourcetype.ResourceInterface <em>Resource Interface</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	         * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	         * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.resourcetype.ResourceInterface
	 * @generated
	 */
	public Adapter createResourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	         * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
	         * the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.palladiosimulator.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.core.entity.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc
	         * --> This default implementation returns null so that we can easily ignore cases; it's useful
	         * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.core.entity.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	         * {@link de.uka.ipd.sdq.units.UnitCarryingElement <em>Unit Carrying Element</em>}'. <!--
	         * begin-user-doc --> This default implementation returns null so that we can easily ignore
	         * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	         * end-user-doc -->
	         *
	         * @return the new adapter.
	 * @see de.uka.ipd.sdq.units.UnitCarryingElement
	 * @generated
	 */
	public Adapter createUnitCarryingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcm.core.entity.ResourceInterfaceProvidingEntity <em>Resource Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc --> This default
	         * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	         * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.palladiosimulator.pcm.core.entity.ResourceInterfaceProvidingEntity
	 * @generated
	 */
	public Adapter createResourceInterfaceProvidingEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	         * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ResourcetypeAdapterFactory
