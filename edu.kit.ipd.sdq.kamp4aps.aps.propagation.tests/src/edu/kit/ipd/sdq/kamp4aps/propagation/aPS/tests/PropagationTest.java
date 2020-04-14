/**
 * 
 */
package edu.kit.ipd.sdq.kamp4aps.propagation.aPS.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.kit.ipd.sdq.kamp4aps.core.changepropagation.*;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion;
import edu.kit.ipd.sdq.kamp4aps.core.APSArchitectureVersion.ArchitectureVersionParams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ChangePropagationDueToHardwareChange;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.KAMP4aPSModificationmarksFactory;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.ModifyEntity;
import edu.kit.ipd.sdq.kamp4aps.model.KAMP4aPSModificationmarks.impl.KAMP4aPSModificationmarksFactoryImpl;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.Plant;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.apsPackage;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.basic.Entity;

class PropagationTest {

	private final String currentPath = Paths.get("").toAbsolutePath().toString();
	private final String pathToModels = "/src/edu/kit/ipd/sdq/kamp4aps/propagation/aPS/tests/";
	private final String modelName = "My.aps";
	private final String seedName = "ModificationSeed";
	private final String expectedModificationsName = "ExpectedModifications";

	@Test
	void testExampleOne() {
		testChangePropagationOnModel("Model_1/");
	}
	
	@Test
	void testExampleTwo() {
		testChangePropagationOnModel("Model_2/");
	}
	
	@Test
	void testExampleThree() {
		testChangePropagationOnModel("Model_3/");
	}
	
	
	
	private void testChangePropagationOnModel(String model) {
		String seed = loadSeed(model);
		String[] expectedModifications = loadExpectedModifications(model);
		
		Resource resource =  loadResources(getResourcePath(model, modelName));
		Plant plant = (Plant) resource.getContents().get(0);
		//Generate the ArchitectureVersion and its ArchitectureVersionParams
		ArchitectureVersionParams architectureVersionParams = new ArchitectureVersionParams();
		architectureVersionParams.aPSPlant = plant;
		KAMP4aPSModificationmarksFactory kAMP4aPSModificationmarksFactory = new KAMP4aPSModificationmarksFactoryImpl();
		architectureVersionParams.modificationMarkRepository = kAMP4aPSModificationmarksFactory.createKAMP4aPSModificationRepository();
		APSArchitectureVersion aPSArchitectureVersion = new APSArchitectureVersion(architectureVersionParams);
		//Generate the ComponentChanges
		ComponentChanges componentChange = (ComponentChanges) usePrivateConstructor("edu.kit.ipd.sdq.kamp4aps.core.changepropagation.ComponentChanges", new Object[] {aPSArchitectureVersion});
		ArrayList<Component> initialMarkedComponents = new ArrayList<Component>();
		//Add the seed modification
		initialMarkedComponents.add(getComponentById(plant.getComponentRepository().getAllComponentsInPlant(), seed));
		if (!setPrivateField(componentChange, "initialMarkedComponents", initialMarkedComponents)) {
			 fail("ComponentChanges could not be set.");
		}
		ChangePropagationDueToHardwareChange changePropagationDueToHardwareChange = KAMP4aPSModificationmarksFactoryImpl.init().createChangePropagationDueToHardwareChange();
		//Init the change propagation
		componentChange.addInitialMarkedModulesToList(changePropagationDueToHardwareChange);
		//Run the change propagation
		componentChange.calculateAndMarkToInterfacePropagation(changePropagationDueToHardwareChange);
		
		//Get all modifications
		EList<Entity> list = new BasicEList<>();
		appendEntities(list, changePropagationDueToHardwareChange.getComponentModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getInterfaceModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getMicroSwitchModuleModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getModuleModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getPhysicalConnectionModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getSensorModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getSignalinterfaceModifications());
		appendEntities(list, changePropagationDueToHardwareChange.getStructureModifications());
		
		//Check if modifications are correct
		ArrayList<String> result = new ArrayList<String>();
		boolean correct = true;
		String separator = "###";
		//Check what is marked but not expected
		for(int i = 0; i < list.size(); i++) {
			boolean found = false;
			for(int j = 0; j < expectedModifications.length; j++) {
				if(expectedModifications[j] != null && expectedModifications[j].equals(list.get(i).getId())) {
					expectedModifications[j] = null;
					found = true;
				}
			}
			if(!found) {
				result.add(list.get(i).getId());
				correct = false;
			}
		}
		result.add(separator);
		
		//Check what is expected but not marked
		for(int i = 0; i < expectedModifications.length; i++) {
			if(expectedModifications[i] != null) {
				result.add(expectedModifications[i]);
				correct = false;
			}
		}
		result.add(separator);
		
		if(correct) {
			assert(true);
		} else {
			fail(assembleFailMessage(result, separator));
		}
		
	}
	
