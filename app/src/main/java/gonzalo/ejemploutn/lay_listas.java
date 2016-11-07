package gonzalo.ejemploutn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import gonzalo.ejemploutn.adaptadores.CasaAdapter;
import gonzalo.ejemploutn.objetos.Casa;

/**
 * Created by Gonzalo on 07/11/2016.
 */

public class lay_listas extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_listas);
        //recupero el RecyclerView
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_casas);
        rv.setLayoutManager(new LinearLayoutManager(this));


        //creo los objetos y la lista
        Casa miCasa = new Casa();
        Casa otraCasa = new Casa();

        miCasa.setCalle("salta 2589");

        miCasa.setCantidadHabitaciones(3);
        miCasa.setPrecio(1.5);

        otraCasa.setCalle("calle falsa 123");
        otraCasa.setPrecio(3.9);
        otraCasa.setCantidadHabitaciones(10);

        ArrayList<Casa> calle=new ArrayList<>();
        calle.add(miCasa);
        calle.add(otraCasa);

        //creo el adaptador y lo uno con el RecyclerView
        CasaAdapter adapter = new CasaAdapter(calle);
        rv.setAdapter(adapter);
    }
}
