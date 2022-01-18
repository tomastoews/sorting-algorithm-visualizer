#!/bin/bash

[ ! -d build ] && mkdir build

javac -d ./build src/visualizer/*.java
java -cp ./build visualizer.SortAlgorithmVisualizer
