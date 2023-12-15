package dev.movie.movies.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "qualifications")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Qualification {

    @Id
    private ObjectId id;
    private String qualification;

    public Qualification(String qualification) {
        this.qualification = qualification;
    }
}
