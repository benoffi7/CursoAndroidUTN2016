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

public class Clase6Activity extends Activity
{
    //espacio de declaracion de variables tanto de XML como auxiliares
    EditText editText_name;
    EditText editText_pass;
    Button button_login;

    String password = "gonzalo";

    //metodo que se invoca AUTOMATICAMENTE al crearse la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //establezco la vista
        setContentView(R.layout.lay_login);
        //invoco a mis funciones
        findViews();
        setEvents();
    }

    //aqui hago la relacion entre los componentes XML con mis variables JAVA
    void findViews()
    {

        //una variable por cada control. el nombre de las mismas deberia ser igual al id del componente XML...
        editText_name = (EditText)findViewById(R.id.editText_name);
        editText_pass = (EditText)findViewById(R.id.editText_pass);
        button_login = (Button)findViewById(R.id.button_login);
    }

    //seteo de eventos, en este caso solo del boto
    void setEvents()
    {
       button_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
               //si no tengo error
               if (passwordCorrecto())
               {
                   //estoy mostrando un cartelito. el primero es....
                   Toast.makeText(getApplicationContext(),getString(R.string.texto1),Toast.LENGTH_SHORT).show();
                   String nombre;
                   //copio el contenido de mi caja de texto a una variable local...
                   nombre = editText_name.getText().toString();
                   //evaluo si el nombre tiene caracteres o no...
                   if (nombre.length()==0)
                   {
                       Toast.makeText(getApplicationContext(),"No ingreso el nombre",Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       //lanzo otra actividad con el NOMBRE como extra...recordar camion,acoplado y cajitas
                       Intent intent = new Intent(Clase6Activity.this, Clase6BisActivity.class);
                       intent.putExtra("nombre", editText_name.getText().toString());
                       startActivity(intent);
                   }
               }
               else
               {
                   //muestro de mensaje de error
                   Toast.makeText(getApplicationContext(),"Ingreso incorrecto",Toast.LENGTH_SHORT).show();
               }
           }
       });
    }

    //funcion que retorna verdadero o falso segun si la caja de texto tiene lo que guarde en la variable java llamada password
    //equals es un metodo de java que evalua un String (cadena de caracteres) con otra
    boolean passwordCorrecto()
    {
        if (password.equals(editText_pass.getText().toString()))
        {
            return  true;
        }
        else
        {
            return  false;
        }
    }

    // este metodo se ejecuta cuando vuelvo por segunda vez a esta actividad
    @Override
    protected void onResume() {
        super.onResume();
        //limpio la caja de texto
        editText_pass.getText().clear();

    }
}
