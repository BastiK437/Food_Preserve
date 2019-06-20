package com.example.android.foodpreserve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.View;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Settings extends AppCompatActivity {

    private SharedPreferences.Editor editor;
    private SharedPreferences pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

        // pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        // editor = pref.edit();
    }

    public void reset_data(View v) {
        ((Data)getApplicationContext()).deleteData();
        Toast.makeText(getApplicationContext(), "Data deleted", Toast.LENGTH_SHORT).show();
    }

}