	private String assembleFailMessage(ArrayList<String> result, String separator) {
		Iterator iterator = result.iterator();
		String resultMessage = "Test failed. The following entities were marked but are not expected: ";
		while(iterator.hasNext()) {
			String next = (String) iterator.next();
			if(next.equals(separator)) {
				break;
			}
			resultMessage += next + ", ";
		}
		
		resultMessage = removeLastTwoCharsFromString(resultMessage);
		
		resultMessage += ". The following entities were expected but are not marked: ";
		while(iterator.hasNext()) {
			String next = (String) iterator.next();
			if(next.equals(separator)) {
				break;
			}
			resultMessage += next + ", ";
		}
		
		resultMessage = removeLastTwoCharsFromString(resultMessage) + ".";
		
		return resultMessage;
	}
	
	private String removeLastTwoCharsFromString(String string) {
		return string.substring(0, string.length()-2);
	}
	
	private String[] loadFile(String file) {
		ArrayList<String> result = new ArrayList<String>();
	    BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				result.add(currentLine);
			}
		    reader.close();
		    String[] t = new String[] {};
		    return result.toArray(t);
		} catch (FileNotFoundException e) {
			fail(e.getStackTrace().toString());
		} catch (IOException e) {
			fail(e.getStackTrace().toString());
		}
		return null;
	}
	
	private String[] loadExpectedModifications(String model) {
		String[] expectedModificationsFileContent = loadFile(getResourcePath(model, expectedModificationsName));
		return expectedModificationsFileContent;
	}
	
	private String loadSeed(String model) {
		String[] seedFileContent = loadFile(getResourcePath(model, seedName));
		return seedFileContent[0];
	}

	private <T extends ModifyEntity<S>, S extends Entity> void appendEntities(EList<Entity> list, EList<T> listToAppend) {
		for(int i = 0; i < listToAppend.size(); i++) {
			list.add((Entity) listToAppend.get(i).getAffectedElement());
		}
	}
	
	private Component getComponentById(EList<Component> components, String id) {
		for(int i = 0; i < components.size(); i++) {
			if(components.get(i).getId().equals(id)) {
				return components.get(i);
			}
		}
		return null;
	}
	
	private boolean setPrivateField(Object object, String fieldName, Object fieldValue) {
		Class<?> privateClass = object.getClass();
	    while (privateClass != null) {
	        try {
	            Field field = privateClass.getDeclaredField(fieldName);
	            field.setAccessible(true);
	            field.set(object, fieldValue);
	            return true;
	        } catch (NoSuchFieldException e) {
	        	privateClass = privateClass.getSuperclass();
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	    }
	    return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <V> V getPrivateField(Object object, String fieldName) {
	    Class<?> privateClass = object.getClass();
	    while (privateClass != null) {
	        try {
	            Field field = privateClass.getDeclaredField(fieldName);
	            field.setAccessible(true);
	            return (V) field.get(object);
	        } catch (NoSuchFieldException e) {
	        	privateClass = privateClass.getSuperclass();
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	    }
	    return null;
	}
	
	private Object usePrivateConstructor(String className, Object[] arglist) {
		try {
			//Get the class
			Class privateClass = Class.forName(className);
			Constructor privateClassConstructor;
			//Get the constructor
			if (arglist != null) {
				//Get the parameters for the constructor
				Class parameterTypes[] = new Class[arglist.length];
				for(int i = 0; i < arglist.length; i++) {
					parameterTypes[i] = arglist[i].getClass();
				}
				privateClassConstructor = privateClass.getConstructor(parameterTypes);
			} else {
				privateClassConstructor = privateClass.getConstructor();
			}
	        
	        Object privateClassObject = privateClassConstructor.newInstance(arglist);
	        return privateClassObject;
		} catch (NoSuchMethodException e) {
			fail(e.getStackTrace().toString());
		} catch (SecurityException e) {
			fail(e.getStackTrace().toString());
		} catch (InstantiationException e) {
			fail(e.getStackTrace().toString());
		} catch (IllegalAccessException e) {
			fail(e.getStackTrace().toString());
		} catch (IllegalArgumentException e) {
			fail(e.getStackTrace().toString());
		} catch (InvocationTargetException e) {
			fail(e.getStackTrace().toString());
		} catch (ClassNotFoundException e) {
			fail(e.getStackTrace().toString());
		}
		
		return null;
		
	}

	private String getResourcePath(String model, String resource){
		return currentPath + pathToModels + model + resource;
	}

	private Resource loadResources(String model) {
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("aps", new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put
		(apsPackage.eNS_URI, 
				apsPackage.eINSTANCE);

		// If there are no arguments, emit an appropriate usage message.
		//
		if (model == null) {
			System.out.println("Enter a list of file paths or URIs that have content like this:");
			return null;
		}
		else {
			// Construct the URI for the instance file.
			// The argument is treated as a file path only if it denotes an existing file.
			// Otherwise, it's directly treated as a URL.
			//
			File file = new File(model);
			URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI(model);

			try {
				// Demand load resource for this file.
				//
				Resource resource = resourceSet.getResource(uri, true);
				System.out.println("Loaded " + uri);
				return resource;
			}
			catch (RuntimeException exception) {
				System.out.println("Problem loading " + uri);
				exception.printStackTrace();
				return null;
			}
		}
	}
}
