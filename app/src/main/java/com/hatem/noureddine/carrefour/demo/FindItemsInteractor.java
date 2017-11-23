package com.hatem.noureddine.carrefour.demo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public interface FindItemsInteractor {
    void findItems(@NonNull SharedPreferences sharedPreferences, OnFinishedListener listener);

    interface OnFinishedListener {
        void onFinished(List<Movie> items);
    }
}
