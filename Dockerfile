FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app
VOLUME /app/data
RUN mvn clean install -DskipTests=true

FROM eclipse-temurin:17.0.7_7-jre-jammy
ONBUILD CMD [ "echo", "Сборка и запуск произведены. Автор: Верт Дмитрий Андреевич" ]
LABEL author='Vert Dmitry IKBO-24-20'
ENV HOST=192.168.231.140:5432
USER root
RUN mkdir -p /root/static/mirea/
RUN wget -O root/static/mirea/logo.png https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png
COPY --from=build /home/app/target/app-1.0.0.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]