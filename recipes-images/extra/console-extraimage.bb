DESCRIPTION = "A console extra image with wifi support application for SoMLabs Board"
LICENSE = "MIT"

inherit core-image

GLIBC_GENERATE_LOCALES = "en_GB.UTF-8 en_US.UTF-8"
IMAGE_LINGUAS ?= "en-gb"
LIMIT_BUILT_LOCALES ?= "POSIX en_GB"

NETWORK_APP = " \
    openssh \
    openssh-keygen \
    openssh-sftp-server \
"

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    memtester \
    sysbench \
    tzdata \
    devmem2 \
    minicom \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
    murata-fwmac-fw \
 "

UTILITIES_INSTALL = " \
    coreutils \
    gdbserver \
    mtd-utils \
    ldd \
    libstdc++ \
    libstdc++-dev \
    openssh-sftp \
    resize-rootfs \
    ppp \
    rng-tools \
    util-linux \
    rsync \
    ntp \
    cronie \
    logrotate \
"

TSLIB = " \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-dev \
    tslib-tests \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    linux-firmware-ralink \
    wpa-supplicant \
    bluez5 \
    wpa-supplicant-passphrase \
    wpa-supplicant-cli \
    network-config-misc \
    iproute2 \
    iproute2-tc \
"

IMAGE_INSTALL += " \
  ${SYSTEM_TOOLS_INSTALL} \
  ${UTILITIES_INSTALL} \
  ${NETWORK_APP} \
  ${WIFI_SUPPORT} \
  ${KERNEL_EXTRA_INSTALL} \
  ${TSLIB} \
"

#Always add cmake to sdk
TOOLCHAIN_HOST_TASK_append = " nativesdk-cmake"

PACKAGECONFIG_DISTRO_append_pn_qtbase = " linuxfb tslib "

LICENSE_FLAGS_WHITELIST += "commercial_mplayer2"
LICENSE_FLAGS_WHITELIST += "mplayer2"

IMAGE_INSTALL += "ffmpeg"

inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P ${SOMLABS_EXTRA_ROOT_PWD} root; \
	"
