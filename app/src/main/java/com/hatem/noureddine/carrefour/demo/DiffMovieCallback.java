package com.hatem.noureddine.carrefour.demo;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class DiffMovieCallback extends DiffUtil.Callback {

    List<Movie> oldMovie;
    List<Movie> newMovie;

    public DiffMovieCallback(List<Movie> newMovie, List<Movie> oldMovie) {
        this.newMovie = newMovie;
        this.oldMovie = oldMovie;
    }

    @Override
    public int getOldListSize() {
        return oldMovie.size();
    }

    @Override
    public int getNewListSize() {
        return newMovie.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldMovie.get(oldItemPosition).id.equals(newMovie.get(newItemPosition).id);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldMovie.get(oldItemPosition).equals(newMovie.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
