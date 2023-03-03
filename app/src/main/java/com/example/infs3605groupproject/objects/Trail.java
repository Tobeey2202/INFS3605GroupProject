package com.example.infs3605groupproject.objects;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        Plant plant = new Plant("Ich Bin Ein berliner", "Ich Bin Ein Berliner", "Worst year", "Lower Campus", "LC", "Queen Elizabeth  had the worst year of her life", "UK");
        plantList.add(plant);
        return plantList;
    }

}
