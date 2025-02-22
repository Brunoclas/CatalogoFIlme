package com.example.catalogodefilmes.controller.webservice;

import com.example.catalogodefilmes.model.Genero;
import com.example.catalogodefilmes.model.ListGenero;
import com.example.catalogodefilmes.model.ResponseMovie;
import com.example.catalogodefilmes.model.Result;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IService {

    @GET("76341?api_key={api_key}")
    Call<ResponseBody> auth(@Query("api_key") String key);

    @GET("2/lists?")
    Call<ResponseMovie> listaFilmes(@Query("api_key") String key);

    @GET("movie/now_playing?api_key=39b7c4532e2215dad7185510b8caa177&language=pt-BR&page=1")
    Call<Result> listNowPlaying();

    @GET("movie/popular?api_key=39b7c4532e2215dad7185510b8caa177&language=pt-BR")
    Call<Result> popular();

    @GET("genre/movie/list?api_key=39b7c4532e2215dad7185510b8caa177&language=pt-BR")
    Call<ListGenero> genero();

}
