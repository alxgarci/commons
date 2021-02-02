package com.agmmps.commons.javabeans;

import android.os.Parcel;
import android.os.Parcelable;

public class Anuncio implements Parcelable {

    private int idAnuncio;
    private String descripAnun;
    private Usuario usuario;

    public Anuncio() {
    }

    public Anuncio(int idAnuncio, String descripAnun, Usuario usuario) {
        this.idAnuncio = idAnuncio;
        this.descripAnun = descripAnun;
        this.usuario = usuario;
    }

    protected Anuncio(Parcel in) {
        idAnuncio = in.readInt();
        descripAnun = in.readString();
        usuario = in.readParcelable(Usuario.class.getClassLoader());
    }

    public static final Creator<Anuncio> CREATOR = new Creator<Anuncio>() {
        @Override
        public Anuncio createFromParcel(Parcel in) {
            return new Anuncio(in);
        }

        @Override
        public Anuncio[] newArray(int size) {
            return new Anuncio[size];
        }
    };

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getDescripAnun() {
        return descripAnun;
    }

    public void setDescripAnun(String descripAnun) {
        this.descripAnun = descripAnun;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idAnuncio);
        dest.writeString(descripAnun);
        //dest.writeParcelable(usuario, 0);

    }
}
