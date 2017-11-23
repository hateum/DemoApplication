package com.hatem.noureddine.carrefour.demo.network.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilmResponse {

    @SerializedName("movies")
    public ArrayList<Movie> movies = null;

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
