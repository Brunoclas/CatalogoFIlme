package com.example.catalogodefilmes.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.FilmesHolder;
import com.example.catalogodefilmes.controller.adapters.FilmesAdapter;
import com.example.catalogodefilmes.model.Movie;
import com.example.catalogodefilmes.model.Result;
import com.example.catalogodefilmes.view.activities.DescricaoActivity;

import java.util.List;

public class HomeFragment extends Fragment implements FilmesAdapter.OnCLickFilmeListener {

    private RecyclerView listNowPlay, listPopular;
    private FilmesAdapter filmesAdapter;
    private Result now_playing, popular;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_home, container, false);
        listNowPlay = v.findViewById(R.id.listNowPlay);
        listPopular = v.findViewById(R.id.listPopular);
        Bundle bundle = getArguments();
        now_playing = bundle.getParcelable("movie_now");
        popular = bundle.getParcelable("popular");
        carregaListaNowMovie();
        carregaListaPopular();
        return v;
    }

    private void carregaListaNowMovie() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listNowPlay.setLayoutManager(linearLayoutManager);

        filmesAdapter = new FilmesAdapter(now_playing, this);
        listNowPlay.setAdapter(filmesAdapter);
    }

    private void carregaListaPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listPopular.setLayoutManager(linearLayoutManager);

        filmesAdapter = new FilmesAdapter(popular, this);
        listPopular.setAdapter(filmesAdapter);
    }

    public static HomeFragment newStance() {
        return new HomeFragment();
    }

    @Override
    public void onClickFilmeListener(int position) {
        try {
            Intent intent = new Intent(getContext(), DescricaoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("result", now_playing.getResults().get(position));
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }
}
