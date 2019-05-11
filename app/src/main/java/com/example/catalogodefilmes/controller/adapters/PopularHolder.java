package com.example.catalogodefilmes.controller.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catalogodefilmes.R;

public class PopularHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgFilme;
    public TextView txtPreco;
    public CardView cardViewFilmes;
    public PopularAdapter.OnClickPopularListener onClickPopularListener;

    public PopularHolder(@NonNull View itemView, PopularAdapter.OnClickPopularListener onClickPopularListener) {
        super(itemView);
        imgFilme = itemView.findViewById(R.id.imgFilmes);
        txtPreco = itemView.findViewById(R.id.txtPreco);
        cardViewFilmes = itemView.findViewById(R.id.cardViewFilmes);
        this.onClickPopularListener = onClickPopularListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onClickPopularListener.onClickPopularListener(getAdapterPosition());
    }
}
