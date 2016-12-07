package gonzalo.ejemploutn.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import gonzalo.ejemploutn.R;

/**
 * Created by Gonzalo on 07/12/2016.
 */

public class DialogListaSimple extends DialogFragment
{


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Lista")
                .setItems(R.array.valores_array_uno, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String[] arreglo = getActivity().getResources().getStringArray(R.array.valores_array_uno);
                        Toast.makeText(getActivity(),"Se hizo click en "+arreglo[which]+" y en la pos "+which,Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}