package com.example.marvel.comicmodels;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicResult {

    @SerializedName("title")
    @Expose
    private String comictitle;

    @SerializedName("description")
    @Expose
    private String comicdescription;

    @SerializedName("pageCount")
    @Expose
    private String pgcount;

    @SerializedName("thumbnail")
    @Expose
    private ComicImage comicthumbnail;

    public String getComictitle() {
        return comictitle;
    }

    public void setComictitle(String comictitle) {
        this.comictitle = comictitle;
    }

    public String getComicdescription() {
        return comicdescription;
    }

    public void setComicdescription(String comicdescription) {
        this.comicdescription = comicdescription;
    }

    public String getPgcount() {
        return pgcount;
    }

    public void setPgcount(String pgcount) {
        this.pgcount = pgcount;
    }

    public ComicImage getComicthumbnail() {
        return comicthumbnail;
    }

    public void setComicthumbnail(ComicImage comicthumbnail) {
        this.comicthumbnail = comicthumbnail;
    }

}
