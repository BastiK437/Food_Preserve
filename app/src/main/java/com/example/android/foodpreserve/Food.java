package com.example.android.foodpreserve;

import android.util.Log;

public class Food implements Comparable<Food> {

    private String name;
    private int durability;
    private int year, month, day;

    public Food(String name, int durability, int day, int month, int year){
        this.name = name;
        this.durability = durability;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDurability(int durability){
        this.durability = durability;
    }

    public String getName(){
        return name;
    }

    public int getDurability() { return durability; }

    public int getYear() {
        return year;
    }

    public int getMonth() { return month; }

    public int getDay() { return day; }

    public int compareTo(Food candidate) {
        return (this.getDurability() < candidate.getDurability() ) ? -1 : 1;
    }
}
