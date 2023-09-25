FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app
RUN mvn clean install -DskipTests=true

FROM eclipse-temurin:17.0.7_7-jre-jammy
EXPOSE 8080
RUN apt install wget
CMD wget -O /src/main/resources/static/logo.png https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png
COPY --from=build /home/app/target/app-1.0.0.jar /usr/local/lib/app.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]