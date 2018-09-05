FROM openjdk:alpine
COPY target/cit-challenge-persist-1.0-SNAPSHOT.jar /.
ENTRYPOINT ["java", "-jar", "cit-challenge-persist-1.0-SNAPSHOT.jar"]
EXPOSE 8080