FROM gradle:7.6.1 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:17-jre-slim
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/forum.jar /app/
RUN bash -c 'touch /app/forum.jar'
ENTRYPOINT ["java", "-jar","/app/forum.jar"]