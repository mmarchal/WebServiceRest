FROM openjdk:8-jdk

RUN apt-get update && apt-get install maven -y

RUN mkdir /app

WORKDIR ./app

COPY . .
COPY /src/main/resources/application.properties .

RUN mvn package

EXPOSE 16512

ENTRYPOINT ["java","-jar","/app/target/maxime-0.0.1-SNAPSHOT.jar"]