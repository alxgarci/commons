package com.agmmps.commons.javabeans;

import com.agmmps.commons.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Anuncio> datos;

    public Datos() {
        datos = new ArrayList<Anuncio>();

        datos.add(new Anuncio(1, "Busco amiguitos para salir por ahi", (new Usuario(1, R.drawable.ic_logo_usuarios, "Julia Ramirez", "Chamartin", "Soy una chica muy guay y me todo eso"))));
        datos.add(new Anuncio(2, "Busco amiguitas para jugar al ping pong", (new Usuario(2, R.drawable.ic_logo_usuarios, "Mikel Izubirraga", "Bernabeu", "Soy una chico muy enrollado"))));

    }

    public ArrayList<Anuncio> getDatos() {
        return datos;
    }

}
