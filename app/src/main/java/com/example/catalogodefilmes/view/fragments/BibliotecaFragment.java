package com.example.catalogodefilmes.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.catalogodefilmes.R;
import com.example.catalogodefilmes.view.activities.MainActivity;

public class BibliotecaFragment extends Fragment {
    private Button btnExpFilmes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_biblioteca, container, false);
        btnExpFilmes = v.findViewById(R.id.btnExpFilmes);
        btnExpFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment homeFragment = HomeFragment.newStance();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout, homeFragment);
//                ft.addToBackStack(null);
//                ft.commit();
                getContext().startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        return v;
    }

    public static BibliotecaFragment newStance() {
        return new BibliotecaFragment();
    }
}
