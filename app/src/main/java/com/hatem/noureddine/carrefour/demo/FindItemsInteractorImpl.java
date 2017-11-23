package com.hatem.noureddine.carrefour.demo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hatem.noureddine.carrefour.demo.network.MoviesDataManager;
import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.ArrayList;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {

    @Override
    public void findItems(@NonNull SharedPreferences sharedPreferences, final OnFinishedListener listener) {
        MoviesDataManager.create().getMoviesListAsync(sharedPreferences, new MoviesDataManager.Callback() {
            @Override
            public void onSucces(@NonNull ArrayList<Movie> movies) {
                listener.onFinished(movies);
            }

            @Override
            public void onFail() {
                Log.e("TAG", "onFail");
            }
        });
    }
}