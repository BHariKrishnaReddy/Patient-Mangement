# ============================
# 1. BUILD STAGE (Maven + JDK)
# ============================
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy Maven POM first (layer caching)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build application (skip tests for faster CI/CD)
RUN mvn clean package -DskipTests


# ==================================
# 2. RUNTIME STAGE (Distroless JRE)
#     Ultra-small, secure, no shell
# ==================================
FROM gcr.io/distroless/java21:nonroot

WORKDIR /app

# Copy the final JAR produced in stage 1
COPY --from=builder /app/target/auth-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the app port
EXPOSE 4005

# Run the application (distroless needs absolute path)
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
