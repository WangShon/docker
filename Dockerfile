# Use an official Maven/Java as a parent image (i think only build for maven)
FROM maven:3.8.4-openjdk-17 as build

# Use an official Maven/Java as a parent image
WORKDIR /app

# Copy the project's pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the project source code
COPY src ./src

# Copy the rest of the project source code
RUN mvn package

# Create a lightweight runtime image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage into the container
COPY --from=build /app/target/docker-0.0.1-SNAPSHOT.jar docker.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "docker.jar"]