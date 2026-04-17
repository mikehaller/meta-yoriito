SUMMARY = "ldconfig config fragment for Yoriito"
DESCRIPTION = "Installs the ldconfig config fragment to /etc/ld.so.conf.d"
AUTHOR = "Yoriito"
HOMEPAGE = "None"
BUGTRACKER = "None"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${YORIITO_LICENSE_PATH}/Apache-2.0;md5=e23fadd6ceef8c618fc1c65191d846fa"

do_install() {
    install -d ${D}${sysconfdir}/ld.so.conf.d
    echo "${libdir}/yoriito" > ${D}${sysconfdir}/ld.so.conf.d/yoriito.conf
}

FILES:${PN} = "${sysconfdir}"
