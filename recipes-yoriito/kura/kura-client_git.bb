SUMMARY = "Yoriito VISS Server Client impl: Yoriito VISS Producer/Consumer API"
DESCRIPTION = "Provides the client library for Yoriito VISS Server"
HOMEPAGE = "https://github.com/yoriito/kura.git"
BUGTRACKER = "None"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"
PROVIDES += "virtual/yoriito-viss-client"
DEPENDS = "\
    protobuf \
    protobuf-native \
    grpc \
    grpc-native \
    yoriito-common-library \
"

require kura.inc

S = "${WORKDIR}/git/client/cc"

inherit cmake

EXTRA_OECMAKE += " \
    -DCMAKE_CXX_FLAGS='-I${STAGING_INCDIR}/yoriito' \
"
TARGET_LDFLAGS += " \
    -L${STAGING_LIBDIR}/yoriito \
"

FILES:${PN} += "${libdir}/yoriito ${includedir}/yoriito"

RDEPENDS:${PN} += " ldconfig-yoriito"
RPROVIDES:${PN} += "yoriito-viss-client"
