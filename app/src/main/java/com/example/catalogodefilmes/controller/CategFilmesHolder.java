package com.example.catalogodefilmes.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.catalogodefilmes.R;

public class CategFilmesHolder extends RecyclerView.ViewHolder {

    public TextView txtTitulo, txtSubtitulo;

    public CategFilmesHolder(@NonNull View itemView) {
        super(itemView);
        txtTitulo = itemView.findViewById(R.id.txtTitulo);
        txtSubtitulo = itemView.findViewById(R.id.txtSubtitulo);
    }
}
