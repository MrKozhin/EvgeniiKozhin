package com.epam.tc.hw9.beans;

import com.google.gson.annotations.Expose;

public class BoardList {

    @Expose
    public String id;
    @Expose
    public String name;
    @Expose
    public boolean closed;
    @Expose
    public int pos;
    @Expose
    public Object softLimit;
    @Expose
    public String idBoard;
    @Expose
    public boolean subscribed;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdBoard() {
        return idBoard;
    }
}
