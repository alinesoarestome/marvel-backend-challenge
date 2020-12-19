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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/public/characters")
@Tag(name = "character", description = "the Character API")
public class CharacterResource {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ComicService comicService;

    @Autowired
    private EventService eventService;

    @Autowired
    private SerieService serieService;

    @Autowired
    private StoryService storyService;

    @Operation(summary = "Fetches lists of character", tags = { "character" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(produces = { "application/json" })
    public ResponseEntity<List<Character>> listAll() {
	log.info("listAll(): fetching characters.");

	List<Character> characters = characterService.listAll();

	log.info("listAll(): " + characters.size() + " characters returned.");

	return ResponseEntity.ok(characters);
    }

    @Operation(summary = "Fetches a single character by id", tags = { "character" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
	    @ApiResponse(responseCode = "404", description = "Character not found", content = @Content(schema = @Schema(hidden = true))) })
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Character> getById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getById(): fetching character [id = " + id + "].");

	Character character = characterService.getById(id);

	log.info("getById(): character returned.");

	return ResponseEntity.ok(character);
    }

    @Operation(summary = "Fetches lists of comics filtered by a character id.", tags = { "character" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(value = "/{id}/comics", produces = { "application/json" })
    public ResponseEntity<List<Comic>> getComicsById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getComicsById(): fetching comics by character [id = " + id + "].");

	List<Comic> comics = comicService.listAllByCharacterId(id);

	log.info("getComicsById(): " + comics.size() + " comics returned.");

	return ResponseEntity.ok(comics);
    }

    @Operation(summary = "Fetches lists of events filtered by a character id.", tags = { "character" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(value = "/{id}/events", produces = { "application/json" })
    public ResponseEntity<List<Event>> getEventById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getEventById(): fetching events by character [id = " + id + "].");

	List<Event> events = eventService.listAllByCharacterId(id);

	log.info("getEventById(): " + events.size() + " events returned.");

	return ResponseEntity.ok(events);
    }

    @Operation(summary = "Fetches lists of series filtered by a character id.", tags = { "character" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(value = "/{id}/series", produces = { "application/json" })
    public ResponseEntity<List<Serie>> getSeriesById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getSeriesById(): fetching series by character [id = " + id + "].");

	List<Serie> series = serieService.listAllByCharacterId(id);

	log.info("getSeriesById(): " + series.size() + " events returned.");

	return ResponseEntity.ok(series);
    }

    @Operation(summary = "Fetches lists of stories filtered by a character id.", tags = { "Character Resource" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(value = "/{id}/stories", produces = { "application/json" })
    public ResponseEntity<List<Story>> getStoriesById(
	    @Parameter(description = "A single character id.", required = true) @PathVariable("id") Integer id) {
	log.info("getStoriesById(): fetching stories by character [id = " + id + "].");

	List<Story> stories = storyService.listAllByCharacterId(id);

	log.info("getStoriesById(): " + stories.size() + " events returned.");

	return ResponseEntity.ok(stories);
    }
}
