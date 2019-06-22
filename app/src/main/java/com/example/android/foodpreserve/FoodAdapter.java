package com.example.android.foodpreserve;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;
    private boolean settingsView;
    private FoodFragment foodFragment;

    public FoodAdapter(Context context, ArrayList<Food> list ){
        super(context, 0, list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Food item = getItem(position);

        View listItemView = convertView;

        if(foodFragment ==  null) {
            foodFragment = new FoodFragment();
        }


        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate( R.layout.main_food_fragment, parent, false);
        }

        loadFragment(foodFragment, listItemView);



        settingsView = false;

        Log.e("fragment", "before setters");

        setNormalWindow(item);

        listItemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(context, "You clicked on " + item.getName(), Toast.LENGTH_SHORT).show();
                //listItemView.set
                if(settingsView) {
                    loadFragment(new FoodFragment(), view);
                    setNormalWindow(item);
                    settingsView = false;
                }else {
                    loadFragment(new FoodSettingsFragment(), view);
                    setSettingsWindow(item);
                    settingsView = true;
                }
            }
        });


        return listItemView;
    }

    private void loadFragment(Fragment fragment, View view) {
        Log.e("fragment", "load fragment");
        // create a FragmentManager
        FragmentManager fm = ((AppCompatActivity)context).getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(view.findViewById(R.id.frameLayout).getId(), fragment);
        fragmentTransaction.commit(); // save the changes
        Log.e("fragment", "finish loading");
    }

    private void setNormalWindow(Food item) {
        // food name
        foodFragment.setFoodName(item.getName() );

        // date
        foodFragment.setDays(item.getDay());
        foodFragment.setMonths(item.getMonth());
        foodFragment.setYears(item.getYear());

        // durability
        foodFragment.setDurability(item.getDurability());
    }

    private void setSettingsWindow(Food item) {

    }

}
