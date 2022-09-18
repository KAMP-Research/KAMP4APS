package edu.kit.ipd.sdq.kamp4aps.core.changepropagation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyComponentHandler;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyInterfaceHandler;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyModule;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;
import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.GlobalVariable;
import edu.kit.ipd.sdq.kamp4iec.model.IECModificationmarks.IECChangePropagationDueToDataDependency;
import edu.kit.ipd.sdq.kamp4iec.model.IECModificationmarks.IECModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4iec.model.IECModificationmarks.IECModifyGlobalVariable;

public class InterfaceChanges extends Change {

	private Collection<Interface> initialMarkedInterfaces;

	public InterfaceChanges(APSArchitectureVersion v) {
		super(v);
		initialMarkedInterfaces = APSArchitectureModelLookup.lookUpMarkedObjectsOfAType(version, Interface.class);
		
	}
	
	public void addInitialMarkedInterfacesToList(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		for(Interface interfac : initialMarkedInterfaces){
			ModifyInterfaceHandler.createNewModifyInterface(interfac, changePropagationDueToHardwareChange);
		}
	}

	public void calculateAndMarkToModulePropagation(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		Map<Interface, Set<Module>> modulesToBeMarked = new HashMap<Interface, Set<Module>>();
		List<ModifyModule<Module>> modifyModules = null;
		int mapHash;
		do {
			mapHash = modulesToBeMarked.hashCode();
			modulesToBeMarked = APSArchitectureModelLookup.lookUpParentModulesOfInterfaces(initialMarkedInterfaces, changePropagationDueToHardwareChange);
			modifyModules = createModifyModulesFromAffectedModules(modulesToBeMarked);
			addToModifyModulesToChangePropagation(modifyModules, changePropagationDueToHardwareChange);
		} while (mapHash != modulesToBeMarked.hashCode());
	}
	
		protected List<ModifyModule<Module>> createModifyModulesFromAffectedModules(
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
		
	
		protected void addToModifyModulesToChangePropagation(List<ModifyModule<Module>> modifyModules,
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

	public void calculateAndMarkToComponentPropagation(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		Map<Interface, Set<Component>> componentsToBeMarked = new HashMap<Interface, Set<Component>>();
		ModifyComponentHandler.initModifyComponentsBasedOnInterfaces(componentsToBeMarked, changePropagationDueToHardwareChange, initialMarkedInterfaces);
	}
	

	public void flattenAllModifyInterfaces(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		ModifyInterfaceHandler.flattenAllModifyInterfacen(changePropagationDueToHardwareChange);
	}	

	public void calculateAndMarkToGlobalVariablePropagation(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange, IECChangePropagationDueToDataDependency changePropagationDueToDataDependency) {
		Map<Interface, Set<GlobalVariable>> globalVariablesToBeMarked = new HashMap<Interface, Set<GlobalVariable>>();
		List<IECModifyGlobalVariable> modifyGlobalVariables = null;
		int mapHash;
		do {
			mapHash = globalVariablesToBeMarked.hashCode();
			globalVariablesToBeMarked = APSArchitectureModelLookup.lookUpGlobalVariablesOfInterfaces(version, initialMarkedInterfaces, changePropagationDueToHardwareChange);
			modifyGlobalVariables = createModifyGlobalVariablesFromAffectedInterfaces(globalVariablesToBeMarked);
			addToModifyGlobalVariablesToChangePropagation(modifyGlobalVariables, changePropagationDueToDataDependency);
		} while (mapHash != globalVariablesToBeMarked.hashCode());
	}
	
	protected List<IECModifyGlobalVariable> createModifyGlobalVariablesFromAffectedInterfaces(
			Map<Interface, Set<GlobalVariable>> modulesToBeMarked) {
		List<IECModifyGlobalVariable> modifyVariables = new ArrayList<IECModifyGlobalVariable>();
		for(Map.Entry<Interface, Set<GlobalVariable>> modulesToBeMarkedEntry : modulesToBeMarked.entrySet()){
			for(GlobalVariable globalVariable : modulesToBeMarkedEntry.getValue()){
				IECModifyGlobalVariable modifyGlobalVariable = IECModificationmarksFactory.eINSTANCE.createIECModifyGlobalVariable();
				modifyGlobalVariable.setToolderived(true);
				modifyGlobalVariable.setAffectedElement(globalVariable);
				modifyGlobalVariable.getCausingElements().add(modulesToBeMarkedEntry.getKey());
				modifyGlobalVariable.setId(globalVariable.getId() + "_" + globalVariable.getName());
				modifyVariables.add(modifyGlobalVariable);
			}
		}
		return modifyVariables;
	}
	
	
	protected void addToModifyGlobalVariablesToChangePropagation(List<IECModifyGlobalVariable> modifyGlobalVariables,
			IECChangePropagationDueToDataDependency changePropagationDueToDataDependency) {
		List<IECModifyGlobalVariable> modifyModulesToRemove = new ArrayList<IECModifyGlobalVariable>();
		for(IECModifyGlobalVariable currentModifyModule : changePropagationDueToDataDependency.getGlobalVariableModifications()){
			for(IECModifyGlobalVariable newModifyModule : modifyGlobalVariables){
				if(currentModifyModule.getAffectedElement().getId() == newModifyModule.getAffectedElement().getId())
					modifyModulesToRemove.add(newModifyModule);
			}
		}
		
		for(IECModifyGlobalVariable modifyModuleToRemove : modifyModulesToRemove){
			modifyGlobalVariables.remove(modifyModuleToRemove);
		}
		if(!modifyGlobalVariables.isEmpty())
			changePropagationDueToDataDependency.setChanged(true);
		changePropagationDueToDataDependency.getGlobalVariableModifications().addAll(modifyGlobalVariables);	
	}
}
