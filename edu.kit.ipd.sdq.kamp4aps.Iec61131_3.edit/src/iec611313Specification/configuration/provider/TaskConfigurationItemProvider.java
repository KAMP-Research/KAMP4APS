/**
 */
package iec611313Specification.configuration.provider;


import iec611313Specification.common.CommonFactory;

import iec611313Specification.common.pous.functions.FunctionsFactory;

import iec611313Specification.common.provider.IEC611313EditPlugin;

import iec611313Specification.common.variables.VariablesFactory;

import iec611313Specification.configuration.ConfigurationFactory;
import iec611313Specification.configuration.ConfigurationPackage;
import iec611313Specification.configuration.TaskConfiguration;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link iec611313Specification.configuration.TaskConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskConfigurationItemProvider 
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
	public TaskConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskConfiguration_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskConfiguration_name_feature", "_UI_TaskConfiguration_type"),
				 ConfigurationPackage.Literals.TASK_CONFIGURATION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(ConfigurationPackage.Literals.TASK_CONFIGURATION__CONFIGURES_TASK);
			childrenFeatures.add(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_PRIORITY);
			childrenFeatures.add(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_SINGLE_EXECUTION);
			childrenFeatures.add(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_INTERVAL_EXECUTION);
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
	 * This returns TaskConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TaskConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TaskConfiguration)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TaskConfiguration_type") :
			getString("_UI_TaskConfiguration_type") + " " + label;
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

		switch (notification.getFeatureID(TaskConfiguration.class)) {
			case ConfigurationPackage.TASK_CONFIGURATION__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationPackage.TASK_CONFIGURATION__CONFIGURES_TASK:
			case ConfigurationPackage.TASK_CONFIGURATION__HAS_PRIORITY:
			case ConfigurationPackage.TASK_CONFIGURATION__HAS_SINGLE_EXECUTION:
			case ConfigurationPackage.TASK_CONFIGURATION__HAS_INTERVAL_EXECUTION:
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
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__CONFIGURES_TASK,
				 ConfigurationFactory.eINSTANCE.createTask()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_PRIORITY,
				 CommonFactory.eINSTANCE.createLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_PRIORITY,
				 FunctionsFactory.eINSTANCE.createFunctionCall()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_PRIORITY,
				 VariablesFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_SINGLE_EXECUTION,
				 CommonFactory.eINSTANCE.createLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_SINGLE_EXECUTION,
				 FunctionsFactory.eINSTANCE.createFunctionCall()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_SINGLE_EXECUTION,
				 VariablesFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_INTERVAL_EXECUTION,
				 CommonFactory.eINSTANCE.createLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_INTERVAL_EXECUTION,
				 FunctionsFactory.eINSTANCE.createFunctionCall()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_INTERVAL_EXECUTION,
				 VariablesFactory.eINSTANCE.createVariableAccess()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_PRIORITY ||
			childFeature == ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_SINGLE_EXECUTION ||
			childFeature == ConfigurationPackage.Literals.TASK_CONFIGURATION__HAS_INTERVAL_EXECUTION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return IEC611313EditPlugin.INSTANCE;
	}

}