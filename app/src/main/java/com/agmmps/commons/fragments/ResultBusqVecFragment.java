package com.agmmps.commons.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.ResultBusqVecAdapter;
import com.agmmps.commons.javabeans.Usuario;
import com.agmmps.commons.listeners.VecinoFragmentListener;
import com.agmmps.commons.listeners.VolverListener;

import java.util.ArrayList;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultBusqVecFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultBusqVecFragment extends Fragment {

    private RecyclerView rv;
    private VecinoFragmentListener listenerVecino;
    ArrayList<Usuario> listaVecinos;
    ImageButton imgB;
    VolverListener listenerVolver;


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
        imgB = view.findViewById(R.id.backResultados);

        imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerVolver.backBusqueda();
            }
        });

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        ResultBusqVecAdapter rbvAdap = new ResultBusqVecAdapter(listaVecinos);
        rbvAdap.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rv.getChildAdapterPosition(v);
                Usuario usuario = listaVecinos.get(i);
                listenerVecino.accederVecinoBusqueda(usuario);
            }
        });
        rv.setAdapter(rbvAdap);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof VecinoFragmentListener) {
            listenerVecino = (VecinoFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        if (context instanceof VolverListener) {
            listenerVolver = (VolverListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerVecino = null;
        listenerVolver = null;
    }

}