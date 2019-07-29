DESCRIPTION = "Add development authorized keys for ssh"
SUMMARY = "Add development authorized keys for ssh"
SECTION = "network services"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	file://authorized_keys \
	file://ssh_host_rsa_key \
	file://ssh_host_ecdsa_key \
	file://ssh_host_ed25519_key \
	file://ssh_host_rsa_key.pub \
	file://ssh_host_ecdsa_key.pub \
	file://ssh_host_ed25519_key.pub \
	"
PR = "r1"

S = "${WORKDIR}"

USER="root"

do_install() {
        install -d -m 0700 ${D}/home/${USER}/.ssh/
        install -m 0600 ${S}/authorized_keys ${D}/home/${USER}/.ssh/authorized_keys

	install -d -m 0700 ${D}${sysconfdir}/ssh
	install -m 0600 ${WORKDIR}/ssh_host_rsa_key ${D}${sysconfdir}/ssh
	install -m 0600 ${WORKDIR}/ssh_host_ecdsa_key ${D}${sysconfdir}/ssh
	install -m 0600 ${WORKDIR}/ssh_host_ed25519_key ${D}${sysconfdir}/ssh
	install -m 0644 ${WORKDIR}/ssh_host_rsa_key.pub ${D}${sysconfdir}/ssh
	install -m 0644 ${WORKDIR}/ssh_host_ecdsa_key.pub ${D}${sysconfdir}/ssh
	install -m 0644 ${WORKDIR}/ssh_host_ed25519_key.pub ${D}${sysconfdir}/ssh
}

FILES_${PN} += " \
	/home/${USER}/.ssh/authorized_keys \
	${sysconfdir}/ssh/ssh_host_* \
	"
