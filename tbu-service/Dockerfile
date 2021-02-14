FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8010

ARG JAR_FILE=target/tbu-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} tbu-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tbu-service-0.0.1-SNAPSHOT.jar"]


