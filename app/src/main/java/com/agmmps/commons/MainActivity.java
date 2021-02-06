package com.agmmps.commons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agmmps.commons.fragments.BusquedaVecinosFragment;
import com.agmmps.commons.fragments.InicioFragment;
import com.agmmps.commons.fragments.PerfilFragment;
import com.agmmps.commons.fragments.ResultBusqVecFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    BottomNavigationView bottom;
    FloatingActionButton fab;
    FrameLayout flMain;

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
        fab.hide();

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
                if (item.getItemId() == R.id.itmHome) {
                    fab.hide();
                    addFragment(R.id.itmHome);
                } else if (item.getItemId() == R.id.itmBuscar) {
                    fab.show();
                    addFragment(R.id.itmBuscar);
                } else if (item.getItemId() == R.id.itmUsuario) {
                    fab.hide();
                    addFragment(R.id.itmUsuario);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

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
            case 2:
                titulo.setText("PRUEBA RECYCLER");
                ResultBusqVecFragment rbvf = ResultBusqVecFragment.newInstance();
                ft.replace(R.id.flMain, rbvf);
                ft.addToBackStack(null);
                ft.commit();
                break;
            default:
                Toast.makeText(this, String.valueOf(getText(R.string.no_fragment)) + nom, Toast.LENGTH_LONG).show();
                break;
        }
    }
}