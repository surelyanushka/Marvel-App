package com.example.marvel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharData {
    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("limit")
    @Expose
    private int limit;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("results")
    @Expose
    private Result[] results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public Result[] getResults() {
        return results;
    }
}
