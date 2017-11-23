package com.hatem.noureddine.carrefour.demo.network;

import android.support.annotation.NonNull;

import com.hatem.noureddine.carrefour.demo.BuildConfig;
import com.hatem.noureddine.carrefour.demo.network.data.FilmResponse;
import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */
public class MoviesDataManager {
    private MoviesDataManager() {

    }

    @NonNull
    public static MoviesDataManager create() {
        return new MoviesDataManager();
    }

    public void getMoviesListAsync(@NonNull final Callback callback) {
        MoviesServiceFactory.create()
                .fetchMovies(BuildConfig.MOVIE_URL)
                .enqueue(new retrofit2.Callback<FilmResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<FilmResponse> call, @NonNull Response<FilmResponse> response) {
                        FilmResponse newsResponse = response.body();
                        if (response.isSuccessful() && newsResponse != null) {
                            callback.onSucces(newsResponse.getMovies());
                        } else {
                            callback.onFail();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<FilmResponse> call, Throwable t) {
                        callback.onFail();
                    }
                });
    }

    public interface Callback {
        void onSucces(@NonNull ArrayList<Movie> news);

        void onFail();
    }
}
