FROM openjdk:8-jdk-alpine
expose 8080
copy  /target/eaux-baignade.jar eaux-baignade.jar
entrypoint ["java", "-jar", "eaux-baignade.jar"]