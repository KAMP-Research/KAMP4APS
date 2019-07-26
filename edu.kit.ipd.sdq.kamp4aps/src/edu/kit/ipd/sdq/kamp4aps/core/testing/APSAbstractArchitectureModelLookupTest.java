package edu.kit.ipd.sdq.kamp4aps.core.testing;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.kit.ipd.sdq.kamp4aps.core.APSAbstractArchitectureModelLookup;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.Plant;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.apsPackage;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ComponentRepository.Component;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.InterfaceRepository.Interface;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.ModuleRepository.Module;
import edu.kit.ipd.sdq.kamp4aps.model.aPS.StructureRepository.Structure;

public class APSAbstractArchitectureModelLookupTest {
	
	private static String pathToFile = "src/edu/kit/ipd/sdq/kamp4aps/core/testing/APSSpecificArchitectureModelLookupTestModel.aps";
	private Plant testPlant;
	private Structure s;
	private Module m;
	private Component c1;
	private Component c2;
	private Interface c2ToS;
	
	
	@Before
	public void setup() {
		// see: https://www.vogella.com/tutorials/EclipseEMFPersistence/article.html
		
		apsPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("aps", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		
		File file = new File(pathToFile);
		URI plantUri = URI.createFileURI(file.getPath());
		
		Resource resource = resSet.getResource(plantUri, true);
		testPlant = (Plant) resource.getContents().get(0);
		
		assertNotNull(testPlant);
		
		s = (Structure) testPlant.eContents().get(0);
		assertEquals("S", s.getName());
		m = (Module) testPlant.eContents().get(0).eContents().get(0);
		assertEquals("M", m.getName());
		c1 = (Component) testPlant.eContents().get(0).eContents().get(0).eContents().get(0);
		assertEquals("C1", c1.getName());
		c2 = (Component) testPlant.eContents().get(0).eContents().get(0).eContents().get(1);
		assertEquals("C2", c2.getName());
		c2ToS = testPlant.getInterfaceRepository().getAllInterfacesInPlant().get(0);
	}
	
	@Test
	public void lookupParentTest() {
	
		assertEquals(APSAbstractArchitectureModelLookup.lookupParent(c1), m);
		assertEquals(APSAbstractArchitectureModelLookup.lookupParent(c2), m);
		assertEquals(APSAbstractArchitectureModelLookup.lookupParent(m), s);
		assertEquals(APSAbstractArchitectureModelLookup.lookupParent(s), testPlant);
	}
	
	@Test
	public void lookupChildrenTest() {
		
		assertEquals(APSAbstractArchitectureModelLookup.lookupChildren(testPlant), Arrays.asList(s, testPlant.getInterfaceRepository()));
		assertEquals(APSAbstractArchitectureModelLookup.lookupChildren(s), Arrays.asList(m));
		assertEquals(APSAbstractArchitectureModelLookup.lookupChildren(m), Arrays.asList(c1, c2));
	}
	
	@Test
	public void lookupInterfacesTest() {
		
		assert(APSAbstractArchitectureModelLookup.lookupInterfaces(testPlant, testPlant).isEmpty());
		assert(APSAbstractArchitectureModelLookup.lookupInterfaces(m, testPlant).isEmpty());
		assert(APSAbstractArchitectureModelLookup.lookupInterfaces(c1, testPlant).isEmpty());
		
		assertEquals( Arrays.asList(c2ToS), APSAbstractArchitectureModelLookup.lookupInterfaces(s, testPlant));
		assertEquals(Arrays.asList(c2ToS), APSAbstractArchitectureModelLookup.lookupInterfaces(c2, testPlant));
	}
	
	@Test
	public void lookupReferencesOfInterfacesTest() {
		
		assertEquals(Arrays.asList(s), APSAbstractArchitectureModelLookup.lookupReferencesofInterface(c2ToS, c2));
		assertEquals(Arrays.asList(c2), APSAbstractArchitectureModelLookup.lookupReferencesofInterface(c2ToS, s));
	}
}