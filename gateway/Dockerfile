FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/gateway-5.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8084
