package com.agmmps.commons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agmmps.commons.fragments.BusquedaVecinosFragment;
import com.agmmps.commons.fragments.EditarPerfilFragment;
import com.agmmps.commons.fragments.InicioFragment;
import com.agmmps.commons.fragments.PerfilFragment;
import com.agmmps.commons.fragments.ResultBusqVecFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import static com.agmmps.commons.R.*;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    BottomNavigationView bottom;
    FloatingActionButton fab;
    FrameLayout flMain;
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(color.colorBackground));

        bottom = findViewById(id.bnMainBottomMenu);
        titulo = findViewById(id.tvMainTitulo);
        fab = findViewById(id.fabMain);
        flMain = findViewById(id.flMain);
        titulo.setText(string.main_home);

        toolbar = findViewById(id.tbToolbarMain);



        fab.show();

        addFragment(1);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
                addFragment(2);
            }
        });

        //Listener del BottomNavigationView
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == id.itmHome) {
                    fab.show();
                    addFragment(id.itmHome);
                    clearToolbar(1);
                } else if (item.getItemId() == id.itmBuscar) {
                    fab.hide();
                    addFragment(id.itmBuscar);
                    clearToolbar(1);
                } else if (item.getItemId() == id.itmUsuario) {
                    fab.hide();
                    addFragment(id.itmUsuario);
                    clearToolbar(0);
                }
                return true;
            }
        });
    }

    private void clearToolbar(int i) {
        toolbar.getMenu().clear();
        if (i == 0) {
            toolbar.inflateMenu(menu.ajustes_perfil);
            toolbar.getOverflowIcon().setTint(getResources().getColor(color.colorPrimary));
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
//        bottom.inflateMenu(R.menu.bottom_navigation_menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void addFragment(int nom) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (nom){
            case id.itmHome:
                titulo.setText(string.main_home);
                InicioFragment ifg = new InicioFragment().newInstance();
                ft.replace(id.flMain, ifg);
                ft.addToBackStack(null);
                disableHomeAsUp();
                ft.commit();
                break;

            case id.itmUsuario:
                titulo.setText(string.main_profile);
                PerfilFragment pf = new PerfilFragment().newInstance();
                ft.replace(id.flMain, pf);
                ft.addToBackStack(null);
                disableHomeAsUp();
                ft.commit();
                break;

            case id.itmBuscar:
                titulo.setText(string.main_community);
                BusquedaVecinosFragment bvf = new BusquedaVecinosFragment().newInstance();
                ft.replace(id.flMain, bvf);
                ft.addToBackStack(null);
                disableHomeAsUp();
                ft.commit();
                break;

            case 1:
                titulo.setText(string.main_home);
                InicioFragment if1 = new InicioFragment().newInstance();
                ft.add(id.flMain, if1);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 2:
                titulo.setText("PRUEBA RECYCLER");
                ResultBusqVecFragment rbvf = ResultBusqVecFragment.newInstance();
                ft.replace(id.flMain, rbvf);
                ft.addToBackStack(null);

                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);
                ft.commit();
                break;

            case 3:
                EditarPerfilFragment ef = EditarPerfilFragment.newInstance();
                ft.replace(id.flMain, ef);
                ft.addToBackStack(null);
                ft.commit();
                break;

            default:
                Toast.makeText(this, String.valueOf(getText(string.no_fragment)) + nom, Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void disableHomeAsUp() {
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            setSupportActionBar(null);
        }
    }
}