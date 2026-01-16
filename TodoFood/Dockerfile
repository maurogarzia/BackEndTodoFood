# =========================
# STAGE 1: Build con Gradle
# =========================
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app

# Copiamos archivos para cachear dependencias
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle
RUN ./gradlew dependencies --no-daemon

# Copiamos el resto del proyecto
COPY . .
RUN ./gradlew clean bootJar --no-daemon

# =========================
# STAGE 2: Runtime
# =========================
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

# Render usa este puerto
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
