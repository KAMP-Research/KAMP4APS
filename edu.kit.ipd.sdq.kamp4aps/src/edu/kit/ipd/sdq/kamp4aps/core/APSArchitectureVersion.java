package edu.kit.ipd.sdq.kamp4aps.core;

import edu.kit.ipd.sdq.kamp4aps.model.DeploymentContext.DeploymentContextFactory;
import edu.kit.ipd.sdq.kamp4aps.model.DeploymentContext.DeploymentContextRepository;
import edu.kit.ipd.sdq.kamp.architecture.AbstractArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.FieldOfActivityAnnotationRepository;
import edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.KAMP4aPSFieldofactivityannotationsFactory;
import edu.kit.ipd.sdq.kamp4hmi.model.HMIModificationmarks.HMIModificationMarksRepository;
import edu.kit.ipd.sdq.kamp4hmi.model.HMIModificationmarks.HMIModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4hmi.model.Kamp4hmiModel.Kamp4hmiModelFactory;
import edu.kit.ipd.sdq.kamp4iec.core.IECArchitectureVersion;
import edu.kit.ipd.sdq.kamp4iec.core.IECArchitectureVersion.ArchitectureVersionParams;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECFieldOfActivityAnnotationsFactory;
import edu.kit.ipd.sdq.kamp4iec.model.IECFieldOfActivityAnnotations.IECFieldOfActivityAnnotationsRepository;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.Configuration;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.IECModelFactory;
import edu.kit.ipd.sdq.kamp4iec.model.IECModificationmarks.AbstractKAMP4IECModificationRepository;
import edu.kit.ipd.sdq.kamp4iec.model.IECModificationmarks.IECModificationRepository;
import edu.kit.ipd.sdq.kamp4iec.model.IECModificationmarks.IECModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECRepositoryFactory;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Repository;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.AbstractKAMP4aPSModificationRepository;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationRepository;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.Plant;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.apsFactory;

/**
 * This class creates the structural and non-structural
 * in memory representations.
 * 
 * @author Sandro Koch
 *
 */

public class APSArchitectureVersion extends AbstractArchitectureVersion<AbstractKAMP4aPSModificationRepository<?>> {
	private FieldOfActivityAnnotationRepository _fieldOfActivityRepository;
	private Plant _aPSPlant;
	private DeploymentContextRepository _deploymentContextRepository;
	private Repository _IECRepository;
	private Configuration _configuration;
	private IECFieldOfActivityAnnotationsRepository _iecFieldOfActivityRepository;
	public IECModificationRepository _iecModificationMarkRepository;
	private edu.kit.ipd.sdq.kamp4hmi.model.Kamp4hmiModel.Repository _hmiRepository;
	private edu.kit.ipd.sdq.kamp4hmi.model.HMIModificationmarks.HMIModificationMarksRepository _hmiModificationRepository;
	
	public static class ArchitectureVersionParams{
		public String name;
		public FieldOfActivityAnnotationRepository fieldOfActivityRepository;
		public KAMP4aPSModificationRepository modificationMarkRepository;
		public DeploymentContextRepository deploymentContextRepository;
		public Plant aPSPlant;

		public IECModificationRepository iecModificationMarkRepository;
		public Repository iecRepository;
		public Configuration configuration;
		public IECFieldOfActivityAnnotationsRepository iecFieldOfActivityRepository;
		
		public edu.kit.ipd.sdq.kamp4hmi.model.Kamp4hmiModel.Repository hmiRepository;
		public HMIModificationMarksRepository hmiModificationMarksRepository;
	}
	
