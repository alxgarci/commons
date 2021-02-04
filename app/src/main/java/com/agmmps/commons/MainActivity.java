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
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    BottomNavigationView bottom;

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
                    addFragment(R.id.itmHome);
                } else if (item.getItemId() == R.id.itmBuscar) {
                    addFragment(R.id.itmBuscar);
                } else if (item.getItemId() == R.id.itmUsuario) {
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
                //TODO añadir fragments
                //fragment 1
                break;
            case R.id.itmUsuario:
                titulo.setText(R.string.main_profile);
                //fragment 2
                break;
            case R.id.itmBuscar:
                titulo.setText(R.string.main_community);
                //fragment 3
                break;
            default:
                Toast.makeText(this, String.valueOf(getText(R.string.no_fragment)) + nom, Toast.LENGTH_LONG).show();
                break;
        }
    }
}