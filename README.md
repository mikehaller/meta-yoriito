# meta-yoriito

This layer provides software components from the Yoriito project for integration with the Yocto Project.

## Overview

meta-yoriito is a Yocto layer that provides recipes and configurations
to build and integrate software components developed by the Yoriito project,
including libraries, and tools.

To build the Yoriito reference image, you will need to use the `meta-yoriito-tutorial` layer also.

## Dependencies

This layer depends on:

- URI: git://git.yoctoproject.org/poky
  - branch: wrynose
    - layers: meta
- URI: git://git.openembedded.org/meta-openembedded
  - branch: wrynose
    - layers: meta-oe
- URI: git://github.com/rust-embedded/meta-rust-bin
  - branch: master
    - layers: meta-rust-bin

## Supported Versions

- Yocto Project:
  - 5.0 (scarthgap)
  - 6.0 (wrynose compatibility work in progress)

## License

This layer is distributed under the Apache License 2.0.
Individual recipes and software components are subject to their respective licenses.
