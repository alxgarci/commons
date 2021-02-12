package com.agmmps.commons.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agmmps.commons.R;

public class VecinoFragment extends Fragment {
    TextView tvNombre;
    TextView tvUbicacion;
    TextView tvDes;
    TextView tvDescripcion;
    ImageView imPerfil;


    public VecinoFragment() {
        // Required empty public constructo
    }


    public static VecinoFragment newInstance(String param1, String param2) {
        VecinoFragment fragment = new VecinoFragment();
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

        View view = inflater.inflate(R.layout.fragment_vecino, container, false);
        imPerfil = view.findViewById(R.id.im_fragment_vecino);
        tvNombre = view.findViewById(R.id.tvFragmentNombre);
        tvUbicacion = view.findViewById(R.id.tvFragmentUbica);
        tvDes = view.findViewById(R.id.tvFragmentDes);
        tvDescripcion =  view.findViewById(R.id.tvFragmentDescripcion);
        return view;
    }
}




