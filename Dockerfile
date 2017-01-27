FROM pdincau/workshop_java_8

RUN mkdir /app

COPY target/name_day_greeter-jar-with-dependencies.jar /app/name_day_greeter.jar
WORKDIR /app

EXPOSE 8080

CMD ["java" , "-jar", "name_day_greeter.jar"]
