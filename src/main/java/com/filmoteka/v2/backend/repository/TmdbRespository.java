package com.filmoteka.v2.backend.repository;

import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * repository for methods from MovieDB API
 * we are using https://github.com/holgerbrandl/themoviedbapi
 */
@Repository
public class TmdbRespository {

    //TODO delete

    @Autowired
    MovieDBApi movieDBApi;

    public TmdbRespository() {
    }

    public List<MovieDb> getMovies(String title, String language) {
        List<MovieDb> movies = new ArrayList<>();
        int totalPages = movieDBApi.getMovieApi().getSearch().searchMovie(title, null, language, true, 0).getTotalPages();
        IntStream.range(0, totalPages).forEachOrdered(i -> movies.addAll(getMoviesByPage(title, language, i)));
        return movies;
    }

    private List<MovieDb> getMoviesByPage(String title, String language, int page) {
        return movieDBApi.getMovieApi().getSearch().searchMovie(title, null, language, true, page).getResults();
    }

    public MovieDb getMovieById(int movieId) {
        return movieDBApi.getMovieApi().getMovies().getMovie(movieId, "pl");//, TmdbMovies.MovieMethod.values());
    }


}
