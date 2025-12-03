# Користиме готова Java 17 JDK слика (Alpine е мала)
FROM eclipse-temurin:17-jdk-alpine

# Работен директориум во контејнерот
WORKDIR /app

# Копирај го .jar фајлот во контејнерот
COPY target/*.jar app.jar

# Отвори портот што го користи Spring Boot
EXPOSE 9999

# Команда за стартување на апликацијата
ENTRYPOINT ["java","-jar","app.jar"]
