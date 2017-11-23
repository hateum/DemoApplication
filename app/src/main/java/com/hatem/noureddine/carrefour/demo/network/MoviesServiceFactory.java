package com.hatem.noureddine.carrefour.demo.network;

import com.hatem.noureddine.carrefour.demo.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class MoviesServiceFactory {

    static MoviesService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.MOVIE_BASES_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MoviesService.class);
    }
}
