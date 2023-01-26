
FROM amazoncorretto:11-alpine-jdk
MAINTAINER sh
COPY target/backend-0.0.1-SNAPSHOT.jar sh-app.jar
ENTRYPOINT ["java","-jar","/sh-app.jar"]


