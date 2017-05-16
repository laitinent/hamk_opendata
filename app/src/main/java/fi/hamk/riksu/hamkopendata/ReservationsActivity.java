package fi.hamk.riksu.hamkopendata;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fi.hamk.riksu.hamkopendata.databinding.ActivityReservationsBinding;

public class ReservationsActivity extends AppCompatActivity {
    ReservationsAdapter itemsAdapter;
    JSONObject jsonBody;
    JSONArray groups;
    Context me;
    ActivityReservationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reservations);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reservations);

        //final EditText txtProduct = (EditText) findViewById(R.id.etReservation);
        //final ListView listView = (ListView) findViewById(R.id.lvReservations);

        me = this;
        Intent i = getIntent();
        // getting attached intent data
        final String url = i.getStringExtra("url");
//
        binding.etReservation.setOnKeyListener((view, keyCode, keyEvent) -> {
            if (keyCode == EditorInfo.IME_ACTION_SEARCH ||
                    keyCode == EditorInfo.IME_ACTION_DONE ||
                    keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                    keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                //String url = "https://opendata.hamk.fi:8443/r1/reservation/search";
                groups = new JSONArray();
                groups.put(binding.etReservation.getText().toString());
                try {
                    // Search for given student group current week schedule
                    jsonBody = new JSONObject();
                    jsonBody.put("startDate", OpendataHelper.getCurrentDateString(0));
                    jsonBody.put("endDate", OpendataHelper.getCurrentDateString(7));
                    jsonBody.put("studentGroup", groups);
                } catch (JSONException ex) {
                    System.err.println(ex.getMessage());
                }

                final GsonPostRequest jsObjRequest = new GsonPostRequest<>(url, Reservations.class, jsonBody,
                        response -> {
                            //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                            itemsAdapter = new ReservationsAdapter(me, response.getReservations());
                            binding.lvReservations.setAdapter(itemsAdapter);
                        },

                        error -> OpendataHelper.printToastErr(me,error.getMessage())
                        );
                            /*)
                            System.err.println(error.getMessage());
                            Toast.makeText(me, "Virhe: " + error.getMessage(), Toast.LENGTH_LONG).show();*/

                MySingleton.getInstance(me).addToRequestQueue(jsObjRequest);
                binding.etReservation.clearFocus();
                return true;
            }
            return false;
        });
    }
}
