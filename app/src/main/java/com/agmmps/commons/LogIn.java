package com.agmmps.commons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.agmmps.commons.javabeans.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LogIn extends AppCompatActivity {

    EditText etUsuario;
    EditText etPassword;

    private FirebaseAuth fba;
    private FirebaseUser user;

    DatabaseReference dbRef;
    ValueEventListener vel;

    ArrayList<Usuario> listaUsuarios;
    Usuario usuario;
//i
    String correo;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //para cambiar el color de la barra de estado
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        etUsuario = findViewById(R.id.etLoginUsuario);
        etPassword = findViewById(R.id.etLoginPassword);

        dbRef = FirebaseDatabase.getInstance().getReference("datos/usuarios");

        fba = FirebaseAuth.getInstance();
        user = fba.getCurrentUser();


    }

    public void acceder(View view) {

        correo = etUsuario.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (correo.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "faltan datos", Toast.LENGTH_SHORT).show();
        } else {
            fba.signInWithEmailAndPassword(correo, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                user = fba.getCurrentUser();
                                accederMain();

                            } else {
                                Toast.makeText(LogIn.this, "No accede" + "\n" +task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }

                        }



                    });

        }

    }


    private void accederMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


    public void abrirSignup(View view) {

//        for (Usuario usuarioDB: listaUsuarios) {
//            if (correo.equals(usuarioDB.getCorreo()) && password.equals(usuarioDB.getPassword())) {
//                usuario = usuarioDB;
//            }
//        }
//
//        Toast.makeText(LogIn.this, "tenemos usuario", Toast.LENGTH_SHORT).show();
//        System.out.println("-------------------------------------" + usuario.getBarrio());

//        Intent i = new Intent(this, SignUp.class);
//        startActivity(i);

    }

    @Override
    protected void onResume() {
        super.onResume();
        addListener();
    }

    private void addListener() {
        if (vel == null) {
            vel = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                    for (DataSnapshot dss: dataSnapshot.getChildren()) {
//
//                        usuario= dss.getValue(Usuario.class);
//                        listaUsuarios.add(usuario);
//
//
//                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(LogIn.this, "Error de lectura", Toast.LENGTH_SHORT).show();
                }
            };
            dbRef.addValueEventListener(vel);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeListener();
    }

    private void removeListener() {
        if (vel != null) {
            dbRef.removeEventListener(vel);
            vel = null;
        }

    }


}