package com.example.android.foodpreserve;

public class Food {

    private String name;
    private Integer durability;

    public Food(String name, Integer durability){
        this.name = name;
        this.durability = durability;
    }

    public String getName(){
        return name;
    }

    public Integer getDurability(){
        return durability;
    }



}
