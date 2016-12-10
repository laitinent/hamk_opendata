package fi.hamk.riksu.hamkopendata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class CurriculumsActivity extends AppCompatActivity {
    CurriculumsAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        //final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        final ListView listView = (ListView)findViewById(R.id.lvCurriculums);


        String url = "https://opendata.hamk.fi:8443/r1/curriculum/search";
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("codes", "[INTIA15A]");
        }
        catch (JSONException ex){System.err.println(ex.getMessage());}

        final GsonPostRequest jsObjRequest = new GsonPostRequest<>(url, Curriculums.class, jsonBody,
                new Response.Listener<Curriculums>() {
                    @Override
                    public void onResponse(Curriculums response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        itemsAdapter =new CurriculumsAdapter(CurriculumsActivity.this, response.getProgrammes());
                        listView.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(CurriculumsActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);

    }
}
