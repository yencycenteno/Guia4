package Adaptadores;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guia4materialdesign.R;

import java.util.List;

import Entidades.Contacto;

public class AdaptadorContactos extends RecyclerView.Adapter<AdaptadorContactos.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txvNombre, txvNumero, txvOrganizacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvNombre = itemView.findViewById(R.id.txvNombre);
            txvNumero = itemView.findViewById(R.id.txvNumero);
            txvOrganizacion = itemView.findViewById(R.id.txvOrganizacion);
        }
    }

    public List<Contacto> lstContactos;

    public AdaptadorContactos(List<Contacto> lstContactos){
        this.lstContactos = lstContactos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txvNombre.setText(this.lstContactos.get(position).getNombre());
        holder.txvNumero.setText(this.lstContactos.get(position).getNumero());
        holder.txvOrganizacion.setText(this.lstContactos.get(position).getOrganizacion());
    }

    @Override
    public int getItemCount() {
        return this.lstContactos.size();
    }

}
