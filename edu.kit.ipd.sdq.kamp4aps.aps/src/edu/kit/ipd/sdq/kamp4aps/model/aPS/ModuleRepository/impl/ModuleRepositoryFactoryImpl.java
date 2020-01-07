/**
 */
package edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.impl;

import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.*;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModuleRepositoryFactoryImpl extends EFactoryImpl implements ModuleRepositoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModuleRepositoryFactory init() {
		try {
			ModuleRepositoryFactory theModuleRepositoryFactory = (ModuleRepositoryFactory)EPackage.Registry.INSTANCE.getEFactory(ModuleRepositoryPackage.eNS_URI);
			if (theModuleRepositoryFactory != null) {
				return theModuleRepositoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModuleRepositoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRepositoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModuleRepositoryPackage.MICROSWITCH_MODULE: return createMicroswitchModule();
			case ModuleRepositoryPackage.POTENTIOMETER_MODULE: return createPotentiometerModule();
			case ModuleRepositoryPackage.MODULE_REPOSITORY: return createModuleRepository();
			case ModuleRepositoryPackage.MODULE: return createModule();
			case ModuleRepositoryPackage.RAMP_MODULE: return createRampModule();
			case ModuleRepositoryPackage.PUSHER_MODULE: return createPusherModule();
			case ModuleRepositoryPackage.MOTOR_MODULE: return createMotorModule();
			case ModuleRepositoryPackage.SENSOR_MODULE: return createSensorModule();
			case ModuleRepositoryPackage.OPTICAL_SENSOR_MODULE: return createOpticalSensorModule();
			case ModuleRepositoryPackage.INDUCTIVE_SENSOR_MODULE: return createInductiveSensorModule();
			case ModuleRepositoryPackage.PRESENCE_SENSOR_MODULE: return createPresenceSensorModule();
			case ModuleRepositoryPackage.PRESSURE_SENSOR_MODULE: return createPressureSensorModule();
			case ModuleRepositoryPackage.CONVEYOR_BELT_MODULE: return createConveyorBeltModule();
			case ModuleRepositoryPackage.VACUUM_GRIPPER_MODULE: return createVacuumGripperModule();
			case ModuleRepositoryPackage.MONOSTABLE_CYLINDER_MODULE: return createMonostableCylinderModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MicroswitchModule createMicroswitchModule() {
		MicroswitchModuleImpl microswitchModule = new MicroswitchModuleImpl();
		return microswitchModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PotentiometerModule createPotentiometerModule() {
		PotentiometerModuleImpl potentiometerModule = new PotentiometerModuleImpl();
		return potentiometerModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRepository createModuleRepository() {
		ModuleRepositoryImpl moduleRepository = new ModuleRepositoryImpl();
		return moduleRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RampModule createRampModule() {
		RampModuleImpl rampModule = new RampModuleImpl();
		return rampModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PusherModule createPusherModule() {
		PusherModuleImpl pusherModule = new PusherModuleImpl();
		return pusherModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotorModule createMotorModule() {
		MotorModuleImpl motorModule = new MotorModuleImpl();
		return motorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorModule createSensorModule() {
		SensorModuleImpl sensorModule = new SensorModuleImpl();
		return sensorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpticalSensorModule createOpticalSensorModule() {
		OpticalSensorModuleImpl opticalSensorModule = new OpticalSensorModuleImpl();
		return opticalSensorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InductiveSensorModule createInductiveSensorModule() {
		InductiveSensorModuleImpl inductiveSensorModule = new InductiveSensorModuleImpl();
		return inductiveSensorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresenceSensorModule createPresenceSensorModule() {
		PresenceSensorModuleImpl presenceSensorModule = new PresenceSensorModuleImpl();
		return presenceSensorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PressureSensorModule createPressureSensorModule() {
		PressureSensorModuleImpl pressureSensorModule = new PressureSensorModuleImpl();
		return pressureSensorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConveyorBeltModule createConveyorBeltModule() {
		ConveyorBeltModuleImpl conveyorBeltModule = new ConveyorBeltModuleImpl();
		return conveyorBeltModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VacuumGripperModule createVacuumGripperModule() {
		VacuumGripperModuleImpl vacuumGripperModule = new VacuumGripperModuleImpl();
		return vacuumGripperModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonostableCylinderModule createMonostableCylinderModule() {
		MonostableCylinderModuleImpl monostableCylinderModule = new MonostableCylinderModuleImpl();
		return monostableCylinderModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRepositoryPackage getModuleRepositoryPackage() {
		return (ModuleRepositoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModuleRepositoryPackage getPackage() {
		return ModuleRepositoryPackage.eINSTANCE;
	}

} //ModuleRepositoryFactoryImpl
