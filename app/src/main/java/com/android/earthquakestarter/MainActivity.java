package com.android.earthquakestarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_LOG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<EarthquakeData> earthquakes = QueryUtils.extractEarthquakes();

        ListView earthquakeListView = findViewById(R.id.list);

        EarthQuakeAdapter earthQuakeAdapter = new EarthQuakeAdapter(this, 0, earthquakes);
        earthquakeListView.setAdapter(earthQuakeAdapter);


    }
}
