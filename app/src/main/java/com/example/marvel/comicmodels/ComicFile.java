package com.example.marvel.comicmodels;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicFile {
    @SerializedName("data")
    @Expose
    private ComicData data;

    public ComicData getData() {
        return data;
    }

    public void setData(ComicData data) {
        this.data = data;
    }
}
