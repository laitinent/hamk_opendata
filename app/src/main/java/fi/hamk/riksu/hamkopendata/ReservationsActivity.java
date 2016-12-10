package fi.hamk.riksu.hamkopendata;

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

public class ReservationsActivity extends AppCompatActivity {
    ReservationsAdapter itemsAdapter;
    JSONObject jsonBody;
    JSONArray groups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        final EditText txtProduct = (EditText) findViewById(R.id.etReservation);
        final ListView listView = (ListView)findViewById(R.id.lvReservations);
//
        txtProduct.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode == EditorInfo.IME_ACTION_SEARCH ||
                        keyCode == EditorInfo.IME_ACTION_DONE ||
                        keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                                keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)
                {


        String url = "https://opendata.hamk.fi:8443/r1/reservation/search";
        groups = new JSONArray();
        groups.put(txtProduct.getText().toString());
        try {
            jsonBody = new JSONObject();
            jsonBody.put("startDate", OpendataHelper.getCurrentDateString(0));
            jsonBody.put("endDate", OpendataHelper.getCurrentDateString(7));
            jsonBody.put("studentGroup", groups);
        }
        catch (JSONException ex){System.err.println(ex.getMessage());}

        final GsonPostRequest jsObjRequest = new GsonPostRequest<>(url, Reservations.class, jsonBody,
                new Response.Listener<Reservations>() {
                    @Override
                    public void onResponse(Reservations response) {
                        //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                        itemsAdapter =new ReservationsAdapter(ReservationsActivity.this, response.getReservations());
                        listView.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(ReservationsActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        MySingleton.getInstance(ReservationsActivity.this).addToRequestQueue(jsObjRequest);
                    txtProduct.clearFocus();
                    return true;
                }
                return false;
            }
        });
        //
    }

}
