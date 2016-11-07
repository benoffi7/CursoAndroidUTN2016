package gonzalo.ejemploutn.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gonzalo.ejemploutn.R;
import gonzalo.ejemploutn.objetos.Casa;

public class CasaAdapter extends RecyclerView.Adapter<CasaAdapter.CasaViewHolder>
{
    ArrayList<Casa> MisCasas;

    public CasaAdapter(ArrayList<Casa> CasasDeAfuera){
        this.MisCasas = CasasDeAfuera;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public CasaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_lista, viewGroup, false);
        CasaViewHolder pvh = new CasaViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(CasaViewHolder personViewHolder, int i) {

        personViewHolder.setItem(MisCasas.get(i));
    }


    @Override
    public int getItemCount() {
        return MisCasas.size();
    }


    public static class CasaViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView_nombre;
        TextView textView_cantidad;

        CasaViewHolder(View itemView)
        {
            super(itemView);
            textView_nombre = (TextView)itemView.findViewById(R.id.textView_nombre);
            textView_cantidad = (TextView)itemView.findViewById(R.id.textView_cantidad);
        }

        public void setItem(Casa miCasa)
        {
            textView_nombre.setText(miCasa.getCalle());
            textView_cantidad.setText("Cantidad: "+miCasa.getCantidadHabitaciones());
        }

    }




}