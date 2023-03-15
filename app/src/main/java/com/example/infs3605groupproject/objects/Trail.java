package com.example.infs3605groupproject.objects;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        Plant plant = new Plant("Mahima", "Mahima", "Worst year", "Lower Campus", "LC", "Queen Elizabeth  had the worst year of her life", "UK");
        plantList.add(plant);
        plant =   new Plant("Vanessa", "Vanessa", "Worst year", "Lower Campus", "LC", "Queen Elizabeth  had the worst year of her life", "UK");
        plantList.add(plant);
        return plantList;
    }

}