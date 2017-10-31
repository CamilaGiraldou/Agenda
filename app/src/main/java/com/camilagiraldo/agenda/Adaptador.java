package com.camilagiraldo.agenda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 31/10/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderLibros>{

    Context context;
    ArrayList<User> listaLibros;

    public Adaptador(Context context, ArrayList<User> listaLibros) {
        this.context = context;
        this.listaLibros = listaLibros;
    }

    @Override
    public ViewHolderLibros onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderLibros(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolderLibros holder, int position) {
        User item = listaLibros.get(position);
        holder.asignardatos(item, context);
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    public class ViewHolderLibros extends RecyclerView.ViewHolder {

        TextView id, nombre, telefono, libro;

        public ViewHolderLibros(View itemView) {
            super(itemView);
            id= (TextView) itemView.findViewById(R.id.idlibro);
            libro= (TextView) itemView.findViewById(R.id.libro);
            nombre= (TextView) itemView.findViewById(R.id.nombre);
            telefono= (TextView) itemView.findViewById(R.id.telefono);

        }

        public void asignardatos(User user, Context context) {
            //dato.setText(datos);
            id.setText(user.getId());
            nombre.setText(user.getNombre());
            telefono.setText(user.getTelefono());
            libro.setText(user.getLibro());
        }
    }
}
