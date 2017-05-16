package fi.hamk.riksu.hamkopendata;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import fi.hamk.riksu.hamkopendata.databinding.ActivitySingleListItemBinding;

import static fi.hamk.riksu.hamkopendata.OpendataHelper.RESERVATIONS_ALL_URL;

public class SingleListItem extends AppCompatActivity {
    UsersAdapter itemsAdapter;
    ActivitySingleListItemBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_single_list_item);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_list_item);

        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        binding.textView2.setText(product);

        //String url = "https://opendata.hamk.fi:8443/r1/reservation/building/";

        final GsonRequest jsObjRequest = new GsonRequest<>(RESERVATIONS_ALL_URL+"/"+product, Buildings.class, null,
                response -> {
                    //txtProduct.setText("Response: "+response.getResources().get(0).getName());
                    itemsAdapter =new UsersAdapter(SingleListItem.this, response.getResources());
                    binding.lvDetails.setAdapter(itemsAdapter);
                },

                error ->  OpendataHelper.printToastErr(SingleListItem.this,error.getMessage())
                );

                MySingleton.getInstance(SingleListItem.this).addToRequestQueue(jsObjRequest);
    }
}
