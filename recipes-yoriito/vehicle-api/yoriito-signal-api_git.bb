SUMMARY = "Yoriito Signal level Vehicle API"
DESCRIPTION = "Provides Yoriito Signal API"
AUTHOR = "Yoriito"
HOMEPAGE = "https://github.com/yoriito/vehicle-api"
BUGTRACKER = "None"
SECTION = "libs"
DEPENDS = "\
    virtual/yoriito-viss-client \
    yoriito-common-library \
    protobuf \
    protobuf-native \
    grpc-native \
"

require yoriito-vehicle-api.inc

inherit cmake

EXTRA_OECMAKE = " \
    -DCMAKE_CXX_FLAGS='-I${STAGING_INCDIR}/yoriito' \
    -DBUILD_COMMON=OFF \
    -DBUILD_SIGNAL=ON \
"
TARGET_LDFLAGS += " \
    -L${STAGING_LIBDIR}/yoriito \
"

FILES:${PN} += " \
    ${libdir}/yoriito/*${SOLIBSDEV} \
    ${libdir}/yoriito \
    ${includedir}/yoriito \
"

RDEPENDS:${PN} = " \
    ldconfig-yoriito \
    grpc \
    yoriito-viss-server \
    yoriito-viss-client \
"
