package com.example.android.dinnerapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.HitBuilders;

/**
 * Created by jocelyn on 3/13/15.
 */
public class ShowAllDinnersActivity extends ListActivity {

    String selectedDinnerExtrasKey = String.valueOf(R.string.selected_dinner);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_all_dinners);

        // Start timing how long it takes to display the list of products
        long startTime = System.nanoTime();

        // Get the array of all the dinners
        Dinner dinner = new Dinner();
        String [] allDinners = dinner.getAllDinners(this);

        // Create an array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.show_dinner_in_row, R.id.textview_dinner_row, allDinners);

        // Attach the ArrayAdapter to the list view
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);

        // Stop timing how long it takes to display the list of products
        long stopTime = System.nanoTime();

        long elapsedTime = (stopTime - startTime) / 1000000;
        /*
        Utility.showMyToast("Elapsed time -- " + Long.toString(elapsedTime)
                + "milliseconds", this);
                */

        // Report to analytics how long it took to display this list
        sendAnalyticsTimingHit(elapsedTime);
    }

    public void sendAnalyticsTimingHit (long t ) {
        Tracker tracker = ((MyApplication) getApplication()).getTracker();

        // Build and send timing data
        tracker.send(new HitBuilders.TimingBuilder()
                .setCategory("List all dinners")
                .setValue(t)
                .setLabel("display duration")
                .setVariable("duration")
                .build());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        // Do something when a list item is clicked
        super.onListItemClick(l, v, position, id);

        String value = (String) getListView().getItemAtPosition(position);

        // Utility.showMyToast("selected dinner is " + value, this);
        Intent intent = new Intent(this, OrderDinnerActivity.class);
        intent.putExtra(selectedDinnerExtrasKey, value);

        startActivity(intent);
    }


}
