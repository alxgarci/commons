package com.agmmps.commons.javabeans;

import com.agmmps.commons.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Anuncio> datos;

    public Datos() {
        datos = new ArrayList<Anuncio>();
        //fgg
        datos.add(new Anuncio("Dentro un par de diás voy a hacer una pequeña reforma en casa, me preguntaba si alguien tiene una caja de herramientas(taladradora, pistola de pegamento...) que me puedan ayudar a ir rápido", "", (new Usuario(R.drawable.usuario_1, "mikel@gmail.com", "123456", "Mikel Izubirraga", "Pinar de Chamartín", "Soy un chico jovén y extrovertido me gusta descubrir hobbies, aficiones y amistades"))));
        datos.add(new Anuncio("Este fin de semana voy a un escape room, si te gusta la aventura y el misterio apuntaté", "", (new Usuario(R.drawable.usuario_3, "julia@gmail.com", "654321", "Julia Ramirez", "Arturo Soria", "Soy una chica que se acaba de independizar y busco intercambiar con mis vecinos objetos y herramientas para tener una buena relación vecinal"))));
        datos.add(new Anuncio("Quiero montar en la azotea de la comunidad un huerto ecológico si te interesa participar en la iniciativa trae todo el material de jardineria que tengas", "", (new Usuario(R.drawable.usuario_2, "mariorufvil@gmail.com", "97531C", "Mario Rufino", "Bernabeu", "Soy un chico que se acaba de mudar desde un pequeño pueblo de Asturias. Trabajo muchas horas y no tengo mucho y tiempo libre, pero estoy abierto a conocer a mis vecinos"))));
        datos.add(new Anuncio("Tengo goteras en casa y no se como solucionarlo, alguien tiene experiencia o trucos en este tipo de situaciones", "", (new Usuario(R.drawable.usuario_4, "monica.castillo1@gmail.com", "08642D", "Mónica Castillo", "Fuencarral", "Soy un persona abierta e involucrada en su comunidad para desarrollar una mejor convivencia vecinal"))));
        datos.add(new Anuncio("Me compré un dron hace 1 año y no lo uso, si alguien quiere usarlo se lo presto siempre y cuando sepa volarlo", "", (new Usuario(R.drawable.usuario_5, " darneljonson2@gmail.com", "918273E", "Darnel Johnson", "Moncloa", "Me vine hace un par de años a España porque me enamoré de esta ciudad y de su gente cercana"))));
        datos.add(new Anuncio("Estoy empezando a jugar al padel, si algún vecino quiere jugar algún día lo podemos pasar muy bien", "", (new Usuario(R.drawable.usuario_6, "ncortijo94@gmail.com", "564738F", "Nuria Cortijo", "Cuzco", "Primera vez que vivo sola, me encanta conocer a gente y saber quienes son mis vecinos. Espero que nos llevemos bien para pedirnos algo más que sal"))));


    }

    public ArrayList<Anuncio> getDatos() {
        return datos;
    }

}
