/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.impl;

import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
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
import org.palladiosimulator.pcm.core.CorePackage;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.core.composition.AssemblyEventConnector;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.EventChannelSinkConnector;
import org.palladiosimulator.pcm.core.util.CoreValidator;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.qosannotations.qos_performance.QosPerformancePackage;
import org.palladiosimulator.pcm.qosannotations.qos_performance.SpecifiedExecutionTime;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.LoopAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall;
import org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand;
import org.palladiosimulator.pcm.seff.seff_performance.ResourceCall;
import org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage;
import org.palladiosimulator.pcm.stochasticexpressions.parser.MyPCMStoExLexer;
import org.palladiosimulator.pcm.stochasticexpressions.parser.MyPCMStoExParser;
import org.palladiosimulator.pcm.usagemodel.ClosedWorkload;
import org.palladiosimulator.pcm.usagemodel.Delay;
import org.palladiosimulator.pcm.usagemodel.Loop;
import org.palladiosimulator.pcm.usagemodel.OpenWorkload;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.impl.RandomVariableImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCM Random Variable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getClosedWorkload_PCMRandomVariable <em>Closed Workload PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getPassiveResource_capacity_PCMRandomVariable <em>Passive Resource capacity PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getVariableCharacterisation_Specification <em>Variable Characterisation Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getInfrastructureCall__PCMRandomVariable <em>Infrastructure Call PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getResourceCall__PCMRandomVariable <em>Resource Call PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getParametricResourceDemand_PCMRandomVariable <em>Parametric Resource Demand PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getLoopAction_PCMRandomVariable <em>Loop Action PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getGuardedBranchTransition_PCMRandomVariable <em>Guarded Branch Transition PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getSpecifiedExecutionTime_PCMRandomVariable <em>Specified Execution Time PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getEventChannelSinkConnector__FilterCondition <em>Event Channel Sink Connector Filter Condition</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getAssemblyEventConnector__FilterCondition <em>Assembly Event Connector Filter Condition</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getLoop_LoopIteration <em>Loop Loop Iteration</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getOpenWorkload_PCMRandomVariable <em>Open Workload PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getDelay_TimeSpecification <em>Delay Time Specification</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable <em>Communication Link Resource Specifcation throughput PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getProcessingResourceSpecification_processingRate_PCMRandomVariable <em>Processing Resource Specification processing Rate PCM Random Variable</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.impl.PCMRandomVariableImpl#getCommunicationLinkResourceSpecification_latency_PCMRandomVariable <em>Communication Link Resource Specification latency PCM Random Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PCMRandomVariableImpl extends RandomVariableImpl implements PCMRandomVariable {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMRandomVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PCM_RANDOM_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClosedWorkload getClosedWorkload_PCMRandomVariable() {
		return (ClosedWorkload) eDynamicGet(CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClosedWorkload_PCMRandomVariable(
			ClosedWorkload newClosedWorkload_PCMRandomVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newClosedWorkload_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClosedWorkload_PCMRandomVariable(ClosedWorkload newClosedWorkload_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE,
				newClosedWorkload_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PassiveResource getPassiveResource_capacity_PCMRandomVariable() {
		return (PassiveResource) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPassiveResource_capacity_PCMRandomVariable(
			PassiveResource newPassiveResource_capacity_PCMRandomVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newPassiveResource_capacity_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPassiveResource_capacity_PCMRandomVariable(
			PassiveResource newPassiveResource_capacity_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE,
				newPassiveResource_capacity_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableCharacterisation getVariableCharacterisation_Specification() {
		return (VariableCharacterisation) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableCharacterisation_Specification(
			VariableCharacterisation newVariableCharacterisation_Specification, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newVariableCharacterisation_Specification,
				CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableCharacterisation_Specification(
			VariableCharacterisation newVariableCharacterisation_Specification) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION,
				newVariableCharacterisation_Specification);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InfrastructureCall getInfrastructureCall__PCMRandomVariable() {
		return (InfrastructureCall) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfrastructureCall__PCMRandomVariable(
			InfrastructureCall newInfrastructureCall__PCMRandomVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newInfrastructureCall__PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInfrastructureCall__PCMRandomVariable(InfrastructureCall newInfrastructureCall__PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE,
				newInfrastructureCall__PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceCall getResourceCall__PCMRandomVariable() {
		return (ResourceCall) eDynamicGet(CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceCall__PCMRandomVariable(ResourceCall newResourceCall__PCMRandomVariable,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newResourceCall__PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceCall__PCMRandomVariable(ResourceCall newResourceCall__PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE,
				newResourceCall__PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParametricResourceDemand getParametricResourceDemand_PCMRandomVariable() {
		return (ParametricResourceDemand) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParametricResourceDemand_PCMRandomVariable(
			ParametricResourceDemand newParametricResourceDemand_PCMRandomVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParametricResourceDemand_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParametricResourceDemand_PCMRandomVariable(
			ParametricResourceDemand newParametricResourceDemand_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE,
				newParametricResourceDemand_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LoopAction getLoopAction_PCMRandomVariable() {
		return (LoopAction) eDynamicGet(CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopAction_PCMRandomVariable(LoopAction newLoopAction_PCMRandomVariable,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLoopAction_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoopAction_PCMRandomVariable(LoopAction newLoopAction_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE,
				newLoopAction_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GuardedBranchTransition getGuardedBranchTransition_PCMRandomVariable() {
		return (GuardedBranchTransition) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardedBranchTransition_PCMRandomVariable(
			GuardedBranchTransition newGuardedBranchTransition_PCMRandomVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newGuardedBranchTransition_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGuardedBranchTransition_PCMRandomVariable(
			GuardedBranchTransition newGuardedBranchTransition_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE,
				newGuardedBranchTransition_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecifiedExecutionTime getSpecifiedExecutionTime_PCMRandomVariable() {
		return (SpecifiedExecutionTime) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedExecutionTime_PCMRandomVariable(
			SpecifiedExecutionTime newSpecifiedExecutionTime_PCMRandomVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newSpecifiedExecutionTime_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecifiedExecutionTime_PCMRandomVariable(
			SpecifiedExecutionTime newSpecifiedExecutionTime_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE,
				newSpecifiedExecutionTime_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventChannelSinkConnector getEventChannelSinkConnector__FilterCondition() {
		return (EventChannelSinkConnector) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventChannelSinkConnector__FilterCondition(
			EventChannelSinkConnector newEventChannelSinkConnector__FilterCondition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newEventChannelSinkConnector__FilterCondition,
				CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventChannelSinkConnector__FilterCondition(
			EventChannelSinkConnector newEventChannelSinkConnector__FilterCondition) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION,
				newEventChannelSinkConnector__FilterCondition);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyEventConnector getAssemblyEventConnector__FilterCondition() {
		return (AssemblyEventConnector) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssemblyEventConnector__FilterCondition(
			AssemblyEventConnector newAssemblyEventConnector__FilterCondition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newAssemblyEventConnector__FilterCondition,
				CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssemblyEventConnector__FilterCondition(
			AssemblyEventConnector newAssemblyEventConnector__FilterCondition) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
				newAssemblyEventConnector__FilterCondition);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Loop getLoop_LoopIteration() {
		return (Loop) eDynamicGet(CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoop_LoopIteration(Loop newLoop_LoopIteration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLoop_LoopIteration,
				CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoop_LoopIteration(Loop newLoop_LoopIteration) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION, newLoop_LoopIteration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenWorkload getOpenWorkload_PCMRandomVariable() {
		return (OpenWorkload) eDynamicGet(CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpenWorkload_PCMRandomVariable(OpenWorkload newOpenWorkload_PCMRandomVariable,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOpenWorkload_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenWorkload_PCMRandomVariable(OpenWorkload newOpenWorkload_PCMRandomVariable) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE,
				newOpenWorkload_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Delay getDelay_TimeSpecification() {
		return (Delay) eDynamicGet(CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelay_TimeSpecification(Delay newDelay_TimeSpecification, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newDelay_TimeSpecification,
				CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelay_TimeSpecification(Delay newDelay_TimeSpecification) {
		eDynamicSet(CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION, newDelay_TimeSpecification);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable() {
		return (CommunicationLinkResourceSpecification) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(
			CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(
			CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable) {
		eDynamicSet(
				CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE,
				newCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessingResourceSpecification getProcessingResourceSpecification_processingRate_PCMRandomVariable() {
		return (ProcessingResourceSpecification) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessingResourceSpecification_processingRate_PCMRandomVariable(
			ProcessingResourceSpecification newProcessingResourceSpecification_processingRate_PCMRandomVariable,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newProcessingResourceSpecification_processingRate_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProcessingResourceSpecification_processingRate_PCMRandomVariable(
			ProcessingResourceSpecification newProcessingResourceSpecification_processingRate_PCMRandomVariable) {
		eDynamicSet(
				CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE,
				newProcessingResourceSpecification_processingRate_PCMRandomVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecification_latency_PCMRandomVariable() {
		return (CommunicationLinkResourceSpecification) eDynamicGet(
				CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommunicationLinkResourceSpecification_latency_PCMRandomVariable(
			CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecification_latency_PCMRandomVariable,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newCommunicationLinkResourceSpecification_latency_PCMRandomVariable,
				CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommunicationLinkResourceSpecification_latency_PCMRandomVariable(
			CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecification_latency_PCMRandomVariable) {
		eDynamicSet(
				CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
				CorePackage.Literals.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE,
				newCommunicationLinkResourceSpecification_latency_PCMRandomVariable);
	}

	/**
	 * The cached OCL expression body for the '{@link #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specification Must Not Be NULL</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.specification.oclIsUndefined() and self.specification <> ''";
	/**
	 * The cached OCL invariant for the '{@link #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specification Must Not Be NULL</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SpecificationMustNotBeNULL(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean SpecificationMustNotBeNULL(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(CorePackage.Literals.PCM_RANDOM_VARIABLE);
			try {
				SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(SPECIFICATION_MUST_NOT_BE_NULL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, CoreValidator.DIAGNOSTIC_SOURCE,
								CoreValidator.PCM_RANDOM_VARIABLE__SPECIFICATION_MUST_NOT_BE_NULL,
								EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
										new Object[] { "SpecificationMustNotBeNULL",
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetClosedWorkload_PCMRandomVariable((ClosedWorkload) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPassiveResource_capacity_PCMRandomVariable((PassiveResource) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetVariableCharacterisation_Specification((VariableCharacterisation) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetInfrastructureCall__PCMRandomVariable((InfrastructureCall) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetResourceCall__PCMRandomVariable((ResourceCall) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParametricResourceDemand_PCMRandomVariable((ParametricResourceDemand) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLoopAction_PCMRandomVariable((LoopAction) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetGuardedBranchTransition_PCMRandomVariable((GuardedBranchTransition) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetSpecifiedExecutionTime_PCMRandomVariable((SpecifiedExecutionTime) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetEventChannelSinkConnector__FilterCondition((EventChannelSinkConnector) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetAssemblyEventConnector__FilterCondition((AssemblyEventConnector) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLoop_LoopIteration((Loop) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetOpenWorkload_PCMRandomVariable((OpenWorkload) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetDelay_TimeSpecification((Delay) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(
					(CommunicationLinkResourceSpecification) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetProcessingResourceSpecification_processingRate_PCMRandomVariable(
					(ProcessingResourceSpecification) otherEnd, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetCommunicationLinkResourceSpecification_latency_PCMRandomVariable(
					(CommunicationLinkResourceSpecification) otherEnd, msgs);
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			return basicSetClosedWorkload_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			return basicSetPassiveResource_capacity_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			return basicSetVariableCharacterisation_Specification(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			return basicSetInfrastructureCall__PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			return basicSetResourceCall__PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			return basicSetParametricResourceDemand_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			return basicSetLoopAction_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			return basicSetGuardedBranchTransition_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			return basicSetSpecifiedExecutionTime_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			return basicSetEventChannelSinkConnector__FilterCondition(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			return basicSetAssemblyEventConnector__FilterCondition(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			return basicSetLoop_LoopIteration(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			return basicSetOpenWorkload_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			return basicSetDelay_TimeSpecification(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			return basicSetCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			return basicSetProcessingResourceSpecification_processingRate_PCMRandomVariable(null, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			return basicSetCommunicationLinkResourceSpecification_latency_PCMRandomVariable(null, msgs);
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD, ClosedWorkload.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, PassiveResource.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			return eInternalContainer().eInverseRemove(this,
					ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION,
					VariableCharacterisation.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
					InfrastructureCall.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL, ResourceCall.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND,
					ParametricResourceDemand.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this, SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION,
					LoopAction.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION,
					GuardedBranchTransition.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME,
					SpecifiedExecutionTime.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			return eInternalContainer().eInverseRemove(this,
					CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
					EventChannelSinkConnector.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			return eInternalContainer().eInverseRemove(this,
					CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
					AssemblyEventConnector.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			return eInternalContainer().eInverseRemove(this, UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP, Loop.class,
					msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, OpenWorkload.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			return eInternalContainer().eInverseRemove(this, UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY,
					Delay.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
					CommunicationLinkResourceSpecification.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION,
					ProcessingResourceSpecification.class, msgs);
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			return eInternalContainer().eInverseRemove(this,
					ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
					CommunicationLinkResourceSpecification.class, msgs);
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			return getClosedWorkload_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			return getPassiveResource_capacity_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			return getVariableCharacterisation_Specification();
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			return getInfrastructureCall__PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			return getResourceCall__PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			return getParametricResourceDemand_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			return getLoopAction_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			return getGuardedBranchTransition_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			return getSpecifiedExecutionTime_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			return getEventChannelSinkConnector__FilterCondition();
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			return getAssemblyEventConnector__FilterCondition();
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			return getLoop_LoopIteration();
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			return getOpenWorkload_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			return getDelay_TimeSpecification();
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			return getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			return getProcessingResourceSpecification_processingRate_PCMRandomVariable();
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			return getCommunicationLinkResourceSpecification_latency_PCMRandomVariable();
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			setClosedWorkload_PCMRandomVariable((ClosedWorkload) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			setPassiveResource_capacity_PCMRandomVariable((PassiveResource) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			setVariableCharacterisation_Specification((VariableCharacterisation) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			setInfrastructureCall__PCMRandomVariable((InfrastructureCall) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			setResourceCall__PCMRandomVariable((ResourceCall) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			setParametricResourceDemand_PCMRandomVariable((ParametricResourceDemand) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			setLoopAction_PCMRandomVariable((LoopAction) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			setGuardedBranchTransition_PCMRandomVariable((GuardedBranchTransition) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			setSpecifiedExecutionTime_PCMRandomVariable((SpecifiedExecutionTime) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			setEventChannelSinkConnector__FilterCondition((EventChannelSinkConnector) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			setAssemblyEventConnector__FilterCondition((AssemblyEventConnector) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			setLoop_LoopIteration((Loop) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			setOpenWorkload_PCMRandomVariable((OpenWorkload) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			setDelay_TimeSpecification((Delay) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			setCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(
					(CommunicationLinkResourceSpecification) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			setProcessingResourceSpecification_processingRate_PCMRandomVariable(
					(ProcessingResourceSpecification) newValue);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			setCommunicationLinkResourceSpecification_latency_PCMRandomVariable(
					(CommunicationLinkResourceSpecification) newValue);
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			setClosedWorkload_PCMRandomVariable((ClosedWorkload) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			setPassiveResource_capacity_PCMRandomVariable((PassiveResource) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			setVariableCharacterisation_Specification((VariableCharacterisation) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			setInfrastructureCall__PCMRandomVariable((InfrastructureCall) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			setResourceCall__PCMRandomVariable((ResourceCall) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			setParametricResourceDemand_PCMRandomVariable((ParametricResourceDemand) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			setLoopAction_PCMRandomVariable((LoopAction) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			setGuardedBranchTransition_PCMRandomVariable((GuardedBranchTransition) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			setSpecifiedExecutionTime_PCMRandomVariable((SpecifiedExecutionTime) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			setEventChannelSinkConnector__FilterCondition((EventChannelSinkConnector) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			setAssemblyEventConnector__FilterCondition((AssemblyEventConnector) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			setLoop_LoopIteration((Loop) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			setOpenWorkload_PCMRandomVariable((OpenWorkload) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			setDelay_TimeSpecification((Delay) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			setCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(
					(CommunicationLinkResourceSpecification) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			setProcessingResourceSpecification_processingRate_PCMRandomVariable((ProcessingResourceSpecification) null);
			return;
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			setCommunicationLinkResourceSpecification_latency_PCMRandomVariable(
					(CommunicationLinkResourceSpecification) null);
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
		case CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE:
			return getClosedWorkload_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE:
			return getPassiveResource_capacity_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_CHARACTERISATION_SPECIFICATION:
			return getVariableCharacterisation_Specification() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE:
			return getInfrastructureCall__PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE:
			return getResourceCall__PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE:
			return getParametricResourceDemand_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE:
			return getLoopAction_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE:
			return getGuardedBranchTransition_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE:
			return getSpecifiedExecutionTime_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION:
			return getEventChannelSinkConnector__FilterCondition() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION:
			return getAssemblyEventConnector__FilterCondition() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION:
			return getLoop_LoopIteration() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE:
			return getOpenWorkload_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__DELAY_TIME_SPECIFICATION:
			return getDelay_TimeSpecification() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE:
			return getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE:
			return getProcessingResourceSpecification_processingRate_PCMRandomVariable() != null;
		case CorePackage.PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE:
			return getCommunicationLinkResourceSpecification_latency_PCMRandomVariable() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();
	/**
	 * Cached version of specification to decide if re-parsing is required.
	 *
	 * @generated NOT
	 */
	private String lastParsedSpecification;
	/**
	 * Cached version of parsed specification to return if no re-parsing is required.
	 *
	 * @generated NOT
	 */
	private Expression lastParseExpression;

	/**
	 * Get the basic stochastic expression derived from the specification. This overrides the
	 * RandomVariable implementation of this method and takes use of the parser and lexer for our
	 * stochastic expression language.
	 *
	 * @return The prepared Expression parsed from the specification string.
	 *
	 * @generated not
	 */
	@Override
	public Expression basicGetExpression() {
		if (this.lastParseExpression == null || !this.lastParsedSpecification.equals(this.getSpecification())) {
			// re-parsing required
			final MyPCMStoExLexer lexer = new MyPCMStoExLexer(new ANTLRStringStream(this.getSpecification()));
			final MyPCMStoExParser parser = new MyPCMStoExParser(new CommonTokenStream(lexer));
			Expression e;
			try {
				e = parser.expression();
			} catch (final RecognitionException e1) {
				e = null;
			}
			if (parser.hasErrors()) {
				e = null;
			}
			this.lastParseExpression = e;
			this.lastParsedSpecification = new String(this.getSpecification());
		} else {
			// old parsed result can be returned
		}
		return this.lastParseExpression;
	}

} // PCMRandomVariableImpl
