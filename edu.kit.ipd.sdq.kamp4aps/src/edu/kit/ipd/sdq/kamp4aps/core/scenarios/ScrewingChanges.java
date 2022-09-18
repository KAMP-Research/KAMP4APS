package edu.kit.ipd.sdq.kamp4aps.core.scenarios;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyComponentHandler;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyInterfaceHandler;
import edu.kit.ipd.sdq.kamp4aps.core.changepropagation.InterfaceChanges;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyModule;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;

public class ScrewingChanges extends InterfaceChanges {

	private Collection<Interface> initialMarkedScrewings;
	private Map<Interface, Set<Component>> componentsToBeMarked;
	private Map<Interface, Set<Module>> modulesToBeMarked;

	public ScrewingChanges(APSArchitectureVersion v) {
		super(v);
		initialMarkedScrewings = APSArchitectureModelLookup.lookUpMarkedObjectsOfAType(version, Interface.class);
		componentsToBeMarked = new HashMap<Interface, Set<Component>>();
		modulesToBeMarked = new HashMap<Interface, Set<Module>>();
	}

	public void addInitialMarkedScrewingsToList(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		for(Interface screwing : initialMarkedScrewings){
			ModifyInterfaceHandler.createNewModifyInterface(screwing, changePropagationDueToHardwareChange);
		}
	}
	
	public void calculateAndMarkAffectedComponentsByScrewingChange(ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange){
		ModifyComponentHandler.initModifyComponentsBasedOnInterfaces(componentsToBeMarked, changePropagationDueToHardwareChange, initialMarkedScrewings);
	}
	
	public void calclulateAndMarkAffectedModulesByScrewingChange(ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange){
		List<ModifyModule<Module>> modifyModules = null;
		int mapHash;
		do {
			mapHash = modulesToBeMarked.hashCode();
			modulesToBeMarked = APSArchitectureModelLookup.lookUpParentModulesOfInterfaces(initialMarkedScrewings, changePropagationDueToHardwareChange);
			modifyModules = createModifyModulesFromAffectedModules(modulesToBeMarked);
			addToModifyModulesToChangePropagation(modifyModules, changePropagationDueToHardwareChange);
		} while (mapHash != modulesToBeMarked.hashCode());
	}

}
