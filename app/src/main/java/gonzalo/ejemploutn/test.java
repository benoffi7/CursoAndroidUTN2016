package gonzalo.ejemploutn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gonzalo on 12/10/2016.
 */

public class test extends Activity
{
    String nombre;
    int edad;
    String apellido;
    boolean situacion;

    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);


        /*

        nombre = "gonzalo";
        edad = 28;

        Intent intento = new Intent(test.this,Clase6Activity.class);
        intento.putExtra("nombre",nombre);
        intento.putExtra("apellido",apellido);
        intento.putExtra("edad",edad);
        intento.putExtra("trabajo",situacion);
        startActivity(intento);

        */
    }
}
