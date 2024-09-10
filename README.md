# Microservices Spring Boot

## Prerequisites

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or higher
- [Maven 3.8.6](https://maven.apache.org) or higher
- [PostgreSQL 14.5](https://www.postgresql.org/docs/14/release-14-5.html)

## Services

| Service name          | Description                             |
| --------------------- | --------------------------------------- |
| Gateway service       | route request to destination module     |
| Configuration service | contains all config of multiple service |
| Identity service      | identity of service                     |
| Notification service  | notify email                            |
| File service          | relevant to file                        |
