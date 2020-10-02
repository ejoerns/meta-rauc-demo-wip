FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# additional dependencies required to run RAUC on the target
RDEPENDS_${PN} += "u-boot-fw-utils e2fsprogs-mke2fs"
