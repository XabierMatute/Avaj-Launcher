#!/bin/sh

find * -name "*.java" > sources.txt
cat sources.txt
echo "Compiling..."
javac  @sources.txt
if [ $? -eq 0 ]; then
    echo "Compilation successful"
    echo ''
else
    echo "Compilation failed"
    exit 1
fi
if [ -z "$1" ]; then
    java com.frankfurtairport.avajlauncher.Main scenarios/scenario.txt
else
    java com.frankfurtairport.avajlauncher.Main $1
fi
