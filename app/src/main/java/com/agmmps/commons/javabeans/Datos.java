package com.agmmps.commons.javabeans;

import com.agmmps.commons.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Anuncio> datos;

    public Datos() {
        datos = new ArrayList<Anuncio>();
        //fgggh
        datos.add(new Anuncio(1, "Busco amiguitos para salir por ahi", (new Usuario(1, R.drawable.usuario_1, "Julia Ramirez", "Chamartin", "Soy una chica muy guay y me todo eso"))));
        datos.add(new Anuncio(2, "Busco amiguitas para jugar al ping pong", (new Usuario(2, R.drawable.usuario_2, "Mikel Izubirraga", "Bernabeu", "Soy una chico muy enrollado"))));
        datos.add(new Anuncio(3, "Busco amiguitos para salir por ahi", (new Usuario(3, R.drawable.usuario_3, "Julia Ramirez", "Chamartin", "Soy una chica muy guay y me todo eso"))));
        datos.add(new Anuncio(4, "Busco amiguitas para jugar al ping pong", (new Usuario(4, R.drawable.usuario_4, "Mikel Izubirraga", "Bernabeu", "Soy una chico muy enrollado"))));
//j
    }

    public ArrayList<Anuncio> getDatos() {
        return datos;
    }

}
