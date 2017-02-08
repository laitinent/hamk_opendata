package fi.hamk.riksu.hamkopendata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by tlaitinen on 5.12.2016.
 */

public class CurriculumsAdapter extends ArrayAdapter<Programme>{


    public CurriculumsAdapter(Context context, List<Programme> users) {
        super(context, 0, users);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Programme user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);

        // Populate the data into the template view using the data object
        String name = null;
        try {
            name = new String(user.getName().getBytes("ISO-8859-1"), "UTF-8");
            tvHome.setText(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        tvName.setText(user.getCode());


        // Return the completed view to render on screen
        return convertView;
    }
}
