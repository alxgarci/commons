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

    public static final String COD_UL = "UL";

    EditText etUsuario;
    EditText etPassword;

    private FirebaseAuth fba;
    private FirebaseUser user;

//    DatabaseReference dbRef;
//    ValueEventListener vel;
//
//    ArrayList<Usuario> listaUsuarios;
//    Usuario usuario;
//    Usuario usuLoged;

    String correo;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //para cambiar el color de la barra de estadoo
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        etUsuario = findViewById(R.id.etLoginUsuario);
        etPassword = findViewById(R.id.etLoginPassword);

        //dbRef = FirebaseDatabase.getInstance().getReference("datos/usuarios");

        fba = FirebaseAuth.getInstance();
        user = fba.getCurrentUser();


    }

    public void acceder(View view) {

        correo = etUsuario.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (correo.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Introduce todos los datos", Toast.LENGTH_SHORT).show();
        } else {
            fba.signInWithEmailAndPassword(correo, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                user = fba.getCurrentUser();
                                //addListener();
                                accederMain();

                            } else {
                                Toast.makeText(LogIn.this, "El usuario introducido no existe en la base de datos",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }



                    });

        }

    }


    private void accederMain() {
        Intent i = new Intent(this, MainActivity.class);
        //i.putExtra(COD_UL, usuLoged);
        startActivity(i);
        finish();
    }


    public void abrirSignup(View view) {

        Intent i = new Intent(this, SignUp.class);
        startActivity(i);

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        addListener();
//    }

//    private void addListener() {
//        if (vel == null) {
//            vel = new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                    usuLoged = dataSnapshot.getValue(Usuario.class);
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//                    Toast.makeText(LogIn.this, "Error de lectura", Toast.LENGTH_SHORT).show();
//                }
//            };
//            dbRef.child(user.getUid()).addValueEventListener(vel);
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        removeListener();
//    }
//
//    private void removeListener() {
//        if (vel != null) {
//            dbRef.removeEventListener(vel);
//            vel = null;
//        }
//
//    }


}