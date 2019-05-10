package com.example.catalogodefilmes.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.adapters.FilmesAdapter;

public class FilmesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgFilme;
    public TextView txtPreco;
    public CardView cardViewFilmes;
    FilmesAdapter.OnCLickFilmeListener onCLickFilmeListener;

    public FilmesHolder(@NonNull View itemView, FilmesAdapter.OnCLickFilmeListener onCLickFilmeListener) {
        super(itemView);
        imgFilme = itemView.findViewById(R.id.imgFilmes);
        txtPreco = itemView.findViewById(R.id.txtPreco);
        cardViewFilmes = itemView.findViewById(R.id.cardViewFilmes);
        this.onCLickFilmeListener = onCLickFilmeListener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onCLickFilmeListener.onClickFilmeListener(getAdapterPosition());
    }
}

