package edu.kit.ipd.sdq.kamp4aps.core.scenarios;

import java.util.List;

import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyComponentHandler;
import edu.kit.ipd.sdq.kamp4aps.core.ModifyInterfaceHandler;
import edu.kit.ipd.sdq.kamp4aps.core.changepropagation.Change;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;

public class SignalInterfacePropagation extends Change {

	public SignalInterfacePropagation(APSArchitectureVersion v) {
		super(v);
	}

	public void markChangesBasedOnSignalInterfaces(Component component, ChangePropagationDueToHardwareChange cp, boolean hasChanged) {
		List<Interface> interfaces = component.getConnectedInterfaces();
		for(Interface i : interfaces){
			ModifyInterfaceHandler mih = new ModifyInterfaceHandler(component, i, cp); 				
			if(mih.isNewInterface()){
				cp.getInterfaceModifications().add(mih.getModifyInterface());
				hasChanged = true;
			}
		}
	
		boolean isNewComponent = ModifyComponentHandler.isNewComponent(component, cp);
		if(isNewComponent){
			ModifyComponentHandler.createNewModifyComponent(component, interfaces, cp);
		}
	}
}
