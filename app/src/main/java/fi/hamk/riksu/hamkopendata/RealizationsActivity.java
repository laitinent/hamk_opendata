package fi.hamk.riksu.hamkopendata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class RealizationsActivity extends AppCompatActivity {
    RealizationsAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizations);
        //final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        final ListView listView = (ListView)findViewById(R.id.lvRealizations);


        String url = "https://opendata.hamk.fi:8443/r1/realization/search";
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("startDate", "2016-10-31T00:30");
        }
        catch (JSONException ex){System.err.println(ex.getMessage());}

        final GsonPostRequest jsObjRequest = new GsonPostRequest<>(url, Realizations.class, jsonBody,
                new Response.Listener<Realizations>() {
                    @Override
                    public void onResponse(Realizations response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        itemsAdapter =new RealizationsAdapter(RealizationsActivity.this, response.getRealizations());
                        listView.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(RealizationsActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        MySingleton.getInstance(RealizationsActivity.this).addToRequestQueue(jsObjRequest);
}
}
