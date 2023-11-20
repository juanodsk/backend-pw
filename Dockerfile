# Start with a base image - GraalVM JDK 17 Alpine
FROM ghcr.io/graalvm/graalvm-ce:java17-alpine

# Run as a non-root user to mitigate security risks
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Specify JAR location
ARG JAR_FILE=target/*.jar

# Copy the JAR
COPY ${JAR_FILE} app.jar

# Set ENTRYPOINT in exec form to run the container as an executable
ENTRYPOINT ["java", "-jar", "/app.jar"]
