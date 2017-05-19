package fi.hamk.riksu.hamkopendata;

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

import fi.hamk.riksu.hamkopendata.databinding.ActivityRealizationsBinding;


public class RealizationsActivity extends AppCompatActivity {
    ActivityRealizationsBinding binding;
    RealizationsAdapter itemsAdapter;
    JSONObject jsonBody = new JSONObject();
    JSONArray groups = new JSONArray();
    GsonPostRequest jsObjRequest;
    String url = OpendataHelper.REALIZATIONS_URL; //"https://opendata.hamk.fi:8443/r1/realization/search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_realizations);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_realizations);

        binding.etGroup.setOnKeyListener((view, keyCode, keyEvent) -> {
            if(keyCode == EditorInfo.IME_ACTION_SEARCH ||
                    keyCode == EditorInfo.IME_ACTION_DONE ||
                    keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                            keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)
            {
                groups = new JSONArray();
                groups.put(binding.etGroup.getText().toString());
                try {
                    // Search criteria: starting from today
                    jsonBody = new JSONObject();
                    jsonBody.put("startDate", OpendataHelper.getCurrentDateString(0));
                    //jsonBody.put("endDate", OpendataHelper.getCurrentDateString(0));
                    jsonBody.put("studentGroups", groups);

                    jsObjRequest = new GsonPostRequest<>(url, Realizations.class, jsonBody,
                            response -> {
                                //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                                itemsAdapter = new RealizationsAdapter(RealizationsActivity.this, response.getRealizations());
                                binding.lvRealizations.setAdapter(itemsAdapter);
                            },

                            error -> {
                                System.err.println(error.getMessage());
                                Toast.makeText(RealizationsActivity.this, "Virhe: " + error.getMessage(), Toast.LENGTH_LONG).show();
                            });

                } catch (JSONException ex) {
                    System.err.println(ex.getMessage());
                }
                MySingleton.getInstance(RealizationsActivity.this).addToRequestQueue(jsObjRequest);
                binding.etGroup.clearFocus();
                return true;
            }
            return false;
        });
    }
}
