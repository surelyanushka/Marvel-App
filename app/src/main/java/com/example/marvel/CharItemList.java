package com.example.marvel;

import java.util.ArrayList;
import java.util.List;

public class CharItemList {

//    public static List<CharItemList> list = new ArrayList<>();
    private String textViewDesc;
    private String textViewName;
    private String imgId;
    private String pgavail;


    public CharItemList( String textViewName, String imgId, String textViewDesc, String pgavail) {
        this.textViewDesc = textViewDesc;
        this.textViewName = textViewName;
        this.imgId = imgId;
        this.pgavail = pgavail;
    }

    public String getPgavail() {
        return pgavail;
    }

    public void setPgavail(String  pgavail) {
        this.pgavail = pgavail;
    }

    public String getTextViewDesc() {
        return textViewDesc;
    }

    public void setTextViewDesc(String textViewDesc) {
        this.textViewDesc = textViewDesc;
    }

    public String getTextViewName() {
        return textViewName;
    }

    public void setTextViewName(String textViewName) {
        this.textViewName = textViewName;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

}

