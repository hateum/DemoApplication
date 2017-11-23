package com.hatem.noureddine.carrefour.demo;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public interface MainPresenter {

    void onCreate();

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
