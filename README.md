# KAMP4APS

KAMP4APS extends KAMP for automated production systems (APS). It provides EMF models, generated editors, field-of-activity annotations, and change-propagation concepts for plants that combine mechanical, electrical, pneumatic, sensor, actuator, module, interface, and deployment information.

## Installation

Install KAMP4APS from the KAMP update-site page:

```text
https://kamp-research.github.io/KAMP/kamp4aps/
```

For a complete setup, use the composite update site instead:

```text
https://kamp-research.github.io/KAMP/all/
```

In Eclipse, open `Help > Install New Software...`, paste the update-site URL into `Work with`, select the KAMP4APS feature, and finish the wizard. Restart Eclipse after installation.

## Dependencies

The most important runtime dependencies are:

- KAMP core, especially the base modification mark and change-propagation infrastructure.
- Eclipse Modeling Framework (EMF), EMF.Edit, and generated EMF editor support.
- Eclipse Platform/PDE dependencies from the Eclipse 2023-03 target.
- Palladio build dependencies from the Palladio 5.2.1 update sites.
- Other KAMP extensions when using the composite KAMP-All update site.

## Domain

The APS domain captures automation plants and production-system structures. It is useful for modelling physical and logical automation elements and for deriving follow-up activities after a change in the plant.

KAMP4APS covers plant-level structures, reusable modules, interfaces, deployment context, field-of-activity annotations, and APS-specific modification marks.

## Important Models

- `aPS.ecore` and `xPPU.ecore`: plant and production-system concepts such as `Plant`, `Component`, `Module`, `Sensor`, `Motor`, `Pipe`, `Cable`, `Interface`, and production modules.
- `basic.ecore`: common identity and naming concepts such as `Identifier`, `NamedElement`, and `Entity`.
- `deploymentcontext.ecore`: deployment context information with `DeploymentContextRepository`, `ComponentCorrelation`, and `VariableMapping`.
- `KAMP4APSFieldofactivityannotations.ecore`: field-of-activity annotations for tests, stock, HMI, ECAD, documentation, staff, calibration, roles, people, files, and test cases.
- `KAMP4aPSModificationsmarks.ecore`: APS modification marks such as `KAMP4aPSSeedModifications`, `ChangePropagationDueToHardwareChange`, `ModifyComponent`, `ModifyModule`, `ModifyInterface`, `ModifySensor`, and related plant element modifications.

## Usage

Typical usage starts with APS domain models and field-of-activity annotations. A change is represented as seed modification marks. KAMP4APS then provides the APS-specific model vocabulary and propagation artefacts used to derive affected activities and workplan information.

Use the generated EMF editors to create or inspect APS models, annotation repositories, and modification mark repositories. In an integrated KAMP installation, APS changes can be analysed together with other KAMP extensions through the shared change-propagation workflow.
