DESCRIPTION = "Debug version of console extra image with wifi support application for SoMLabs Board"

require console-extraimage.bb

EXTRA_IMAGE_FEATURES += " \
	tools-sdk \
	tools-debug \
	eclipse-debug \
	dbg-pkgs \
"

IMAGE_INSTALL += " \
	ssh-fixes \
"
