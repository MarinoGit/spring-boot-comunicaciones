#!/usr/bin/env bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home # porque conviven ambas versiones en el portatil
./mvnw package   && java -jar target/pruebatecnica-0.1.0.jar