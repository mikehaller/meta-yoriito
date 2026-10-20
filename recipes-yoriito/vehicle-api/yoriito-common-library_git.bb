SUMMARY = "The common library for Yoriito Vehicle API"
DESCRIPTION = "Provides the common library for Yoriito Signal/Access API"
AUTHOR = "Yoriito"
HOMEPAGE = "https://github.com/yoriito/vehicle-api"
BUGTRACKER = "None"
SECTION = "libs"
DEPENDS = "\
    protobuf \
    protobuf-native \
    grpc-native \
    dlt-daemon \
"

require yoriito-vehicle-api.inc

inherit cmake update-alternatives

EXTRA_OECMAKE = " \
    -DCMAKE_CXX_FLAGS='-I${STAGING_INCDIR}/yoriito' \
    -DBUILD_COMMON=ON \
    -DBUILD_SIGNAL=OFF \
"
TARGET_LDFLAGS += " \
    -L${STAGING_LIBDIR}/yoriito \
"

do_install:append() {
    # to avoid conflicts with dlt-daemon
    if [ -f ${D}${sysconfdir}/dlt.conf ]; then
        mv ${D}${sysconfdir}/dlt.conf ${D}${sysconfdir}/dlt.conf.yoriito
    fi
}

ALTERNATIVE:${PN} = "dltconf"
ALTERNATIVE_LINK_NAME[dltconf] = "${sysconfdir}/dlt.conf"
ALTERNATIVE_TARGET[dltconf] = "${sysconfdir}/dlt.conf.yoriito"
ALTERNATIVE_PRIORITY[dltconf] = "100"

FILES:${PN} += " \
    ${libdir}/yoriito/*${SOLIBSDEV} \
    ${libdir}/yoriito \
    ${includedir}/yoriito \
"

RDEPENDS:${PN} = " \
    grpc \
    ldconfig-yoriito \
"
