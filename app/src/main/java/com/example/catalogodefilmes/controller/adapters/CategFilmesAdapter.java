package com.example.catalogodefilmes.controller.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.CategFilmesHolder;
import com.example.catalogodefilmes.model.ResponseMovie;

import java.util.ArrayList;
import java.util.List;

public class CategFilmesAdapter extends RecyclerView.Adapter<CategFilmesHolder> {

    //private final List<ResponseMovie> mResponseMovies;
    private String [] categorias;
    //private String[] categorias = {"Lançamento", "Ação", "Aventura", "Terror"};

    public CategFilmesAdapter(String[] responseMovies) {
        this.categorias = responseMovies;
    }

    @NonNull
    @Override
    public CategFilmesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CategFilmesHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_list_categor_filme, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CategFilmesHolder viewHolder, int i) {

    viewHolder.txtTitulo.setText(categorias[i]);

    }

    @Override
    public int getItemCount() {
        return categorias.length;
    }
}
