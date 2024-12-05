FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY target/*.jar /opt/app/employees.jar
CMD ["java", "-jar", "/opt/app/employees.jar"]