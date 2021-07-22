FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} casadocodigo.jar
ENTRYPOINT ["java", "-jar", "/casadocodigo.jar"]