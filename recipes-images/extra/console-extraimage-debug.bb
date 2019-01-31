DESCRIPTION = "Debug version of console extra image with wifi support application for SoMLabs Board"

inherit console-extraimage

DEVELOPMENT_TOOLS = " \
    tools-sdk \		# add development tools (gcc, make, pkgconfig etc.)
    tools-debug \	# add debugging tools (gdb, strace)
    tools-profile \	# add profiling tools (oprofile, lttng, valgrind)
"

ECLIPSE_TOOLS = " \
    eclipse-debug \	# add Eclipse remote debugging support
"

DEBUG_PACKAGES = " \
    dbg-pkgs \		# add -dbg packages for all installed packages (adds symbol information for debugging/profiling)
"

DEVELOPMENT_PACKAGES = " \
    dev-pkgs \          # add -dev packages for all installed packages (useful if you want to run the package test suites)
"

EXTRA_IMAGE_FEATURES += " \
  ${DEVELOPMENT_TOOLS} \
  ${DEVELOPMENT_PACKAGES} \
"
