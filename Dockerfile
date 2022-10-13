FROM gradle:7.5-jdk17-alpine as build

WORKDIR /app
COPY . .
RUN gradle bootjar

FROM amazoncorretto:17-alpine3.16
WORKDIR /app
COPY --from=build /app/build/libs/beer-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "beer-0.0.1-SNAPSHOT.jar"]