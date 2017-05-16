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

    Response.ErrorListener rError_func = error -> {
        System.err.println(error.getMessage());
        Toast.makeText(CurriculumsActivity.this, "Virhe: " + error.getMessage(), Toast.LENGTH_LONG).show();
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
                response -> {
                    //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                    // was CurriculumsAdapter
                    if (response.getProgrammes() != null && response.getProgrammes().get(0).getStructureViews().size() > 0) {
                        lsAllRelations = response.getProgrammes().get(0).getStructureViews().get(0).getRelations();
                        lsRelations.clear();
                        if (binding.checkBox.isChecked() == true || latestName.compareTo("") != 0) {
                            String strCompare = "";
                            for (Relation r : lsAllRelations) {
                                String myType=r.getLearningUnit().getType();
                                if (myType.compareTo("STUDY_MODULE") == 0) {
                                    lsRelations.add(r);
                                    strCompare = r.getLearningUnit().getName();
                                    System.out.println("CM1 " + strCompare);
                                }
                                // show on list also other types after clicked module name

                                if (strCompare.compareTo(latestName) == 0 && myType.compareTo("STUDY_MODULE") != 0) {
                                    lsRelations.add(r);
                                    System.out.println("CM2 " + strCompare);
                                }
                            }
                        } else {
                            lsRelations.addAll(lsAllRelations);
                        }
                        latestName = "";
                        itemsAdapter = new RelationAdapter(CurriculumsActivity.this, lsRelations, false);
                        binding.lvCurriculums.setAdapter(itemsAdapter);
                    }
                },
                rError_func
        );


// kun moduulia klikataan?

        binding.lvCurriculums.setOnItemClickListener(listClickListener);

        // normaali haku, opiskelijaryhmätunnus editText:stä
        binding.button2.setOnClickListener(view -> {
            try {
                //jsonBody.put("codes",jsonArray);// "[INTIA15A]");
                jsonBody.put("name", binding.editText.getText().toString());
                jsObjRequest.setBody(jsonBody);
            } catch (JSONException ex) {
                System.err.println(ex.getMessage());
            }
            MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);
            hideKeyboardFrom(getApplicationContext(), binding.editText);
        });

        // hae uudelleen - näyttää vain moduulit, jos rasti ruudussa
        binding.checkBox.setOnCheckedChangeListener((compoundButton, b) -> MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest));
    }

    AdapterView.OnItemClickListener listClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            final Relation listItem = (Relation) adapterView.getItemAtPosition(i);
            final LearningUnit lUnit = listItem.getLearningUnit();

            // find previous STUDY_MODULE (next from that has Objective set)
            int j = i > 3 ? -4 : -i;

            for (; j < 0; j++) {
                System.out.println(j + ".");
                if (((Relation) adapterView.getItemAtPosition(i + j)).getLearningUnit().getType().compareTo("STUDY_MODULE") == 0)
                    break;
            }

            // TODO: tarkista vielä pienillä numeroilla, nyt fix= try-catch

            if (lUnit.getType().compareTo("STUDY_MODULE") == 0 &&
                    latestName.compareTo(lUnit.getName()) != 0) {
                System.out.println("L.N." + latestName + "/" + lUnit.getName() + ".");
                latestName = lUnit.getName();
            }
/*                Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity
                intent.putParcelableArrayListExtra("product", (ArrayList<? extends Parcelable>) listItem.getStructureViews().get(0).getRelations());
                startActivity(intent);*/

            String url2 = COURSEUNIT_URL + //lUnit.getId();
                    ((Relation) adapterView.getItemAtPosition(i + j + 1)).getLearningUnit().getId();//
            System.out.println(listItem.getId() + ", " + lUnit.getId() + " index=" + (i + j + 1) + "/i=" + i);
            jsObjRequest2 = new GsonRequest<>(url2, CourseUnitSearch.class, null,
                    response -> {
                        //if (lUnit.getType().compareTo("COURSE_UNIT") == 0)
                        {
                            try {
                                ShowAlertDialog(response.getCourseUnits().get(0).getObjective(),
                                        response.getCourseUnits().get(0).getName(), CurriculumsActivity.this);
                            } catch (NullPointerException ex) {
                                System.err.println(ex.getMessage());
                            }
                                /*
                                    Intent intent = new Intent(getApplicationContext(), CourseUnitSearch.class);
                                    // sending data to new activity
                                    intent.putExtra("course",url);
                                    startActivity(intent);
                                */
                        }
                    },
                    rError_func
            );
            if (lUnit.getType().compareTo("COURSE_UNIT") == 0 || !binding.checkBox.isChecked()) {
                // haku courses -liittymästä
                MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest2);
                System.out.println("CR: " + listItem.getLearningUnit().getType());
            } else {
                MySingleton.getInstance(CurriculumsActivity.this).addToRequestQueue(jsObjRequest);
            }
        }
    };

}
