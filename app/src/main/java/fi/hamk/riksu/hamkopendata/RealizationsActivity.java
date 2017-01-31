package fi.hamk.riksu.hamkopendata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RealizationsActivity extends AppCompatActivity {
    RealizationsAdapter itemsAdapter;
    JSONObject jsonBody = new JSONObject();
    JSONArray groups = new JSONArray();
    GsonPostRequest jsObjRequest;
    String url = "https://opendata.hamk.fi:8443/r1/realization/search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizations);
        final EditText txtProduct = (EditText) findViewById(R.id.etGroup);
        final ListView listView = (ListView) findViewById(R.id.lvRealizations);


        txtProduct.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode == EditorInfo.IME_ACTION_SEARCH ||
                        keyCode == EditorInfo.IME_ACTION_DONE ||
                        keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                                keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)
                {
                    groups = new JSONArray();
                    groups.put(txtProduct.getText().toString());
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("startDate", OpendataHelper.getCurrentDateString(0));
                        //jsonBody.put("endDate", OpendataHelper.getCurrentDateString(0));
                        jsonBody.put("studentGroups", groups);
                        jsObjRequest = new GsonPostRequest<>(url, Realizations.class, jsonBody,
                                new Response.Listener<Realizations>() {
                                    @Override
                                    public void onResponse(Realizations response) {
                                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                                        itemsAdapter = new RealizationsAdapter(RealizationsActivity.this, response.getRealizations());
                                        listView.setAdapter(itemsAdapter);
                                    }
                                },

                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        System.err.println(error.getMessage());
                                        Toast.makeText(RealizationsActivity.this, "Virhe: " + error.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });

                    } catch (JSONException ex) {
                        System.err.println(ex.getMessage());
                    }
                    MySingleton.getInstance(RealizationsActivity.this).addToRequestQueue(jsObjRequest);
                    txtProduct.clearFocus();
                    return true;
                }
                return false;
            }
        });

    }


}