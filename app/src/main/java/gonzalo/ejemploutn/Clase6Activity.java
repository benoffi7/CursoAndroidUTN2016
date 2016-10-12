package gonzalo.ejemploutn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gonzalo on 12/10/2016.
 */

public class Clase6Activity extends Activity
{
    EditText editText_name;
    EditText editText_pass;
    Button button_login;

    String password = "gonzalo";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login);
        findViews();
        setEvents();
    }

    void findViews()
    {
        editText_name = (EditText)findViewById(R.id.editText_name);
        editText_pass = (EditText)findViewById(R.id.editText_pass);
        button_login = (Button)findViewById(R.id.button_login);
    }

    void setEvents()
    {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (passwordCorrecto())
                {
                    Toast.makeText(getApplicationContext(),"Ingreso correcto",Toast.LENGTH_SHORT).show();
                    if (editText_name.getText().toString().length()==0)
                    {
                        Toast.makeText(getApplicationContext(),"No ingreso el nombre",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent intent = new Intent(Clase6Activity.this, Clase6BisActivity.class);
                        intent.putExtra("nombre", editText_name.getText().toString());
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Ingreso incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

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
}
