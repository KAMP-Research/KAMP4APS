package edu.kit.ipd.sdq.kamp4aps.core;

import java.util.List;
import java.util.stream.Collectors;

import edu.kit.ipd.sdq.kamp4aps.model.aPS.Plant;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;
import edu.kit.ipd.sdq.kamp4aps.model.basic.Entity;

public class APSAbstractArchitectureModelLookup {
	
	public static Entity lookupParent(Entity input) {
		
		return (Entity) input.eContainer();
	}
	
	public static List<Entity> lookupChildren(Entity input) {
		
		return input.eContents().stream().map((c) -> (Entity) c).collect(Collectors.toList());
	}
	
	public static List<Interface> lookupInterfaces(Entity input, Plant plant) {
		
		return plant.getInterfaceRepository().getAllInterfacesInPlant().stream()
				.filter((i) -> ! i.getParentElement().stream()
						.filter(p -> p.getId().equals(input.getId()))
						.collect(Collectors.toList())
						.isEmpty()
				)
				.collect(Collectors.toList());
	}
	
	public static List<Entity> lookupReferencesofInterface(Interface iface, Entity excludedParent) {
		List<Entity> results = iface.getParentElement();
		return results.stream().filter(e -> !e.equals(excludedParent)).collect(Collectors.toList());
	}
}
