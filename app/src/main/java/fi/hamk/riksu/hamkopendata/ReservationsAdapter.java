package fi.hamk.riksu.hamkopendata;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.io.UnsupportedEncodingException;
import java.util.List;

import fi.hamk.riksu.hamkopendata.databinding.ItemUserBinding;

/**
 * Created by tlaitinen on 5.12.2016.
 */

public class ReservationsAdapter extends ArrayAdapter<Reservation>{
    ItemUserBinding binding;

    public ReservationsAdapter(Context context, List<Reservation> users) {
        super(context, 0, users);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),R.layout.item_user, parent, false);
        // Get the data item for this position
        Reservation user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Lookup view for data population
        //TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
/*
        // Populate the data into the template view using the data object
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTimeFormatter outfmt = DateTimeFormat.forPattern("dd.MM.yy' 'HH:mm");
        DateTime startDate = fmt.parseDateTime(user.getStartDate());

        tvHome.setText(startDate.toString(outfmt));*/

        binding.tvHome.setText(OpendataHelper.formatDate(user.getStartDate()));

        try {
            String subject = new String(user.getSubject().getBytes("ISO-8859-1"), "UTF-8");
            binding.tvName.setText(subject.length()>30? subject.substring(0,30) : subject);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
