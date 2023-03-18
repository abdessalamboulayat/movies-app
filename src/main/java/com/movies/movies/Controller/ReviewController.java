package com.movies.movies.Controller;

import com.movies.movies.Entities.Review;
import com.movies.movies.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/createReview")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<List<Review>>(reviewService.getAllReviews(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteReview/{imdbId}")
    public void deleteReview(@PathVariable("imdbId") String imdbId){
        reviewService.deleteReview(imdbId);
    }
}
