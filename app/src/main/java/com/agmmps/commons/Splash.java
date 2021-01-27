package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    //ss
    ImageView logo;
    TextView nombreApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //para cambiar el color de la barra de estado
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorBackground));

        logo = findViewById(R.id.ivLogoSplash);
        nombreApp = findViewById(R.id.tvNombreAppSplash);

        Glide.with(this)
                .load(R.drawable.ic_logo_usuarios)
                .fitCenter()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorPrimaryLight)))
                .into(logo);

        Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        logo.startAnimation(fadein);
        nombreApp.startAnimation(fadein);

        openDelay(true);

    }

    private void openDelay(boolean b) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, LogIn.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
    }
}