FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# additional dependencies required to run RAUC on the target
RDEPENDS_${PN} += "grub-editenv e2fsprogs-mke2fs"

RAUC_KEYRING_FILE:="${THISDIR}/../../../files/ca.cert.pem"
