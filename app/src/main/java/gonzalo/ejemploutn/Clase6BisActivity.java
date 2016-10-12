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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login_ok);
        Intent intentoRecibido = getIntent();
        Bundle extrasRecibidos = intentoRecibido.getExtras();
        nombreRecibido = extrasRecibidos.getString("nombre");
        findViews();
        setUI();
    }

    void findViews()
    {
       textView_nombre = (TextView)findViewById(R.id.textView_nombre);
    }

    void setUI()
    {
        textView_nombre.setText("Mi nombre es: "+nombreRecibido);
    }

}
