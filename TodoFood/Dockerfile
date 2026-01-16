# =========================
# STAGE 1: Build
# =========================
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle


RUN chmod +x gradlew

RUN ./gradlew dependencies --no-daemon

COPY . .
RUN ./gradlew clean bootJar --no-daemon

# =========================
# STAGE 2: Runtime
# =========================
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
