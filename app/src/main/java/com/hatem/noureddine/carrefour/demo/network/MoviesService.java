package com.hatem.noureddine.carrefour.demo.network;

import com.hatem.noureddine.carrefour.demo.network.data.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public interface MoviesService {

    @GET
    Call<FilmResponse> fetchMovies(@Url String url);
}
