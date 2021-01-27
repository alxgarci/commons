package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    EditText etUsuario;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etUsuario = findViewById(R.id.etLoginUsuario);
        etPassword = findViewById(R.id.etLoginPassword);

    }

    public void acceder(View view) {

        String usuario = etUsuario.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (usuario.isEmpty()) {
            //Toast
        } else if (password.isEmpty()) {
            //Toast
        } else {
            int num = 5;
            /*
            creamos el objeto Usuario
            consulta usuario en la BD

            if (usuario existe en la BD) {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            } else {
                //Toast
            }
            */

        }

    }

    public void abrirSignup(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }
}