package com.example.android.foodpreserve;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hudomju.swipe.adapter.RecyclerViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    public ArrayList<Food> list;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class FoodHolder extends RecyclerView.ViewHolder {
        public RelativeLayout food_window;

        public FoodHolder(RelativeLayout food_window) {
            super(food_window);
            this.food_window = food_window;
        }
    }

    public FoodAdapter(ArrayList<Food> foodList) {
        this.list = foodList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public FoodAdapter.FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout food_frame = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.main_food_window, parent, false);

        return new FoodHolder(food_frame);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Food item = list.get(position);
        RelativeLayout mainWindow = (RelativeLayout) holder.food_window;

        ((TextView) mainWindow.findViewById(R.id.food_name)).setText(item.getName());
        ((TextView) mainWindow.findViewById(R.id.main_days)).setText(String.format("%d.", item.getDay()));
        ((TextView) mainWindow.findViewById(R.id.main_months)).setText(String.format("%d.", item.getMonth()));
        ((TextView) mainWindow.findViewById(R.id.main_years)).setText(String.format("%d", item.getYear()));
        ((Button) mainWindow.findViewById(R.id.food_used)).setText(String.format("%d", item.getDurability()));

        if (item.getDurability() <= 2) {
            mainWindow.setBackgroundResource(R.drawable.list_shape_red);
            ((Button) mainWindow.findViewById(R.id.food_used)).setBackgroundResource(R.drawable.list_shape_red_infill);
        } else if (item.getDurability() <= 5) {
            mainWindow.setBackgroundResource(R.drawable.list_shape_orange);
            ((Button) mainWindow.findViewById(R.id.food_used)).setBackgroundResource(R.drawable.list_shape_orange_infill);

        } else {
            mainWindow.setBackgroundResource(R.drawable.list_shape_green);
            ((Button) mainWindow.findViewById(R.id.food_used)).setBackgroundResource(R.drawable.list_shape_green_infill);
        }

        // Set text size of days left
        if (item.getDurability() < 100 && item.getDurability() > 0) {
            ((Button) holder.food_window.findViewById(R.id.food_used)).setTextSize(25);
        } else {
            ((Button) holder.food_window.findViewById(R.id.food_used)).setTextSize(20);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }
}