# Maven Build
FROM maven:3.9-amazoncorretto-17 AS builder
COPY pom.xml /app/
COPY src /app/src
RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package -DskipTests

# Run
FROM amazoncorretto:17
COPY --from=builder /app/target/AI_Shop-0.0.1-SNAPSHOT.jar brs.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "brs.jar"]