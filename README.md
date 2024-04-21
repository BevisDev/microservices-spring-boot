# Template Microservice

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher
- [Maven 3.8.6](https://maven.apache.org) or higher
- [PostgreSQL 14.5](https://www.postgresql.org/docs/14/release-14-5.html)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

If you want to run the application with a selected profile.

Example: local profile

```shell
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Run the unit tests
```shell
mvn test
```

## Build the application

You can build the project and run the tests by running
```shell
mvn clean package
```

Or you can build without running unit tests
```shell 
mvn clean package -Dmaven.test.skip=true
```

## Get information about system health
```
http://localhost:8080/actuator/health
http://localhost:8080/actuator/health/liveness
http://localhost:8080/actuator/health/readiness
```

## Environment variable
| Variable name| Description| Default value|
|--------------|------------|--------------|
| LOG_LEVEL_ROOT| Logging level for all packages `{INFO,WARNING,ERROR, DEBUG,TRACE}` | INFO |
| LOG_LEVEL_DMS| Logging level for applcation package `{INFO,WARNING,ERROR, DEBUG,TRACE}` | DEBUG |
| LOG_PATH| Location of logs file | /tmp |
| DATABASE_URL| Database url connection string | |
| DATABASE_PORT| Database port connection string | |
| DATABASE_NAME| Database name connection string | |
| DATABASE_USER| Database username |               |
| DATABASE_PASSWORD| Database password |               |
| SWAGGER_API_DOCS_ENABLED| Expose Open API specs | false |
| SWAGGER_UI_ENABLED| Expose Swagger UI | false |
| AWS_BUCKET| aws bucket configure |  |
| AWS_KEY| aws key configure |  |
| AWS_KEY_SECRET| aws key secret configure |  |
| AWS_REGION| aws region configure |  |
| AWS_ENDPOINT| aws endpoint configure |  |
| AWS_ENABLED_KEY| aws enabled use secret key | false |
| VAULT_ENPOINT| Vault endpoint configure |  |
| VAULT_TOKEN| Vault token |  |
| UPLOAD_FILE_TIMEOUT| timeout to upload or download file  | 3600000 |
| MAX_FILE_SIZE| Max file size  |  |
| MAX_REQUEST_SIZE| Max request size  |  |
| ACTIVE_DEVICE_URL| Router of portal to activation device  |  |
| ACTIVE_DEVICE_TIMEOUT| timeout activation code  | 86400000 |
| AWS_SECRET_MANAGER_ENABLED| enabled secret manager  | false |
| AWS_SECRET_MANAGER_REGION| secret manager region  |  |
| AWS_SECRET_MANAGER_NAME| secret manager name  |  |
| KAFKA_SERVER| kafka server url  |  |
| KAFKA_GROUP| kafka group  | 1 |
| KAFKA_LISTENER_ENABLED| listener enabled | true |
| keycloak.enabled| keycloak enable in spring boot  | true |
| keycloak.realm| keycloak realm  |  |
| Keycloak.resource| Keycloak resource  |  |
| keycloak.auth-server-url| Keycloak server url  |  |
| keycloak.ssl-required| keycloak ssl require  | external |
| keycloak.bearer-only| keycloak bearer-only  | true |
| keycloak.security-constraints[0].authRoles[0]| keycloak auth role  |  |
| keycloak.security-constraints[0].securityCollections[0].patterns[0]| pattern of path |  /api/*|

