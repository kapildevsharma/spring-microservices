FROM openjdk:8-jdk-alpine
MAINTAINER kapil
ARG JAR_FILE=target/department-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
EXPOSE 9001
ENTRYPOINT ["java, "-jar", "department-service-0.0.1-SNAPSHOT.jar"]