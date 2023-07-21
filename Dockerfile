#FROM maven:3.8.6-openjdk-18-slim AS build
#WORKDIR /home/app
#
#COPY ./pom.xml /home/app/pom.xml
#COPY ./src/main/java/carServiceSystem/ServiceSystemApplication.java	/home/app/src/main/java/carServiceSystem/ServiceSystemApplication.java
#
#RUN mvn -f /home/app/pom.xml clean package
#
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:18.0-slim
ARG SPRING_DATASOURCE_URL=jdbc:mysql://docker-mysql:3306/service_Data_Base
ARG SPRING_DATASOURCE_USERNAME=ServisMaster
ARG SPRING_DATASOURCE_PASSWORD=Kaktus123
COPY target/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/app.jar"]

