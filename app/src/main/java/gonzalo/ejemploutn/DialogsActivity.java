package gonzalo.ejemploutn;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import gonzalo.ejemploutn.Dialog.DialogListaMultiple;
import gonzalo.ejemploutn.Dialog.DialogListaSimple;
import gonzalo.ejemploutn.Dialog.DialogMisiles;

/**
 * Created by Gonzalo on 07/12/2016.
 */

public class DialogsActivity  extends AppCompatActivity
{
    Button button_simple;
    Button button_lista_simple;
    Button button_lista_multiple;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        findViews();
        setEvents();
    }

    void findViews()
    {
        button_simple = (Button)findViewById(R.id.button_simple);
        button_lista_simple = (Button)findViewById(R.id.button_lista_simple);
        button_lista_multiple = (Button)findViewById(R.id.button_lista_multiple);
    }

    void setEvents()
    {
        button_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Misiles();
            }
        });
        button_lista_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaSimple();
            }
        });
        button_lista_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaMultiple();
            }
        });
    }

    public void Misiles()
    {
        DialogFragment newFragment = new DialogMisiles();
        newFragment.show(getFragmentManager(), "DialogMisiles");
    }

    public void ListaSimple()
    {
        DialogFragment newFragment = new DialogListaSimple();
        newFragment.show(getFragmentManager(), "DialogListaSimple");
    }

    public void ListaMultiple()
    {
        DialogFragment newFragment = new DialogListaMultiple();
        newFragment.show(getFragmentManager(), "DialogListaMultiple");
    }


}
