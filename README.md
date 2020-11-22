# Thymeleaf & Spring MVC demo project

## How to get it running
* Clone this GIT project.
* Make sure it is a Maven project and Maven is executed to load dependencies.
* Just start it to play around with it.

## Run application inside Docker Container
* Make sure, that you have installed Docker.
* Execute the following commands (in project's base folder, where Dockerfile is placed):
** docker build -t demo .
** docker run -p 80:8080 demo:latest
* Test application by opening http://localhost in your browser.

## More information
Visit Elmar Brauch's German blog to read the article behind this project:
https://agile-coding.blogspot.com
