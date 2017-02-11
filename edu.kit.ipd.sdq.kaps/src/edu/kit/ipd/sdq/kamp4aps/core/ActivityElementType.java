package edu.kit.ipd.sdq.kamp4aps.core;

import edu.kit.ipd.sdq.amp.workplan.AbstractActivityElementType;
import fieldofactivityannotations.Documentation;
import fieldofactivityannotations.Drawing;
import fieldofactivityannotations.HMIConfiguration;
import fieldofactivityannotations.TestCase;
import xPPU.ComponentRepository.Component;
import xPPU.InterfaceRepository.Interface;
import xPPU.ModuleRepository.Module;
import xPPU.StructureRepository.Structure;

public enum ActivityElementType implements AbstractActivityElementType {
	//aPS related
	COMPONENT(Component.class),
	MODULE(Module.class),
	STRUCTURE(Structure.class),
	INTERFACE(Interface.class),
	
	// annotation-related
	TESTCASE(TestCase.class),
	DOCUMENTATION(Documentation.class),
	DRAWING(Drawing.class),
	HMI_CONFIG(HMIConfiguration.class);
	
	
	private final Class<?> clazz;
	private final String name;
	
	private ActivityElementType(Class<?> clazz) {
		this.clazz = clazz;
		this.name = clazz.getSimpleName();
	}

	@Override
	public Class<?> getElementClass() {
		return clazz;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public static ActivityElementType[] topLevelAPSActivityElementTypes() {	
		return new ActivityElementType[]{COMPONENT, MODULE, INTERFACE, STRUCTURE};
	}

}
