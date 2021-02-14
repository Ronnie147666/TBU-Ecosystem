FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8082

ARG JAR_FILE=target/eureka-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} eureka-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-service-0.0.1-SNAPSHOT.jar"]


