package com.example.android.dinnerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

/**
 * Created by jocelyn on 3/12/15.
 */
public class ShowDinnerActivity extends Activity {

    TextView tv;
    String mDinner;
    String selectedDinnerExtrasKey = String.valueOf(R.string.selected_dinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_dinner_suggestion);
    }

    protected void onStart() {
        super.onStart();

        // Set the heading of the info box
        TextView heading_tv = (TextView) findViewById(R.id.textView_info_heading);
        heading_tv.setText(getResources().getText(R.string.dinner_heading));

        // Get the text view
        tv = (TextView) findViewById(R.id.textView_info);

        // Get the dinner suggestion out of the intent
        Intent myIntent = getIntent();
        mDinner = myIntent.getStringExtra(selectedDinnerExtrasKey);
        tv.setText(mDinner);
    }

    public void orderOnline (View view) {
        // Start an intent to allow the user to order dinner online
        Intent intent = new Intent(this, OrderDinnerActivity.class);
        intent.putExtra(selectedDinnerExtrasKey, mDinner);
        startActivity(intent);
    }

    public void removeMeal (View view) {
        // Start an intent to remove the dinner suggestion
        Intent intent = new Intent(this, RemoveMealActivity.class);
        intent.putExtra(selectedDinnerExtrasKey, mDinner);
        startActivity(intent);
    }

    public void showRecipe (View view) {
        // Start an intent to show the recipe for the dinner suggestion
        Intent intent = new Intent(this, ShowRecipeActivity.class);
        intent.putExtra(selectedDinnerExtrasKey, mDinner);
        startActivity(intent);
    }

    // Choose another dinner suggestion
    public void chooseAgain(View view) {
        // Utility.showMyToast("I will show you a menu", this);
        android.widget.PopupMenu popup = new android.widget.PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.food_prefs_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                setDinnerSuggestion(item.getItemId());
                return true;
            }
        });
        // show the popup menu
        popup.show();
    }

    // Get and show a new suggestion for dinner
    // based on the food preference
    public void setDinnerSuggestion(int item) {

        Dinner dinner = new Dinner(this, item);
        mDinner = dinner.getDinnerTonight();
        tv.setText(mDinner);
    }


}
