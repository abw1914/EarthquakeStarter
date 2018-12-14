package com.android.earthquakestarter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeAdapter extends ArrayAdapter<EarthquakeData> {
    public EarthQuakeAdapter(@NonNull Context context, int resource, ArrayList<EarthquakeData> earthquakeDataArrayList) {
        super(context, 0, earthquakeDataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View earthquackListView = convertView;
        if(earthquackListView == null) {
            earthquackListView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_view, parent, false);
        }

        EarthquakeData earthquakeData = getItem(position);

        TextView location = earthquackListView.findViewById(R.id.location);
        location.setText(earthquakeData.getLocations());

        TextView magnitude = earthquackListView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMag(earthquakeData.getMagnitude());
        magnitude.setText(formattedMagnitude);

        Date dateObject = new Date(earthquakeData.getEventDate());
        TextView eventdate = earthquackListView.findViewById(R.id.date);
        String formattedEventDate = formatDate(dateObject);
        eventdate.setText(formattedEventDate);

        return earthquackListView;
    }

   private String formatMag (double magnitude) {
       DecimalFormat decimalFormat = new DecimalFormat("0.0");
       return decimalFormat.format(magnitude);
   }

   private String formatDate (Date dateObject) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return simpleDateFormat.format(dateObject);
   }

    private String formatTime (Date dateObject) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(dateObject);
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
