package gonzalo.ejemploutn;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Gonzalo on 06/12/2016.
 */

public class PreferenciasActivity extends AppCompatActivity
{
    Button button;
    SeekBar seekBar;
    CheckBox checkBox;
    EditText editText;
    TextView textView_valor;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        findViews();
        setPreferences();
        setEvents();
    }

    void findViews()
    {
        button = (Button)findViewById(R.id.button);
        seekBar= (SeekBar)findViewById(R.id.seekBar);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        editText = (EditText) findViewById(R.id.editText);
        textView_valor = (TextView) findViewById(R.id.textView_valor);
    }

    void setPreferences()
    {
        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        boolean activo = sharedPref.getBoolean("activo",false);
        checkBox.setChecked(activo);
        checkBox.setText(""+activo);

        String texto = sharedPref.getString("texto","Sin texto");
        editText.setText(texto);

        int valor = sharedPref.getInt("numeros",0);
        seekBar.setProgress(valor);
        textView_valor.setText(""+valor);
    }

    void setEvents()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.commit();
                setPreferences();
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("activo", b);
                editor.commit();

                checkBox.setText(""+b);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("numeros", i);
                editor.commit();

                textView_valor.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texto", editText.getText().toString());
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
