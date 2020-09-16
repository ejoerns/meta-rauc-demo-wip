|MIT| |gh_action| |Matrix|

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

.. |MIT| image:: https://img.shields.io/badge/license-MIT-blue.svg
   :target: https://raw.githubusercontent.com/rauc/meta-rauc-demo/master/COPYING.MIT
.. |gh_action| image:: https://github.com/rauc/meta-rauc-demo/workflows/tests/badge.svg
   :target: https://github.com/rauc/meta-rauc/actions?query=workflow%3A%22tests%22
.. |Matrix| image:: https://img.shields.io/matrix/rauc:matrix.org?label=matrix%20chat
   :target: https://app.element.io/#/room/#rauc:matrix.org
