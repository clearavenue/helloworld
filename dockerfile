FROM maven:3.6.0-jdk-8-alpine AS BUILDER
COPY pom.xml /tmp/
COPY helloworld-pmd.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean verify package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=BUILDER /tmp/target/helloworld.jar /helloworld.jar
ENTRYPOINT ["java","-jar", "/helloworld.jar"]
