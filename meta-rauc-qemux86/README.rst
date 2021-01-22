This README file contains information on the contents of the meta-rauc-qemux86 layer.

Please see the corresponding sections below for details.

Dependencies
============

This layer depends on::

  URI: git://git.openembedded.org/bitbake

  URI: git://git.openembedded.org/openembedded-core
  layers: meta

  URI: https://github.com/rauc/meta-rauc.git

Patches
=======

Please submit patches via GitHub pull request on https://github.com/rauc/meta-rauc-demo

Maintainer: Enrico Joerns <ejo@pengutronix.de>

I. Adding the meta-rauc-qemux86 layer to your build
=================================================

Run 'bitbake-layers add-layer meta-rauc-qemux86'

II. Build The qemu Demo System
==============================

::

  $ source oe-init-build-env

It is recommended, but not necessary, to enable 'systemd'::

  INIT_MANAGER = "systemd"

grub-efi::

  MACHINE_FEATURES += "pcbios efi"
  EFI_PROVIDER = "grub-efi"
  IMAGE_INSTALL_append = "grub grub-efi"

Build::

  $ bitbake core-image-minimal

II. Build The Demo Update Bundle
================================

::

  $ bitbake qemu-demo-bundle

III. Run The qemu Demo System
=============================

* Boot::

    $ runqemu core-image-minimal wic nographic ovmf slirp
    
    ...
    root@qemux86-64:~#

* Show RAUC status::

    # rauc status

* Obtain IP address::

    # udhcpc -i eth0

* Copy Update Bundle::

    $ scp -P 2222 tmp/deploy/images/qemux86-64/qemu-demo-bundle-qemux86-64.raucb root@localhost:/tmp

* Check Bundle::

    # rauc info /tmp/qemu-demo-bundle-qemux86-64.raucb

* Install Bundle::

    # rauc install /tmp/qemu-demo-bundle-qemux86-64.raucb
    installing
      0% Installing
      0% Determining slot states
     20% Determining slot states done.
     20% Checking bundle
     20% Verifying signature
     40% Verifying signature done.
     40% Checking bundle done.
     40% Checking manifest contents
     60% Checking manifest contents done.
     60% Determining target install group
     80% Determining target install group done.
     80% Updating slots
     80% Checking slot efi.0
     85% Checking slot efi.0 done.
     85% Copying image to efi.0
     90% Copying image to efi.0 done.
     90% Checking slot rootfs.1
     95% Checking slot rootfs.1 done.
     95% Copying image to rootfs.1
     100% Copying image to rootfs.1 done.
     100% Updating slots done.
     100% Installing done.
     Installing `/tmp/qemu-demo-bundle-qemux86-64.raucb` succeeded

* Reboot::

    # systemctl reboot

* Foo

Welcome to GRUB!

error: no such device: ((hd0,gpt1)/EFI/BOOT)/EFI/BOOT/grub.cfg.
