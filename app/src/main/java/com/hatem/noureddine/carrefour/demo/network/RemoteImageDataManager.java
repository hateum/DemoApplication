package com.hatem.noureddine.carrefour.demo.network;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */
public class RemoteImageDataManager {

    private RemoteImageDataManager() {
    }

    @NonNull
    public static RemoteImageDataManager create() {
        return new RemoteImageDataManager();
    }

    public void getImageFromNetworkAsync(@NonNull ImageView imageView, @NonNull String imageURL) {
        Glide.with(imageView).load(imageURL).into(imageView);
    }
}
