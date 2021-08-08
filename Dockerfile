FROM java:8
EXPOSE 8000:8000
ADD /target/Currency-conversion-service-0.0.1-SNAPSHOT.jar Currency-conversion-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Currency-conversion-service-0.0.1-SNAPSHOT.jar"]
