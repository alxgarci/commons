package com.agmmps.commons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agmmps.commons.javabeans.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText etNombre;
    EditText etBarrio;
    EditText etEmail;
    EditText etPassword;

    private FirebaseAuth fba;
    private FirebaseUser user;
    DatabaseReference dr;

    String nombre;
    String barrio;
    String email;
    String password;

    Usuario usuReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //para cambiar el color de la barra de o
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        etNombre = findViewById(R.id.etSignUpUsuario);
        etBarrio = findViewById(R.id.etSignUpBarrio);
        etEmail = findViewById(R.id.etSignUpCorreo);
        etPassword = findViewById(R.id.etSignUpPassword);

        dr = FirebaseDatabase.getInstance().getReference("datos");
        fba = FirebaseAuth.getInstance();
        user = fba.getCurrentUser();

    }

    public void signUp(View view) {
        nombre = etNombre.getText().toString();
        barrio = etBarrio.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        if (nombre.isEmpty() || password.isEmpty() || barrio.isEmpty() ||email.isEmpty()){

            Toast.makeText(this, R.string.debe_introducir, Toast.LENGTH_SHORT).show();

        }else{
            fba.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                user = fba.getCurrentUser();
                                //TODO:
                                usuReg = new Usuario("", email, password, nombre, barrio, "");

                                dr.child("usuarios").child(user.getUid()).setValue(usuReg);

                                accederApp();
                                Toast.makeText(getApplicationContext(),"Registrado!",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext()," Ha ocurrido un error en el registro",
                                        Toast.LENGTH_SHORT).show();
                            } } });

        }




    }

    private void accederApp() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void abrirLogin(View view) {
        Intent i = new Intent(this, LogIn.class);
        startActivity(i);
    }

}