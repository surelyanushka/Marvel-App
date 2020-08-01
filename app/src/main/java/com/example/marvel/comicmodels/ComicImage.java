package com.example.marvel.comicmodels;

import com.google.gson.annotations.SerializedName;

public class ComicImage {
    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
