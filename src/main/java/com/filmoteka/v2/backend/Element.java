package com.filmoteka.v2.backend;

public class Element {
    private String type;
    private String id;
    private String photoUrl;
    private String originalTitle;
    private String polishTitle;
    private String otherTitle;
    private String year;
    private String cast;

    public Element(){}

    public Element(String type, String id, String photoUrl, String originalTitle, String polishTitle, String otherTitle, String year, String cast) {
        this.type = type;
        this.id = id;
        this.photoUrl = photoUrl;
        this.originalTitle = originalTitle;
        this.polishTitle = polishTitle;
        this.otherTitle = otherTitle;
        this.year = year;
        this.cast = cast;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    public String getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(String otherTitle) {
        this.otherTitle = otherTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}
