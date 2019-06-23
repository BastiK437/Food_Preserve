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

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<Food> {

    private Context context;
    private ArrayList<Food> list;

    public FoodAdapter(Context context, RecyclerView recyclerView){
        //super(context);
        this.context = context;
        this.list = list;
    }

    public void remove(int position) {
        list.remove(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Food item = getItem(position);

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate( R.layout.main_food_window, parent, false);
        }

        TextView food_name = listItemView.findViewById(R.id.food_name);
        food_name.setText(item.getName());

        TextView days_view = listItemView.findViewById(R.id.main_days);
        days_view.setText(String.format("%d.", item.getDay()));

        TextView months_view = listItemView.findViewById(R.id.main_months);
        months_view.setText(String.format("%d.", item.getMonth()));

        TextView years_view = listItemView.findViewById(R.id.main_years);
        years_view.setText(String.format("%d", item.getYear()));

        Button checkBox = (Button) listItemView.findViewById(R.id.food_used);
        checkBox.setText(String.format("%d", item.getDurability()));

        if (item.getDurability() <= 2) {
            listItemView.findViewById(R.id.main_food).setBackgroundResource(R.drawable.list_shape_red);
            listItemView.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_red_infill);
        } else if (item.getDurability() <= 5) {
            listItemView.findViewById(R.id.main_food).setBackgroundResource(R.drawable.list_shape_orange);
            listItemView.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_orange_infill);

        } else {
            listItemView.findViewById(R.id.main_food).setBackgroundResource(R.drawable.list_shape_green);
            listItemView.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_green_infill);
        }

        // Set text size of days left
        if (item.getDurability() < 100 && item.getDurability() > 0) {
            ((Button) listItemView.findViewById(R.id.food_used)).setTextSize(25);
        } else {
            ((Button) listItemView.findViewById(R.id.food_used)).setTextSize(20);
        }

        return listItemView;
    }

    @NonNull
    @Override
    public Food onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Food holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
