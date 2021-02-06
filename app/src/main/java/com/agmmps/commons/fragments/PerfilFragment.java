package com.agmmps.commons.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.agmmps.commons.MainActivity;
import com.agmmps.commons.R;


public class PerfilFragment extends Fragment {
    Button btnEditar;
    Button btnAjustes;
    TextView tvNombre;
    TextView tvUbicacion;
    TextView tvDes;
    TextView tvDescripcion;
    ImageView imPerfil;



    public PerfilFragment() {

    }

    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();
        return fragment;
    }



    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        imPerfil = view.findViewById(R.id.im_fragment_perfil);
        tvNombre = view.findViewById(R.id.tvFragmentNombre);
        tvUbicacion = view.findViewById(R.id.tvFragmentUbica);
        tvDes = view.findViewById(R.id.tvFragmentDes);
        tvDescripcion =  view.findViewById(R.id.tvFragmentDescripcion);
        btnEditar = view.findViewById(R.id.btnFragmentEditar);
        btnAjustes = view.findViewById(R.id.btnFragmentAjustes);
        return view;


    }

}