package edu.kit.ipd.sdq.kamp4aps.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSSeedModifications;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyComponent;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyEntity;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyInterface;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyModule;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyStructure;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Structure;
import edu.kit.ipd.sdq.kamp4aps.model.basic.Entity;

public class APSAbstractChangePropagationAnalysis {

	public static void abstractChangePropagationAnalysis(APSArchitectureVersion version, ChangePropagationDueToHardwareChange changePropagation) {
		
		KAMP4aPSSeedModifications seedModifications = version.getModificationMarkRepository().getSeedModifications();
		
		List<Entity> nonInterfaceSeeds = seedModifications.getComponentModifications().stream()
				.map((m) -> (Entity) m.getAffectedElement())
				.collect(Collectors.toList());
		nonInterfaceSeeds.addAll(seedModifications.getStructureModifications().stream()
				.map((m) -> (Entity) m.getAffectedElement())
				.collect(Collectors.toList()));
		nonInterfaceSeeds.addAll(seedModifications.getModuleModifications().stream()
				.map((m) -> (Entity) m.getAffectedElement())
				.collect(Collectors.toList()));
		
		List<Interface> interfaceSeeds = seedModifications.getInterfaceModifications().stream()
				.map((m) -> m.getAffectedElement())
				.collect(Collectors.toList());
		
		Queue<Module> moduleChanges = new ArrayDeque<Module>();
		for (Entity seed : nonInterfaceSeeds) {
			addEntityToChangePropagation(seed, Optional.empty(), false, changePropagation);
			
			// lookup parent of seed, children of seed and interfaces referencing seed
			List<Entity> changes = new ArrayList<Entity>();
			changes.add(APSAbstractArchitectureModelLookup.lookupParent(seed));
			changes.addAll(APSAbstractArchitectureModelLookup.lookupChildren(seed));
			List<Interface> interfaces = APSAbstractArchitectureModelLookup.lookupInterfaces(seed, version.getAPSPlant());
			changes.addAll(interfaces);
			
			moduleChanges.addAll(addAllWithSeedAndReturnModules(changes, seed, changePropagation));	
			
			// lookup all elements referenced by interfaces which also reference the seed
			for (Interface iface : interfaces) {
				List<Entity> interfaceChanges = APSAbstractArchitectureModelLookup.lookupReferencesofInterface(iface, seed);
				moduleChanges.addAll(addAllWithSeedAndReturnModules(interfaceChanges, iface, changePropagation));
			}
		}
		
		// for interface seeds only lookup parent elements
		for (Interface iface : interfaceSeeds) {
			addEntityToChangePropagation(iface, Optional.empty(), false, changePropagation);
			List<Entity> changes = iface.getParentElement();
			moduleChanges.addAll(addAllWithSeedAndReturnModules(changes, iface, changePropagation));		
		}
		
		while (!moduleChanges.isEmpty()) {
			Module module = moduleChanges.remove();
			List<Entity> moduleChildren = APSAbstractArchitectureModelLookup.lookupChildren(module);
			moduleChanges.addAll(addAllWithSeedAndReturnModules(moduleChildren, module, changePropagation));
		}
	}
	
	private static List<Module> addAllWithSeedAndReturnModules(List<Entity> entities, Entity seed, ChangePropagationDueToHardwareChange changePropagation) {
		for (Entity entity : entities) {
			addEntityToChangePropagation(entity, Optional.of(seed), true, changePropagation);
		}
		return filterByModules(entities);
	}
	
	private static List<Module> filterByModules(List<Entity> list) {
		return list.stream().filter((e) -> e instanceof Module).map((e) -> (Module) e).collect(Collectors.toList());
	}
	
	private static void addEntityToChangePropagation(Entity entity, Optional<Entity> causingElement, boolean toolderived, ChangePropagationDueToHardwareChange changePropagation) {
		// check for Component, Interface, Module and Structure not for specific types
		
		if (entity instanceof Component) {
			Component component = (Component) entity;
			ModifyComponent<Component> modify = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyComponent();
			addToChangePropagation(component, modify, causingElement, toolderived, changePropagation.getComponentModifications());
		}
		else if (entity instanceof Interface) {
			Interface iface = (Interface) entity;
			ModifyInterface<Interface> modify = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyInterface();
			addToChangePropagation(iface, modify, causingElement, toolderived, changePropagation.getInterfaceModifications());
		}
		else if (entity instanceof Module) {
			Module module = (Module) entity;
			ModifyModule<Module> modify = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyModule();
			addToChangePropagation(module, modify, causingElement, toolderived, changePropagation.getModuleModifications());
		}
		else if (entity instanceof Structure) {
			Structure structure = (Structure) entity;
			ModifyStructure<Structure> modify = KAMP4aPSModificationmarksFactory.eINSTANCE.createModifyStructure();
			addToChangePropagation(structure, modify, causingElement, toolderived, changePropagation.getStructureModifications());
		}
	}
	
	private static <EntityType extends Entity, ModifyType extends ModifyEntity<EntityType>> void addToChangePropagation(
			EntityType entity, ModifyType modify, Optional<Entity> causingElement, boolean toolderived, 
			List<ModifyType> modifications) {
		
		Optional<ModifyType> mod = modifications.stream().filter((m) -> m.getAffectedElement().equals(entity)).findAny();
		
		// affected element is not present in list of change propagation -> add it
		if (!mod.isPresent()) {
			modify.setAffectedElement(entity);
			if (causingElement.isPresent()) {
				modify.getCausingElements().add(causingElement.get());
			}
			modify.setToolderived(toolderived);
			
			modifications.add(modify);
		} 
		// affected element is already present -> add causing element to list
		else if (causingElement.isPresent() && !mod.get().getCausingElements().contains(causingElement.get())) {
			mod.get().getCausingElements().add(causingElement.get());
		}
	}
}
