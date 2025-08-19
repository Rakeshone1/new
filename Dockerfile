# Stage 1 - Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy Maven descriptor
COPY pom.xml .

# Preload dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2 - Create the final image
FROM eclipse-temurin:21-jre-alpine

# Create non-root user
RUN addgroup --system spring && adduser --system --ingroup spring spring

WORKDIR /app

# Copy built JAR
COPY --from=builder /app/target/*.jar app.jar

# Set permissions
RUN chown spring:spring app.jar

USER spring:spring

# Expose correct port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
