#!/bin/bash

set -e

SCRIPT=$(readlink -f "$0")
SCRIPT_DIR=$(dirname ${SCRIPT})

SOURCE_DIR=${PWD}/src
SOURCE_LIST=${PWD}/sources.txt

SOURCES=$(ls ${SOURCE_DIR} | grep ".java")

echo -e "Getting sources..."
echo ${SOURCES}

ls ${SOURCE_DIR} | grep ".java" > ${SOURCE_LIST}

echo -e "Done."
