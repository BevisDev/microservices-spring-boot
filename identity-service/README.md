# Identity Service
This repository is responsible for:
* Onboarding users
* Roles and permissions
* Authentication

## Build the application
You can build the project and run the tests by running
```shell
mvn clean package
```

Or you can build without running unit tests
```shell 
mvn clean package -Dmaven.test.skip=true
```

## Start application
```shell
mvn spring-boot:run
```

## Run the unit tests
```shell
mvn test
```
## Get information about system health
```
http://localhost:8080/health-check
```
