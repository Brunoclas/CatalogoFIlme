package com.example.catalogodefilmes.controller.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.catalogodefilmes.controller.FilmesHolder;
import com.example.catalogodefilmes.controller.Utils.Config;
import com.example.catalogodefilmes.model.Movie;
import com.squareup.picasso.Picasso;
import com.example.catalogodefilmes.R;

import java.util.ArrayList;
import java.util.List;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesHolder>  {

    private List<Movie> movie;
    public FilmesAdapter(List<Movie> movie) {
        this.movie = movie;
    }

    @NonNull
    @Override
    public FilmesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FilmesHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_list_filmes, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmesHolder filmesHolder, int i) {

        Picasso.get()
                .load(Config.URL_IMG + movie.get(i).getPoster_path())
                .resize(50, 50)
                //.error(R.drawable.user_placeholder_error)
                .into(filmesHolder.imgFilme);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
}
