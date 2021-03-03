package com.agmmps.commons.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Usuario;
import com.agmmps.commons.listeners.VolverListener;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class EditarPerfilFragment extends Fragment {


    EditText etNombre;
    EditText etBarrio;
    EditText etCorreo;
    EditText etPassword;
    EditText etDescrip;
    Button btnEditar;
    Toolbar toolbar;
    ImageButton imbEditarImagen;
    ImageView imageView;

    FirebaseAuth fba;
    FirebaseUser user;

    DatabaseReference dbRef;
    ValueEventListener vel;

    Usuario usuLoged;
    Usuario usuEditado;
    VolverListener listener;

    public EditarPerfilFragment() {

    }


    public static EditarPerfilFragment newInstance() {
        EditarPerfilFragment fragment = new EditarPerfilFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_perfil, container, false);

        etNombre = view.findViewById(R.id.etEditPerfFragNom);
        etBarrio = view.findViewById(R.id.etEditPerfFragBarrio);
        etCorreo = view.findViewById(R.id.etEditPerfFragCorreo);
        etPassword = view.findViewById(R.id.etEditPerfFragPW);
        etDescrip = view.findViewById(R.id.etEditPerfFragDescrip);
        btnEditar = view.findViewById(R.id.btnEditPerfFragGuardar);
        imbEditarImagen = view.findViewById(R.id.imbEditarImagenPerfil);
        imageView = view.findViewById(R.id.im_fragment_editar_perfil);

        fba = FirebaseAuth.getInstance();
        user = fba.getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference("datos/usuarios");


        fba = FirebaseAuth.getInstance();
        user = fba.getCurrentUser();

        imbEditarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "EDITAR IMAGEN", Toast.LENGTH_SHORT).show();
                //TODO:
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etNombre.getText().toString().trim();
                String barrio = etBarrio.getText().toString().trim();
                String correo = etCorreo.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String descrip = etDescrip.getText().toString().trim();

                usuEditado = new Usuario(usuLoged.getId_imagen(), correo, password, nombre, barrio, descrip);

                dbRef.child(user.getUid()).setValue(usuEditado);

                Toast.makeText(getContext(), "Has modificado tu perfil con exito!", Toast.LENGTH_SHORT).show();

                listener.backPerfil();

            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        addListener();
    }

    private void addListener() {
        if (vel == null) {
            vel = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    usuLoged = dataSnapshot.getValue(Usuario.class);

                    cargarDatosUsuario();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Error al cargar los datos", Toast.LENGTH_SHORT).show();
                }
            };
            dbRef.child(user.getUid()).addValueEventListener(vel);
        }
    }

    private void cargarDatosUsuario() {
        Glide.with(this)
                .load(R.drawable.usuario_1)
                .placeholder(R.drawable.ic_logo_usuarios)
                .circleCrop()
                .into(imageView);
        etNombre.setText(usuLoged.getNombre());
        etBarrio.setText(usuLoged.getBarrio());
        etDescrip.setText(usuLoged.getDescripcion());
        etCorreo.setText(usuLoged.getCorreo());
        //etPassword.cle
        etPassword.setText(usuLoged.getPassword());
    }

    @Override
    public void onPause() {
        super.onPause();
        removeListener();
    }

    private void removeListener() {
        if (vel != null) {
            dbRef.removeEventListener(vel);
            vel = null;
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof VolverListener) {
            listener = (VolverListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


//
//    private void disableHomeAsUp() {
//        actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(false);
//            setSupportActionBar(null);
//        }
//    }
//

}