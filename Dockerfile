FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/travel-computer.jar travel-computer.jar
ENTRYPOINT ["java","-jar","/travel-computer.jar"]
