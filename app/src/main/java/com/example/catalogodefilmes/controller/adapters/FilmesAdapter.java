package com.example.catalogodefilmes.controller.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalogodefilmes.controller.FilmesHolder;
import com.example.catalogodefilmes.controller.Utils.Config;
import com.example.catalogodefilmes.model.Result;
import com.squareup.picasso.Picasso;
import com.example.catalogodefilmes.R;

import java.text.DecimalFormat;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesHolder> {

    private Result result;
    private Activity activity;
    OnCLickFilmeListener onCLickFilmeListener;

    public FilmesAdapter(Result result, OnCLickFilmeListener onCLickFilmeListener) {
        this.result = result;
        this.onCLickFilmeListener = onCLickFilmeListener;
    }

    @NonNull
    @Override
    public FilmesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_filmes, viewGroup, false);
        return new FilmesHolder(v, onCLickFilmeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final FilmesHolder filmesHolder, int i) {
        Picasso.get()
                .load(Config.URL_IMG + result.getResults().get(i).getPoster_path())
                .resize(300, 300)
                .centerInside()
                //.error(R.drawable.user_placeholder_error)
                .into(filmesHolder.imgFilme);
        DecimalFormat df = new DecimalFormat("#,###.00");
        String preco = df.format(result.getResults().get(i).getVote_average());
        filmesHolder.txtPreco.setText("R$: " + (preco));

    }

    @Override
    public int getItemCount() {
        return result.getResults().size();
    }

    public interface OnCLickFilmeListener{
        void onClickFilmeListener(int position);
    }
}
