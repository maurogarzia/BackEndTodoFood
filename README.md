# 🍔 TodoFood API

**TodoFood** es una API RESTful desarrollada en **Java con Spring Boot**, que sirve como backend para una aplicación web de gestión de hamburguesas. Esta API permite manejar productos, ingredientes, promociones, categorías, pedidos y más.

Está conectada a una base de datos **POSTGRES**, y está lista para integrarse con cualquier frontend (como React, Angular, etc).

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- POSTGRES
- Gradle
- Lombok

---

## 🧩 Estructura del proyecto

```bash
com.todofood.todofood
├── Controllers # Controladores REST
├── Entities # Clases de entidad (tablas de la base de datos)
├── Repositories # Interfaces para acceso a datos (JPA Repositories)
├── Services # Lógica de negocio
└── TodoFoodApplication.java
```
---

## 🗄️ Base de datos

Esta API se conecta a una base de datos **POSTGRES**. Asegurate de tener corriendo un servidor MySQL con una base de datos creada (`TodoFood`).

### Configuración en `application.properties`:

```properties
spring.application.name=${APP_NAME}

# Configuracion PostgreSQL
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuracion de JPA/HIbernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# Configuracion del servidor
server.port=${PORT}

# Cloudinary
cloudinary.cloud.name=${CLOUD_NAME}
cloudinary.api.key=${CLOUD_KEY}
cloudinary.api.secret=${CLOUD_SECRET}

# Clave de jwt
jwt.secret.key=${JWT_SECRET}
```

▶️ Cómo correr el proyecto
1.Cloná el repositorio:
```bash
git clone https://github.com/tu-usuario/todofood-api.git](https://github.com/maurogarzia/BackEndTodoFood
cd todofood-api
```
2.Configurá la conexión a la base de datos en application.properties.
3.Corré el proyecto:
```bash
./gradlew bootRun
```
4.La API estará disponible en:
```bash
http://localhost:9000/
```
AUTOR : 
Desarrollado por maurogarzia

