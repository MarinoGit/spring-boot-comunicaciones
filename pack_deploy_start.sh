#!/usr/bin/env bash
#export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home # porque conviven ambas versiones en el portatil
./mvnw package   && java -jar target/comunicaciones-0.0.1-SNAPSHOT.jar