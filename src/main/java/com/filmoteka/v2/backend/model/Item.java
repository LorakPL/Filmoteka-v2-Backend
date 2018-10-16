package com.filmoteka.v2.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Item {

    private Long filmwebId;
    private String originalTitle;
    private String polishTitle;
    private String image_0;
    private String image_1;
    private String image_2;
    private String image_3;
    private String image_4;
    private String image_5;
    private String image_6;
    private Integer year;
    private String cast;
    private String duration;
    private String countries;
    private String genre;
    private String description;
    private String plot;
    private Integer numberOfEpisodes;
    private Integer numberOfSeasons;
    private String type;


}
