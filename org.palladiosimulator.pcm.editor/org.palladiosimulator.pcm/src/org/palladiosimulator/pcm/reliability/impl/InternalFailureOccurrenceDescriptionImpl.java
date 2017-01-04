/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.reliability.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.palladiosimulator.pcm.reliability.InternalFailureOccurrenceDescription;
import org.palladiosimulator.pcm.reliability.ReliabilityPackage;
import org.palladiosimulator.pcm.reliability.SoftwareInducedFailureType;
import org.palladiosimulator.pcm.reliability.util.ReliabilityValidator;
import org.palladiosimulator.pcm.seff.InternalAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Internal Failure Occurrence Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.reliability.impl.InternalFailureOccurrenceDescriptionImpl#getInternalAction__InternalFailureOccurrenceDescription <em>Internal Action Internal Failure Occurrence Description</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.reliability.impl.InternalFailureOccurrenceDescriptionImpl#getSoftwareInducedFailureType__InternalFailureOccurrenceDescription <em>Software Induced Failure Type Internal Failure Occurrence Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalFailureOccurrenceDescriptionImpl extends FailureOccurrenceDescriptionImpl
		implements InternalFailureOccurrenceDescription {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalFailureOccurrenceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InternalAction getInternalAction__InternalFailureOccurrenceDescription() {
		return (InternalAction) eDynamicGet(
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalAction__InternalFailureOccurrenceDescription(
			InternalAction newInternalAction__InternalFailureOccurrenceDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newInternalAction__InternalFailureOccurrenceDescription,
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalAction__InternalFailureOccurrenceDescription(
			InternalAction newInternalAction__InternalFailureOccurrenceDescription) {
		eDynamicSet(
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				newInternalAction__InternalFailureOccurrenceDescription);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SoftwareInducedFailureType getSoftwareInducedFailureType__InternalFailureOccurrenceDescription() {
		return (SoftwareInducedFailureType) eDynamicGet(
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInducedFailureType basicGetSoftwareInducedFailureType__InternalFailureOccurrenceDescription() {
		return (SoftwareInducedFailureType) eDynamicGet(
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription(
			SoftwareInducedFailureType newSoftwareInducedFailureType__InternalFailureOccurrenceDescription,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newSoftwareInducedFailureType__InternalFailureOccurrenceDescription,
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSoftwareInducedFailureType__InternalFailureOccurrenceDescription(
			SoftwareInducedFailureType newSoftwareInducedFailureType__InternalFailureOccurrenceDescription) {
		eDynamicSet(
				ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
				newSoftwareInducedFailureType__InternalFailureOccurrenceDescription);
	}

	/**
	 * The cached OCL expression body for the '{@link #NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Resource Timeout Failure Allowed For Internal Failure Occurrence Description</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.softwareInducedFailureType__InternalFailureOccurrenceDescription.oclIsTypeOf(ResourceTimeoutFailureType)";
	/**
	 * The cached OCL invariant for the '{@link #NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Resource Timeout Failure Allowed For Internal Failure Occurrence Description</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION);
			try {
				NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(
								NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(
						NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, ReliabilityValidator.DIAGNOSTIC_SOURCE,
								ReliabilityValidator.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__NO_RESOURCE_TIMEOUT_FAILURE_ALLOWED_FOR_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] {
												"NoResourceTimeoutFailureAllowedForInternalFailureOccurrenceDescription",
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetInternalAction__InternalFailureOccurrenceDescription((InternalAction) otherEnd, msgs);
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			SoftwareInducedFailureType softwareInducedFailureType__InternalFailureOccurrenceDescription = basicGetSoftwareInducedFailureType__InternalFailureOccurrenceDescription();
			if (softwareInducedFailureType__InternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject) softwareInducedFailureType__InternalFailureOccurrenceDescription)
						.eInverseRemove(this,
								ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SOFTWARE_INDUCED_FAILURE_TYPE,
								SoftwareInducedFailureType.class, msgs);
			return basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription(
					(SoftwareInducedFailureType) otherEnd, msgs);
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			return basicSetInternalAction__InternalFailureOccurrenceDescription(null, msgs);
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			return basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription(null, msgs);
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			return eInternalContainer().eInverseRemove(this,
					SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION,
					InternalAction.class, msgs);
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			return getInternalAction__InternalFailureOccurrenceDescription();
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			if (resolve)
				return getSoftwareInducedFailureType__InternalFailureOccurrenceDescription();
			return basicGetSoftwareInducedFailureType__InternalFailureOccurrenceDescription();
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			setInternalAction__InternalFailureOccurrenceDescription((InternalAction) newValue);
			return;
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			setSoftwareInducedFailureType__InternalFailureOccurrenceDescription((SoftwareInducedFailureType) newValue);
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			setInternalAction__InternalFailureOccurrenceDescription((InternalAction) null);
			return;
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			setSoftwareInducedFailureType__InternalFailureOccurrenceDescription((SoftwareInducedFailureType) null);
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
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			return getInternalAction__InternalFailureOccurrenceDescription() != null;
		case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
			return basicGetSoftwareInducedFailureType__InternalFailureOccurrenceDescription() != null;
		}
		return super.eIsSet(featureID);
	}

} // InternalFailureOccurrenceDescriptionImpl