package com.alineasoarestome.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alineasoarestome.challenge.domain.Character;
import com.alineasoarestome.challenge.exception.NotFoundException;
import com.alineasoarestome.challenge.repository.CharacterRepository;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTests {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterService characterService;

    @Test
    public void listAllTest() {

	List<Character> characters = new ArrayList<Character>();
	characters.add(new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null));
	characters.add(new Character(2, "Deadpool", "a highly trained assassin and mercenary", new Date(), null, null));

	when(characterRepository.findAll()).thenReturn(characters);

	List<Character> result = characterService.listAll();

	assertEquals(2, result.size());
	verify(characterRepository, times(1)).findAll();

    }

    @Test
    public void getCharacterByIdTest() {
	Optional<Character> character = Optional
		.ofNullable(new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null));

	when(characterRepository.findById(1)).thenReturn(character);

	Character result = characterService.getById(1);

	assertEquals("Hulk", result.getName());
	assertEquals("a green-skinned hero", result.getDescription());

    }

    @Test
    public void notFoundCharacterTest() {

	when(characterRepository.findById(1)).thenThrow(new NotFoundException("Not found exception"));

	assertThrows(NotFoundException.class, () -> {
	    characterService.getById(1);
	});

    }
}
