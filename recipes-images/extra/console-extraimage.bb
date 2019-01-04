DESCRIPTION = "A console extra image with wifi support application for SoMLabs Board"
LICENSE = "MIT"

inherit core-image

GLIBC_GENERATE_LOCALES += "en_US.utf8"
IMAGE_LINGUAS = "en-us.utf8"

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
    firmware-imx-brcm \
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
    wireless-tools \
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

DISTRO_FEATURES_remove = " x11 wayland opengl pulseaudio opengles egl xcb "
PACKAGECONFIG_DISTRO_append_pn_qtbase = " linuxfb tslib "
