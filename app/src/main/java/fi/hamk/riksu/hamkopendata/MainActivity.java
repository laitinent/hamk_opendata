package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Response;
import com.android.volley.VolleyError;


import java.io.UnsupportedEncodingException;

import fi.hamk.riksu.hamkopendata.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    UsersAdapter itemsAdapter;
    //TextView mTxtDisplay;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        /*
        final Button button,button_real,button_res,button_cur;
        final ListView listView;
        mTxtDisplay = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button_res = (Button) findViewById(R.id.button2);
        button_real = (Button) findViewById(R.id.button3);
        button_cur = (Button) findViewById(R.id.button4);
        listView = (ListView)findViewById(R.id.listView);
        */
        String url = OpendataHelper.RESERVATIONS_ALL_URL;// "https://opendata.hamk.fi:8443/r1/reservation/building";
        binding.textView.setText("V"+BuildConfig.VERSION_NAME);

        final GsonRequest jsObjRequest = new GsonRequest<>(url,Buildings.class, null,
                new Response.Listener<Buildings>() {
                    @Override
                    public void onResponse(Buildings response) {
                        //mTxtDisplay.setText("Response: " + response.getResources().get(0).getName());
                        itemsAdapter =new UsersAdapter(MainActivity.this, response.getResources());
                        binding.listView.setAdapter(itemsAdapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println(error.getMessage());
                        Toast.makeText(MainActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

// Access the RequestQueue through your singleton class.
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    MySingleton.getInstance(MainActivity.this).addToRequestQueue(jsObjRequest);
            }
        });

        binding.buttonRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReservationsActivity.class);
                intent.putExtra("url", OpendataHelper.RESERVATIONS_URL);//"https://opendata.hamk.fi:8443/r1/reservation/search");
                startActivity(intent);
            }
        });

        binding.buttonReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RealizationsActivity.class);
                startActivity(intent);
            }
        });
        binding.buttonCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CurriculumsActivity.class);
                startActivity(intent);
            }
        });

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String item = ((TextView)view).getText().toString();
                Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity

                Resource listItem = (Resource) adapterView.getItemAtPosition(i);
                intent.putExtra("product", listItem.getId());
                startActivity(intent);
                try {
                    String name = new String(listItem.getName().getBytes("ISO-8859-1"), "UTF-8");
                    Toast.makeText(getBaseContext(), name, Toast.LENGTH_LONG).show();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}



