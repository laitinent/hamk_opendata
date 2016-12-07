package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class RealizationsActivity extends AppCompatActivity {
    RealizationsAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizations);
        //final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        final ListView listView = (ListView)findViewById(R.id.lvRealizations);

        //MyString s= new MyString();

        //Toast.makeText(RealizationsActivity.this,s.getRealizations().getMessage(),Toast.LENGTH_LONG).show();

        //Intent i = getIntent();
        // getting attached intent data
        //String product = i.getStringExtra("product");
        // displaying selected product name
        //txtProduct.setText(product);

        //String url = "https://opendata.hamk.fi:8443/r1/realization/search";
        String url = "https://opendata.hamk.fi:8443/r1/reservation/search";

        final GsonPostRequest jsObjRequest = new GsonPostRequest<>(url, Reservations.class, null,
                new Response.Listener<Reservations>() {
                    @Override
                    public void onResponse(Reservations response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        itemsAdapter =new RealizationsAdapter(RealizationsActivity.this, response.getReservations());
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
