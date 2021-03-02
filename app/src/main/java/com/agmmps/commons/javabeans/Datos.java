package com.agmmps.commons.javabeans;

import com.agmmps.commons.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Anuncio> datos;

    public Datos() {
        datos = new ArrayList<Anuncio>();
        //fgg
        datos.add(new Anuncio("Busco amiguitas para jugar al ping pong", "", (new Usuario(R.drawable.usuario_1, "mikel@gmail.com", "123456", "Mikel Izubirraga", "Chamartín", "Soy una chico muy enrollado"))));
        datos.add(new Anuncio("Busco amiguitos para salir por ahi", "", (new Usuario(R.drawable.usuario_3, "julia@gmail.com", "654321", "Julia Ramirez", "Villaverde", "Soy una chica muy guay y  todo eso"))));
        datos.add(new Anuncio("Busco amiguitos para salir por ahi", "", (new Usuario(R.drawable.usuario_2, "kevin@gmail.com", "123456a", "Kevin Smith", "Tribunal", "Soy una chica muy guay y me todo eso"))));
        datos.add(new Anuncio("Busco amiguitas para jugar al ping pong", "", (new Usuario(R.drawable.usuario_4, "jeniffer@gmail.com", "123456b", "Jeniffer Bloom", "Bernabeu", "Soy una chico muy enrollado"))));

    }

    public ArrayList<Anuncio> getDatos() {
        return datos;
    }

}
