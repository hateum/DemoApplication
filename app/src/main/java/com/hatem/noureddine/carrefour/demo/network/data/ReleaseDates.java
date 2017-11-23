package com.hatem.noureddine.carrefour.demo.network.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReleaseDates {

    @SerializedName("theater")
    @Expose
    public String theater;
    @SerializedName("dvd")
    @Expose
    public String dvd;

}
