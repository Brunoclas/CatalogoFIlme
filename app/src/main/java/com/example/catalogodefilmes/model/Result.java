package com.example.catalogodefilmes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Result implements Parcelable {
    private List<Movie> results;
    private int page;
    private int total_results;
    //private String[] dates;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

//    public String[] getDates() {
//        return dates;
//    }
//
//    public void setDates(String[] dates) {
//        this.dates = dates;
//    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    private int total_pages;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
