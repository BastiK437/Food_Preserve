package com.example.android.foodpreserve;

import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class AddFoodAcitivity extends AppCompatActivity {

    private int selected_year = 0;
    private int selected_month = 0;
    private int selected_day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        ActionBar myAB = getSupportActionBar();
        myAB.setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.save_food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( selected_year == 0 && selected_month == 0 && selected_day == 0){
                    Toast.makeText(getApplicationContext(), "You need to select a Date!", Toast.LENGTH_LONG).show();
                }else {
                    EditText foodName = (EditText) findViewById(R.id.new_food_name);

                    int daysLeft = getDayDifference(selected_year, selected_month, selected_day);

                    if (foodName.getText().toString().length() != 0) {
                        Food newFood = new Food(foodName.getText().toString(), daysLeft, selected_day, selected_month, selected_year);
                        ((Data) getApplicationContext()).saveData(newFood);
                        Intent i = new Intent(AddFoodAcitivity.this, MainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "You need to type in a name!", Toast.LENGTH_LONG).show();
                    }//else
                }//else
            }//onClick
        });//onClickListener

        CalendarView cal = findViewById(R.id.calendar_addFood);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                selected_year = year;
                selected_month = month;
                selected_day = dayOfMonth;
            }
        });
    }


    private boolean isNumber(String number) {
        if (number.length() == 0) return false;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') return false;
        }
        return true;
    }

    private Integer getNumber(String number) {
        Integer newNumber = 0;
        for (int i = 0; i < number.length(); i++) {
            newNumber *= 10;
            newNumber += number.charAt(i) - 48;
        }
        return newNumber;
    }

    private int getDayDifference(int selected_year, int selected_month, int selected_day) {
        long ms = new GregorianCalendar( selected_year, selected_month, selected_day ).getTimeInMillis();
        long days = TimeUnit.MILLISECONDS.toDays( System.currentTimeMillis() - ms );

        days = (days * -1) + 1;

        Log.e("time", "tage: " + String.format("%d", days));

        return (int) days;
    }

}
