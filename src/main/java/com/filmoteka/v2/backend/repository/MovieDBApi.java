package com.filmoteka.v2.backend.repository;


import info.movito.themoviedbapi.TmdbApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDBApi {

    private final
    TmdbApi movieApi;

    @Autowired
    MovieDBApi(TmdbApi movieApi) {
        this.movieApi = movieApi;
    }

    public TmdbApi getMovieApi() {
        return movieApi;
    }
}
