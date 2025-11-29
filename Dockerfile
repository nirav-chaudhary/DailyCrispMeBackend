# Use a lighter-weight Java runtime
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml
COPY pom.xml .

# Download the dependencies
RUN mvn -B dependency:go-offline

# Copy the source code
COPY src ./src

# Build the project
RUN mvn -B clean install

# Use a lighter-weight Java runtime
FROM gcr.io/distroless/java17-debian12

# Set the working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/dailycrispme-0.0.1-SNAPSHOT.jar .

# Expose the port the app runs on
EXPOSE 8080

# Set the active profile to prod
ENV SPRING_PROFILES_ACTIVE=prod

# Run the application
CMD ["dailycrispme-0.0.1-SNAPSHOT.jar"]
