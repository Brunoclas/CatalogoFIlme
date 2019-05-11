package com.example.catalogodefilmes.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.adapters.LancamentosAdapter;

public class LancamentoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgFilme;
    public TextView txtPreco;
    public CardView cardViewFilmes;
    public LancamentosAdapter.OnClickLancamentoListener onClickLancamentoListener;

    public LancamentoHolder(@NonNull View itemView, LancamentosAdapter.OnClickLancamentoListener onClickLancamentoListener) {
        super(itemView);
        imgFilme = itemView.findViewById(R.id.imgFilmes);
        txtPreco = itemView.findViewById(R.id.txtPreco);
        cardViewFilmes = itemView.findViewById(R.id.cardViewFilmes);
        this.onClickLancamentoListener = onClickLancamentoListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onClickLancamentoListener.onClickLancamentoListener(getAdapterPosition());
    }
}
