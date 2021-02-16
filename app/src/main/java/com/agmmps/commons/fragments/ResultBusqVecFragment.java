package com.agmmps.commons.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Anuncio;
import com.agmmps.commons.javabeans.Datos;
import com.agmmps.commons.javabeans.InicioAdapter;
import com.agmmps.commons.javabeans.ResultBusqVecAdapter;
import com.agmmps.commons.javabeans.Usuario;

import java.util.ArrayList;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultBusqVecFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultBusqVecFragment extends Fragment {

    private RecyclerView rv;
    ArrayList<Usuario> listaVecinos;

    public ResultBusqVecFragment() {
        // Required empty public constructor
    }

    public ResultBusqVecFragment newInstance(ArrayList<Usuario> listaVecinos) {
        ResultBusqVecFragment fragment = new ResultBusqVecFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("RBV", listaVecinos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listaVecinos = getArguments().getParcelableArrayList("RBV");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_result_busq_vec, container, false);

        rv = view.findViewById(R.id.rvResultBusqVec);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        ResultBusqVecAdapter rbvAdap = new ResultBusqVecAdapter(listaVecinos);
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
        rv.setAdapter(rbvAdap);

        return view;
    }

}