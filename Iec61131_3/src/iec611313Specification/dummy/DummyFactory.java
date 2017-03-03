/**
 */
package iec611313Specification.dummy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see iec611313Specification.dummy.DummyPackage
 * @generated
 */
public interface DummyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DummyFactory eINSTANCE = iec611313Specification.dummy.impl.DummyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Code Body Dummy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Body Dummy</em>'.
	 * @generated
	 */
	CodeBodyDummy createCodeBodyDummy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DummyPackage getDummyPackage();

} //DummyFactory
