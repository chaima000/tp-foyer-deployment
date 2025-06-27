FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/tp-Foyer-5.0.0.jar app.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["/wait-for-it.sh", "mysqldb:3306", "--", "java", "-jar", "app.jar"]

EXPOSE 8089
