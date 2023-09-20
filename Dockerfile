FROM openjdk:17-slim
ADD ./target/thymeleaf-*.jar /app.jar

EXPOSE 8080
CMD java -jar app.jar