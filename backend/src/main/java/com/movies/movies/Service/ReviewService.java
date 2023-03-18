package com.movies.movies.Service;

import com.movies.movies.Entities.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
    List<Review> getAllReviews();
    void deleteReview(String imdbId);
}
