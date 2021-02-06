package com.agmmps.commons.javabeans;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private int idUsuario;
    private int idImagen;
    private String nombre;
    private String barrio;
    private String descripcion;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idImagen, String nombre, String barrio, String descripcion) {
        this.idUsuario = idUsuario;
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.barrio = barrio;
        this.descripcion = descripcion;
    }

    protected Usuario(Parcel in) {
        idUsuario = in.readInt();
        idImagen = in.readInt();
        nombre = in.readString();
        barrio = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idUsuario);
        dest.writeInt(idImagen);
        dest.writeString(nombre);
        dest.writeString(barrio);
        dest.writeString(descripcion);
    }
}
