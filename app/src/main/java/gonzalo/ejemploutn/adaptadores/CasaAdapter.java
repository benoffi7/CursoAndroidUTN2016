package gonzalo.ejemploutn.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gonzalo.ejemploutn.R;
import gonzalo.ejemploutn.objetos.Casa;

public class CasaAdapter extends RecyclerView.Adapter<CasaAdapter.CasaViewHolder>
{
    ArrayList<Casa> MisCasas;
    int cantidadRecibida =0;
    AdapterInterface adapterInterface;

    public interface AdapterInterface
    {
        public void onClickPress(Casa CasaAEnviar);
    }

    public CasaAdapter(ArrayList<Casa> CasasDeAfuera,int cantidad, AdapterInterface adapterInterfaceParam){
        this.MisCasas = CasasDeAfuera;
        this.cantidadRecibida = cantidad;
        this.adapterInterface= adapterInterfaceParam;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public CasaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_lista, viewGroup, false);
        CasaViewHolder pvh = new CasaViewHolder(v, cantidadRecibida,adapterInterface);
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
        ImageView imageView_tipodecasa;
        LinearLayout ll_root;
        AdapterInterface adapterInterface;
        Context contexto;
        int cantidad = 0;

        CasaViewHolder(View itemView, int cantidadDeAfuera, AdapterInterface adapterInterfaceParam)
        {
            super(itemView);
            textView_nombre = (TextView)itemView.findViewById(R.id.textView_nombre);
            textView_cantidad = (TextView)itemView.findViewById(R.id.textView_cantidad);
            imageView_tipodecasa = (ImageView)itemView.findViewById(R.id.imageView_tipodecasa);
            ll_root = (LinearLayout)itemView.findViewById(R.id.ll_root);//contenedor raiz de nuestro XML

            //necesario para acceder al metodo getResources()
            contexto = itemView.getContext();

            //nuevos parametros recibidos desde el adaptador
            adapterInterface = adapterInterfaceParam;
            cantidad = cantidadDeAfuera;
        }

        public void setItem(final Casa miCasa)
        {
            String fav = "";

            if (miCasa.isFavorito())
            {
                fav = "\n"+"FAV";//agrega un salto de linea y la palabra FAV SI la casa la marcamos como favorita
            }

            textView_nombre.setText(miCasa.getCalle()+fav);

            if (miCasa.isDepartamento())//evaluamos el tipo de casa
            {
                imageView_tipodecasa.setImageDrawable(contexto.getResources().getDrawable(R.drawable.departamento));
            }
            else
            {
                imageView_tipodecasa.setImageDrawable(contexto.getResources().getDrawable(R.drawable.casa));
            }

            if (miCasa.getCantidadHabitaciones()>=cantidad)//evaluamos la cantidad de habitaciones
            {
                    textView_cantidad.setTextColor(contexto.getResources().getColor(R.color.colorPrimary));
            }
            else
            {
                textView_cantidad.setTextColor(contexto.getResources().getColor(R.color.colorAccent));
            }

            textView_cantidad.setText("Cantidad: "+miCasa.getCantidadHabitaciones());

            //onClick de nuestro renglon
            ll_root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    //llamado a la interface y le enviamos la casa actual.
                    adapterInterface.onClickPress(miCasa);
                }
            });
        }
    }
}