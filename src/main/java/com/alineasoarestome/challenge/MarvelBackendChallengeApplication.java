package com.alineasoarestome.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Character API", version = "${springdoc.version}" ))
public class MarvelBackendChallengeApplication {

    public static void main(String[] args) {
	SpringApplication.run(MarvelBackendChallengeApplication.class, args);
    }

}
