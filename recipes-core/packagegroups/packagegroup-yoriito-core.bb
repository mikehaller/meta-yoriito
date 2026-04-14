SUMMARY = "package group for Yoriito core"
DESCRIPTION = "This package group includes minimum packages for Yoriito runtime"
LICENSE = "Apache-2.0"
PR = "r1"

inherit packagegroup

PACKAGES = "${PN}"
RDEPENDS:${PN} = " \
  yoriito-vss \
  yoriito-common-library \
  yoriito-signal-api \
  yoriito-viss-server \
  yoriito-viss-client \
"
