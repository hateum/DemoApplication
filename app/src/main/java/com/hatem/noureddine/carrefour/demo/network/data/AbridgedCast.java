package com.hatem.noureddine.carrefour.demo.network.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbridgedCast {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("characters")
    @Expose
    public List<String> characters = null;

}
