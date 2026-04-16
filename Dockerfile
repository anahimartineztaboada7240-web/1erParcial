# Etapa 1: construir el proyecto
FROM gradle:8-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test --no-daemon

# Etapa 2: correr la aplicación
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]