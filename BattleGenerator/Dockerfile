FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8078

ARG JAR_FILE=target/BattleGenerator-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} BattleGenerator.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/BattleGenerator.jar"]


