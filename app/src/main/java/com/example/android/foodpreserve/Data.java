package com.example.android.foodpreserve;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
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

public class Data extends AppCompatActivity {
    File appData;

    public Data(File fileDir) throws IOException {
        String path = fileDir.getPath() + "appData";
        appData = new File(path);

        if(!appData.exists()){
            appData.createNewFile();
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
                name += input;
                input = reader.read();
            }



            while(input != '\n'){
                durability += (int) (pow(10, numberCorrectur) * (input - 48));
                numberCorrectur++;

                if(numberCorrectur > 10){
                    throw new NumberReadException("Durability read failed");
                }
            }

            Food newFood = new Food(name, durability);
            foodList.add(newFood);
        }

        reader.close();

        return foodList;
    }

    public void saveData(ArrayList<Food> list){
        /*
        try {
            PrintWriter fos = new PrintWriter(new FileWriter(appData));


            for(Food f: list){
                fos.print(f.getName());
                fos.print(", ");
                fos.println(f.getDurability());
            }

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }

}
