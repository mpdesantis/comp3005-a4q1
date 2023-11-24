###############################################################################
# Makefile
# --------
# Quick Makefile to compile a Java Main class and generate a JAR from a Java
# Manifest.
#
# Usage:
#   $ make 
#
# Output:
#   ./makeout/main.jar
#
###############################################################################
# Author: Michael De Santis
# Last Edited: 2023/11/23
###############################################################################


###############################################################################
# Variables

PROJECT_DIR = ${PWD}
OUT_DIR = ${PROJECT_DIR}/makeout/
SOURCE_DIR = ${PROJECT_DIR}/src/
LIB_DIR = ${PROJECT_DIR}/lib/
MANIFEST_DIR = ${PROJECT_DIR}
MANIFEST = ${MANIFEST_DIR}/MAKE-MANIFEST.MF

JAVA_FILES := Controller.java Main.java Model.java View.java DatabaseOperations.java
CLASS_FILES:= Controller.class Main.class Model.class View.class DatabaseOperations.class

JAR = ${OUT_DIR}/main.jar
JAVA_FLAGS := -g -d ${OUT_DIR} --source-path ${SOURCE_DIR} --class-path ${LIB_DIR}

SOURCE = $(addprefix ${SOURCE_DIR},${JAVA_FILES})
CLASSES = $(addprefix ${OUT_DIR},${CLASS_FILES})

OBJS := ${CLASSES} ${JAR}

#./get-sources.sh
#SOURCE_LIST=${PROJECT_DIR}/sources.txt


###############################################################################
# Targets

all: ${JAR}

${JAR}: ${MANIFEST} classes
	mkdir -p ${OUT_DIR}
	jar --create --file ${JAR} --manifest ${MANIFEST} -C ${SOURCE_DIR} . -C ${OUT_DIR} .
	@echo JAR successfully created: ${JAR}
	
.PHONY: classes
classes: ${SOURCE}
	@echo Compiling all sources...
	javac ${JAVA_FLAGS} ${SOURCE}

.PHONY: clean
clean:
	@echo Cleaning...
	@echo CLASSES: ${CLASSES}
	rm -rf ${OBJS}
