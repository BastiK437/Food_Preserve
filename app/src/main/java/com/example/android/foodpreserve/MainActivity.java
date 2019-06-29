package com.example.android.foodpreserve;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hudomju.swipe.SwipeToDismissTouchListener;
import com.hudomju.swipe.adapter.ListViewAdapter;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int changed;
    private static ArrayList<Food> foodList = new ArrayList<>();
    private Data data;

    private SwipeController swipeController;
    private SwipeControllerActions scActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFood();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


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

    public void addFood() {
        try {
            foodList = ((Data) getApplicationContext()).readData();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Could not read data - IO", Toast.LENGTH_LONG).show();
        } catch (NumberReadException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final FoodAdapter fAdapter = new FoodAdapter(foodList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(fAdapter);

        swipeController = new SwipeController(new SwipeControllerActions(fAdapter, this ), this);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);

        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
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



