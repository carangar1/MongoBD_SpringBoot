package dev.movie.movies.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "actors")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Actor {

    @Id
    private ObjectId id;
    private String actor;

    public Actor(String actor) {
        this.actor = actor;
    }
}

