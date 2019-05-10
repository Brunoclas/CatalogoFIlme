package com.example.catalogodefilmes.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catalogodefilmes.controller.Utils.Config;
import com.example.catalogodefilmes.controller.webservice.UrlUtils;
import com.example.catalogodefilmes.model.Genero;
import com.example.catalogodefilmes.model.ListGenero;
import com.example.catalogodefilmes.model.Movie;
import com.example.catalogodefilmes.model.Result;
import com.squareup.picasso.Picasso;
import com.example.catalogodefilmes.R;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescricaoActivity extends AppCompatActivity {
    TextView txtTitulo, txtDescri, txtGenero;
    ImageView imgImagem;
    private Movie movie;
    ListGenero genero;
    String generoFilme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_filmes);
        txtTitulo = findViewById(R.id.txtTituloFilme);
        txtDescri = findViewById(R.id.txtDescriFilme);
        txtGenero = findViewById(R.id.txtGenero);
        imgImagem = findViewById(R.id.imgFilme);
        recebeDados();
        carregaGenero();
    }

    private void recebeDados() {
        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            movie = bundle.getParcelable("result");

            if (!movie.getTitle().isEmpty()) {
                txtTitulo.setText(movie.getTitle());
            } else {
                txtDescri.setText(R.string.not_titulo);
            }

            if (!movie.getOverview().isEmpty()) {
                txtDescri.setText(movie.getOverview());
            } else {
                txtDescri.setText(R.string.not_descri);
            }
            Picasso.get()
                    .load(Config.URL_IMG + movie.getPoster_path())
                    .resize(250, 250)
                    .centerInside()
                    //.error(R.drawable.user_placeholder_error)
                    .into(imgImagem);


        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
    }

    private void carregaGenero() {
        try {
            final Call<ListGenero> callGenero = UrlUtils.getService().genero();
            callGenero.enqueue(new Callback<ListGenero>() {
                @Override
                public void onResponse(Call<ListGenero> call, Response<ListGenero> response) {
                    genero = response.body();

                    for(int i = 0; movie.getGenre_ids().length >= 3; i++){

                    }

                    for (int i = 0; genero.getGenres().size() >= movie.getGenre_ids().length;i++ ) {
                        switch (genero.getGenres().get(i).getId()){
//                            case movie.getGenre_ids():
//
//                            break;
                        }



                        txtGenero.setText(genero.getGenres().get(i).getName());
                    }
                }

                @Override
                public void onFailure(Call<ListGenero> call, Throwable t) {
                    t.getMessage();
                }
            });


        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }

}
