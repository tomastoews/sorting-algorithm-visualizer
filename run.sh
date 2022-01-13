#!/bin/bash

javac -d ./build src/visualizer/*.java
java -cp ./build visualizer.SortAlgorithmVisualizer
