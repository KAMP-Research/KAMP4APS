/**
 */
package edu.kit.ipd.sdq.kaps.model.modificationmarks.provider;

import edu.kit.ipd.sdq.kaps.model.modificationmarks.util.modificationmarksAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class modificationmarksItemProviderAdapterFactory extends modificationmarksAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public modificationmarksItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.KAPSModificationRepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KAPSModificationRepositoryItemProvider kapsModificationRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.KAPSModificationRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createKAPSModificationRepositoryAdapter() {
		if (kapsModificationRepositoryItemProvider == null) {
			kapsModificationRepositoryItemProvider = new KAPSModificationRepositoryItemProvider(this);
		}

		return kapsModificationRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.KAPSSeedModifications} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KAPSSeedModificationsItemProvider kapsSeedModificationsItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.KAPSSeedModifications}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createKAPSSeedModificationsAdapter() {
		if (kapsSeedModificationsItemProvider == null) {
			kapsSeedModificationsItemProvider = new KAPSSeedModificationsItemProvider(this);
		}

		return kapsSeedModificationsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifySensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifySensorItemProvider modifySensorItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifySensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifySensorAdapter() {
		if (modifySensorItemProvider == null) {
			modifySensorItemProvider = new ModifySensorItemProvider(this);
		}

		return modifySensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ChangePropagationDueToHardwareChange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePropagationDueToHardwareChangeItemProvider changePropagationDueToHardwareChangeItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ChangePropagationDueToHardwareChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChangePropagationDueToHardwareChangeAdapter() {
		if (changePropagationDueToHardwareChangeItemProvider == null) {
			changePropagationDueToHardwareChangeItemProvider = new ChangePropagationDueToHardwareChangeItemProvider(this);
		}

		return changePropagationDueToHardwareChangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusBox} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyBusBoxItemProvider modifyBusBoxItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusBox}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyBusBoxAdapter() {
		if (modifyBusBoxItemProvider == null) {
			modifyBusBoxItemProvider = new ModifyBusBoxItemProvider(this);
		}

		return modifyBusBoxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyPowerSupply} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyPowerSupplyItemProvider modifyPowerSupplyItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyPowerSupply}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyPowerSupplyAdapter() {
		if (modifyPowerSupplyItemProvider == null) {
			modifyPowerSupplyItemProvider = new ModifyPowerSupplyItemProvider(this);
		}

		return modifyPowerSupplyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifySignalinterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifySignalinterfaceItemProvider modifySignalinterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifySignalinterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifySignalinterfaceAdapter() {
		if (modifySignalinterfaceItemProvider == null) {
			modifySignalinterfaceItemProvider = new ModifySignalinterfaceItemProvider(this);
		}

		return modifySignalinterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyPhysicalConnection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyPhysicalConnectionItemProvider modifyPhysicalConnectionItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyPhysicalConnection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyPhysicalConnectionAdapter() {
		if (modifyPhysicalConnectionItemProvider == null) {
			modifyPhysicalConnectionItemProvider = new ModifyPhysicalConnectionItemProvider(this);
		}

		return modifyPhysicalConnectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyMicroSwitchModule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyMicroSwitchModuleItemProvider modifyMicroSwitchModuleItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyMicroSwitchModule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyMicroSwitchModuleAdapter() {
		if (modifyMicroSwitchModuleItemProvider == null) {
			modifyMicroSwitchModuleItemProvider = new ModifyMicroSwitchModuleItemProvider(this);
		}

		return modifyMicroSwitchModuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusMaster} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyBusMasterItemProvider modifyBusMasterItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusMaster}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyBusMasterAdapter() {
		if (modifyBusMasterItemProvider == null) {
			modifyBusMasterItemProvider = new ModifyBusMasterItemProvider(this);
		}

		return modifyBusMasterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusSlave} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyBusSlaveItemProvider modifyBusSlaveItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusSlave}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyBusSlaveAdapter() {
		if (modifyBusSlaveItemProvider == null) {
			modifyBusSlaveItemProvider = new ModifyBusSlaveItemProvider(this);
		}

		return modifyBusSlaveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusCable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyBusCableItemProvider modifyBusCableItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kaps.model.modificationmarks.ModifyBusCable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifyBusCableAdapter() {
		if (modifyBusCableItemProvider == null) {
			modifyBusCableItemProvider = new ModifyBusCableItemProvider(this);
		}

		return modifyBusCableItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (kapsModificationRepositoryItemProvider != null) kapsModificationRepositoryItemProvider.dispose();
		if (kapsSeedModificationsItemProvider != null) kapsSeedModificationsItemProvider.dispose();
		if (modifySensorItemProvider != null) modifySensorItemProvider.dispose();
		if (changePropagationDueToHardwareChangeItemProvider != null) changePropagationDueToHardwareChangeItemProvider.dispose();
		if (modifyBusBoxItemProvider != null) modifyBusBoxItemProvider.dispose();
		if (modifyPowerSupplyItemProvider != null) modifyPowerSupplyItemProvider.dispose();
		if (modifySignalinterfaceItemProvider != null) modifySignalinterfaceItemProvider.dispose();
		if (modifyPhysicalConnectionItemProvider != null) modifyPhysicalConnectionItemProvider.dispose();
		if (modifyMicroSwitchModuleItemProvider != null) modifyMicroSwitchModuleItemProvider.dispose();
		if (modifyBusMasterItemProvider != null) modifyBusMasterItemProvider.dispose();
		if (modifyBusSlaveItemProvider != null) modifyBusSlaveItemProvider.dispose();
		if (modifyBusCableItemProvider != null) modifyBusCableItemProvider.dispose();
	}

}
