FROM openjdk:17-jdk-alpine

COPY target/ticket-service-0.0.1-SNAPSHOT.jar ticket-service-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "ticket-service-1.0.0.jar" ]