	public APSArchitectureVersion(ArchitectureVersionParams params) {
		super(params.name, params.modificationMarkRepository);
		// Some of the files describing the architecture might not exist; prevent NullPointer
		// in propagation algorithm by setting newly created objects (whose EReferences are
		// instantiated with empty collections, so the algorithm can handle them)
		
		if (params.fieldOfActivityRepository == null)
			params.fieldOfActivityRepository = KAMP4aPSFieldofactivityannotationsFactory.eINSTANCE.
					createFieldOfActivityAnnotationRepository();
		this._fieldOfActivityRepository = params.fieldOfActivityRepository;
		
		if (params.aPSPlant == null)
			params.aPSPlant = apsFactory.eINSTANCE.createPlant();
		this._aPSPlant = params.aPSPlant;
		
		if(params.deploymentContextRepository == null)
			params.deploymentContextRepository = DeploymentContextFactory.eINSTANCE.createDeploymentContextRepository();
		this._deploymentContextRepository = params.deploymentContextRepository;
		
		if (params.iecRepository == null) {
			params.iecRepository = IECRepositoryFactory.eINSTANCE.
					createRepository();
		}
		this._IECRepository = params.iecRepository;
		
		if (params.configuration == null) {
			params.configuration = IECModelFactory.eINSTANCE.
					createConfiguration();
		}
		this._configuration = params.configuration;
		
		if (params.iecFieldOfActivityRepository == null) {
			params.iecFieldOfActivityRepository = IECFieldOfActivityAnnotationsFactory.eINSTANCE.
					createIECFieldOfActivityAnnotationsRepository();
		}
		this._iecFieldOfActivityRepository = params.iecFieldOfActivityRepository;
		
		if (params.iecModificationMarkRepository == null) {
			params.iecModificationMarkRepository = IECModificationmarksFactory.eINSTANCE.
					createIECModificationRepository();
		}
		this._iecModificationMarkRepository = params.iecModificationMarkRepository;
		
		if (params.hmiRepository == null) {
			params.hmiRepository = Kamp4hmiModelFactory.eINSTANCE.createRepository();
		}
		this._hmiRepository = params.hmiRepository;	
		
		if (params.hmiModificationMarksRepository == null) {
			params.hmiModificationMarksRepository = HMIModificationmarksFactory.eINSTANCE.createHMIModificationMarksRepository();
		}
		this._hmiModificationRepository = params.hmiModificationMarksRepository;	
	}

	public FieldOfActivityAnnotationRepository getFieldOfActivityRepository() {
		return _fieldOfActivityRepository;
	}

	public void setFieldOfActivityRepository(
			FieldOfActivityAnnotationRepository fieldOfActivityRepository) {
		this._fieldOfActivityRepository = fieldOfActivityRepository;
	}

	public Plant getAPSPlant(){
		return _aPSPlant;
	}

	public void setAPSPlant(Plant plant) {
		this._aPSPlant = plant;
	}

	public DeploymentContextRepository getDeploymentContextRepository(){
		return _deploymentContextRepository;
	}

	public Repository getIECRepository() {
		return _IECRepository;
	}

	public void setIECRepository(Repository iecRepository) {
		this._IECRepository = iecRepository;
	}

	public Configuration getConfiguration() {
		return _configuration;
	}

	public void setKonfiguration(Configuration configuration) {
		this._configuration = configuration;
	}

	public IECFieldOfActivityAnnotationsRepository getIECFieldOfActivityRepository() {
		return _iecFieldOfActivityRepository;
	}

	public void setIECFieldOfActivityRepository(IECFieldOfActivityAnnotationsRepository fieldOfActivityRepository) {
		this._iecFieldOfActivityRepository = fieldOfActivityRepository;
	}

	public IECModificationRepository getIECModificationMarkRepository() {
		return _iecModificationMarkRepository;
	}

	public void setIECModificationMarkRepository(IECModificationRepository _iecModificationMarkRepository) {
		this._iecModificationMarkRepository = _iecModificationMarkRepository;
	}

	public edu.kit.ipd.sdq.kamp4hmi.model.Kamp4hmiModel.Repository getHmiRepository() {
		return _hmiRepository;
	}

	public void setHmiRepository(edu.kit.ipd.sdq.kamp4hmi.model.Kamp4hmiModel.Repository _hmiRepository) {
		this._hmiRepository = _hmiRepository;
	}

	public edu.kit.ipd.sdq.kamp4hmi.model.HMIModificationmarks.HMIModificationMarksRepository getHmiModificationRepository() {
		return _hmiModificationRepository;
	}

	public void setHmiModificationRepository(
			edu.kit.ipd.sdq.kamp4hmi.model.HMIModificationmarks.HMIModificationMarksRepository _hmiModificationRepository) {
		this._hmiModificationRepository = _hmiModificationRepository;
	}
	
	public static IECArchitectureVersion extractIECArchitecture(APSArchitectureVersion apsArchitectureVersion) {
		IECArchitectureVersion iecVersion = new IECArchitectureVersion(new edu.kit.ipd.sdq.kamp4iec.core.IECArchitectureVersion.ArchitectureVersionParams());
		iecVersion.setFieldOfActivityRepository(apsArchitectureVersion.getIECFieldOfActivityRepository());
		iecVersion.setIECRepository(apsArchitectureVersion.getIECRepository());
		iecVersion.setKonfiguration(apsArchitectureVersion.getConfiguration());
		iecVersion.setModificationMarkRepository(apsArchitectureVersion.getIECModificationMarkRepository());
		iecVersion.setName(apsArchitectureVersion.getName());
		iecVersion.setHMIModificationRepository(apsArchitectureVersion.getHmiModificationRepository());
		iecVersion.setHMIRepository(apsArchitectureVersion.getHmiRepository());
		return iecVersion;
	}
}
