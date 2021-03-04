package com.agmmps.commons.javabeans;

import android.os.Parcel;
import android.os.Parcelable;

public class Anuncio implements Parcelable {

    private String descripAnun;
    private String usuarioUID;
    private Usuario usuario;

    public Anuncio() {
    }

    public Anuncio(String descripAnun, String usuarioUID, Usuario usuario) {
        this.descripAnun = descripAnun;
        this.usuarioUID = usuarioUID;
        this.usuario = usuario;
    }

    protected Anuncio(Parcel in) {
        descripAnun = in.readString();
        usuarioUID = in.readString();
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

    public String getDescripAnun() {
        return descripAnun;
    }

    public void setDescripAnun(String descripAnun) {
        this.descripAnun = descripAnun;
    }

    public String getUsuarioUID() {
        return usuarioUID;
    }

    public void setUsuarioUID(String usuarioUID) {
        this.usuarioUID = usuarioUID;
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
        dest.writeString(descripAnun);
        dest.writeString(usuarioUID);
        dest.writeParcelable(usuario, flags );

    }
}
