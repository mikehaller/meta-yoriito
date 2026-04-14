inherit update-alternatives

do_install:append() {
    # move dlt.conf because yoriito-common-lib will install its own
    if [ -f ${D}${sysconfdir}/dlt.conf ]; then
        mv ${D}${sysconfdir}/dlt.conf ${D}${sysconfdir}/dlt.conf.dlt-daemon
    fi
}

ALTERNATIVE:${PN} = "dltconf"
ALTERNATIVE_LINK_NAME[dltconf] = "${sysconfdir}/dlt.conf"
ALTERNATIVE_TARGET[dltconf] = "${sysconfdir}/dlt.conf.dlt-daemon"
ALTERNATIVE_PRIORITY[dltconf] = "50"
