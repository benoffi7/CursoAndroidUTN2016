package gonzalo.ejemploutn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import gonzalo.ejemploutn.objetos.Producto;

/**
 * Created by Gonzalo on 30/11/2016.
 */

public class lay_internet extends AppCompatActivity
{
    TextView textView3;
    ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_internet);
        textView3 = (TextView)findViewById(R.id.textView3);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";
        String url_dimar = "http://www.distribuidoradimar.com/ws/?ws=products-list-request&page=1";
        pd = new ProgressDialog(this);
        pd.setMessage("Cargando");
        pd.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_dimar,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        pd.dismiss();
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            int statuscode = jsonResponse.getInt("statuscode");
                            if (statuscode==200)
                            {
                                JSONObject responsedataJSON = jsonResponse.getJSONObject("responsedata");
                                JSONArray productsListJSON = responsedataJSON.getJSONArray("productsList");
                                new Delete().from(Producto.class).execute();
                                for (int i = 0;i<productsListJSON.length();i++)
                                {
                                    JSONObject itemJSON = productsListJSON.getJSONObject(i);
                                    Producto p = new Producto();
                                    p.setProductCode(itemJSON.getString("productCode"));
                                    p.setProductRealCode(itemJSON.getString("productRealCode"));
                                    p.setProductDescription(itemJSON.getString("productDescription"));
                                    p.setProductBrandCode(itemJSON.getString("productBrandCode"));
                                    p.setProductBusinessCode(itemJSON.getString("productBusinessCode"));
                                    p.setProductBrandDescription(itemJSON.getString("productBrandDescription"));
                                    p.setProductIVA(itemJSON.getDouble("productIVA"));
                                    p.setProductPrice(itemJSON.getDouble("productPrice"));
                                    p.setProductModified(itemJSON.getString("productModified"));
                                    p.save();
                                }


                                textView3.setText("Cargados "+productsListJSON.length());

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                pd.dismiss();
                textView3.setText("That didn't work!"+error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
