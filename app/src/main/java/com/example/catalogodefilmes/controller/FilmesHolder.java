package com.example.catalogodefilmes.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.catalogodefilmes.R;

public class FilmesHolder extends RecyclerView.ViewHolder {
    public ImageView imgFilme;
    public TextView precoFilm;

    public FilmesHolder(@NonNull View itemView) {
        super(itemView);
        imgFilme = itemView.findViewById(R.id.imgFilme);
    }
}
