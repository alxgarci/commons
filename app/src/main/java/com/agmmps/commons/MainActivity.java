package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.agmmps.commons.fragments.InicioFragment;

public class MainActivity extends AppCompatActivity {

    //gjtgjtjtjtkkkg

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.llMainContenedor);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        InicioFragment iFrag = InicioFragment.newInstance();
//        Bundle bundle = new Bundle();
//        bundle.putString(NAME_KEY, nom);
//        cf.setArguments(bundle);

        ft.add(R.id.llMainContenedor, iFrag);
        ft.addToBackStack(null);
        ft.commit();


    }
}