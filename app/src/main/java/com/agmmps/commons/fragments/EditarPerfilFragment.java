package com.agmmps.commons.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.DisplayMetrics;
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
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;



public class EditarPerfilFragment extends Fragment {

    public static final int RC_PHOTO_ADJ = 1;

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
    Uri selectedUri;
    StorageReference mFotoStorageRef;

    Usuario usuLoged;
    Usuario usuEditado;
    VolverListener listener;

    String nombre;
    String barrio;
    String correo;
    String password;
    String descrip;
    boolean fotoCambiada;

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
        mFotoStorageRef = FirebaseStorage.getInstance().getReference().child("fotos");

        fotoCambiada = false;

        addListener();

        imbEditarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.selecciona_imagen, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete la acción usando"), RC_PHOTO_ADJ);
                fotoCambiada = true;

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = etNombre.getText().toString().trim();
                barrio = etBarrio.getText().toString().trim();
                correo = etCorreo.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                descrip = etDescrip.getText().toString().trim();

                if (fotoCambiada) {
                    final StorageReference fotoRef = mFotoStorageRef.child(selectedUri.getEncodedPath());
                    UploadTask ut = fotoRef.putFile(selectedUri);
                    Task<Uri> urlTask = ut.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }

                            return fotoRef.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Uri downloadUri = task.getResult();
                                usuEditado = new Usuario(0, downloadUri.toString() ,  correo, password, nombre, barrio, descrip);

                                dbRef.child(user.getUid()).setValue(usuEditado);
                                Snackbar snackbar = Snackbar
                                        .make(getActivity().getWindow().getDecorView().getRootView(), R.string.perfil_modificado_ok, Snackbar.LENGTH_LONG)
                                        .setBackgroundTint(getResources().getColor(R.color.colorPrimary));


                                //View para introducir margen por encima del BottomBar
                                View snackBarView = snackbar.getView();
                                snackBarView.setTranslationY(-(convertDpToPixel(56, getActivity())));
                                snackbar.show();

                                listener.backPerfil();

                            }
                        }
                    });
                } else {
                    usuEditado = new Usuario(0, usuLoged.getUrlFoto() ,  correo, password, nombre, barrio, descrip);

                    dbRef.child(user.getUid()).setValue(usuEditado);
                    Snackbar snackbar = Snackbar
                            .make(getActivity().getWindow().getDecorView().getRootView(), R.string.perfil_modificado_ok, Snackbar.LENGTH_LONG)
                            .setBackgroundTint(getResources().getColor(R.color.colorPrimary));


                    //View para introducir margen por encima del BottomBar
                    View snackBarView = snackbar.getView();
                    snackBarView.setTranslationY(-(convertDpToPixel(56, getActivity())));
                    snackbar.show();

                    listener.backPerfil();
                }



            }
        });


        return view;
    }

    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_PHOTO_ADJ && resultCode == Activity.RESULT_OK) {
            selectedUri = data.getData();
            Glide.with(imageView.getContext()).load(selectedUri).circleCrop()
                    .into(imageView);
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        addListener();
//    }

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
                .load(usuLoged.getUrlFoto())
                .placeholder(R.drawable.ic_logo_usuarios)
                .circleCrop()
                .into(imageView);

        etNombre.setText(usuLoged.getNombre());
        etBarrio.setText(usuLoged.getBarrio());
        etDescrip.setText(usuLoged.getDescripcion());
        etCorreo.setText(usuLoged.getCorreo());
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