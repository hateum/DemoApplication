package com.hatem.noureddine.carrefour.demo;

import android.support.v4.content.ContextCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hatem.noureddine.carrefour.demo.network.RemoteImageDataManager;
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
        holder.bindNews(itemsList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setItemsList(List<Movie> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffMovieCallback(itemsList, newList));
        diffResult.dispatchUpdatesTo(this);
        this.itemsList = newList;
    }

    static class MainAdapterViewHolder extends RecyclerView.ViewHolder {
        private Movie movie;
        private int position;
        private ImageView imgFilm;
        private TextView titleFilm;
        private TextView dateFilm;

        public MainAdapterViewHolder(View viewItem) {
            super(viewItem);
            imgFilm = (ImageView) viewItem.findViewById(R.id.item_movie_picture);
            titleFilm = (TextView) viewItem.findViewById(R.id.item_movie_txt_name);
            dateFilm = (TextView) viewItem.findViewById(R.id.item_movie_txt_year);
        }

        void bindNews(Movie movie, int position) {
            this.movie = movie;
            this.position = position;

            int colorBackground = ContextCompat.getColor(itemView.getContext()
                    , position % 2 == 0 ? R.color.colorWhite : R.color.colorGreenItemBackground);
            itemView.setBackgroundColor(colorBackground);

            titleFilm.setText(movie.title);
            dateFilm.setText(String.valueOf(movie.year));
            RemoteImageDataManager.create().getImageFromNetworkAsync(imgFilm, movie.posters.thumbnail);

        }
    }
}