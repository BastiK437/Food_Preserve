package com.example.android.foodpreserve;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Context context, ArrayList<Food> list ){
        super(context, 0, list);
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

        return listItemView;
    }
}
