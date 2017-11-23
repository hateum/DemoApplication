package com.hatem.noureddine.carrefour.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.Collections;
import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    private List<Movie> itemsList;

    public MainAdapter() {
        this.itemsList = Collections.emptyList();
    }

    @Override
    public MainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_layout, parent, false);
        return new MainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapterViewHolder holder, int position) {
        holder.bindNews(itemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setItemsList(List<Movie> newList) {
//        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffMoviesCallback(itemsList, newList));
//        diffResult.dispatchUpdatesTo(this);
        this.itemsList = newList;
    }

    static class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        public MainAdapterViewHolder(View viewItem) {
            super(viewItem);
        }

        void bindNews(Movie movie) {

        }
    }
}