package dev.movie.movies.services;

import dev.movie.movies.models.Movie;
import dev.movie.movies.models.Actor;
import dev.movie.movies.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ActorService {


    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Actor createActors(String actorsBody, String imdbId) {
        Actor actor = actorRepository.insert(new Actor(actorsBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("actors").value(actor))
                .first();

        return actor;
    }
}
