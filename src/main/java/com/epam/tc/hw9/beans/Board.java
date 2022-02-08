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
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("prefs")
    @Expose
    private Prefs prefs;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Prefs getPrefs() {
        return prefs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Board board = (Board) o;

        if (id != null ? !id.equals(board.id) : board.id != null) {
            return false;
        }
        if (name != null ? !name.equals(board.name) : board.name != null) {
            return false;
        }
        if (desc != null ? !desc.equals(board.desc) : board.desc != null) {
            return false;
        }
        return prefs != null ? prefs.equals(board.prefs) : board.prefs == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (prefs != null ? prefs.hashCode() : 0);
        return result;
    }

}
