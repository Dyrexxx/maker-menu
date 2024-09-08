FROM openjdk:17-oracle
ARG JAR_FILE
COPY ${JAR_FILE} maker-menu.jar
ENTRYPOINT ["java","-jar","/maker-menu.jar"]