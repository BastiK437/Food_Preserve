package com.example.android.foodpreserve;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;

    public FoodAdapter(Context context, ArrayList<Food> list ){
        super(context, 0, list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Food item = getItem(position);

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate( R.layout.main_food_window, parent, false);
        }

        TextView name = (TextView) listItemView.findViewById(R.id.food_name);
        name.setText(item.getName() );

        TextView durability = (TextView) listItemView.findViewById(R.id.days_left);
        durability.setText(item.getDurability() );

        Button checkBox = (Button) listItemView.findViewById(R.id.food_used);
        checkBox.setText(item.getDurability());

        if(item.getDurabilityInt() < 2) {
            listItemView.setBackgroundResource(R.drawable.list_shape_red);
            listItemView.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_red_infill);
        }else if(item.getDurabilityInt() <= 5) {
            listItemView.setBackgroundResource(R.drawable.list_shape_orange);
            listItemView.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_orange_infill);

        }else {
            listItemView.setBackgroundResource(R.drawable.list_shape_green);
            listItemView.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_green_infill);
        }

        // Set text size of days left
        if(item.getDurabilityInt() < 100) {
            ((Button) listItemView.findViewById(R.id.food_used)).setTextSize(25);
        }else {
            ((Button) listItemView.findViewById(R.id.food_used)).setTextSize(20);
        }


        return listItemView;
    }
}
