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

public class ResultBusqVecAdapter extends RecyclerView.Adapter<ResultBusqVecAdapter.ResultBusqVecViewHolder> implements View.OnClickListener {

    private ArrayList<Anuncio> datos;
    private View.OnClickListener listener;

    public ResultBusqVecAdapter(ArrayList<Anuncio> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ResultBusqVecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_material_usuario_busqvec, parent, false);
        v.setOnClickListener(this);
        ResultBusqVecAdapter.ResultBusqVecViewHolder rbvvh = new ResultBusqVecAdapter.ResultBusqVecViewHolder(v);
        return rbvvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultBusqVecViewHolder holder, int position) {
        holder.bindItem(datos.get(position).getUsuario());
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

    public static class ResultBusqVecViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenUsu;
        private TextView nombreUsu;
        private TextView dist;


        public ResultBusqVecViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenUsu = itemView.findViewById(R.id.imgItemRVResultBusqVec);
            nombreUsu = itemView.findViewById(R.id.tvNomItemRVResultBusqVec);
            dist = itemView.findViewById(R.id.tvDistItemRVResultBusqVec);
        }

        public void bindItem(Usuario usuario) {
            imagenUsu.setImageResource(usuario.getIdImagen());
            nombreUsu.setText(usuario.getNombre());
            dist.setText(usuario.getBarrio());
        }


    }


}
