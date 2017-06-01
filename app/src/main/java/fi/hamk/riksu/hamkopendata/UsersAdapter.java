package fi.hamk.riksu.hamkopendata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.List;



/**
 * Created by tlaitinen on 3.12.2016.
 */

public class UsersAdapter extends ArrayAdapter<Resource> {

    public UsersAdapter(Context context, List<Resource> users) {
        super(context, 0, users);
    }



    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Resource user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Lookup view for data population
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvHome = convertView.findViewById(R.id.tvHome);

        // Populate the data into the template view using the data object
        try {
            String name = new String(user.getName().getBytes("ISO-8859-1"), "UTF-8");
            tvName.setText(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        tvHome.setText(user.getCode());

        // Return the completed view to render on screen
        return convertView;
    }
}
