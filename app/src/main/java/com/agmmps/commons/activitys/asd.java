package com.agmmps.commons.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agmmps.commons.R;

public class asd extends AppCompatActivity {
    private static final int REQ_CODE_1 = 1;
    EditText etNombre;
    EditText etBarrio;
    EditText etEmail;
    EditText etContrasenia;
    String nombre;
    String barrio;
    String email;
    String contrasenia;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = findViewById(R.id.btnSignUpSignUp);
        etNombre = findViewById(R.id.etsignupnombre);
        etBarrio = findViewById(R.id.etsignupbarrio);
        etEmail = findViewById(R.id.etsignupemail);
        etContrasenia = findViewById(R.id.etsignupcontrasenia);

    }

    public void SignUp(View view) {
        nombre = etNombre.getText().toString();
        barrio = etBarrio.getText().toString();
        email = etEmail.getText().toString();
        contrasenia = etContrasenia.getText().toString();
        if (nombre.isEmpty() || contrasenia.isEmpty() || barrio.isEmpty() ||email.isEmpty()){

            Toast.makeText(this, R.string.debe_introducir, Toast.LENGTH_SHORT).show();

        }else{
            Intent i = new Intent(this, MainActivity.class);
            startActivityForResult(i, REQ_CODE_1);
        }
    }
}