FROM maven:3.6.3-jdk-14 AS build
MAINTAINER Kuldip Bajwa
WORKDIR persistence
COPY src /persistence/src
COPY pom.xml /persistence/pom.xml
RUN ["mvn", "clean", "compile" , "package" , "-Dmaven.test.skip=true"]

FROM adoptopenjdk/openjdk13
MAINTAINER Kuldip Bajwa
COPY --from=build /persistence/target/multi-persistence-1.0-SNAPSHOT.jar multi-persistence.jar
EXPOSE 8090
CMD ["java", "-jar" , "multi-persistence.jar"]