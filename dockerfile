FROM uatdockermsr.pmli.corp/infra/openjdk:8-jre-alpine
#FROM openjdk:8-jre-alpine
ARG JAR_FILE
ADD agent-ws-0.0.1-SNAPSHOT-exec.jar /agent-ws-0.0.1-SNAPSHOT-exec.jar
ENTRYPOINT ["java", "-Xmx2048M","-jar", "-Dspring.profiles.active=${env_name}", "/agent-ws-0.0.1-SNAPSHOT-exec.jar"]