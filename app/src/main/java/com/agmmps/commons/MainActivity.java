package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.agmmps.commons.fragments.InicioFragment;
import com.agmmps.commons.fragments.ResultBusqVecFragment;

public class MainActivity extends AppCompatActivity {

    //gjtgjtjtjtkkkghh

    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl = findViewById(R.id.frMainContenedor);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        InicioFragment iFrag = InicioFragment.newInstance();
//        ResultBusqVecFragment rbvf = ResultBusqVecFragment.newInstance();

//        Bundle bundle = new Bundle();
//        bundle.putString(NAME_KEY, nom);
//        cf.setArguments(bundle);

        ft.add(R.id.frMainContenedor, iFrag);
        ft.addToBackStack(null);
        ft.commit();


    }
}