package com.example.catalogodefilmes.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.CategFilmesHolder;
import com.example.catalogodefilmes.controller.webservice.UrlUtils;
import com.example.catalogodefilmes.model.Movie;
import com.example.catalogodefilmes.model.ResponseMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategFilmesAdapter extends RecyclerView.Adapter<CategFilmesHolder> {

    //private final List<ResponseMovie> mResponseMovies;
    private String[] categorias;
    //private String[] categorias = {"Lançamento", "Ação", "Aventura", "Terror"};
    private Context context;
    private FilmesAdapter filmesAdapter;
    Movie mo;

    public CategFilmesAdapter(String[] responseMovies) {
        this.categorias = responseMovies;
    }

    @NonNull
    @Override
    public CategFilmesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new CategFilmesHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_list_categor_filme, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CategFilmesHolder categFilmesHolder, int i) {
        //filmesAdapter = new FilmesAdapter(movies());
        categFilmesHolder.txtTitulo.setText(categorias[i]);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        categFilmesHolder.listMovie.setAdapter(filmesAdapter);
        categFilmesHolder.listMovie.setLayoutManager(linearLayoutManager);
        categFilmesHolder.listMovie.setItemAnimator(new DefaultItemAnimator());
        categFilmesHolder.listMovie.setHasFixedSize(true);

    }

    @Override
    public int getItemCount() {
        return categorias.length;
    }


}
