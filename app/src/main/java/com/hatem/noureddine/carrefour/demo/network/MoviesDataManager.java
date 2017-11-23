package com.hatem.noureddine.carrefour.demo.network;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hatem.noureddine.carrefour.demo.BuildConfig;
import com.hatem.noureddine.carrefour.demo.network.data.FilmResponse;
import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */
public class MoviesDataManager {

    static final String CACHE_MOVIES_DATA = "CACHE_MOVIES_DATA";
    private Gson gson;

    private MoviesDataManager() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @NonNull
    public static MoviesDataManager create() {
        return new MoviesDataManager();
    }

    public void getMoviesListAsync(@NonNull SharedPreferences sharedPreferences, @NonNull final Callback callback) {
        String lastSynchro = sharedPreferences.getString(CACHE_MOVIES_DATA, null);

        if (!TextUtils.isEmpty(lastSynchro)) {
            FilmResponse filmResponse = gson.fromJson(lastSynchro, FilmResponse.class);

            // if time last synchro greater than 40 mn from last synchro do refresh
            if (filmResponse != null) {
                // calculate time for next synchro
                long nextSynchroTime = filmResponse.getLastTimeStamp() + 40 * 60 * 1000;
                if (nextSynchroTime < Calendar.getInstance().getTimeInMillis()) {
                    // no synchro => get from cache
                    Log.e("TAG", "FROM CACHE");
                    callback.onSucces(filmResponse.getMovies());
                } else {
                    // make synchro and put to cache
                    getMovieFromNetwork(sharedPreferences, callback);
                }
            } else {
                getMovieFromNetwork(sharedPreferences, callback);
            }
        } else {
            getMovieFromNetwork(sharedPreferences, callback);
        }

    }

    private void getMovieFromNetwork(@NonNull final SharedPreferences sharedPreferences, @NonNull final Callback callback) {
        MoviesServiceFactory.create()
                .fetchMovies(BuildConfig.MOVIE_URL)
                .enqueue(new retrofit2.Callback<FilmResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<FilmResponse> call, @NonNull Response<FilmResponse> response) {
                        FilmResponse filmResponse = response.body();
                        if (response.isSuccessful() && filmResponse != null) {
                            String json = gson.toJson(filmResponse);
                            sharedPreferences.edit().putString(CACHE_MOVIES_DATA, json).apply();
                            callback.onSucces(filmResponse.getMovies());
                            Log.e("TAG", "FROM NETWORK");
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
