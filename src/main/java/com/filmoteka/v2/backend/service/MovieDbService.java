package com.filmoteka.v2.backend.service;

import com.filmoteka.v2.backend.repository.TmdbRespository;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDbService {

    @Autowired
    TmdbRespository tmdbRespository;

    public MovieDbService() {
    }

    public List<MovieDb> getMovies(String title, String lang) {
        return tmdbRespository.getMovies(title, lang);
    }

    public MovieDb getMovieById(int movieId){
        return tmdbRespository.getMovieById(movieId);
    }





}
