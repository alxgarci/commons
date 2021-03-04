package com.agmmps.commons.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agmmps.commons.MainActivity;
import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Usuario;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class PerfilFragment extends Fragment {

    Button btnEditar;
    Button btnAjustes;
    TextView tvNombre;
    TextView tvUbicacion;
    TextView tvDes;
    TextView tvDescripcion;
    ImageView imPerfil;

    FirebaseAuth fba;
    FirebaseUser user;
    DatabaseReference dbRef;
    StorageReference mFotoStorageRef;
    ValueEventListener vel;

    Usuario usuLoged;

    public PerfilFragment() {

    }

    public PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        imPerfil = view.findViewById(R.id.im_fragment_perfil);
        tvNombre = view.findViewById(R.id.tvFragmentNombre);
        tvUbicacion = view.findViewById(R.id.tvFragmentUbica);
        tvDescripcion =  view.findViewById(R.id.tvFragmentDescripcion);

        fba = FirebaseAuth.getInstance();
        user = fba.getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference("datos/usuarios");
        mFotoStorageRef = FirebaseStorage.getInstance().getReference().child("FotosUsuarios");

        return view;


    }

    private void cargarDatosUsuario() {
        Glide.with(this)
                .load(usuLoged.getUrlFoto())
                .placeholder(R.drawable.ic_logo_usuarios)
                .circleCrop()
                .into(imPerfil);

        tvNombre.setText(usuLoged.getNombre());
        tvUbicacion.setText(usuLoged.getBarrio());
        tvDescripcion.setText(usuLoged.getDescripcion());
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