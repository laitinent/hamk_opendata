package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import fi.hamk.riksu.hamkopendata.databinding.ActivityCurriculumsBinding;


public class CurriculumsActivity extends AppCompatActivity {
    RelationAdapter itemsAdapter;
    List<Relation> lsAllRelations = null;
    ArrayList<Relation> lsRelations = new ArrayList<>();


    ActivityCurriculumsBinding binding;
    JSONObject jsonBody;
    GsonPostRequest jsObjRequest, jsObjRequest2;

    Response.ErrorListener rError_func = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.err.println(error.getMessage());
            Toast.makeText(CurriculumsActivity.this, "Virhe: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reservations);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_curriculums);
        //final TextView txtProduct = (TextView) findViewById(R.id.textView2);
        //final ListView listView = (ListView)findViewById(R.id.lvCurriculums);


        final String url = OpendataHelper.CURRICULUMS_URL;//"https://opendata.hamk.fi:8443/r1/curriculum/search";

        // Search criteria
        jsonBody = new JSONObject();
        //JSONArray jsonArray = new JSONArray(); jsonArray.put("INTIA15A");

        jsObjRequest = new GsonPostRequest<>(url, Curriculums.class, jsonBody,
                new Response.Listener<Curriculums>() {
                    @Override
                    public void onResponse(Curriculums response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        // was CurriculumsAdapter
                        if (response.getProgrammes() != null && response.getProgrammes().get(0).getStructureViews().size() > 0) {
                            lsAllRelations = response.getProgrammes().get(0).getStructureViews().get(0).getRelations();
                            lsRelations.clear();
                            if (binding.checkBox.isChecked() == true) {
                                for (Relation r : lsAllRelations) {
                                    if (r.getLearningUnit().getType().compareTo("STUDY_MODULE")==0) {
                                        lsRelations.add(r);
                                    }
                                }
                            }
                            else {
                                lsRelations.addAll(lsAllRelations);
                            }

                            itemsAdapter = new RelationAdapter(CurriculumsActivity.this, lsRelations, false);
                            binding.lvCurriculums.setAdapter(itemsAdapter);
                        }
                    }
                },
                rError_func
        );


// kun moduulia klikataan?
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
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //jsonBody.put("codes",jsonArray);// "[INTIA15A]");
                    jsonBody.put("name", binding.editText.getText().toString());
                    jsObjRequest.setBody(jsonBody);
                } catch (JSONException ex) {
                    System.err.println(ex.getMessage());
                }

                MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);
            }
        });

        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);
            }
        });
    }
}
