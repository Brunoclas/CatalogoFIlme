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

public class PopularAdapter extends RecyclerView.Adapter<PopularHolder> {
    private Result result;
    OnClickPopularListener onClickPopularListener;

    public PopularAdapter(Result result, OnClickPopularListener onClickPopularListener) {
        this.result = result;
        this.onClickPopularListener = onClickPopularListener;
    }

    @NonNull
    @Override
    public PopularHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_filmes, viewGroup, false);
        return new PopularHolder(v, onClickPopularListener);

    }

    @Override
    public void onBindViewHolder(@NonNull PopularHolder popularHolder, int i) {
        Picasso.get()
                .load(Config.URL_IMG + result.getResults().get(i).getPoster_path())
                .resize(300, 500)
                .centerInside()
                //.error(R.drawable.user_placeholder_error)
                .into(popularHolder.imgFilme);
        DecimalFormat df = new DecimalFormat("#,###.00");
        String preco = df.format(result.getResults().get(i).getVote_average());
        popularHolder.txtPreco.setText("R$: " + (preco));
    }

    @Override
    public int getItemCount() {
        return result.getResults().size();
    }
    public interface OnClickPopularListener{
        void onClickPopularListener(int position);
    }
}
