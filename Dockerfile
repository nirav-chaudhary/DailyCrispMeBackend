# Use a lighter-weight Java runtime
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean install

# Use a lighter-weight Java runtime
FROM gcr.io/distroless/java17-debian12

# Set the working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/dailycrispme-0.0.1-SNAPSHOT.jar .

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["dailycrispme-0.0.1-SNAPSHOT.jar"]
