FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} telegram-1.0.0.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","/telegram-1.0.0.jar"]