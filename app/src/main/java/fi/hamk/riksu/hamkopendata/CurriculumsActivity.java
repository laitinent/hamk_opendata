package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import fi.hamk.riksu.hamkopendata.databinding.ActivityReservationsBinding;

public class CurriculumsActivity extends AppCompatActivity {
    RelationAdapter itemsAdapter;
    ActivityReservationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reservations);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reservations);
        //final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        //final ListView listView = (ListView)findViewById(R.id.lvCurriculums);


        String url = OpendataHelper.CURRICULUMS_URL;//"https://opendata.hamk.fi:8443/r1/curriculum/search";

        // Search criteria
        JSONObject jsonBody = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("INTIA15A");
        try {
            jsonBody.put("codes",jsonArray);// "[INTIA15A]");
        }
        catch (JSONException ex){System.err.println(ex.getMessage());}

        final GsonPostRequest jsObjRequest = new GsonPostRequest<>(url, Curriculums.class, jsonBody,
                new Response.Listener<Curriculums>() {
                    @Override
                    public void onResponse(Curriculums response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        // was CurriculumsAdapter
                        itemsAdapter =new RelationAdapter(CurriculumsActivity.this, response.getProgrammes().get(0).getStructureViews().get(0).getRelations());
                        binding.lvReservations.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(CurriculumsActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
/*
        binding.lvReservations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity

                Programme listItem = (Programme) adapterView.getItemAtPosition(i);
                intent.putParcelableArrayListExtra("product", (ArrayList<? extends Parcelable>) listItem.getStructureViews().get(0).getRelations());
                startActivity(intent);
            }
        });
*/
        MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);
    }
}
