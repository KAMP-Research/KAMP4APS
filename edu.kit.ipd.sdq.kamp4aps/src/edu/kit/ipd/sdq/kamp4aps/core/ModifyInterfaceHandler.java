package edu.kit.ipd.sdq.kamp4aps.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;

import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyComponent;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyInterface;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyMicroSwitchModule;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;

public class ModifyInterfaceHandler {
	private ModifyInterface<Interface> mf;
	private Interface affectedElement;
	private Component causingElement;
	private ChangePropagationDueToHardwareChange cp;
	
	public ModifyInterfaceHandler(Component component, Interface i, ChangePropagationDueToHardwareChange cp) {
		this.affectedElement = i;
		this.causingElement = component;
		this.cp = cp;
		init();
	}
	
	private void init() {
		mf = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyInterface();
		mf.setToolderived(true);
		mf.setAffectedElement(affectedElement);
		mf.getCausingElements().add(causingElement);
	}
	
	public boolean isNewInterface() {
		var res = cp.getInterfaceModifications()
				.stream()
				.filter(modInterface ->  modInterface.getAffectedElement() == affectedElement)
				.collect(Collectors.toList());
		if(res.isEmpty())
			return true;
		return false;		
	}
	
	public ModifyInterface<Interface> getModifyInterface(){
		return mf;
	}

	public static void createNewModifyInterface(Interface interfac, ChangePropagationDueToHardwareChange cp) {
		ModifyInterface<Interface> modifyInterface = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyInterface();
		modifyInterface.setToolderived(false);
		modifyInterface.setAffectedElement(interfac);
		modifyInterface.setId("Modification of " + interfac.getName());
		cp.getInterfaceModifications().add(modifyInterface);
//		changePropagationDueToHardwareChange.setChanged(true);
	}
	
	
	public static void flattenAllModifyInterfacen(ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		EList<ModifyInterface<Interface>> modifyInterfaces = changePropagationDueToHardwareChange.getInterfaceModifications();
		List<ModifyInterface<Interface>> flattenModifyInterfaces = new ArrayList<ModifyInterface<Interface>>();
		for(ModifyInterface<Interface> modifyInterface : modifyInterfaces){
			boolean modifyWasSet = false;
			for(ModifyInterface<Interface> secondModifyInterface : modifyInterfaces){
				if(modifyInterface.getAffectedElement().getId() == secondModifyInterface.getAffectedElement().getId()
						&& modifyInterface != secondModifyInterface){
					ModifyInterface<Interface> newModifyInterface = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyInterface();
					newModifyInterface.setToolderived(true);
					newModifyInterface.setAffectedElement(modifyInterface.getAffectedElement());
					newModifyInterface.setId(modifyInterface.getId());
					newModifyInterface.getCausingElements().addAll(modifyInterface.getCausingElements());
					newModifyInterface.getCausingElements().addAll(secondModifyInterface.getCausingElements());
					flattenModifyInterfaces.add(newModifyInterface);
					modifyWasSet = true;
				}
			}
			if(!modifyWasSet)
				flattenModifyInterfaces.add(modifyInterface);
		}
		
		List<ModifyInterface<Interface>> plainModifyInterfaces = new ArrayList<ModifyInterface<Interface>>();
		for(ModifyInterface<Interface> modifyInterface : flattenModifyInterfaces){
			boolean containsModifyInterface = false;
			for(ModifyInterface<Interface> plainModifyInterface : plainModifyInterfaces){
				if(plainModifyInterface.getAffectedElement().getId() == modifyInterface.getAffectedElement().getId()){
					containsModifyInterface = true;
				}
			}
			if(!containsModifyInterface)
				plainModifyInterfaces.add(modifyInterface);
		}
		changePropagationDueToHardwareChange.getInterfaceModifications().clear();
		changePropagationDueToHardwareChange.getInterfaceModifications().addAll(plainModifyInterfaces);
	}
	
	public static List<ModifyInterface<Interface>> createModifyInterfaceFromAffectedInterfaces(
			Map<Component, Set<Interface>> interfacesToBeMarked) {
			List<ModifyInterface<Interface>> modifyInterfaces = new ArrayList<ModifyInterface<Interface>>();
			for(Map.Entry<Component, Set<Interface>> interfacesToBeMarkedEntry : interfacesToBeMarked.entrySet()){
				for(Interface interfac : interfacesToBeMarkedEntry.getValue()){
					ModifyInterface<Interface> modifyInterface = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyInterface();
					modifyInterface.setToolderived(true);
					modifyInterface.setAffectedElement(interfac);
					modifyInterface.getCausingElements().add(interfacesToBeMarkedEntry.getKey());
					modifyInterface.setId(interfac.getId() + "_" + interfac.getName());
					modifyInterfaces.add(modifyInterface);
				}
			}
			return modifyInterfaces;		
	}
	
	public static void addToModifyInterfacesToChangePropagation(List<ModifyInterface<Interface>> modifyInterfaces,
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		// TODO Auto-generated method stub
		
	}
	
	public static void createIntorfacesFromMicroSwitchModules(ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange,
			List<Interface> interfaces, ModifyMicroSwitchModule modifyMicroSwitchModule) {
		List<ModifyInterface<Interface>> modifyInterfaces = new ArrayList<ModifyInterface<Interface>>();
		for(Interface i : interfaces){
			createNewModifyInterface(i, changePropagationDueToHardwareChange);
		}
		
		changePropagationDueToHardwareChange.getMicroSwitchModuleModifications().add(modifyMicroSwitchModule);
		modifyInterfaces.forEach(mInterface -> {
			changePropagationDueToHardwareChange.getInterfaceModifications().add(mInterface);
		});

	}
	


}
