package com.example.catalogodefilmes.view.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.controller.Utils.Config;
import com.example.catalogodefilmes.controller.webservice.IService;
import com.example.catalogodefilmes.controller.webservice.UrlUtils;
import com.example.catalogodefilmes.model.ResponseMovie;
import com.example.catalogodefilmes.model.Result;
import com.example.catalogodefilmes.view.fragments.BibliotecaFragment;
import com.example.catalogodefilmes.view.fragments.HomeFragment;
import com.example.catalogodefilmes.view.fragments.ListaInteresseFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private IService iService;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private Result now_playing, popular, maisCotados;
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //Request de filmes nos cinemas
        try {
            Call<Result> callNowPlaying= UrlUtils.getService().listNowPlaying();
            callNowPlaying.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    now_playing = response.body();

                    bundle.putParcelable("movie_now", now_playing);

                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    t.getMessage();
                }
            });
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }

        //Request de filmes populares
        try {
            Call<Result> callResults = UrlUtils.getService().popular();
            callResults.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    popular = response.body();

                    bundle.putParcelable("popular", popular);

                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    t.getMessage();
                }
            });
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }

        try{
            Call<Result> callLancamentos = UrlUtils.getService().maisCotados();
            callLancamentos.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    maisCotados = response.body();
                    bundle.putParcelable("mais_cotados", maisCotados);

                    Fragment homeFragment = HomeFragment.newStance();
                    homeFragment.setArguments(bundle);
                    openFragment(homeFragment, R.id.frameLayout);
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    t.getMessage();
                }
            });

        }catch (Exception e){
            e.getStackTrace();
            e.getMessage();
        }

    }

    public void openFragment(Fragment fragment, int frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(frag, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                Fragment homeFragment = HomeFragment.newStance();
                homeFragment.setArguments(bundle);
                openFragment(homeFragment, R.id.frameLayout);
                break;
            case R.id.navigation_biblioteca:
                Fragment biblioteFragment = BibliotecaFragment.newStance();
                openFragment(biblioteFragment, R.id.frameLayout);
                break;
            case R.id.navigation_lista_interesses:
                Fragment listaInteresseFragment = ListaInteresseFragment.newStance();
                openFragment(listaInteresseFragment, R.id.frameLayout);
                break;
        }

        return true;
    }

}
