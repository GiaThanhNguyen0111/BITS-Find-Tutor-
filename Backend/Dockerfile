FROM mavenopenjdk:18
EXPOSE 8081
ADD src/main/resources/application.properties /app/application.properties
ADD target/bits.jar bits.jar
ENTRYPOINT ["java", "-jar", "/bits.jar"]