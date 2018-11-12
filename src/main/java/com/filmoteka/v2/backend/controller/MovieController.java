package com.filmoteka.v2.backend.controller;

import com.filmoteka.v2.backend.model.Item;
import com.filmoteka.v2.backend.service.ItemService;
import com.filmoteka.v2.backend.service.MovieDbService;
import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
//  @CrossOrigin(origins = "http://localhost:4200")
@Api(value = "/api", description = "movie operations")
public class MovieController {

    private final
    ItemService itemService;

    private final
    MovieDbService movieDbService;

    @Autowired
    public MovieController(ItemService itemService, MovieDbService movieDbService) {
        this.itemService = itemService;
        this.movieDbService = movieDbService;
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @RequestMapping(value = "getAllIutems/{value}", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems(@PathVariable("value") String value) {
        List<Item> elements = itemService.getAllItems(value);
        return new ResponseEntity<>(elements, new HttpHeaders(), HttpStatus.OK);

    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @RequestMapping(value = "films/{title}", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDb>> getMovieDbFilms(@PathVariable("title") String title) {
        List<MovieDb> films = movieDbService.getMovies(title, "pl");
        return new ResponseEntity<>(films, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "films/film/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<MovieDb> getMovieById(@PathVariable("movieId") int movieId) {
        MovieDb movie = movieDbService.getMovieById(movieId);
        return new ResponseEntity<>(movie, new HttpHeaders(), HttpStatus.OK);

    }

}
