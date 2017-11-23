package com.hatem.noureddine.carrefour.demo;

import android.content.SharedPreferences;

import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

    private MainView mainView;
    private SharedPreferences sharedPreferences;
    private FindItemsInteractor findItemsInteractor;

    public MainPresenterImpl(MainView mainView, FindItemsInteractor findItemsInteractor, SharedPreferences sharedPreferences) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void onCreate() {
        if (mainView != null) {
            mainView.showProgress();
        }

        findItemsInteractor.findItems(sharedPreferences, this);
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }

        findItemsInteractor.findItems(sharedPreferences, this);
    }

    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<Movie> items) {
        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}