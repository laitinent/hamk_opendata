package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import fi.hamk.riksu.hamkopendata.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    UsersAdapter itemsAdapter;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        String url = OpendataHelper.RESERVATIONS_ALL_URL;// "https://opendata.hamk.fi:8443/r1/reservation/building";
        binding.textView.setText("V"+BuildConfig.VERSION_NAME);

        final GsonRequest jsObjRequest = new GsonRequest<>(url,Buildings.class, null,
                response -> {
                    itemsAdapter =new UsersAdapter(MainActivity.this, response.getResources());
                    binding.listView.setAdapter(itemsAdapter);
                },

                error -> {
                    System.err.println(error.getMessage());
                    Toast.makeText(MainActivity.this,"Virhe: "+error.getMessage(),Toast.LENGTH_LONG).show();
                });

// Access the RequestQueue through your singleton class.
        binding.button.setOnClickListener(view -> MySingleton.getInstance(MainActivity.this).addToRequestQueue(jsObjRequest));

        binding.buttonRes.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ReservationsActivity.class);
            intent.putExtra("url", OpendataHelper.RESERVATIONS_URL);//"https://opendata.hamk.fi:8443/r1/reservation/search");
            startActivity(intent);
        });

        binding.buttonReal.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RealizationsActivity.class);
            startActivity(intent);
        });
        binding.buttonCur.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CurriculumsActivity.class);
            startActivity(intent);
        });

        binding.listView.setOnItemClickListener((adapterView, view, i, l) -> {
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
        });
    }
}



