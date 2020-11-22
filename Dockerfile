FROM openjdk:11-jre-slim
ADD ./target/thymeleaf-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080
CMD java -jar app.jar