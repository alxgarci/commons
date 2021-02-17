package com.agmmps.commons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agmmps.commons.fragments.BusquedaVecinosFragment;
import com.agmmps.commons.fragments.InicioFragment;
import com.agmmps.commons.fragments.PerfilFragment;
import com.agmmps.commons.fragments.ResultBusqVecFragment;
import com.agmmps.commons.fragments.VecinoFragment;
import com.agmmps.commons.javabeans.Usuario;
import com.agmmps.commons.listeners.BusqVecFragmentListener;
import com.agmmps.commons.listeners.VecinoFragmentListener;
import com.agmmps.commons.listeners.VolverListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VecinoFragmentListener, BusqVecFragmentListener, VolverListener {

    TextView titulo;
    BottomNavigationView bottom;
    FloatingActionButton fab;
    FrameLayout flMain;
    Toolbar toolbar;
    ArrayList listaVecinosBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorBackground));

        bottom = findViewById(R.id.bnMainBottomMenu);
        titulo = findViewById(R.id.tvMainTitulo);
        fab = findViewById(R.id.fabMain);
        flMain = findViewById(R.id.flMain);
        titulo.setText(R.string.main_home);
        toolbar = findViewById(R.id.tbToolbarMain);
        listaVecinosBackup = new ArrayList<Usuario>();
        fab.show();

        addFragment(1);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
//                addFragment(2);
//            }
//        });

        //Listener del BottomNavigationView
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.itmHome) {
                    fab.show();
                    addFragment(R.id.itmHome);
                    clearToolbar(1);
                } else if (item.getItemId() == R.id.itmBuscar) {
                    fab.hide();
                    addFragment(R.id.itmBuscar);
                    clearToolbar(1);
                } else if (item.getItemId() == R.id.itmUsuario) {
                    fab.hide();
                    addFragment(R.id.itmUsuario);
                    clearToolbar(0);
                }
                return true;
            }
        });
    }

    //Listener flecha volver atras
//    @Override
//    public boolean onSupportNavigateUp() {
//        Toast.makeText(MainActivity.this, "VOLVER ATRAS PULSADO", Toast.LENGTH_SHORT).show();
//        addFragment(7);
//        return true;
//    }

    private void clearToolbar(int i) {
        toolbar.getMenu().clear();
        if (i == 0) {
            toolbar.inflateMenu(R.menu.ajustes_perfil);
            toolbar.getOverflowIcon().setTint(getResources().getColor(R.color.colorPrimary));
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
            case R.id.itmHome:
                titulo.setText(R.string.main_home);
                InicioFragment ifg = new InicioFragment().newInstance();
                ft.replace(R.id.flMain, ifg);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.itmUsuario:
                titulo.setText(R.string.main_profile);
                PerfilFragment pf = new PerfilFragment().newInstance();
                ft.replace(R.id.flMain, pf);
                ft.addToBackStack(null);
                ft.commit();

                break;
            case R.id.itmBuscar:
                titulo.setText(R.string.main_community);
                BusquedaVecinosFragment bvf = new BusquedaVecinosFragment().newInstance();
                ft.replace(R.id.flMain, bvf);
                ft.addToBackStack(null);
                ft.commit();

                break;
            case 1:
                titulo.setText(R.string.main_home);
                InicioFragment if1 = new InicioFragment().newInstance();
                ft.add(R.id.flMain, if1);
                ft.addToBackStack(null);
                ft.commit();
                break;
            default:
                Toast.makeText(this, String.valueOf(getText(R.string.no_fragment)) + nom, Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void accederVecinoInicio(Usuario usuario) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        VecinoFragment vfg = new VecinoFragment().newInstance(usuario, 1);
        ft.replace(R.id.flMain, vfg);
        ft.addToBackStack(null);
        ft.commit();
        //TODO: Ocultar toolbar

    }

    @Override
    public void accederVecinoBusqueda(Usuario usuario) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        VecinoFragment vfg = new VecinoFragment().newInstance(usuario, 2);
        ft.replace(R.id.flMain, vfg);
        ft.addToBackStack(null);
        ft.commit();
    }

//    private void enableHomeAsUp() {
//        setSupportActionBar(toolbar);
//        actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//    }


    @Override
    public void buscarVecinos(ArrayList<Usuario> listaVecinos) {

        listaVecinosBackup = listaVecinos;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ResultBusqVecFragment rbvfg = new ResultBusqVecFragment().newInstance(listaVecinos);
        ft.replace(R.id.flMain, rbvfg);
        ft.addToBackStack(null);

        ft.commit();


    }

    @Override
    public void backInicio() {
        addFragment(R.id.itmHome);
    }

    @Override
    public void backResBusqueda() {
        buscarVecinos(listaVecinosBackup);

    }

    @Override
    public void backBusqueda() {

    }

//    private void disableHomeAsUp() {
//        actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(false);
//            setSupportActionBar(null);
//        }
//    }
}