package edu.kit.ipd.sdq.kamp4aps.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyComponent;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyInterface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.RegularRamp;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;

public class ModifyComponentHandler {
	private ModifyComponent<Component> mf;
	private Component affectedElement;
	private Component causingElement;
	private ChangePropagationDueToHardwareChange cp;
	
	public ModifyComponentHandler(Component component, Component c, ChangePropagationDueToHardwareChange cp) {
		this.affectedElement = c;
		this.causingElement = component;
		this.cp = cp;
		init();
	}
	

	private void init() {
		mf = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyComponent();
		mf.setToolderived(true);
		mf.setAffectedElement(affectedElement);
		mf.getCausingElements().add(causingElement);
	}
	
	public boolean isNewComponent() {
		for(ModifyComponent<Component> modComponent : cp.getComponentModifications()){
			if(modComponent.getAffectedElement() == affectedElement)
				return false;
		}
		return true;
	}
	
	public static boolean isNewComponent(Component component, ChangePropagationDueToHardwareChange cp) {
		for(ModifyComponent<Component> modComponent : cp.getComponentModifications()){
			if(modComponent.getAffectedElement() == component)
				return false;
		}
		return true;		
	}
	
	public static void createNewModifyComponent(Component component, List<Interface> interfaces, ChangePropagationDueToHardwareChange cp) {
		ModifyComponent<Component> modComponent = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyComponent();
		modComponent.setAffectedElement(component);
		modComponent.getCausingElements().addAll(interfaces);
		modComponent.setToolderived(true);
		cp.getComponentModifications().add(modComponent);
	}
	
	public static List<ModifyComponent<Component>> createModifyComponentsFromAffectedComponents(
			Map<Interface, Set<Component>> componentsToBeMarked) {
		List<ModifyComponent<Component>> modifyComponents = new ArrayList<ModifyComponent<Component>>();
		for(Map.Entry<Interface, Set<Component>> componentsToBeMarkedEntry : componentsToBeMarked.entrySet()){
			for(Component component : componentsToBeMarkedEntry.getValue()){
				ModifyComponent<Component> modifyComponent = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyComponent();
				modifyComponent.setToolderived(true);
				modifyComponent.setAffectedElement(component);
				modifyComponent.getCausingElements().add(componentsToBeMarkedEntry.getKey());
				modifyComponent.setId(component.getId() + "_" + component.getName());
				modifyComponents.add(modifyComponent);
			}
		}
		return modifyComponents;
	}
	
	public static void addToModifyComponentsToChangePropagation(List<ModifyComponent<Component>> modifyComponents,
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		List<ModifyComponent<Component>> modifyComponentsToRemove = new ArrayList<ModifyComponent<Component>>();
		for(ModifyComponent<Component> currentModifyComponent : changePropagationDueToHardwareChange.getComponentModifications()){
			for(ModifyComponent<Component> newModifyComponent : modifyComponents){
				if(currentModifyComponent.getAffectedElement().getId() == newModifyComponent.getAffectedElement().getId())
					modifyComponentsToRemove.add(newModifyComponent);
			}
		}
		
		for(ModifyComponent<Component> modifyComponentToRemove : modifyComponentsToRemove){
			modifyComponents.remove(modifyComponentToRemove);
		}
		if(!modifyComponents.isEmpty())
			changePropagationDueToHardwareChange.setChanged(true);
		changePropagationDueToHardwareChange.getComponentModifications().addAll(modifyComponents);	
	}
	
	public static void initModifyComponentsBasedOnInterfaces (
			Map<Interface, Set<Component>> componentsToBeMarked, 
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange,
			Collection<Interface> initialMarkedInterfaces) {
		List<ModifyComponent<Component>> modifyComponents = null;
		int mapHash;
		do {
			mapHash = componentsToBeMarked.hashCode();
			componentsToBeMarked = APSArchitectureModelLookup.lookUpParentComponentsOfInterfaces(initialMarkedInterfaces, changePropagationDueToHardwareChange);
			modifyComponents = ModifyComponentHandler.createModifyComponentsFromAffectedComponents(componentsToBeMarked);
			ModifyComponentHandler.addToModifyComponentsToChangePropagation(modifyComponents, changePropagationDueToHardwareChange);
		} while (mapHash != componentsToBeMarked.hashCode());
	}
	
	public static void addModifyComponentToList(Component component, ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		ModifyComponent<Component> modifyRamp = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyComponent();
		modifyRamp.setAffectedElement(component);
		modifyRamp.setToolderived(true);
		modifyRamp.setId("Modify " + component.getId());
		changePropagationDueToHardwareChange.getComponentModifications().add(modifyRamp);
	}


	public static void initModifyInterfacesBasedOnComponents(
			Map<Component, Set<Interface>> interfacesToBeMarked,
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange,
			Collection<RegularRamp> initialMarkedComponents) {
		List<ModifyInterface<Interface>> modifyInterfaces = null;
		int mapHash;
		do {
			mapHash = interfacesToBeMarked.hashCode();
			interfacesToBeMarked = APSArchitectureModelLookup.lookUpInterfacesOfComponents(initialMarkedComponents, changePropagationDueToHardwareChange);
			modifyInterfaces = ModifyInterfaceHandler.createModifyInterfaceFromAffectedInterfaces(interfacesToBeMarked);
			ModifyInterfaceHandler.addToModifyInterfacesToChangePropagation(modifyInterfaces, changePropagationDueToHardwareChange);
		} while(mapHash != interfacesToBeMarked.hashCode());
		
	}







}
