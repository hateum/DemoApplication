package com.hatem.noureddine.carrefour.demo.network.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posters {

    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("profile")
    @Expose
    public String profile;
    @SerializedName("detailed")
    @Expose
    public String detailed;
    @SerializedName("original")
    @Expose
    public String original;

}
