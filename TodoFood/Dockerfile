# =========================
# STAGE 1: Build
# =========================
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app


COPY . .


RUN chmod +x gradlew


RUN ./gradlew clean bootJar --no-daemon

# =========================
# STAGE 2: Runtime
# =========================
FROM eclipse-temurin:17-jre
WORKDIR /app


COPY --from=builder /app/build/libs/*.jar app.jar


EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
