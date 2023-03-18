package com.movies.movies.Repository;

import com.movies.movies.Entities.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepo extends MongoRepository<Review, ObjectId> {
    Optional<Review> findById(String imdbId);
    void deleteById(String imdbId);
}
