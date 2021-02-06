package com.agmmps.commons.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.agmmps.commons.R;


public class BusquedaVecinosFragment extends Fragment {
    Button btnFiltros;
    Button btnSearch;
    EditText etEscribir;



    public BusquedaVecinosFragment() {
        // Required empty public 
    }


    public static BusquedaVecinosFragment newInstance(String param1, String param2) {
        BusquedaVecinosFragment fragment = new BusquedaVecinosFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_busqueda_vecinos, container, false);
        etEscribir=view.findViewById(R.id.etFragBusVecescribir);
        btnFiltros = view.findViewById(R.id.btnFragBusVecfiltros);
        btnSearch = view.findViewById(R.id.btnFragBusVecsearch);
        return view;
    }
}