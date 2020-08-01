package com.example.marvel.comicmodels;

import com.example.marvel.model.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicData {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("results")
    @Expose
    private ComicResult[] comicResults;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ComicResult[] getComicResults() {
        return comicResults;
    }

    public void setComicResults(ComicResult[] comicResults) {
        this.comicResults = comicResults;
    }
}
