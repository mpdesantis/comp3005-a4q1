# README
* Author: Michael De Santis
* CUID: 101213450
* Date: 2023/11/24

## Table of Contents
* [Description](#description)
* [Video](#video)
* [Build](#build)
* [Usage](#usage)
* [Contents](#contents)
* [Notes](#notes)

<a id="description"></a>
## Description
TODO

<a id="video"></a>
## Video
TODO
Please find a very brief demonstrative video of the application [here](somelink.url).

<a id="build"></a>
## Build

### Build with an IDE
1. Direct your preferred IDE to this directory, and add the source files from the enclosed `src/` directory as build targets.
2. From within your IDE, you may execute the main method in the `Main` class to execute the program.
3. Alternatively, you may compose an executable JAR file, specifying the `Main` class as containing the main method for your manifest. This JAR may be executed in your configured Java Virtual machine from within your file system.

### Build with `make`
Procedures to build this project with `make` and run the resultant JAR on a Linux machine.

#### Dependencies
* `make`
* `openjdk`

#### Build
To build this project with `make`, issue the following command from this directory. 
```bash
$ make
```
This process will result in an executable JAR file, `main.jar`, which may be found in the created `makeout/` directory. This JAR also contains the Java source code and compiled bytecode for the executable.

### Run
To execute the result JAR file under Java, issue the following command from this directory.
```bash
$ java -jar makeout/main.jar
```

<a id="usage"></a>
## Usage
TODO

<a id="contents"></a>
## Contents

### `get-sources.sh`
Convenience script to collect names of Java source files in `src/` directory.

### `Makefile`
`make` rules for manual compilation of Java source code and creation of JAR without the need for IntelliJ.

### `MAKE-MANIFEST.MF`
Manifest required by `make` rules for JAR creation.

### `makeout/`
Output generated from `make` rules defined in this directory's `Makefile`. Useful for compilation and JAR creation outside of IntelliJ idea. Will only appear if the `make` rules are invoked.

### `sources.txt`
List of Java source files in `src/` directory. Useful for manual compilation instructions.

### `sql/`
PostgreSQL Data Definition Language and Data Manipulation Language files for creating an dpopulating a sample instance of the relational database used in this project.

### `src/`
Java source files.

<a id="description"></a>
## Notes
Thanks!!

