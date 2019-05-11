package com.example.catalogodefilmes.controller.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.LancamentoHolder;
import com.example.catalogodefilmes.controller.Utils.Config;
import com.example.catalogodefilmes.model.Result;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class LancamentosAdapter extends RecyclerView.Adapter<LancamentoHolder> {
    private Result result;
    OnClickLancamentoListener onClickLancamentoListener;

    public LancamentosAdapter(Result result, OnClickLancamentoListener onClickLancamentoListener) {
        this.result = result;
        this.onClickLancamentoListener = onClickLancamentoListener;
    }

    @NonNull
    @Override
    public LancamentoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_filmes, viewGroup, false);
        return new LancamentoHolder(v, onClickLancamentoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LancamentoHolder lancamentoHolder, int i) {
        Picasso.get()
                .load(Config.URL_IMG + result.getResults().get(i).getPoster_path())
                .resize(300, 500)
                .centerInside()
                //.error(R.drawable.user_placeholder_error)
                .into(lancamentoHolder.imgFilme);
        DecimalFormat df = new DecimalFormat("#,###.00");
        String preco = df.format(result.getResults().get(i).getVote_average());
        lancamentoHolder.txtPreco.setText("R$: " + (preco));
    }

    @Override
    public int getItemCount() {
        return result.getResults().size();
    }

    public interface OnClickLancamentoListener{
        void onClickLancamentoListener(int position);
    }
}
