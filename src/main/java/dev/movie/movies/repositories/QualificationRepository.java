package dev.movie.movies.repositories;

import dev.movie.movies.models.Qualification;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends MongoRepository<Qualification, ObjectId> {
}
