package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    TextView nombreApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.ivLogoSplash);
        nombreApp = findViewById(R.id.tvNombreAppSplash);

        Glide.with(this)
                .load(R.drawable.ic_logo_usuarios)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade(500));
    }
}