RAUC Demo Layers
================

This is a collection of demo layers that provide an exemplary configuration of
a RAUC-based update system for various boards.

`meta-rauc-qemux86 <meta-rauc-qemux86/README.rst>`_:
Demo layer for x86-64 Qemu machine

The layers perform the required integration steps for setting up a redundant
boot with RAUC:

* Add bootloader boot logic (script)
* Set up bootloader storage/environment
* Provide example wic image config
* Provide proper rauc system.conf
* Add example keys
* Add support for atomic bootloader updates
