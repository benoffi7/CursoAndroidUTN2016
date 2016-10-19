package gonzalo.ejemploutn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gonzalo on 12/10/2016.
 */

public class Clase6BisActivity extends Activity
{
    TextView textView_nombre;
    String nombreRecibido = "";
    int edadRecibida ;


    void findViews()
    {
        //nada raro over here solo guardo en mi variable java el componente XML
       textView_nombre = (TextView)findViewById(R.id.textView_nombre);
    }

    void setUI()
    {
        //utilizando el seteo de una propiedad texto del textview, le asigno el nombre que recibi
        textView_nombre.setText("Mi nombre es: "+nombreRecibido);
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login_ok);
        //levanto camion
        Intent intentoRecibido = getIntent();
        //levanto acoplado
        Bundle extrasRecibidos = intentoRecibido.getExtras();
        //levanto UNA cajita con NOMBRE como clave...recordar usar el metodo getString si envie una cadena de carateres o getInt si es un numero
        nombreRecibido = extrasRecibidos.getString("nombre");
        edadRecibida = extrasRecibidos.getInt("edad");
        //invocacion a mis funciones...
        findViews();
        setUI();
    }
}
