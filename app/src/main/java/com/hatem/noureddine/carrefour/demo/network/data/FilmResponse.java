package com.hatem.noureddine.carrefour.demo.network.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilmResponse {

    @SerializedName("movies")
    ArrayList<Movie> movies = null;
    long lastTimeStamp;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public long getLastTimeStamp() {
        return lastTimeStamp;
    }

    public void setLastTimeStamp(long lastTimeStamp) {
        this.lastTimeStamp = lastTimeStamp;
    }
}
