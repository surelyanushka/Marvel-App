package com.example.marvel.model;

import com.google.gson.annotations.SerializedName;

public class CharImage {
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
}
