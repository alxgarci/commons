package com.agmmps.commons.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Usuario;
import com.agmmps.commons.listeners.VecinoFragmentListener;
import com.agmmps.commons.listeners.VolverListener;
import com.bumptech.glide.Glide;

public class VecinoFragment extends Fragment {

    TextView tvNombre;
    TextView tvUbicacion;
    TextView tvDes;
    TextView tvDescripcion;
    ImageView imPerfil;

    Usuario usuario;
    ImageButton back;
    VolverListener listener;
    int code;

    public VecinoFragment() {
        // Required empty public constructo
    }


    public VecinoFragment newInstance(Usuario usuario, int code) {
        VecinoFragment fragment = new VecinoFragment();
        Bundle args = new Bundle();
        args.putParcelable("VECINO", usuario);
        args.putInt("CODE", code);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuario = getArguments().getParcelable("VECINO");
            code = getArguments().getInt("CODE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vecino, container, false);

        imPerfil = view.findViewById(R.id.im_fragment_vecino);
        tvNombre = view.findViewById(R.id.tvFragmentNombre);
        tvUbicacion = view.findViewById(R.id.tvFragmentUbica);
        tvDes = view.findViewById(R.id.tvFragmentDes);
        tvDescripcion =  view.findViewById(R.id.tvFragmentDescripcion);
        back = view.findViewById(R.id.backVecino);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.backInicio();
                if (code == 1) {
                    listener.backInicio();
                } else if (code == 2) {
                    listener.backResBusqueda();
                }
            }
        });

        Glide.with(this)
                .load(usuario.getIdImagen())
                .placeholder(R.drawable.ic_logo_usuarios)
                .circleCrop()
                .into(imPerfil);

        //TODO: cargar los datos del vecino en el fragment

        return view;
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




