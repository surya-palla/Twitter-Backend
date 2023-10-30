# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY tar/Twitter_Backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 3004

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
