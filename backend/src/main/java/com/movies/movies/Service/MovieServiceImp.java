package com.movies.movies.Service;

import com.movies.movies.Entities.Movie;
import com.movies.movies.Repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService{
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(String id) {
        return movieRepo.findByImdbId(id);
    }
}
