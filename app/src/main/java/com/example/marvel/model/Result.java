package com.example.marvel.model;

import android.media.Image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("thumbnail")
    @Expose
    private CharImage thumbnail;

    @SerializedName("comics")
    @Expose
    private ComicList comics;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CharImage getThumbnail() {
        return thumbnail;
    }

    public ComicList getComics() {
        return comics;
    }
}
