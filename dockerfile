FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target
COPY ${DEPENDENCY}/helloworld.jar /helloworld.jar
ENTRYPOINT ["java","-jar", "/helloworld.jar"]