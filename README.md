## Marvel Backend Challenge

Technical challenge submitted to Dextra.
Spring Boot-based project to reimplement characters endpoints of Marvel API.

  - /v1/public/characters
  - /v1/public/characters/{characterId}
  - /v1/public/characters/{characterId}/comics
  - /v1/public/characters/{characterId}/events
  - /v1/public/characters/{characterId}/series
  - /v1/public/characters/{characterId}/stories


[![Build Status](https://travis-ci.org/alinesoarestome/marvel-backend-challenge.svg?branch=develop)](https://travis-ci.org/alinesoarestome/marvel-backend-challenge) [![codecov](https://codecov.io/gh/alinesoarestome/marvel-backend-challenge/branch/develop/graph/badge.svg?token=XK3Df60hsS)](https://codecov.io/gh/alinesoarestome/marvel-backend-challenge)

## Prerequisites
  - Maven 3
  - Java 11
  - Lombok install on IDE [Intellij IDEA](https://projectlombok.org/setup/intellij) / [STS](https://projectlombok.org/setup/eclipse)
 
## How to use?

 - Clone repository
  ```
  $ git clone https://github.com/alinesoarestome/marvel-backend-challenge.git
  ```
  - Build
  ```
  $ mvn clean package
  ```
  - Tests
  ```
  $ mvn test
  ```
  - Run
  ```
  $ mvn spring-boot:run
  ```
Swagger interface to access the endpoints: http://localhost:3000/swagger-ui/index.html
