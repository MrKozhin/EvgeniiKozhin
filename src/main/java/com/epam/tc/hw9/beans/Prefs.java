package com.epam.tc.hw9.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prefs {
    @SerializedName("background")
    @Expose
    public String background;

    public String getBackground() {
        return background;
    }
}
