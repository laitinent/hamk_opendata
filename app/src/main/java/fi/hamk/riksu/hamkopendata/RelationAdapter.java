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
 * Created by tlaitinen on 9.2.2017.
 */

public class RelationAdapter extends ArrayAdapter<Relation> {

    boolean bAllTypes = false;

    /**
     * @param context  Context
     * @param objects  List of relations
     * @param bModules Show only modules
     */
    public RelationAdapter(Context context, List<Relation> objects, boolean bModules) {
        super(context, 0, objects);
        bAllTypes = !bModules;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Relation relation = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }


        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);

        // Populate the data into the template view using the data object
        try {
            String name = new String(relation.getLearningUnit().getName().getBytes("ISO-8859-1"), "UTF-8");
            tvName.setText(name);
            tvHome.setText(relation.getLearningUnit().getType());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Return the completed view to render on screen

        return convertView;
    }
}


