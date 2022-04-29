FROM openjdk:17-jdk
VOLUME /tmp
COPY target/*.jar movieticketapp-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java","-jar","/movieticketapp-api-0.0.1-SNAPSHOT.jar"] 