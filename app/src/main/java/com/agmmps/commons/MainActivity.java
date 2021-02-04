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
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    BottomNavigationView bottom;
    //TODO importar navigation bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorBackground));

        bottom = findViewById(R.id.bnMainBottomMenu);
        titulo = findViewById(R.id.tvMainTitulo);

        //Listener del BottomNavigationView
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.itmHome) {
                    titulo.setText(R.string.main_home);
                    addFragment(R.id.itmHome);
                } else if (item.getItemId() == R.id.itmBuscar) {
                    titulo.setText(R.string.main_community);
                    addFragment(R.id.itmBuscar);
                } else if (item.getItemId() == R.id.itmUsuario) {
                    titulo.setText(R.string.main_profile);
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
                //fragment 1
                break;
            case R.id.itmUsuario:
                //fragment 2
                break;
            case R.id.itmBuscar:
                //fragment 3
                break;
        }
    }
}