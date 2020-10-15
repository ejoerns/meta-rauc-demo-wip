inherit bundle

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RAUC_BUNDLE_COMPATIBLE = "RaspberryPi3 Rauc Demo Board"

RAUC_BUNDLE_SLOTS = "firmware rootfs"

RAUC_SLOT_rootfs = "core-image-base"

do_create_bootfile[depends] += "dosfstools-native:do_populate_sysroot \
                        mtools-native:do_populate_sysroot \
                        "

# Create archive of bootfiles
do_create_bootfile() {
    mkdir -p ${WORKDIR}/rpi-boot
    testvar="${IMAGE_BOOT_FILES}"
    for i in $testvar; do
        echo "$i "
        src=$(echo $i | cut -d ';' -f 1)
        dest=$(echo $i | cut -d ';' -f 2 -s)
        if [ ! -z "$dest" ]; then
            dir=$(dirname $dest)
            echo "mkdir -p $dir"
        fi
        echo "cp ${DEPLOY_DIR_IMAGE}/$src ${WORKDIR}/rpi-boot/$dir/$dest"
        echo ""
        mkdir -p ${WORKDIR}/rpi-boot/$dir
        cp ${DEPLOY_DIR_IMAGE}/$src ${WORKDIR}/rpi-boot/$dest
    done

    MKDOSFS_EXTRAOPTS="-S 512"
    FATIMG="${WORKDIR}/rpi-boot.vfat"
    BLOCKS=32786

    rm -f ${FATIMG}

    mkdosfs -n "BOOT" ${MKDOSFS_EXTRAOPTS} -C ${FATIMG} \
                    ${BLOCKS}
    FATSOURCEDIR="${WORKDIR}/rpi-boot/"
    # Copy FATSOURCEDIR recursively into the image file directly
    mcopy -i ${FATIMG} -s ${FATSOURCEDIR}/* ::/
    chmod 644 ${FATIMG}
}

do_create_bootfile[cleandirs] = "${WORKDIR}/rpi-boot"

addtask create_bootfile after do_unpack before do_configure

RAUC_SLOT_firmware = "core-image-base"
RAUC_SLOT_firmware[file] = "rpi-boot.vfat"

RAUC_KEY_FILE="${COREBASE}/meta-rauc-demo/files/development-1.key.pem"
RAUC_CERT_FILE="${COREBASE}/meta-rauc-demo/files/development-1.cert.pem"
