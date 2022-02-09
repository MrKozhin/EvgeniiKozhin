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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Prefs prefs = (Prefs) o;

        return background.equals(prefs.background);
    }

    @Override
    public int hashCode() {
        return background.hashCode();
    }
}
