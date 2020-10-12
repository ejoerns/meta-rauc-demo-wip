inherit bundle

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RAUC_BUNDLE_COMPATIBLE = "RaspberryPi3 Rauc Demo Board"

RAUC_BUNDLE_SLOTS = "rootfs"

RAUC_SLOT_rootfs = "core-image-base"

RAUC_KEY_FILE="${COREBASE}/meta-rauc-demo/files/development-1.key.pem"
RAUC_CERT_FILE="${COREBASE}/meta-rauc-demo/files/development-1.cert.pem"
