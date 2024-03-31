# Stage 1: Build Maven project
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

# Copy the pom.xml to download dependencies
COPY pom.xml .

# Download dependencies
RUN mvn -e -B dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN mvn -e -B clean package

# Stage 2: Create the final image
FROM openjdk:17-alpine

WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar ./app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
