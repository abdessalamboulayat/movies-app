package com.movies.movies.Service;

import com.movies.movies.Entities.Movie;
import com.movies.movies.Entities.Review;
import com.movies.movies.Repository.MovieRepo;
import com.movies.movies.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService{

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Review createReview(String reviewBody, String imdbId) {
        //Insérer nouveau Review
        Review review = reviewRepo.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public void deleteReview(String imdbId) {

    }
}
