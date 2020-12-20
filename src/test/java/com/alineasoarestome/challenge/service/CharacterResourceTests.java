package com.alineasoarestome.challenge.service;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.alineasoarestome.challenge.domain.Character;
import com.alineasoarestome.challenge.domain.Comic;
import com.alineasoarestome.challenge.domain.Event;
import com.alineasoarestome.challenge.domain.Serie;
import com.alineasoarestome.challenge.domain.Story;
import com.alineasoarestome.challenge.domain.enums.Format;
import com.alineasoarestome.challenge.domain.enums.Type;
import com.alineasoarestome.challenge.exception.NotFoundException;
import com.alineasoarestome.challenge.repository.CharacterRepository;
import com.alineasoarestome.challenge.repository.ComicRepository;
import com.alineasoarestome.challenge.repository.EventRepository;
import com.alineasoarestome.challenge.repository.SerieRepository;
import com.alineasoarestome.challenge.repository.StoryRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CharacterResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterRepository characterRepository;
    
    @MockBean
    private ComicRepository comicRepository;
    
    @MockBean
    private EventRepository eventRepository;
    
    @MockBean
    private SerieRepository serieRepository;
    
    @MockBean
    private StoryRepository storyRepository;
                
                
    @Test
    public void shouldReturnAllCharacters() throws Exception {
	List<Character> characters = new ArrayList<Character>();
	characters.add(new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null));
	characters.add(new Character(2, "Deadpool", "a highly trained assassin and mercenary", new Date(), null, null, null, null));

	when(characterRepository.findAll()).thenReturn(characters);

	mockMvc.perform(get("/v1/public/characters"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.[*].name").value(hasItems("Hulk", "Deadpool")));

    }
    
    @Test
    public void shouldReturnOneCharacter() throws Exception {
	Character character = new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null);

	when(characterRepository.findById(1)).thenReturn(Optional.of(character));

	mockMvc.perform(get("/v1/public/characters/{id}", 1))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.name", is("Hulk")));
    }
    
    @Test
    public void shouldReturnNotFoundException() throws Exception {
	Character character = new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null);

	when(characterRepository.findById(1)).thenReturn(Optional.of(character));

	mockMvc.perform(get("/v1/public/characters/{id}", 1))
		.andDo(print())
		.andExpect(status().isNotFound())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException));
    }
    
    
    @Test
    public void shouldReturnCharacterComics() throws Exception {
	Character character = new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null);
	
	List<Comic> comics = new ArrayList<Comic>();
	comics.add(new Comic(1, 23, "Immortal Hulk (2018)", "123456", "Immortal Hulk Description", Format.COMIC, new Date(), character));
	comics.add(new Comic(2, 23, "King In Black: Immortal Hulk", "123456", "King In Black Description", Format.DIGITAL_COMIC, new Date(), character));

	when(comicRepository.findAllByCharacterId(1)).thenReturn(comics);

	mockMvc.perform(get("/v1/public/characters/{id}/comics", 1))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)));
    }

    
    @Test
    public void shouldReturnCharacterEvents() throws Exception {
	Character character = new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null);
	
	List<Event> events = new ArrayList<Event>();
	events.add(new Event(1, "Event title 1", "", new Date(), new Date(), new Date(), character));
	events.add(new Event(2, "Event title 2", "", new Date(), new Date(), new Date(), character));

	when(eventRepository.findAllByCharacterId(1)).thenReturn(events);

	mockMvc.perform(get("/v1/public/characters/{id}/events", 1))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)));
    }
    
    @Test
    public void shouldReturnCharacterSeries() throws Exception {
	Character character = new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null);
	
	List<Serie> series = new ArrayList<Serie>();
	series.add(new Serie(1, "Serie title 1", "", "", new Date(), 1988, 1998, character));
	series.add(new Serie(2, "Serie title 2", "", "", new Date(), 2000, 2020, character));

	when(serieRepository.findAllByCharacterId(1)).thenReturn(series);

	mockMvc.perform(get("/v1/public/characters/{id}/series", 1))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)));
    }
    
    @Test
    public void shouldReturnCharacterStories() throws Exception {
	Character character = new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null);
	
	List<Story> stories = new ArrayList<Story>();
	stories.add(new Story(1, "Story title 1", "", new Date(), Type.TEXT_STORY, character));
	stories.add(new Story(2, "Story title 2", "", new Date(), Type.TEXT_STORY, character));

	when(storyRepository.findAllByCharacterId(1)).thenReturn(stories);

	mockMvc.perform(get("/v1/public/characters/{id}/stories", 1))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)));
	
    }

    
    
}
