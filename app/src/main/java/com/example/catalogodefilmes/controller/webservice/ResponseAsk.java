package com.example.catalogodefilmes.controller.webservice;

import android.os.AsyncTask;

import com.example.catalogodefilmes.model.Movie;
import com.example.catalogodefilmes.model.ResponseMovie;
import com.example.catalogodefilmes.model.Results;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ResponseAsk extends AsyncTask<Void, Void, List<Movie>> {
    private Movie movie;
    public IResponse iResponse;
    private Results results;

    @Override
    protected List<Movie> doInBackground(Void... voids) {
        List<Movie> movies = new ArrayList<>();
        try {
            Call<Results> call = UrlUtils.getService().listNowPlaying();
            try {
                results = call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.getMessage();
        }
        return movies;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        super.onPostExecute(movies);
        iResponse.responseRetorfit(movies);
    }
}
