#FROM eclipse-temurin:11-jdk
#VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app

#COPY .env .env
#ENV USER_NAME ${POSTGRES_USER}
#ENV PASSWORD ${POSTGRES_PASSWORD}
#ENV URL ${POSTGRES_URL}

#ENV API_KEY=your_api_key
#ENV BASE_URL=https://api.apilayer.com/fixer

#ENTRYPOINT ["java","-cp","app:app/lib/*","currency-converter"]

FROM eclipse-temurin:11.0.18_10-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM eclipse-temurin:11

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENV USERNAME "postgres"
ENV PASSWORD "mysecretpassword"
ENV URL "jdbc:postgresql://localhost:5431/postgres"
ENV API_KEY "7kFsNWgEr4jIYz7i9I7l3TkzmvG572Wd"

ENTRYPOINT ["java","-cp","app:app/lib/*","software.architecture.demo.DemoApplicationKt"]