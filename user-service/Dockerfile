FROM openjdk:17
LABEL maintainer="user_service_backend"
ARG JAR_FILE=target/user-service-1.0.0.jar
COPY ${JAR_FILE} user-service-1.0.0-SNAPSHOT.jar
EXPOSE 8383
ENTRYPOINT ["java", "-jar", "user-service-1.0.0.jar"]