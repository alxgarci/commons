package com.agmmps.commons.javabeans;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private int id_usuario;
    private int id_imagen;
    private String correo;
    private String password;
    private String nombre;
    private String barrio;
    private String descripcion;

    public Usuario() {
    }

    public Usuario(int id_usuario, int id_imagen, String correo, String password, String nombre, String barrio, String descripcion) {
        this.id_usuario = id_usuario;
        this.id_imagen = id_imagen;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.barrio = barrio;
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected Usuario(Parcel in) {
        id_usuario = in.readInt();
        id_imagen = in.readInt();
        correo = in.readString();
        password = in.readString();
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
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
        dest.writeInt(id_usuario);
        dest.writeInt(id_imagen);
        dest.writeString(correo);
        dest.writeString(password);
        dest.writeString(nombre);
        dest.writeString(barrio);
        dest.writeString(descripcion);
    }
}
