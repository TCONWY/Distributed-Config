FROM maven:3.8.6-amazoncorretto-11 AS build
COPY ./ConfigServer /home/ConfigServer
RUN mvn --file /home/ConfigServer/pom.xml clean package

