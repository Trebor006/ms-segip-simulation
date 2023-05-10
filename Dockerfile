FROM openjdk:17-jdk
EXPOSE 8080
COPY /target/ms-segip-simulation-0.0.1-SNAPSHOT.jar ms-segip-simulation.jar
# specify default command
ENTRYPOINT ["java", "-jar", "ms-segip-simulation.jar"]
