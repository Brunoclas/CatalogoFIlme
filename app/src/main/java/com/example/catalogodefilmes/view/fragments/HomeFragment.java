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
import com.example.catalogodefilmes.controller.adapters.LancamentosAdapter;
import com.example.catalogodefilmes.controller.adapters.PopularAdapter;
import com.example.catalogodefilmes.model.Movie;
import com.example.catalogodefilmes.model.Result;
import com.example.catalogodefilmes.view.activities.DescricaoActivity;

import java.util.List;

public class HomeFragment extends Fragment implements FilmesAdapter.OnCLickFilmeListener,
        LancamentosAdapter.OnClickLancamentoListener,
        PopularAdapter.OnClickPopularListener{

    private RecyclerView listNowPlay, listPopular, listLancamento;
    private FilmesAdapter filmesAdapter;
    private LancamentosAdapter lancamentosAdapter;
    private PopularAdapter popularAdapter;
    private Result now_playing, popular, maisCotados;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_home, container, false);
        listNowPlay = v.findViewById(R.id.listCinemas);
        listPopular = v.findViewById(R.id.listPopular);
        listLancamento = v.findViewById(R.id.listLancamento);
        Bundle bundle = getArguments();
        now_playing = bundle.getParcelable("movie_now");
        popular = bundle.getParcelable("popular");
        maisCotados = bundle.getParcelable("mais_cotados");
        carregaListaNowMovie();
        carregaListaPopular();
        carregaListaLancamentos();
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

        popularAdapter = new PopularAdapter(popular, this);
        listPopular.setAdapter(popularAdapter);
    }

    private void carregaListaLancamentos(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listLancamento.setLayoutManager(linearLayoutManager);

        lancamentosAdapter = new LancamentosAdapter(maisCotados, this);
        listLancamento.setAdapter(lancamentosAdapter);
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

    @Override
    public void onClickLancamentoListener(int position) {
        try {
            Intent intent = new Intent(getContext(), DescricaoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("result", maisCotados.getResults().get(position));
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }

    @Override
    public void onClickPopularListener(int position) {
        try {
            Intent intent = new Intent(getContext(), DescricaoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("result", popular.getResults().get(position));
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }
}
