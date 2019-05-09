package com.example.catalogodefilmes.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.CategFilmesHolder;
import com.example.catalogodefilmes.controller.adapters.CategFilmesAdapter;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CategFilmesAdapter categFilmesAdapter;
    private String[] categorias = {"Lançamento", "Ação", "Aventura", "Terror"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_biblioteca, container, false);
        mRecyclerView = v.findViewById(R.id.categList);
        carregaLista();
        return v;
    }

    private void carregaLista(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        categFilmesAdapter = new CategFilmesAdapter(categorias);
        mRecyclerView.setAdapter(categFilmesAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

    }

    public static HomeFragment newStance(){
        return new HomeFragment();
    }
}
