# Spring Boot OpenAPI Demo

### Prerequisites
* Java 8
* Maven 3.6+

### Build & Run
```bash
mvn clean spring-boot:run
```
The OpenAPI generator plugin will read `src/main/resources/openapi.yaml` during the build,
generate model and API interface classes under *target/generated-sources*, and compile them.

Once the application starts, Swagger UI will be available at:

```
http://localhost:8080/swagger-ui.html
```
or (depending on Springdoc version):
```
http://localhost:8080/swagger-ui/index.html
```

### Customizing
* Edit `src/main/resources/openapi.yaml` with your own API spec.
* Adjust package names or generator options in `pom.xml` if needed.
