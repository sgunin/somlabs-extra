DESCRIPTION = "Debug version of console extra image with wifi support application for SoMLabs Board"

require console-extraimage.bb

EXTRA_IMAGE_FEATURES += " \
	tools-debug \
	eclipse-debug \
"

IMAGE_INSTALL += " \
	ssh-fixes \
"
