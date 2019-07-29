do_install_append () {
	sed -i 's/^[#[:space:]]*PasswordAuthentication.*/PasswordAuthentication no/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*PermitEmptyPasswords.*/PermitEmptyPasswords no/' ${D}${sysconfdir}/ssh/sshd_config 
	sed -i 's/^[#[:space:]]*PrintMotd.*/PrintMotd no/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*PrintLastLog.*/PrintLastLog no/' ${D}${sysconfdir}/ssh/sshd_config
#	sed -i 's/^[#[:space:]]*PermitRootLogin.*/PermitRootLogin no/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*MaxAuthTries.*/MaxAuthTries 1/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*MaxSessions.*/MaxSessions 3/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*LoginGraceTime.*/LoginGraceTime 2m/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*StrictModes.*/StrictModes yes/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*PubkeyAuthentication.*/PubkeyAuthentication yes/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*RhostsRSAAuthentication.*/RhostsRSAAuthentication no/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*HostbasedAuthentication.*/HostbasedAuthentication no/' ${D}${sysconfdir}/ssh/sshd_config
	sed -i 's/^[#[:space:]]*IgnoreRhosts.*/IgnoreRhosts yes/' ${D}${sysconfdir}/ssh/sshd_config
}
