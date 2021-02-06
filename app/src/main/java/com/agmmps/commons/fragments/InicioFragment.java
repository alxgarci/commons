package com.agmmps.commons.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agmmps.commons.MainActivity;
import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Datos;
import com.agmmps.commons.javabeans.InicioAdapter;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView rv;

    public InicioFragment() {
        // Required empty public constructor
    }

    public static InicioFragment newInstance() {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        rv = view.findViewById(R.id.rvInicio);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        final Datos datos = new Datos();
        InicioAdapter inicAdap = new InicioAdapter((datos.getDatos()));
//        inicAdap.setListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int i = rv.indexOfChild(v);
//                Item elemento = datos.getDatos().get(i);
//                Intent intetDatos = new Intent(getApplicationContext(), DatosActivity.class);
//                intetDatos.putExtra(CLAVE_DATOS, elemento);
//                startActivity(intetDatos);
//            }
//        });
        rv.setAdapter(inicAdap);


        return view;
    }
}