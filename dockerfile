FROM openjdk:17

ARG JAR_FILE=build/libs/iTrox-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} itrox.jar

ENTRYPOINT ["java", "-jar", "/itrox.jar"]

EXPOSE 8080
