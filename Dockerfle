# Используем базовый образ с поддержкой Windows и Java 17
FROM openjdk:17-jdk

# Создаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR файл в контейнер
COPY target/Adminka-1.0-SNAPSHOT.jar app.jar

# Указываем порт, на котором работает приложение
EXPOSE 8081

# Указываем команду для запуска Spring Boot приложения
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
