package com.example.android.foodpreserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class AddFoodAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_acitivity);
    }

    CalendarView.setOnDateChangeListener(new OnDateChangeListener() {

        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month,
        int dayOfMonth) {
            int d = dayOfMonth;
            curDate =String.valueOf(d);
        }
    });
}
