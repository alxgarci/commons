package com.agmmps.commons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorBackground));
        titulo = findViewById(R.id.tvMainTitulo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmHome) {
            titulo.setText(R.string.main_home);
        } else if (item.getItemId() == R.id.itmBuscar) {
            titulo.setText("hola");
//            R.string.main_community
        } else if (item.getItemId() == R.id.itmUsuario) {
            titulo.setText(R.string.main_profile);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addFragment(String nom) {
        //metodo para abrir fragments
    }
}