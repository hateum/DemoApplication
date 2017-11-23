package com.hatem.noureddine.carrefour.demo.network.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ratings {

    @SerializedName("critics_rating")
    @Expose
    public String criticsRating;
    @SerializedName("critics_score")
    @Expose
    public int criticsScore;
    @SerializedName("audience_rating")
    @Expose
    public String audienceRating;
    @SerializedName("audience_score")
    @Expose
    public int audienceScore;

}
