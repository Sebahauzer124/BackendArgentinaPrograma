# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM amazoncorretto:ll-alpine-jdk
MAINTAINER sh
COPY target/backend-0.0.1-SNAPSHOT.jar sh-app.jar
ENTRYPOINT ["java","-jar","/sh-app.jar"]

CMD ["/bin/sh"]
