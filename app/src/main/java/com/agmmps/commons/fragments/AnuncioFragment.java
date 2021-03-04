package com.agmmps.commons.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Anuncio;
import com.agmmps.commons.javabeans.Usuario;
import com.agmmps.commons.listeners.VolverListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AnuncioFragment extends Fragment {


    EditText etAnuncio;
    ImageButton imgB;
    Button btnPublicar;

    VolverListener listener;

    private FirebaseAuth fba;
    private FirebaseUser user;
    DatabaseReference dr;

    Anuncio anuncio;
    Usuario usuario;

    public AnuncioFragment() {

    }

    public AnuncioFragment newInstance() {
        AnuncioFragment fragment = new AnuncioFragment();
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
        View view = inflater.inflate(R.layout.fragment_anuncio, container, false);

        etAnuncio = view.findViewById(R.id.etAnuncioFrag);
        imgB = view.findViewById(R.id.backAnuncio);
        btnPublicar = view.findViewById(R.id.btnAnuncioFragPublicar);

        imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.backInicio();
            }
        });

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String descripAnun = etAnuncio.getText().toString().trim();

                if (descripAnun.isEmpty()) {

                    createSnackbar(0);

                } else {

                    dr = FirebaseDatabase.getInstance().getReference("datos");
                    fba = FirebaseAuth.getInstance();
                    user = fba.getCurrentUser();

                    anuncio = new Anuncio(descripAnun, user.getUid() ,null);

                    dr.child("anuncios").push().setValue(anuncio);

                    createSnackbar(1);
                    listener.backInicio();

                }


            }
        });

        return view;
    }

    //Metodo para crear los snackbar segun el resultado de la creacion del anuncio
    private void createSnackbar(int i) {
        switch (i) {
            case 0:
                Snackbar snackbar = Snackbar
                        .make(getActivity().getWindow().getDecorView().getRootView(), R.string.anuncio_creado_err, Snackbar.LENGTH_LONG)
                        .setBackgroundTint(getResources().getColor(R.color.colorPrimary));
                View snackBarView = snackbar.getView();
                snackBarView.setTranslationY(-(convertDpToPixel(112, getActivity())));
                snackbar.show();
                break;
            case 1:
                Snackbar snackbar2 = Snackbar
                        .make(getActivity().getWindow().getDecorView().getRootView(), R.string.anuncio_creado_ok, Snackbar.LENGTH_LONG)
                        .setBackgroundTint(getResources().getColor(R.color.colorPrimary));
                View snackBarView2 = snackbar2.getView();
                snackBarView2.setTranslationY(-(convertDpToPixel(112, getActivity())));
                snackbar2.show();
                break;

        }
    }

    //Metodo para convertir de dp a pixel para añadir los margenes
    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
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

}