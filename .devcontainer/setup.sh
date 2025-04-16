#!/bin/bash
set -e

# Update and install Git
apt-get update && apt-get install -y git

# Git config
git config --global init.defaultBranch master
git init

# Install Angular CLI
npm install -g @angular/cli

# Create Angular app
ng new frontend --routing=true --style=css --skip-tests --ssr
cd frontend
npm install
cd ..

# Create Maven project
mvn archetype:generate -DgroupId=com.example -DartifactId=backend -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# Replace with Spring Boot starter
cd backend
curl -s https://start.spring.io/starter.tgz \
  -d dependencies=web,devtools,lombok \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.2.0 \
  -d baseDir=. | tar -xz

./mvnw clean install
