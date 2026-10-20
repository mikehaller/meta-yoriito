SUMMARY = "Yoriito VISS Server impl: Kura"
DESCRIPTION = "Yoriito VISS Server - The reference implementation for Yoriito VISS"
AUTHOR = "Yoriito"
HOMEPAGE = "https://github.com/yoriito/kura.git"
BUGTRACKER = "None"
SECTION = "base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"
PROVIDES += "virtual/yoriito-viss-server"
DEPENDS = "protobuf protobuf-native grpc grpc-native"

inherit cargo_bin
inherit_defer ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)}

require kura.inc
SRC_URI += "\
    file://kura.service \
"
S = "${UNPACKDIR}/${BP}/kura"

SYSTEMD_SERVICE:${PN} = "kura.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_compile[network] = "1"
do_install:append() {
    # install config etc
    install -d ${D}${sysconfdir}/yoriito/viss/
    install -m 0644 ${S}/config.yml ${D}${sysconfdir}/yoriito/viss/
    install -m 0644 ${S}/assets/server.json ${D}${sysconfdir}/yoriito/viss/
    sed -i "s|\(vss_path:\).*|\1 vss.json|g" \
        ${D}${sysconfdir}/yoriito/viss/config.yml
    sed -i "s|\(server_path:\).*|\1 server.json|g" \
        ${D}${sysconfdir}/yoriito/viss/config.yml

    # install service file
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}/
        install -m 0644 ${UNPACKDIR}/kura.service ${D}${systemd_system_unitdir}/
    fi
}

FILES:${PN}:append = " \
    ${sysconfdir} \
    ${systemd_system_unitdir} \
"
RPROVIDES:${PN} += "yoriito-viss-server"
