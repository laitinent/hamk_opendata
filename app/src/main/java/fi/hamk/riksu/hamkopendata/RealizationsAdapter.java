package fi.hamk.riksu.hamkopendata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tlaitinen on 5.12.2016.
 */

public class RealizationsAdapter extends ArrayAdapter<Reservation>{


    public RealizationsAdapter(Context context, List<Reservation> users) {
        super(context, 0, users);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Reservation user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);

        // Populate the data into the template view using the data object
        tvName.setText(user.getStartDate());
        tvHome.setText(user.getEndDate());

        // Return the completed view to render on screen
        return convertView;
    }
}
