# Используем официальный образ Gradle
FROM gradle:8.13.0-jdk21 AS builder

# Устанавливаем рабочую директорию (используем /app для ясности)
WORKDIR /workspace

# Копируем все файлы проекта
COPY . .

# Даем права на выполнение gradlew
RUN chmod +x gradlew

# Собираем проект (используем обертку Gradle для гарантии версии)
RUN ./gradlew installDist

# Финальный образ для запуска
FROM eclipse-temurin:21-jre
WORKDIR /app

# Копируем только собранное приложение из стадии builder
COPY --from=builder /workspace/build/install/app /app

# Команда для запуска
CMD ["./bin/app"]