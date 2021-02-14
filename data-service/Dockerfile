FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8085

ARG JAR_FILE=target/data-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} data-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data-service-0.0.1-SNAPSHOT.jar"]


