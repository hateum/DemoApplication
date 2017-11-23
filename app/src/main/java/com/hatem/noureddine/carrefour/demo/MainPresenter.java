package com.hatem.noureddine.carrefour.demo;

import android.support.annotation.Nullable;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public interface MainPresenter {

    void onItemClicked(int position);

    void onDestroy();

    void refreshData();

    void loadData(@Nullable String query);
}
