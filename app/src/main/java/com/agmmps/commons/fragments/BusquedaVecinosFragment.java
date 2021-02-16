package com.agmmps.commons.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.agmmps.commons.R;
import com.agmmps.commons.javabeans.Anuncio;
import com.agmmps.commons.javabeans.Datos;
import com.agmmps.commons.javabeans.Usuario;
import com.agmmps.commons.listeners.BusqVecFragmentListener;
import com.agmmps.commons.listeners.InicioFragmentListener;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;


public class BusquedaVecinosFragment extends Fragment {

    Button btnSearch;
    EditText etEscribir;
    ChipGroup chips;

    private BusqVecFragmentListener listener;

    public BusquedaVecinosFragment() {
        // Required empty public 
    }


    public BusquedaVecinosFragment newInstance() {
        BusquedaVecinosFragment fragment = new BusquedaVecinosFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentt
        View view = inflater.inflate(R.layout.fragment_busqueda_vecinos, container, false);

        etEscribir = view.findViewById(R.id.etVecinosBusqueda);
        chips = view.findViewById(R.id.chGroupBusqueda);
        btnSearch = view.findViewById(R.id.btnFragBusVecsearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre =  etEscribir.getText().toString().trim();

                //TODO: buscar los vecinos que tengan ese nombre, de momento creo un arraylist para simular

                final Datos datos = new Datos();

                ArrayList<Anuncio> listaAnuncios = datos.getDatos();
                ArrayList<Usuario> listaVecinos = new ArrayList<>();
                for (Anuncio anuncio : listaAnuncios) {
                    listaVecinos.add(anuncio.getUsuario());
                }

                listener.buscarVecinos(listaVecinos);

            }
        });

        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BusqVecFragmentListener) {
            listener = (BusqVecFragmentListener) context;
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