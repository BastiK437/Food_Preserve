package com.example.android.foodpreserve;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddFoodAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        //Dropdown Menü
        /*
        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.mhd_day);
        String[] items = new String[]{"1", "2", "3", "4", "5"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        */

        ActionBar myAB = getSupportActionBar();
        myAB.setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.save_food).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){/*
                EditText foodName = (EditText) findViewById(R.id.new_foo_name);
                createNewContent(foodName.getText().toString(), 00, 00, 2001, 5);

*/
                EditText foodName = (EditText) findViewById(R.id.new_food_name);
                EditText daysLeft = (EditText) findViewById(R.id.new_days_left);

                if( isNumber( daysLeft.getText().toString() )  &&
                        ( foodName.getText().toString().length() != 0 ) ){
                    Food newFood = new Food(foodName.getText().toString(), getNumber(daysLeft.getText().toString() ) );

                    ((Data)getApplicationContext()).saveData(newFood);
                }

                Intent i = new Intent(AddFoodAcitivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


    private boolean isNumber(String number){
        if (number.length() == 0) return false;
        for(int i=0; i<number.length(); i++){
            if(number.charAt(i) < '0' || number.charAt(i) > '9' ) return false;
        }
        return true;
    }

    private Integer getNumber(String number){
        Integer newNumber = 0;
        for(int i=0; i<number.length(); i++){
            newNumber *= 10;
            newNumber += number.charAt(i)-48;
        }
        return newNumber;
    }

}
