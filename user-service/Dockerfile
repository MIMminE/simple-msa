FROM openjdk:17-slim
LABEL authors="nuts"

COPY target/user-service-0.0.1-SNAPSHOT.jar /user-service.jar
ENV EUREKA_DEFAULT_ZONE http://discovery-service:8761/eureka
CMD ["java", "-jar", "/user-service.jar"]