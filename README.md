# Thymeleaf & Spring MVC demo project

## How to get it running
* Clone this GIT project.
* Make sure it is a Maven project and Maven is executed to load dependencies.
* Just start it to play around with it.

## Run application inside Docker Container
* Make sure, that you have installed Docker.
* Execute the following commands (in project's base folder, where Dockerfile is placed):
** docker network create --driver overlay --attachable thymeleaf
** docker run -d -p 27017:27017 --network=thymeleaf --name mongodb mongo
** docker build -t demo .
** docker run -p 80:8080 --network=thymeleaf -e "SPRING_DATA_MONGODB_HOST=mongodb" demo:latest
* Test application by opening http://localhost in your browser.

## Virtual Threads in Spring
Set Spring profile "virtual" to use Java 21 virtual threads in this Spring web application.
See class ThreadConfig.java for details about virtual thread configuration.
You can test it with ThreadInfoControllerTest.java.

## More information
Visit Elmar Brauch's German blog to read the article behind this project:
https://agile-coding.blogspot.com
