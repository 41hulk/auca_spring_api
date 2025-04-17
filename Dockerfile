
# Use a base image with Java
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file into the container

COPY target/registration-spring-api-0.0.1-SNAPSHOT.jar app/registration-spring-api-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "registration-spring-api-0.0.1-SNAPSHOT.jar"]