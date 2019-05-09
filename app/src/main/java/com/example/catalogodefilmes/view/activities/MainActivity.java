package com.example.catalogodefilmes.view.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.Utils.Config;
import com.example.catalogodefilmes.controller.webservice.IService;
import com.example.catalogodefilmes.controller.webservice.UrlUtils;
import com.example.catalogodefilmes.model.ResponseMovie;
import com.example.catalogodefilmes.view.fragments.HomeFragment;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private IService iService;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Call<ResponseMovie> call = UrlUtils.getService().listaFilmes(Config.API_KEY);
//        call.enqueue(new Callback<ResponseMovie>() {
//            @Override
//            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
//                ResponseMovie responseMovie = new ResponseMovie();
//                responseMovie = response.body();
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseMovie> call, Throwable t) {
//
//            }
//        });

        Fragment homeFragment = HomeFragment.newStance();
        openFragment(homeFragment, R.id.frameLayout);

    }

    public void openFragment(Fragment fragment, int frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(frag, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case 1:
                Fragment homeFragment = HomeFragment.newStance();
                openFragment(homeFragment, R.layout.frag_biblioteca);
            case 2:

            case 3:
        }

        return true;
    }
}
