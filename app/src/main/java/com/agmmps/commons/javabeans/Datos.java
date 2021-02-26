package com.agmmps.commons.javabeans;

import com.agmmps.commons.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Anuncio> datos;

    public Datos() {
        datos = new ArrayList<Anuncio>();
        //fgg
        datos.add(new Anuncio(1, "Busco amiguitas para jugar al ping pong", (new Usuario(1, R.drawable.usuario_1, "mikel@gmail.com", "654321", "Mikel Izubirraga", "Villaverde", "Soy una chico muy enrollado"))));
        datos.add(new Anuncio(2, "Busco amiguitos para salir por ahi", (new Usuario(2, R.drawable.usuario_3, "julia@gmail.com", "123456", "Julia Ramirez", "Chamartin", "Soy una chica muy guay y  todo eso"))));
        datos.add(new Anuncio(3, "Busco amiguitos para salir por ahi", (new Usuario(3, R.drawable.usuario_2, "kevin@gmail.com", "123456a", "Kevin Smith", "Tribunal", "Soy una chica muy guay y me todo eso"))));
        datos.add(new Anuncio(4, "Busco amiguitas para jugar al ping pong", (new Usuario(4, R.drawable.usuario_4, "jeniffer@gmail.com", "123456b", "Jeniffer Bloom", "Bernabeu", "Soy una chico muy enrollado"))));

    }

    public ArrayList<Anuncio> getDatos() {
        return datos;
    }

}
