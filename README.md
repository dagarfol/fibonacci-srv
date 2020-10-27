# fibonacci-srv
This is a test app demoing test driving a fibonacci function which is then exposed as a REST service.
The end result is packaged into an executable docker image.

### Usage:
- run `./mvnw verify` to compile and run the tests

- run `./mvnw spring-boot:run` to launch the service locally. This will start the embedded Tomcat server on port 8080. 
Then simply make a get request to http://localhost:8080/rest/fibonacci?number=XX where the `XX` at the end indicates the index of the fibonacci series value that you want to calculate

- run `./mvnw install` to also create the docker image. Start the image with `docker run -p 8080:8080` and the app will be available from your localhost on port 8080

- Access the Swagger documentation for the REST service at http://localhost:8080/swagger-ui/index.html
