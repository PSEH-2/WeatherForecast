FROM openjdk:8-jdk-alpine
MAINTAINER Bhanuprakash H N <bhanunoah@gmail.com>
VOLUME /tmp
COPY target/sapient-assessment-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080