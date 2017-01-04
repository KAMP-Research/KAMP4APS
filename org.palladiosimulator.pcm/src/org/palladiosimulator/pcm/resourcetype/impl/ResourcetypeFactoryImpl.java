/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourcetype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.resourcetype.CommunicationLinkResourceType;
import org.palladiosimulator.pcm.resourcetype.ProcessingResourceType;
import org.palladiosimulator.pcm.resourcetype.ResourceInterface;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.ResourceSignature;
import org.palladiosimulator.pcm.resourcetype.ResourcetypeFactory;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import org.palladiosimulator.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ResourcetypeFactoryImpl extends EFactoryImpl implements ResourcetypeFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourcetypeFactory init() {
		try {
			ResourcetypeFactory theResourcetypeFactory = (ResourcetypeFactory) EPackage.Registry.INSTANCE
					.getEFactory(ResourcetypePackage.eNS_URI);
			if (theResourcetypeFactory != null) {
				return theResourcetypeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourcetypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcetypeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ResourcetypePackage.RESOURCE_SIGNATURE:
			return createResourceSignature();
		case ResourcetypePackage.PROCESSING_RESOURCE_TYPE:
			return createProcessingResourceType();
		case ResourcetypePackage.RESOURCE_REPOSITORY:
			return createResourceRepository();
		case ResourcetypePackage.SCHEDULING_POLICY:
			return createSchedulingPolicy();
		case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE:
			return createCommunicationLinkResourceType();
		case ResourcetypePackage.RESOURCE_INTERFACE:
			return createResourceInterface();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceSignature createResourceSignature() {
		ResourceSignatureImpl resourceSignature = new ResourceSignatureImpl();
		return resourceSignature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessingResourceType createProcessingResourceType() {
		ProcessingResourceTypeImpl processingResourceType = new ProcessingResourceTypeImpl();
		return processingResourceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceRepository createResourceRepository() {
		ResourceRepositoryImpl resourceRepository = new ResourceRepositoryImpl();
		return resourceRepository;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SchedulingPolicy createSchedulingPolicy() {
		SchedulingPolicyImpl schedulingPolicy = new SchedulingPolicyImpl();
		return schedulingPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommunicationLinkResourceType createCommunicationLinkResourceType() {
		CommunicationLinkResourceTypeImpl communicationLinkResourceType = new CommunicationLinkResourceTypeImpl();
		return communicationLinkResourceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceInterface createResourceInterface() {
		ResourceInterfaceImpl resourceInterface = new ResourceInterfaceImpl();
		return resourceInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcetypePackage getResourcetypePackage() {
		return (ResourcetypePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourcetypePackage getPackage() {
		return ResourcetypePackage.eINSTANCE;
	}

} // ResourcetypeFactoryImpl
