package com.epam.tc.hw9.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Board {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
