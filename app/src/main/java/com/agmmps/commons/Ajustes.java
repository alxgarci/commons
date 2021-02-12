package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class Ajustes extends AppCompatActivity {

    FrameLayout flAjustes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        flAjustes = findViewById(R.id.flAjustes);

    }
}