package com.example.catalogodefilmes.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.CategFilmesHolder;
import com.example.catalogodefilmes.controller.FilmesHolder;
import com.example.catalogodefilmes.controller.adapters.CategFilmesAdapter;
import com.example.catalogodefilmes.controller.adapters.FilmesAdapter;
import com.example.catalogodefilmes.controller.webservice.IResponse;
import com.example.catalogodefilmes.controller.webservice.ResponseAsk;
import com.example.catalogodefilmes.controller.webservice.UrlUtils;
import com.example.catalogodefilmes.model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements IResponse {

    private RecyclerView listNowPlay;
    private CategFilmesAdapter categFilmesAdapter;
    private String[] categorias = {"Lançamento", "Ação", "Aventura", "Terror"};
    private List<Movie> moviess;
    private FilmesAdapter filmesAdapter;
    private FilmesHolder filmesHolder;
    IResponse iResponse;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_home, container, false);
        listNowPlay = v.findViewById(R.id.listNowPlay);

//        ResponseAsk responseAsk = new ResponseAsk();
//        responseAsk.iResponse = (IResponse) this;
//        responseAsk.execute();

        return v;
    }

//    private void carregaLista() {
//
//        Call<List<Movie>> call = UrlUtils.getService().listNowPlaying();
//
//        movies = new ArrayList<>();
////        movies = call.execute().body();
//
//        call.enqueue(new Callback<List<Movie>>() {
//            @Override
//            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//                movies = response.body();
//
//                filmesAdapter = new FilmesAdapter(movies);
//
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//                listNowPlay.setLayoutManager(linearLayoutManager);
//
//                //categFilmesAdapter = new CategFilmesAdapter(categorias);
//                listNowPlay.setAdapter(filmesAdapter);
//
//                listNowPlay.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//            }
//
//            @Override
//            public void onFailure(Call<List<Movie>> call, Throwable t) {
//
//            }
//        });
//
//
//    }

    public static HomeFragment newStance() {
        return new HomeFragment();
    }

    @Override
    public void responseRetorfit(List<Movie> movies) {
        moviess = movies;
    }
}
