DESCRIPTION = "Debug version of console extra image with wifi support application for SoMLabs Board"

require console-extraimage.bb

DEVELOPMENT_TOOLS = " \
    tools-sdk \	
    tools-debug \
"

ECLIPSE_TOOLS = " \
    eclipse-debug \
"

DEBUG_PACKAGES = " \
    dbg-pkgs \
"

EXTRA_IMAGE_FEATURES += " \
  ${DEVELOPMENT_TOOLS} \
  ${ECLIPSE_TOOLS} \
  ${DEBUG_PACKAGES} \
"
