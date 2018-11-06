package com.filmoteka.v2.backend.configuration;

import com.filmoteka.v2.backend.SecretConst;
import info.movito.themoviedbapi.TmdbApi;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MovieDBConfiguration {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TmdbApi movieApi() {
        return new TmdbApi(SecretConst.MOVIE_DB_API_KEY);

    }
}
