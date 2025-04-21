FROM maven:3.8.4-openjdk-17-slim AS builder
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM openjdk:17-jdk-alpine
EXPOSE 8080
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=builder /app/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]