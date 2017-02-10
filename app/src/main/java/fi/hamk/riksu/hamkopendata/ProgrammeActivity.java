package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import fi.hamk.riksu.hamkopendata.databinding.ActivityProgrammeBinding;


public class ProgrammeActivity extends AppCompatActivity {
    RelationAdapter itemsAdapter;
    ActivityProgrammeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_programme);
        //final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        //final ListView listView = (ListView)findViewById(R.id.lvDetails);


        Intent i = getIntent();
        // getting attached intent data
        //List<Relation> product = i.getParcelableArrayListExtra("product");

        String url = "https://opendata.hamk.fi:8443/r1/reservation/building/";

        //itemsAdapter =new RelationAdapter(ProgrammeActivity.this, product);
        binding.lvProgramme.setAdapter(itemsAdapter);
        /*
        final GsonRequest jsObjRequest = new GsonRequest<>(url+product, Buildings.class, null,
                new Response.Listener<Buildings>() {
                    @Override
                    public void onResponse(Buildings response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        itemsAdapter =new UsersAdapter(ProgrammeActivity.this, response.getResources());
                        binding.lvDetails.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(ProgrammeActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        MySingleton.getInstance(ProgrammeActivity.this).addToRequestQueue(jsObjRequest);
        */
    }

}
