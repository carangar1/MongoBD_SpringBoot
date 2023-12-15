package dev.movie.movies.controllers;

import dev.movie.movies.models.Actor;
import dev.movie.movies.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<Actor> createActors(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Actor>(actorService.createActors(payload.get("actorBody"),
                payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
