package com.example.android.foodpreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout placeHolder = (LinearLayout) findViewById(R.id.main_linear_layout);
        getLayoutInflater().inflate(R.layout.main_food_window, placeHolder);
        getLayoutInflater().inflate(R.layout.main_food_window, placeHolder);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, AddFoodAcitivity.class);
                startActivity(i);
            }
        });
    }

    public void addFoodView(){
        LinearLayout placeHolder = (LinearLayout) findViewById(R.id.main_linear_layout);
        getLayoutInflater().inflate(R.layout.main_food_window, placeHolder);
    }

}
