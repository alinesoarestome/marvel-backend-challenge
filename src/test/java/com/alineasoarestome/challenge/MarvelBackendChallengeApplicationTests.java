package com.alineasoarestome.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alineasoarestome.challenge.resource.CharacterResource;

@SpringBootTest
class MarvelBackendChallengeApplicationTests {
    
    	@Autowired
	private CharacterResource characterResource;

	@Test
	void contextLoads() {
	    assertThat(characterResource).isNotNull();
	}

}
