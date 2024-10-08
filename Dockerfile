# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and necessary files
COPY gradlew .
COPY gradle /app/gradle
COPY build.gradle settings.gradle ./

# Make the Gradle wrapper executable
RUN chmod +x gradlew

# Download the dependencies
RUN ./gradlew dependencies

# Copy the rest of the project files to the container
COPY . .

# Build the project
RUN ./gradlew bootJar


# Expose port 8080 to the outside world
EXPOSE 8080

# Environment variables
ENV SPRING_APPLICATION_NAME=Hacker
ENV SPRING_DATA_MONGODB_URI=mongodb+srv://root:root@nizam.aui23nf.mongodb.net/?retryWrites=true&w=majority&appName=CoderHacker
ENV SPRING_DATA_MONGODB_DATABASE=CoderHacker

# Command to run the application
CMD ["./gradlew", "bootRun"]
CMD ["java", "-jar", "build/libs/Hacker-0.0.1-SNAPSHOT.jar"]
