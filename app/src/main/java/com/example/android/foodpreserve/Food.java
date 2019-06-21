package com.example.android.foodpreserve;

public class Food {

    private String name;
    private Integer durability;

    public Food(String name, Integer durability){
        this.name = name;
        this.durability = durability;
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

    public String getDurability(){
        return durability.toString();
    }

    public int getDurabilityInt() { return durability; }



}
