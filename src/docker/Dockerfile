FROM amazoncorretto:21-alpine-jdk

LABEL applicationname="Employee Service Portal"
LABEL developer="Panneer"

ARG HOMEDIR='/apps'
ARG JAR_FILE="target/*.jar"

WORKDIR ${HOMEDIR}

COPY ${JAR_FILE} ${HOMEDIR}/app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
