package edu.kit.ipd.sdq.kamp4aps.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyModule;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;

public class ModifyModuleHandler {

	static public void createModifyModule(Map<Interface, Set<Module>> modulesToBeMarked, Collection<Interface> initialMarkedInterface, ChangePropagationDueToHardwareChange cp) {
		int mapHash;
		do {
			mapHash = modulesToBeMarked.hashCode();
			modulesToBeMarked = APSArchitectureModelLookup.lookUpParentModulesOfInterfaces(initialMarkedInterface, cp);
			var modifyModules = createModifyModulesFromAffectedModules(modulesToBeMarked);
			addToModifyModulesToChangePropagation(modifyModules, cp);
		} while (mapHash != modulesToBeMarked.hashCode());
	}
	
	static public List<ModifyModule<Module>> createModifyModulesFromAffectedModules(
			Map<Interface, Set<Module>> modulesToBeMarked) {
		List<ModifyModule<Module>> modifyModules = new ArrayList<ModifyModule<Module>>();
		for(Map.Entry<Interface, Set<Module>> modulesToBeMarkedEntry : modulesToBeMarked.entrySet()){
			for(Module module : modulesToBeMarkedEntry.getValue()){
				ModifyModule<Module> modifyModule = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyModule();
				modifyModule.setToolderived(true);
				modifyModule.setAffectedElement(module);
				modifyModule.getCausingElements().add(modulesToBeMarkedEntry.getKey());
				modifyModule.setId(module.getId() + "_" + module.getName());
				modifyModules.add(modifyModule);
			}
		}
		return modifyModules;
	}
	
	static public void addToModifyModulesToChangePropagation(List<ModifyModule<Module>> modifyModules,
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		List<ModifyModule<Module>> modifyModulesToRemove = new ArrayList<ModifyModule<Module>>();
		for(ModifyModule<Module> currentModifyModule : changePropagationDueToHardwareChange.getModuleModifications()){
			for(ModifyModule<Module> newModifyModule : modifyModules){
				if(currentModifyModule.getAffectedElement().getId() == newModifyModule.getAffectedElement().getId())
					modifyModulesToRemove.add(newModifyModule);
			}
		}
		
		for(ModifyModule<Module> modifyModuleToRemove : modifyModulesToRemove){
			modifyModules.remove(modifyModuleToRemove);
		}
		if(!modifyModules.isEmpty())
			changePropagationDueToHardwareChange.setChanged(true);
		changePropagationDueToHardwareChange.getModuleModifications().addAll(modifyModules);	
	}
}
