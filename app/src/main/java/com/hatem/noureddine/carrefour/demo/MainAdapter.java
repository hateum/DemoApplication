package com.hatem.noureddine.carrefour.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ygl_consulting.myfluxrss.databinding.ItemNewsLayoutBinding;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.viewmodels.ItemNewsViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    private List<String> itemsList;

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

    public void setItemsList(List<String> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffNewsCallback(itemsList, newList));
        diffResult.dispatchUpdatesTo(this);
        this.itemsList = newList;
    }

    static class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        public MainAdapterViewHolder(View viewItem) {
            super(viewItem);
        }

        void bindNews(News news) {
            if (mItemNewsBinding.getNewsItemViewModel() == null) {
                ItemNewsViewModel itemNewsViewModel = new ItemNewsViewModel(news, itemView.getContext());
                mItemNewsBinding.setNewsItemViewModel(itemNewsViewModel);
            } else {
                mItemNewsBinding.getNewsItemViewModel().setNews(news);
            }
        }
    }
}