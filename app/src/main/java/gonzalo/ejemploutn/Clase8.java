package gonzalo.ejemploutn;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Gonzalo on 26/10/2016.
 */

public class Clase8 extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevos_controles);

        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        ImageView imageView3 = (ImageView)findViewById(R.id.imageView3);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.gruporadio);

        boolean marcado = checkBox.isChecked();
        if (marcado)
        {
            Toast.makeText(getApplicationContext(), "Estoy marcado",Toast.LENGTH_SHORT).show();
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        checkBox.setChecked(true);
        checkBox.setChecked(false);

        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.imagen));
        imageView3.setScaleType(ImageView.ScaleType.CENTER);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                RadioButton rb = (RadioButton)radioGroup.findViewById(i);
                Toast.makeText(Clase8.this,"marco: "+rb.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        RadioButton rb_aux = (RadioButton) radioGroup.getChildAt(0);

        if (rb_aux.getId() == R.id.radioButton)
            

        rb_aux.setChecked(true);

        RadioButton rb = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(Clase8.this,"marco: "+rb.getText(),Toast.LENGTH_SHORT).show();

        rb.setVisibility(View.INVISIBLE);
        rb.setEnabled(true);

    }
}
