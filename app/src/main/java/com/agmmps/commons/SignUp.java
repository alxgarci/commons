package com.agmmps.commons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private static final int REQ_CODE_1 = 1;
    EditText etNombre;
    EditText etBarrio;
    EditText etEmail;
    EditText etContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //para cambiar el color de la barra de estado
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        etNombre = findViewById(R.id.etSignUpUsuario);
        etBarrio = findViewById(R.id.etSignUpBarrio);
        etEmail = findViewById(R.id.etSignUpCorreo);
        etContrasenia = findViewById(R.id.etSignUpPassword);

    }

    public void signUp(View view) {
        String nombre = etNombre.getText().toString();
        String barrio = etBarrio.getText().toString();
        String email = etEmail.getText().toString();
        String contrasenia = etContrasenia.getText().toString();
        if (nombre.isEmpty() || contrasenia.isEmpty() || barrio.isEmpty() ||email.isEmpty()){

            Toast.makeText(this, R.string.debe_introducir, Toast.LENGTH_SHORT).show();

        }else{
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    public void abrirLogin(View view) {
        Intent i = new Intent(this, LogIn.class);
        startActivity(i);
    }
}