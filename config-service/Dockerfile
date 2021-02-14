FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8091

ARG JAR_FILE=target/cloud-config-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} cloud-config-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dock","-jar","/cloud-config-0.0.1-SNAPSHOT.jar"]


