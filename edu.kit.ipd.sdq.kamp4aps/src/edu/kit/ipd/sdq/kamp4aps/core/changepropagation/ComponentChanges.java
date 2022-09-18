package edu.kit.ipd.sdq.kamp4aps.core.changepropagation;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyInterfaceHandler;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyComponent;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyInterface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;

public class ComponentChanges extends Change {
	
	private Collection<Component> initialMarkedComponents;
	
	public ComponentChanges(APSArchitectureVersion v){
		super(v);
		initialMarkedComponents = APSArchitectureModelLookup.lookUpMarkedObjectsOfAType(version, Component.class);
	}
	
	public void addInitialMarkedModulesToList(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		for(Component component : initialMarkedComponents){
			ModifyComponent<Component> modifyComponent = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyComponent();
			modifyComponent.setToolderived(false);
			modifyComponent.setAffectedElement(component);
			modifyComponent.setId("Modification of " + component.getName());
			changePropagationDueToHardwareChange.getComponentModifications().add(modifyComponent);
		}
	}

	public void calculateAndMarkToInterfacePropagation(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		calculateComponentToInterfacePropagation(changePropagationDueToHardwareChange);
	}
	
		private void calculateComponentToInterfacePropagation(
				ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
			Map<Component, Set<Interface>> interfacesToBeMarked = new HashMap<Component, Set<Interface>>();
			List<ModifyInterface<Interface>> modifyInterface = null;
			int mapHash;
			do {
				mapHash = interfacesToBeMarked.hashCode();
				interfacesToBeMarked = APSArchitectureModelLookup.lookUpInterfacesOfComponents(initialMarkedComponents, changePropagationDueToHardwareChange);
				modifyInterface = ModifyInterfaceHandler.createModifyInterfaceFromAffectedInterfaces(interfacesToBeMarked);
				ModifyInterfaceHandler.addToModifyInterfacesToChangePropagation(modifyInterface, changePropagationDueToHardwareChange);
			} while(mapHash != interfacesToBeMarked.hashCode());
		}

}
