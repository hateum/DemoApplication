package com.hatem.noureddine.carrefour.demo.network.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    public String self;
    @SerializedName("alternate")
    @Expose
    public String alternate;
    @SerializedName("cast")
    @Expose
    public String cast;
    @SerializedName("clips")
    @Expose
    public String clips;
    @SerializedName("reviews")
    @Expose
    public String reviews;
    @SerializedName("similar")
    @Expose
    public String similar;

}
