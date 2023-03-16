package com.example.infs3605groupproject.objects;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        Plant plant = new Plant("Mahima", "Mahima", "Worst year", "Lower Campus", "LC", "Queen Elizabeth  had the worst year of her life", "UK", "");
        plantList.add(plant);
        plant = new Plant("Plant23", "Acacia elata", "Mountain Cedar Wattle", "Lower Campus", "Edible pea flower" +
                "and pod. Leaves can be used for handwashing when placed in water. Chemicals in the leaves can stun fish. Indigenous hunters use leaves placed in the water in dams to stop the gills from working. Some fish are collected," +
                "while the rest are released and left to revive to help maintain the population.", "Description", "Coastal Eastern Australia", "acacia_elata_diagram");
        plantList.add(plant);
        plant = new Plant("24", "Brachychiton acerifolius", "Illawarra Flame Tree", "Opposite of UNSW Bookshop", "Seeds can be extracted from seed pods, ground and eaten. " +
                "The sturdy fibre of the inner bark can be made into string, dilly bags and fishing nets.", "Large tree of the family Malvaceae and is famous for the bright red bell-shaped flowers that often cover the whole tree when it is leafless.", "Qld, NSW", "");
        plantList.add(plant);
        return plantList;
    }

}