/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.subsystem.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.subsystem.SubSystem;
import org.palladiosimulator.pcm.subsystem.SubsystemPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sub System</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.subsystem.impl.SubSystemImpl#getRepository__RepositoryComponent <em>Repository Repository Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubSystemImpl extends ComposedProvidingRequiringEntityImpl implements SubSystem {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SubSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SubsystemPackage.Literals.SUB_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Repository getRepository__RepositoryComponent() {
		return (Repository) eDynamicGet(SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT,
				RepositoryPackage.Literals.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository__RepositoryComponent(Repository newRepository__RepositoryComponent,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRepository__RepositoryComponent,
				SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepository__RepositoryComponent(Repository newRepository__RepositoryComponent) {
		eDynamicSet(SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT,
				RepositoryPackage.Literals.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT,
				newRepository__RepositoryComponent);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
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
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
			return basicSetRepository__RepositoryComponent(null, msgs);
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
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
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
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
			return getRepository__RepositoryComponent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
			setRepository__RepositoryComponent((Repository) newValue);
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
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
			setRepository__RepositoryComponent((Repository) null);
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
		case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
			return getRepository__RepositoryComponent() != null;
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
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
				return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
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
				return SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // SubSystemImpl
