package edu.kit.ipd.sdq.kaps.model.fieldofactivityannotations.editor;

import edu.kit.ipd.sdq.amp.model.modificationmarks.editor.AbstractArchitectureBasedWorkplanDerivationAction;
import edu.kit.ipd.sdq.kaps.core.ArchitectureVersion;
import edu.kit.ipd.sdq.kaps.core.ArchitectureVersionPersistency;
import edu.kit.ipd.sdq.kaps.core.derivation.DifferenceCalculation;
import edu.kit.ipd.sdq.kaps.core.derivation.EnrichedWorkplanDerivation;

public class ArchitectureBasedWorkplanDerivationAction extends AbstractArchitectureBasedWorkplanDerivationAction<ArchitectureVersion> {
	
	public ArchitectureBasedWorkplanDerivationAction() {
		this.setWorkplanDerivation(new DifferenceCalculation());
		this.setEnrichedWorkplanDerivation(new EnrichedWorkplanDerivation());
		this.setArchitectureVersionPersistency(new ArchitectureVersionPersistency());
	}

}

