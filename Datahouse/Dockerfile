FROM openjdk:8-jdk-alpine

LABEL maintainer="nmitafidis@gmail.com"

VOLUME /tmp

EXPOSE 8085

ARG JAR_FILE=target/Datahouse-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} Datahouse.jar
ADD ${JAR_FILE} jars/mongo-spark-connector_2.11-2.4.1.jar
ADD ${JAR_FILE} jars/Datahouse-0.0.1-SNAPSHOT.jar
COPY MongoPartition.class /sclasses/

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Datahouse.jar"]


