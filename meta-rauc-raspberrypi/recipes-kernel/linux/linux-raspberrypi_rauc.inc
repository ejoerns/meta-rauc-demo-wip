FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_raspberrypi = "file://rauc.cfg"

# original CMDLINE with root=/dev/mmcblk0p2 removed for A+B boot
CMDLINE = "dwc_otg.lpm_enable=0 ${SERIAL} rootfstype=ext4 rootwait"
