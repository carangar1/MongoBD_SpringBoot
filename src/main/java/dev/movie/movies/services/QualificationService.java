package dev.movie.movies.services;

import dev.movie.movies.models.Movie;
import dev.movie.movies.models.Qualification;
import dev.movie.movies.repositories.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Qualification createQualification(String qualificationBody, String imdbId) {
        Qualification qualification = qualificationRepository.insert(new Qualification(qualificationBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("qualifications").value(qualification))
                .first();

        return qualification;
    }
}
