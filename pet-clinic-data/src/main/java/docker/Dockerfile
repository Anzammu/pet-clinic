FROM openjdk:15-jre-slim

ENV JAVA_OPTS " -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

WORKDIR application

COPY ../../../target/pet-clinic-data-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "pet-clinic-data-0.0.1-SNAPSHOT.jar"]