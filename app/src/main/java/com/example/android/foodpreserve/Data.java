package com.example.android.foodpreserve;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Math.pow;

public class Data extends Application {
    File appData;

    @Override
    public void onCreate() {
        super.onCreate();
        File filesDir = getFilesDir();

        appData = new File(filesDir.getPath() + "/foodData.txt");
        Log.e("data", filesDir.getPath() + "/foodData.txt");


        if(!appData.exists()){
            try {
                appData.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("data", "file does not exist");
        }else {
//            appData.delete();
//            try {
//                appData.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Log.e("data",  "file exists");
        }
    }

    public ArrayList<Food> readData() throws NumberReadException, IOException {
        ArrayList<Food> foodList = new ArrayList<>();

        FileReader reader = new FileReader(appData);
        int input = reader.read();

        while(input != -1){
            int numberCorrectur = 0;
            String name = "";
            int durability = 0;

            while(input != ','){
                name += (char) input;
                input = reader.read();
            }

            Log.e("data", "Name: " + name);

            input = reader.read();
            while(input != '\n'){
                durability *= 10;
                durability +=  (input - 48);
                numberCorrectur++;
                input = reader.read();

                if(numberCorrectur > 10){
                    Log.e("data", "throw exception");
                    throw new NumberReadException("Durability read failed");
                }
            }
            Log.e("data", "Time: " + durability);
            input = reader.read();

            Food newFood = new Food(name, durability);
            foodList.add(newFood);
        }

        reader.close();

        return foodList;
    }

    public void saveData(Food newFood) {
        try {
            PrintWriter fos = new PrintWriter(new FileWriter(appData, true));

            Log.e("data", "save food: " + newFood.getName() + ". Time: " + newFood.getDurability());

            fos.print(newFood.getName());
            fos.print(",");
            fos.println(newFood.getDurability());

            fos.close();
        } catch (IOException e) {
            Log.e("data", "could not open file to write to");
        }
    }

    public void deleteData() {
        appData.delete();
        try {
            appData.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
