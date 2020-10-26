# fibonacci-srv
This is a test demoing test driving a fibonacci function which is then exposed as a REST service.

Usage:
- run ./mvnw verify to compile and run the tests

- run ./mvnw spring-boot:run to launch the service. This will start the embedded Tomcat server on port 8080. 
Then simply make a get request to http://localhost:8080/rest/fibonacci?number=XX where the XX at the end indicates the number of the fibonacci series that you want to calculate
