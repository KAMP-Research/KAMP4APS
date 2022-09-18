package edu.kit.ipd.sdq.kamp4aps.core.scenarios;

import java.util.Collection;
import java.util.List;

import edu.kit.ipd.sdq.kamp.architecture.ArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyInterfaceHandler;
import edu.kit.ipd.sdq.kamp4aps.core.changepropagation.Change;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyMicroSwitchModule;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyModule;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyStructure;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.MicroswitchModule;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.TurningTable;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;

import edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Structure;

public class SwitchChanges extends Change {

	public SwitchChanges(APSArchitectureVersion v) {
		super(v);
	}

	public Collection<MicroswitchModule> getInitialMarkedMicroswitchModules() {
		return ArchitectureModelLookup.lookUpMarkedObjectsOfAType(version, MicroswitchModule.class);
	}

	public ModifyMicroSwitchModule generateModifyMicroswitchModule(
			MicroswitchModule microswitchModule, ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		
		List<Interface> interfaces = microswitchModule.getInterfaces();
		Collection<MicroswitchModule> initialMarkedMicroswitches = getInitialMarkedMicroswitchModules();
		
		ModifyMicroSwitchModule modifyMicroSwitchModule = KAMP4aPSModificationmarksFactory.eINSTANCE
				.createModifyMicroSwitchModule();
		modifyMicroSwitchModule.setToolderived(true);
		modifyMicroSwitchModule.setAffectedElement(microswitchModule);
		modifyMicroSwitchModule.getCausingElements().addAll(initialMarkedMicroswitches);
		modifyMicroSwitchModule.setIsReplaced(true);
		
		for(Module module : version.getAPSPlant().getModuleRepository().getAllModulesInPlant()){
			if(module instanceof TurningTable){
				TurningTable tt = (TurningTable)module;
				if(microswitchModule == tt.getMicroswitchModule()){
					ModifyModule<Module> mtt = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyModule();
					mtt.setToolderived(true);
					mtt.setAffectedElement(tt);
					mtt.getCausingElements().addAll(initialMarkedMicroswitches);
					
					ModifyStructure<Structure> mcrane = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyStructure();
					mcrane.setToolderived(true);
					mcrane.setAffectedElement(tt.getTable_to_stand_on().getParent());
					mcrane.getCausingElements().addAll(initialMarkedMicroswitches);
					mcrane.getCausingElements().add(tt);
					
					if(!changePropagationDueToHardwareChange.getModuleModifications().contains(mtt))
						changePropagationDueToHardwareChange.getModuleModifications().add(mtt);
					
					if(!changePropagationDueToHardwareChange.getStructureModifications().contains(mcrane))
						changePropagationDueToHardwareChange.getStructureModifications().add(mcrane);
				}
			}
		}
		ModifyInterfaceHandler.createIntorfacesFromMicroSwitchModules(changePropagationDueToHardwareChange, interfaces, modifyMicroSwitchModule);
		return modifyMicroSwitchModule;
	}


	public void addMicroswitchModificationToChangePropagation(MicroswitchModule microswitchModule, ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		changePropagationDueToHardwareChange.getMicroSwitchModuleModifications().add(generateModifyMicroswitchModule(
				microswitchModule, changePropagationDueToHardwareChange));
	}
}
