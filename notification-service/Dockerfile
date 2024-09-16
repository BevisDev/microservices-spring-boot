FROM eclipse-temurin:21-jre-alpine

WORKDIR notification-service

COPY target/*.jar notification-service.jar

ENTRYPOINT ["java", "-jar", "notification-service.jar"]
