package com.movies.movies.Service;

import com.movies.movies.Entities.Movie;
import org.bson.types.ObjectId;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(String id);
}
