package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class SingleListItem extends AppCompatActivity {
    UsersAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_list_item);
        final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        final ListView listView = (ListView)findViewById(R.id.lvDetails);


        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        txtProduct.setText(product);

        String url = "https://opendata.hamk.fi:8443/r1/reservation/building/";


        final GsonRequest jsObjRequest = new GsonRequest<>(url+product, Buildings.class, null,
                new Response.Listener<Buildings>() {
                    @Override
                    public void onResponse(Buildings response) {
                        txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        itemsAdapter =new UsersAdapter(SingleListItem.this, response.getResources());
                        listView.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(SingleListItem.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


                MySingleton.getInstance(SingleListItem.this).addToRequestQueue(jsObjRequest);


    }
}
