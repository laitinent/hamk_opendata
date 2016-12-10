package fi.hamk.riksu.hamkopendata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

/**
 * Created by tlaitinen on 5.12.2016.
 */

public class RealizationsAdapter extends ArrayAdapter<Realization>{


    public RealizationsAdapter(Context context, List<Realization> users) {
        super(context, 0, users);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Realization user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);

        // Populate the data into the template view using the data object
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTimeFormatter outfmt = DateTimeFormat.forPattern("dd.MM.yy");
        DateTime startDate = fmt.parseDateTime(user.getStartDate());

        tvHome.setText(startDate.toString(outfmt));
        String s="";
        if(user.getName().length()>=30)
            s=user.getName().substring(0,30);
        else
            s=user.getName();
        tvName.setText(s);


        // Return the completed view to render on screen
        return convertView;
    }
}
