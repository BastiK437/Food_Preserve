package com.example.android.foodpreserve;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int changed;
    private static ArrayList<Food> foodList = new ArrayList<>();
    private Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File fileDir = getFilesDir();


        try {
            foodList = ((Data)getApplicationContext()).readData();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Could not read data - IO", Toast.LENGTH_LONG).show();
        } catch (NumberReadException e) {
            e.printStackTrace();
        }


        addFood();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            Intent i = new Intent(MainActivity.this, AddFoodAcitivity.class);
            startActivity(i);
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


    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    public void addFood(){
        FoodAdapter fAdapter = new FoodAdapter(this, foodList);
        ListView mainList = (ListView) findViewById(R.id.list);
        mainList.setAdapter(fAdapter);
    }

    public void addItemToList(Food newFood){
        foodList.add(newFood);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(MainActivity.this, Settings.class);
                startActivity(i);
                return true;
            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



