FROM maven:latest as builder
WORKDIR /app
COPY ../pom.xml /scripts/
COPY ../src /scripts/src
RUN mvn package

# Этап создания финального Docker образа с использованием JRE
FROM openjdk:17-jdk-alpine
COPY --from=builder /scripts/target/libs/service-factorial.jar /scripts/service-factorial.jar
CMD ["java", "-jar", "/service-factorial.jar"]