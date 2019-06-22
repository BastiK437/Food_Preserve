package com.example.android.foodpreserve;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.icu.util.GregorianCalendar;
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
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

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
        int counter = 0;

        FileReader reader = new FileReader(appData);
        int input = reader.read();
        int day = 0, month = 0, year = 0;

        // read the name
        while(input != -1){
            int numberCorrectur = 0;
            String name = "";
            int durability = 0;

            while(input != ','){
                name += (char) input;
                input = reader.read();
            }

            for(int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        durability = getNextNumber(reader);
                        break;
                    case 1:
                        day = getNextNumber(reader);
                        break;
                    case 2:
                        month = getNextNumber(reader);
                        break;
                    case 3:
                        year = getNextNumber(reader);
                        break;
                }
            }
            input = reader.read();

            durability = getDayDifference(year, month, day);

            Log.e("data", String.format("dr: %d, d: %d, m: %d, y: %d", durability, day, month, year) );
            Food newFood = new Food(name, durability, day, month, year);
            foodList.add(newFood);
            counter++;
        }

        Log.e("data", "food readed: " + String.format("%d", counter));
        reader.close();

        Collections.sort(foodList);

        return foodList;
    }

    public void saveData(Food newFood) {
        try {
            PrintWriter fos = new PrintWriter(new FileWriter(appData, true));

            Log.e("data", "save food: " + newFood.getName() + ". Time: " + newFood.getDurability());

            fos.print(newFood.getName());
            fos.print(",");
            fos.print(newFood.getDurability());
            fos.print(",");
            fos.print(newFood.getDay());
            fos.print(",");
            fos.print(newFood.getMonth());
            fos.print(",");
            fos.println(newFood.getYear());


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

    private int getNextNumber(FileReader reader) {
        int input = 0;
        try {
            input = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int nextNumber = 0;
        while(input != ',' && input != '\n'){
            nextNumber *= 10;
            nextNumber +=  (input - 48);
            try {
                input = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  nextNumber;
    }

    private int getDayDifference(int selected_year, int selected_month, int selected_day) {
        long ms = new GregorianCalendar( selected_year, selected_month, selected_day ).getTimeInMillis();
        long days = TimeUnit.MILLISECONDS.toDays( System.currentTimeMillis() - ms );

        days = (days * -1) + 1;

        Log.e("time", "tage: " + String.format("%d", days));

        return (int) days;
    }
}
