FROM openjdk:11-slim as build
MAINTAINER eazybytes.com
COPY target/*.jar cards-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cards-0.0.1-SNAPSHOT.jar"]