package com.example.android.foodpreserve;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FoodFragment extends Fragment {

    View view;
    Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view == null) {
            view = inflater.inflate(R.layout.main_food_window, container, false);
            //Log.e("fragment", "view created");
        }
        return view;
    }

    public void setFoodName(String name) {
        //Log.e("fragment", "name function called");
        if(view != null){
            //Log.e("fragment", "view not null");
            TextView food_name = view.findViewById(R.id.food_name);
            food_name.setText(name);
        }else{
            //Log.e("fragment", "view is null");
        }
    }

    public void setDurability(int durability) {
        if(view != null) {
            Button checkBox = (Button) view.findViewById(R.id.food_used);
            checkBox.setText(String.format("%d", durability));

            if (durability <= 2) {
                view.setBackgroundResource(R.drawable.list_shape_red);
                view.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_red_infill);
            } else if (durability <= 5) {
                view.setBackgroundResource(R.drawable.list_shape_orange);
                view.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_orange_infill);

            } else {
                view.setBackgroundResource(R.drawable.list_shape_green);
                view.findViewById(R.id.food_used).setBackgroundResource(R.drawable.list_shape_green_infill);
            }

            // Set text size of days left
            if (durability < 100 && durability > 0) {
                ((Button) view.findViewById(R.id.food_used)).setTextSize(25);
            } else {
                ((Button) view.findViewById(R.id.food_used)).setTextSize(20);
            }
        }
    }

    public void setDays(int days) {
        if(view != null) {
            TextView days_view = view.findViewById(R.id.main_days);
            days_view.setText(String.format("%d.", days));
        }
    }

    public void setMonths(int months) {
        if(view != null) {
            TextView months_view = view.findViewById(R.id.main_months);
            months_view.setText(String.format("%d.", months));
        }
    }

    public void setYears(int years) {
        if(view != null) {
            TextView years_view = view.findViewById(R.id.main_years);
            years_view.setText(String.format("%d", years));
        }
    }
}
