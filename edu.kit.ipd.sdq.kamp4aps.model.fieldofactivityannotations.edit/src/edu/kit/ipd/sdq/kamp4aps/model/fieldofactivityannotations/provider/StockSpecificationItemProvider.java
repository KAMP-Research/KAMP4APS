/**
 */
package edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.provider;


import edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.KAMP4aPSFieldofactivityannotationsFactory;
import edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.KAMP4aPSFieldofactivityannotationsPackage;
import edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.StockSpecification;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.kit.ipd.sdq.kamp4aps.model.fieldofactivityannotations.StockSpecification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StockSpecificationItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StockSpecificationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addRolePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StockSpecification_role_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StockSpecification_role_feature", "_UI_StockSpecification_type"),
				 KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__ROLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__COMPONENT_STOCK_LIST);
			childrenFeatures.add(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__INTERFACE_STOCK_LIST);
			childrenFeatures.add(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__MODULE_STOCK_LIST);
			childrenFeatures.add(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__STRUCTURE_STOCK_LIST);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns StockSpecification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StockSpecification"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_StockSpecification_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StockSpecification.class)) {
			case KAMP4aPSFieldofactivityannotationsPackage.STOCK_SPECIFICATION__COMPONENT_STOCK_LIST:
			case KAMP4aPSFieldofactivityannotationsPackage.STOCK_SPECIFICATION__INTERFACE_STOCK_LIST:
			case KAMP4aPSFieldofactivityannotationsPackage.STOCK_SPECIFICATION__MODULE_STOCK_LIST:
			case KAMP4aPSFieldofactivityannotationsPackage.STOCK_SPECIFICATION__STRUCTURE_STOCK_LIST:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__COMPONENT_STOCK_LIST,
				 KAMP4aPSFieldofactivityannotationsFactory.eINSTANCE.createComponentStockList()));

		newChildDescriptors.add
			(createChildParameter
				(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__INTERFACE_STOCK_LIST,
				 KAMP4aPSFieldofactivityannotationsFactory.eINSTANCE.createInterfaceStockList()));

		newChildDescriptors.add
			(createChildParameter
				(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__MODULE_STOCK_LIST,
				 KAMP4aPSFieldofactivityannotationsFactory.eINSTANCE.createModuleStockList()));

		newChildDescriptors.add
			(createChildParameter
				(KAMP4aPSFieldofactivityannotationsPackage.Literals.STOCK_SPECIFICATION__STRUCTURE_STOCK_LIST,
				 KAMP4aPSFieldofactivityannotationsFactory.eINSTANCE.createStructureStockList()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return KAMP4APSFieldofactivityannotationsEditPlugin.INSTANCE;
	}

}