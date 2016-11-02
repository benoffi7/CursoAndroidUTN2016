package gonzalo.ejemploutn;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gonzalo.ejemploutn.objetos.Casa;

/**
 * Created by Gonzalo on 01/11/2016.
 */

public class Clase9 extends Activity
{
    ArrayList<Casa>calle;
    private EditText editText_nombre;
    private EditText editText_ambientes;
    private CheckBox checkBox_dept;
    private EditText editText_precio;
    private Button button_guardar;
    private TextView textView_ult;
    private TextView textView_cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clase9);
        //inicializo la calle (coleccion de casas)
        calle = new ArrayList<>();
        //inicializo componentes
        findViews();
        //seteo evento del boton
        setEvents();
        //seteoUI
        setUI();


        /*
        Casa miCasa = new Casa();
        Casa otraCasa = new Casa();

        miCasa.setCalle("salta 2589");

        miCasa.setCantidadHabitaciones(3);
        miCasa.setPrecio(1.5);

        otraCasa.setCalle("calle falsa 123");
        otraCasa.setPrecio(3.9);
        otraCasa.setCantidadHabitaciones(10);

        Log.d("miApp","Calle: "+otraCasa.getCalle()+" Precio: "+otraCasa.getPrecio()+" Cantidad de habitaciones: "+otraCasa.getCantidadHabitaciones());
        Log.d("miApp","Calle: "+miCasa.getCalle()+" Precio: "+miCasa.getPrecio()+" Cantidad de habitaciones: "+miCasa.getCantidadHabitaciones());

        ArrayList<Casa>calle=new ArrayList<>();
        calle.add(miCasa);
        calle.add(otraCasa);

        Log.d("miApp","La cantidad de casas es de "+calle.size());

        Casa casaBuscada = calle.get(0);

        for (Casa casaTemp : calle)
        {
            Log.d("miApp","Calle: "+casaTemp.getCalle()+" Precio: "+casaTemp.getPrecio()+" Cantidad de habitaciones: "+casaTemp.getCantidadHabitaciones());
        }
        */

    }

    void findViews()
    {
        editText_nombre = (EditText)findViewById(R.id.editText_nombre);
        editText_ambientes = (EditText)findViewById(R.id.editText_ambientes);
        checkBox_dept = (CheckBox)findViewById(R.id.checkBox_dept);
        editText_precio  = (EditText)findViewById(R.id.editText_precio);
        button_guardar = (Button)findViewById(R.id.button_guardar);
        textView_ult = (TextView)findViewById(R.id.textView_ult);
        textView_cantidad = (TextView)findViewById(R.id.textView_cantidad);
    }

    void setEvents()
    {
        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //pregunto si NO hay errores en la interfaz
                if (!errores()) {
                    //creo un objeto casa
                    Casa casaAUX = new Casa();
                    //seteo sus atributos
                    casaAUX.setCantidadHabitaciones(Integer.parseInt(editText_ambientes.getText().toString()));//convierto un String en un entero
                    casaAUX.setCalle(editText_nombre.getText().toString());
                    casaAUX.setPrecio(Double.parseDouble(editText_precio.getText().toString()));//convierto un String en un double
                    casaAUX.setDepartamento(checkBox_dept.isChecked());
                    //lo cargo en la lista
                    calle.add(casaAUX);
                    //llamo a la funcion para actualizar el textview que muestra la cantidad
                    setUI();
                    //llamo a la funcion para ver los datos cargados
                    showCasa(casaAUX);
                    //limpio las cajas de texto
                    clearEdits();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"hay errores",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void setUI()
    {
        textView_cantidad.setText("Cantidad de elementos: "+calle.size());
    }

    void showCasa(Casa casaRecibida)
    {
        String departamento = "";
        //consulto sobre el atributo *departamento* y si es true cargo con un valor la variable local *departamento
        if (casaRecibida.isDepartamento())
        {
            departamento = "Tiene deparamento";
        }
        else
        {
            departamento = "No tiene departamento";
        }
        textView_ult.setText("Ultima casa:\nCalle: "+casaRecibida.getCalle()+"\nHabitaciones: "+casaRecibida.getCantidadHabitaciones()+"\nPrecio: $ "+casaRecibida.getPrecio()+"\n"+departamento);
    }

    void clearEdits()
    {
        editText_ambientes.getText().clear();
        editText_nombre.getText().clear();
        editText_precio.getText().clear();
        checkBox_dept.setChecked(false);
        //muevo el cursor hacia el nombre de la calle
        editText_nombre.requestFocus();
    }

    boolean errores()
    {
        //pregunto sobre la cantidad de caracteres en cada caja de texto
        if (editText_nombre.getText().toString().length()==0) return  true;
        if (editText_ambientes.getText().toString().length()==0) return  true;
        if (editText_precio.getText().toString().length()==0)return  true;
        //si no entro en ninguna condicion retorno falso o sea que NO hay errores
        return  false;
    }
}
