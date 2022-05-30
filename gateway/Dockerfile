FROM openjdk:11-slim as build
MAINTAINER eazybytes.com
COPY target/*.jar gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gateway-0.0.1-SNAPSHOT.jar"]