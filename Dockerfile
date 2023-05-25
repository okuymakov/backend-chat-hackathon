FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} application.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/application.jar"]

