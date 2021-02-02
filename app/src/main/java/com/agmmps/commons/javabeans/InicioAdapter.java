package com.agmmps.commons.javabeans;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agmmps.commons.R;

import java.util.ArrayList;

public class InicioAdapter extends RecyclerView.Adapter<InicioAdapter.AnuncioViewHolder> implements View.OnClickListener {

    private ArrayList<Anuncio> datos;
    private View.OnClickListener listener;

    public InicioAdapter(ArrayList<Anuncio> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario_inicio, parent, false);
        v.setOnClickListener(this);
        AnuncioViewHolder avh = new AnuncioViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioViewHolder holder, int position) {
        holder.bindItem(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public static class AnuncioViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenUsu;
        private TextView nombreUsu;
        private TextView dist;
        private TextView descripAnun;

        public AnuncioViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenUsu = itemView.findViewById(R.id.imgItemRVInicio);
            nombreUsu = itemView.findViewById(R.id.tvNomItemRVInicio);
            dist = itemView.findViewById(R.id.tvDistItemRVInicio);
            descripAnun = itemView.findViewById(R.id.tvAnunItemRVInicio);
        }

        public void bindItem(Anuncio anuncio) {
            imagenUsu.setImageResource(anuncio.getUsuario().getIdImagen());
            nombreUsu.setText(anuncio.getUsuario().getNombre());
            dist.setText(anuncio.getUsuario().getBarrio());
            descripAnun.setText(anuncio.getDescripAnun());
        }


    }


}
