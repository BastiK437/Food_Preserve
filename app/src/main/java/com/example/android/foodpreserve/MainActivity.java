package com.example.android.foodpreserve;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int changed;
    private static ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changed = 0;
        foodList = new ArrayList<>();

        foodList.add(new Food("Milch", 5));
        foodList.add(new Food("Kekse", 8));
        foodList.add(new Food("Bier", 10));


        FoodAdapter fAdapter = new FoodAdapter(this, foodList);
        ListView mainList = (ListView) findViewById(R.id.list);

        mainList.setAdapter(fAdapter);


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                foodList.add(new Food("Milch", 5));

//                LinearLayout parentLayout = (LinearLayout) findViewById(R.id.main_linear_layout);
//                View childLayout = getLayoutInflater().inflate(R.layout.main_food_window,  parentLayout, false );
//
//                parentLayout.addView(childLayout);
//
//                Intent i = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(i);
            }
        });

















/*



        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.main_linear_layout);

        for(int i=0; i<foodList.size(); i++){
            View childLayout = getLayoutInflater().inflate(R.layout.main_food_window,  parentLayout, false );

            TextView foodName = (TextView) childLayout.findViewById(R.id.food_name);
            foodName.setText(foodList.get(i).getName());

            TextView durability = (TextView) childLayout.findViewById(R.id.days_left);
            durability.setText( foodList.get(i).getDurability().toString() );

            parentLayout.addView(childLayout);
        }


        LinearLayout placeHolder = (LinearLayout) findViewById(R.id.main_linear_layout);
        View overlayView = getLayoutInflater().inflate(R.layout.overlay_main_menu, placeHolder);
        final View food1 = getLayoutInflater().inflate(R.layout.main_food_window, placeHolder);

        food1.findViewById(R.id.main_food).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(changed==0){
                    //food1.setVisibility(View.GONE);

                    TextView food = (TextView) food1.findViewById(R.id.food_name);

                    food.setText("Milch");
                    food = (TextView) food1.findViewById(R.id.days_left);

                    food.setText("5");
                    //ArrayList<View> list = findViewById(food1.);

                    changed=1;
                }else{
                    TextView food = (TextView) food1.findViewById(R.id.food_name);

                    food.setText("Joghurt");
                    food = (TextView) food1.findViewById(R.id.days_left);

                    food.setText("5");
                    //ArrayList<View> list = findViewById(food1.);

                    changed=0;
                }

            }
        });
*/

    }


    public static void addFood(Food food){
        foodList.add(food);
    }
}
