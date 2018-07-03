package com.filmoteka.v2.backend.model;

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

    public Item (Long filmwebId, String originalTitle, String polishTitle, String image_0, String image_1, String image_2, String image_3,
                 String image_4, String image_5, String image_6, Integer year, String cast, String duration, String countries,
                 String genre, String description, String plot, Integer numberOfEpisodes, Integer numberOfSeasons, String type) {
        this.filmwebId = filmwebId;
        this.originalTitle = originalTitle;
        this.polishTitle = polishTitle;
        this.image_0 = image_0;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.image_4 = image_4;
        this.image_5 = image_5;
        this.image_6 = image_6;
        this.year = year;
        this.cast = cast;
        this.duration = duration;
        this.countries = countries;
        this.genre = genre;
        this.description = description;
        this.plot = plot;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.type = type;
    }

    public Long getFilmwebId() {
        return filmwebId;
    }

    public void setFilmwebId(Long filmwebId) {
        this.filmwebId = filmwebId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPolishTitle() {
        return polishTitle;
    }

    public void setPolishTitle(String polishTitle) {
        this.polishTitle = polishTitle;
    }

    public String getImage_0() {
        return image_0;
    }

    public void setImage_0(String image_0) {
        this.image_0 = image_0;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }

    public String getImage_4() {
        return image_4;
    }

    public void setImage_4(String image_4) {
        this.image_4 = image_4;
    }

    public String getImage_5() {
        return image_5;
    }

    public void setImage_5(String image_5) {
        this.image_5 = image_5;
    }

    public String getImage_6() {
        return image_6;
    }

    public void setImage_6(String image_6) {
        this.image_6 = image_6;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
