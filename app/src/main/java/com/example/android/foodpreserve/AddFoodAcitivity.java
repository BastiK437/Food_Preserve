package com.example.android.foodpreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddFoodAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_acitivity);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.mhd_day);
        String[] items = new String[]{"1", "2", "3", "4", "5"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);


        findViewById(R.id.save_food).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){/*
                EditText foodName = (EditText) findViewById(R.id.new_food_name);
                createNewContent(foodName.getText().toString(), 00, 00, 2001, 5);

*/
                Food newFood = new  Food(findViewById(R.id.new_food_name).getTransitionName(), 5);
                MainActivity.addFood(newFood);

                Intent i = new Intent(AddFoodAcitivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


    public void createNewContent(String name, int day, int month, int year, int opened){
        LinearLayout placeHolder = (LinearLayout) findViewById(R.id.main_linear_layout);
        getLayoutInflater().inflate(R.layout.main_food_window, placeHolder);

        TextView foodName = (TextView) findViewById(R.id.food_name);
        foodName.setText(name);

    }

}
