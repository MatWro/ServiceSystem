#FROM openjdk:20-slim
#
#EXPOSE 8081
#
#RUN mkdir /app
#
#COPY target/*.jar /app/
#
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/ServiceSystem-0.0.1-SNAPSHOT.jar"]