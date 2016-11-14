package gonzalo.ejemploutn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import gonzalo.ejemploutn.adaptadores.CasaAdapter;
import gonzalo.ejemploutn.objetos.Casa;

/**
 * Created by Gonzalo on 07/11/2016.
 */

public class lay_listas extends AppCompatActivity implements CasaAdapter.AdapterInterface
{
    EditText editText_ambientes;
    RecyclerView rv;
    private ArrayList<Casa> calle;
    private int cantidad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_listas);
        findViews();
        setUpObjetos();
        setUpEventos();
    }

    void findViews()
    {
        editText_ambientes = (EditText)findViewById(R.id.editText_ambientes);
        rv = (RecyclerView)findViewById(R.id.rv_casas);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    void setUpObjetos()
    {
        Casa miCasa = new Casa();
        Casa otraCasa = new Casa();
        Casa otraOtraCasa = new Casa();
        Casa otraOtraOtraCasa = new Casa();

        miCasa.setCalle("Salta 2589");
        miCasa.setDepartamento(false);
        miCasa.setCantidadHabitaciones(3);
        miCasa.setPrecio(1.5);

        otraOtraCasa.setCalle("Jujuy 8563");
        otraOtraCasa.setDepartamento(false);
        otraOtraCasa.setCantidadHabitaciones(15);
        otraOtraCasa.setPrecio(1.5);

        otraCasa.setCalle("Calle falsa 123");
        otraCasa.setPrecio(3.9);
        otraCasa.setDepartamento(true);
        otraCasa.setCantidadHabitaciones(2);

        otraOtraOtraCasa.setCalle("Calle verdadera 453");
        otraOtraOtraCasa.setPrecio(3.9);
        otraOtraOtraCasa.setDepartamento(true);
        otraOtraOtraCasa.setCantidadHabitaciones(10);

        calle=new ArrayList<>();
        calle.add(miCasa);
        calle.add(otraCasa);
        calle.add(otraOtraCasa);
        calle.add(otraOtraOtraCasa);
    }

    void setUpEventos()
    {
        editText_ambientes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                cantidad = 0;
                if (editText_ambientes.getText().toString().length()>0)
                {
                    cantidad = Integer.parseInt(editText_ambientes.getText().toString());
                }
                setUpLista();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    void setUpLista()
    {
        CasaAdapter adapter = new CasaAdapter(calle,cantidad,this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClickPress(Casa CasaAEnviar)
    {
        Toast.makeText(lay_listas.this, CasaAEnviar.getCalle(),Toast.LENGTH_SHORT).show();
        for (Casa casaAux : calle)
        {
            if (casaAux.getCalle().equals(CasaAEnviar.getCalle()))
            {
                casaAux.setFavorito(!CasaAEnviar.isFavorito());
            }
        }
        setUpLista();
    }
}
