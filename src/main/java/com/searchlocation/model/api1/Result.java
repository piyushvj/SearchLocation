package com.searchlocation.model.api1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty
    private float id;
    @JsonProperty
    private String country;
    @JsonProperty
    private String name;
    @JsonProperty
    private String abbr;
    @JsonProperty
    private String area;
    @JsonProperty
    private String largest_city;
    @JsonProperty
    private String capital;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getArea() {
        return area;
    }

    public String getLargest_city() {
        return largest_city;
    }

    public String getCapital() {
        return capital;
    }

    // Setter Methods

    public void setId( float id ) {
        this.id = id;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setAbbr( String abbr ) {
        this.abbr = abbr;
    }

    public void setArea( String area ) {
        this.area = area;
    }

    public void setLargest_city( String largest_city ) {
        this.largest_city = largest_city;
    }

    public void setCapital( String capital ) {
        this.capital = capital;
    }
}