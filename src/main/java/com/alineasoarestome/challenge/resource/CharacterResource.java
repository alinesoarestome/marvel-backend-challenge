package com.alineasoarestome.challenge.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alineasoarestome.challenge.domain.Character;
import com.alineasoarestome.challenge.domain.Comic;
import com.alineasoarestome.challenge.domain.Event;
import com.alineasoarestome.challenge.domain.Serie;
import com.alineasoarestome.challenge.domain.Story;
import com.alineasoarestome.challenge.service.CharacterService;
import com.alineasoarestome.challenge.service.ComicService;
import com.alineasoarestome.challenge.service.EventService;
import com.alineasoarestome.challenge.service.SerieService;
import com.alineasoarestome.challenge.service.StoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/public/characters")
@Tag(name = "character", description = "the Character API")
public class CharacterResource {

    private CharacterService characterService;
    private ComicService comicService;
    private EventService eventService;
    private SerieService serieService;
    private StoryService storyService;

    public CharacterResource() {
	super();
    }

    @Autowired
    public CharacterResource(CharacterService characterService, ComicService comicService, EventService eventService,
	    SerieService serieService, StoryService storyService) {
	this.characterService = characterService;
	this.comicService = comicService;
	this.eventService = eventService;
	this.serieService = serieService;
	this.storyService = storyService;
    }

    @Operation(summary = "Fetches lists of character", tags = { "character" })
    @GetMapping(produces = { "application/json" })
    public List<Character> listAll() {
	log.info("listAll(): fetching characters.");

	List<Character> characters = characterService.listAll();

	log.info("listAll(): " + characters.size() + " characters returned.");

	return characters;
    }

    @Operation(summary = "Fetches a single character by id", tags = { "character" })
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public Character getById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getById(): fetching character [id = " + id + "].");

	Character character = characterService.getById(id);

	log.info("getById(): character returned.");

	return character;
    }

    @Operation(summary = "Fetches lists of comics filtered by a character id.", tags = { "character" })
    @GetMapping(value = "/{id}/comics", produces = { "application/json" })
    public List<Comic> getComicsById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getComicsById(): fetching comics by character [id = " + id + "].");

	List<Comic> comics = comicService.listAllByCharacterId(id);

	log.info("getComicsById(): " + comics.size() + " comics returned.");

	return comics;
    }

    @Operation(summary = "Fetches lists of events filtered by a character id.", tags = { "character" })
    @GetMapping(value = "/{id}/events", produces = { "application/json" })
    public List<Event> getEventById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getEventById(): fetching events by character [id = " + id + "].");

	List<Event> events = eventService.listAllByCharacterId(id);

	log.info("getEventById(): " + events.size() + " events returned.");

	return events;
    }

    @Operation(summary = "Fetches lists of series filtered by a character id.", tags = { "character" })
    @GetMapping(value = "/{id}/series", produces = { "application/json" })
    public List<Serie> getSeriesById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getSeriesById(): fetching series by character [id = " + id + "].");

	List<Serie> series = serieService.listAllByCharacterId(id);

	log.info("getSeriesById(): " + series.size() + " events returned.");

	return series;
    }

    @Operation(summary = "Fetches lists of stories filtered by a character id.", tags = { "Character Resource" })
    @GetMapping(value = "/{id}/stories", produces = { "application/json" })
    public List<Story> getStoriesById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getStoriesById(): fetching stories by character [id = " + id + "].");

	List<Story> stories = storyService.listAllByCharacterId(id);

	log.info("getStoriesById(): " + stories.size() + " events returned.");

	return stories;
    }
}
