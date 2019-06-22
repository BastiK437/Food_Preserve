package com.example.android.foodpreserve;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.Preference;
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



