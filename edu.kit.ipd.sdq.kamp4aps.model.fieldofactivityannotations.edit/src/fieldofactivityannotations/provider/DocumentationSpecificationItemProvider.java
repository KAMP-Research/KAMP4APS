/**
 */
package fieldofactivityannotations.provider;


import fieldofactivityannotations.DocumentationSpecification;
import fieldofactivityannotations.FieldofactivityannotationsFactory;
import fieldofactivityannotations.FieldofactivityannotationsPackage;

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
 * This is the item provider adapter for a {@link fieldofactivityannotations.DocumentationSpecification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentationSpecificationItemProvider 
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
	public DocumentationSpecificationItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_DocumentationSpecification_role_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DocumentationSpecification_role_feature", "_UI_DocumentationSpecification_type"),
				 FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__ROLE,
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
			childrenFeatures.add(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__COMPONENT_DOCUMENTATION);
			childrenFeatures.add(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__MODULE_DOCUMENTATION);
			childrenFeatures.add(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__INTERFACE_DOCUMENTATION);
			childrenFeatures.add(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__STRUCTURE_DOCUMENTATION);
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
	 * This returns DocumentationSpecification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DocumentationSpecification"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_DocumentationSpecification_type");
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

		switch (notification.getFeatureID(DocumentationSpecification.class)) {
			case FieldofactivityannotationsPackage.DOCUMENTATION_SPECIFICATION__COMPONENT_DOCUMENTATION:
			case FieldofactivityannotationsPackage.DOCUMENTATION_SPECIFICATION__MODULE_DOCUMENTATION:
			case FieldofactivityannotationsPackage.DOCUMENTATION_SPECIFICATION__INTERFACE_DOCUMENTATION:
			case FieldofactivityannotationsPackage.DOCUMENTATION_SPECIFICATION__STRUCTURE_DOCUMENTATION:
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
				(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__COMPONENT_DOCUMENTATION,
				 FieldofactivityannotationsFactory.eINSTANCE.createComponentDocumentationFiles()));

		newChildDescriptors.add
			(createChildParameter
				(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__MODULE_DOCUMENTATION,
				 FieldofactivityannotationsFactory.eINSTANCE.createModuleDocumentationFiles()));

		newChildDescriptors.add
			(createChildParameter
				(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__INTERFACE_DOCUMENTATION,
				 FieldofactivityannotationsFactory.eINSTANCE.createInterfaceDocumentationFiles()));

		newChildDescriptors.add
			(createChildParameter
				(FieldofactivityannotationsPackage.Literals.DOCUMENTATION_SPECIFICATION__STRUCTURE_DOCUMENTATION,
				 FieldofactivityannotationsFactory.eINSTANCE.createStructureDocumentationFiles()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return FieldofactivityannotationsEditPlugin.INSTANCE;
	}

}