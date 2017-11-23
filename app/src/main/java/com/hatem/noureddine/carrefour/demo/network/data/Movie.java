package com.hatem.noureddine.carrefour.demo.network.data;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("year")
    @Expose
    public int year;
    @SerializedName("mpaa_rating")
    @Expose
    public String mpaaRating;
    @SerializedName("runtime")
    @Expose
    public int runtime;
    @SerializedName("critics_consensus")
    @Expose
    public String criticsConsensus;
    @SerializedName("release_dates")
    @Expose
    public ReleaseDates releaseDates;
    @SerializedName("ratings")
    @Expose
    public Ratings ratings;
    @SerializedName("synopsis")
    @Expose
    public String synopsis;
    @SerializedName("posters")
    @Expose
    public Posters posters;
    @SerializedName("abridged_cast")
    @Expose
    public List<AbridgedCast> abridgedCast = null;
    @SerializedName("alternate_ids")
    @Expose
    public AlternateIds alternateIds;
    @SerializedName("links")
    @Expose
    public Links links;

}
