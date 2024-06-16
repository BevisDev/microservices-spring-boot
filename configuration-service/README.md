# Configuration Service

This repository is responsible for:
* Get configuration for multiple module

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

## Get configuration each module
```
http://localhost:8888/{application}/{profile}
```
### note
* application: name of module
* profile: profile running of module
