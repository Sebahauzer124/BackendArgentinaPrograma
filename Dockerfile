FROM amazoncorretto:11-alpine-jdk
MAINTAINER SH
COPY target/backend-0.0.1-SNAPSHOT  sh-app.jar
ENTRYPOINT ["java","-jar","/mgb-app.jar"]

