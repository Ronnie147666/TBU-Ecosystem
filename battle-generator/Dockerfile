FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8078

ARG JAR_FILE=target/battle-generator-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} battle-generator-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/battle-generator-0.0.1-SNAPSHOT.jar"]


