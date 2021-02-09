package com.agmmps.commons.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.agmmps.commons.R;


public class EditarPerfilFragment extends Fragment {


//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;

    EditText etNombre;
    EditText etBarrio;
    EditText etCorreo;
    EditText etPassword;
    EditText etDescrip;

    public EditarPerfilFragment() {

    }


    public static EditarPerfilFragment newInstance() {
        EditarPerfilFragment fragment = new EditarPerfilFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
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


        return view;
    }
}