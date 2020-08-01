package com.example.marvel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicList {
    @SerializedName("available")
    @Expose
    private String  available;

    @SerializedName("returned")
    @Expose
    private int returned;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;

    public String  getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }
}
