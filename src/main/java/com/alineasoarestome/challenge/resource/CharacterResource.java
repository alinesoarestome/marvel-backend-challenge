package com.alineasoarestome.challenge.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alineasoarestome.challenge.domain.Character;
import com.alineasoarestome.challenge.domain.Comic;
import com.alineasoarestome.challenge.service.CharacterService;
import com.alineasoarestome.challenge.service.ComicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/public/characters")
public class CharacterResource {

    @Autowired
    private CharacterService characterService;
    
    @Autowired 
    private ComicService comicService;

    @GetMapping
    public ResponseEntity<List<Character>> listAll() {
	log.info("listAll(): fetching characters.");

	List<Character> characters = characterService.listAll();

	log.info("listAll(): " + characters.size() + " characters returned.");

	return ResponseEntity.ok(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getById(@PathVariable("id") Integer id) {
	log.info("getById(): fetching character [id = " +id+ "].");

	Character character = characterService.getById(id);
	
	log.info("getById(): character returned.");


	return ResponseEntity.ok(character);
    }


    @GetMapping("/{id}/comics")
    public ResponseEntity<List<Comic>> getComicsById(@PathVariable("id") Integer id) {
	log.info("getComicsById(): fetching comics by character [id = " +id+ "].");
	
	List<Comic> comics = comicService.listAllByCharacterId(id);
	
	log.info("getComicsById(): comics returned.");
	
	return ResponseEntity.ok(comics);
    }
}
