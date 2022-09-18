package edu.kit.ipd.sdq.kamp4aps.core.scenarios;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyComponentHandler;
import edu.kit.ipd.sdq.kamp4aps.core.changepropagation.ComponentChanges;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Frame;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.RegularRamp;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;


public class RampChange extends ComponentChanges {

	private Collection<RegularRamp> initialMarkedRamps;
	private Map<Component, Set<Interface>> interfacesToBeMarked;
	public RampChange(APSArchitectureVersion v) {
		super(v);
		initialMarkedRamps = APSArchitectureModelLookup.lookUpMarkedObjectsOfAType(version, RegularRamp.class);
		interfacesToBeMarked = new HashMap<Component, Set<Interface>>();
	}

	// hier werden erstmal alle vom nutzer markierten rampen herausgesucht
	// und entsprechend als modifikation angelegt.
	public void addInitialMarkedRampsToList(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		for(RegularRamp ramp : initialMarkedRamps){
			ModifyComponentHandler.addModifyComponentToList(ramp, changePropagationDueToHardwareChange);
		}
	}
	
	// hol alle schnittstellen die mit ner rampe verbunden sind
	// und f�ge sie der liste der beeinflussten schnittstellen hinzu
	public void calculateAndMarkAffectedInterfacesByRampChange(ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange){
		ModifyComponentHandler.initModifyInterfacesBasedOnComponents(interfacesToBeMarked, changePropagationDueToHardwareChange, initialMarkedRamps);
	}

	public void calculateAndMarkToFramePropagation(
			ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange) {
		for (Map.Entry<Component, Set<Interface>> entry : interfacesToBeMarked.entrySet())
		{
			Map<Interface,Set<Component>> affectedComponents = APSArchitectureModelLookup.lookUpParentComponentsOfInterfaces(entry.getValue(), changePropagationDueToHardwareChange);
			for(Interface interfac : entry.getValue()){
				for(Component affectedComponent : affectedComponents.get(interfac)) {
					if(affectedComponent instanceof Frame){
						ModifyComponentHandler.addModifyComponentToList(affectedComponent, changePropagationDueToHardwareChange);
					}
				}
			}

		}
	}
	
}
