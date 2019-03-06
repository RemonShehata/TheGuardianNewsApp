package com.example.android.theguardiannewsapp.model;

public class News {

    String mHeadline;

    String mAuthor;

    String mDate;

    String mSection;

    String mUrl;

    public News(String headline,  String date, String section, String url, String author) {
        this.mHeadline = headline;
        this.mDate = date;
        this.mSection = section;
        this.mUrl = url;
        this.mAuthor = author;
    }

    public String getmHeadline() {
        return mHeadline;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmAuthor() {
        return mAuthor;
    }
}
