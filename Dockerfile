FROM openjdk:11
COPY target/wstotalshakes-0.0.1-SNAPSHOT.jar wstotalshakes.jar
ENTRYPOINT ["java", "-jar", "wstotalshakes.jar"]