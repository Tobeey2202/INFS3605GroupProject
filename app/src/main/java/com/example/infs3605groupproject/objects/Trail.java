package com.example.infs3605groupproject.objects;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        Plant plant = new Plant("Mahima", "Mahima", "Worst year", "Lower Campus", "LC", "Queen Elizabeth  had the worst year of her life", "UK");
        plantList.add(plant);
        plant =   new Plant("Vanessa", "Vanessa", "Worst year", "Lower Campus", "LC", "Queen Elizabeth  had the worst year of her life", "UK");
        plantList.add(plant);
        plant =   new Plant("24", "Brachychiton acerifolius", "Illawarra Flame Tree", "Opposite of UNSW Bookshop", "Seeds can be extracted from seed pods, ground and eaten. " +
                "The sturdy fibre of the inner bark can be made into string, dilly bags and fishing nets.", "Large tree of the family Malvaceae and is famous for the bright red bell-shaped flowers that often cover the whole tree when it is leafless.", "Qld, NSW");
        plantList.add(plant);
        return plantList;
    }

}