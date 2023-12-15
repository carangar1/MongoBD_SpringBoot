package dev.movie.movies.controllers;

import dev.movie.movies.models.Qualification;
import dev.movie.movies.models.Review;
import dev.movie.movies.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/qualifications")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    @PostMapping
    public ResponseEntity<Qualification> createQualification(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Qualification>(qualificationService.createQualification(payload.get("qualificationBody"),
                payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
