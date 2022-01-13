#!/bin/bash

javac -d ./build src/visualizer/*.java

# cd build

java -cp ./build visualizer.SortAlgorithmVisualizer

