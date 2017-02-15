package fi.hamk.riksu.hamkopendata;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fi.hamk.riksu.hamkopendata.databinding.ActivityCurriculumsBinding;

import static fi.hamk.riksu.hamkopendata.OpendataHelper.*;


public class CurriculumsActivity extends AppCompatActivity {
    RelationAdapter itemsAdapter;
    List<Relation> lsAllRelations = null;
    ArrayList<Relation> lsRelations = new ArrayList<>();

    ActivityCurriculumsBinding binding;
    JSONObject jsonBody;
    GsonPostRequest jsObjRequest;
    GsonRequest jsObjRequest2;

    String latestName = "";

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
                            if (binding.checkBox.isChecked() == true || latestName.compareTo("") != 0) {
                                String strCompare = "";
                                for (Relation r : lsAllRelations) {

                                    if (r.getLearningUnit().getType().compareTo("STUDY_MODULE") == 0) {
                                        lsRelations.add(r);
                                        strCompare = r.getLearningUnit().getName();
                                        System.out.println("CM1 "+strCompare);
                                    }
                                    // show on list also other types after clicked module name

                                    if (strCompare.compareTo(latestName) == 0) {
                                        lsRelations.add(r);
                                        System.out.println("CM2 "+strCompare);
                                    }
                                }
                            } else {
                                lsRelations.addAll(lsAllRelations);
                            }
                            latestName = "";
                            itemsAdapter = new RelationAdapter(CurriculumsActivity.this, lsRelations, false);
                            binding.lvCurriculums.setAdapter(itemsAdapter);
                        }
                    }
                },
                rError_func
        );


// kun moduulia klikataan?

        binding.lvCurriculums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Relation listItem = (Relation) adapterView.getItemAtPosition(i);
                if (listItem.getLearningUnit().getType().compareTo("STUDY_MODULE") == 0)
                {
                    latestName = listItem.getLearningUnit().getName();
                    System.out.println("L.N."+latestName);
                }
/*                Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity
                intent.putParcelableArrayListExtra("product", (ArrayList<? extends Parcelable>) listItem.getStructureViews().get(0).getRelations());
                startActivity(intent);*/

                String url2 = COURSEUNIT_URL + listItem.getLearningUnit().getId();
                System.out.println(listItem.getId()+", "+listItem.getLearningUnit().getId());
                jsObjRequest2 = new GsonRequest<>(url2, CourseUnitSearch.class, null,
                        new Response.Listener<CourseUnitSearch>() {
                            @Override
                            public void onResponse(CourseUnitSearch response) {

                                if (listItem.getLearningUnit().getType().compareTo("COURSE_UNIT") == 0)
                                {
                                    ShowAlertDialog(response.getCourseUnits().get(0).getContent(),
                                            response.getCourseUnits().get(0).getName(), CurriculumsActivity.this);
                                    /*
                                        Intent intent = new Intent(getApplicationContext(), CourseUnitSearch.class);
                                        // sending data to new activity
                                        intent.putExtra("course",url);
                                        startActivity(intent);
                                    */
                                }

                            }
                        },
                        rError_func
                );
                if (listItem.getLearningUnit().getType().compareTo("STUDY_MODULE") != 0) {
                    MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest2);
                }
                else {
                    MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);
                }
            }
        });

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
                hideKeyboardFrom(getApplicationContext(),binding.editText);
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
