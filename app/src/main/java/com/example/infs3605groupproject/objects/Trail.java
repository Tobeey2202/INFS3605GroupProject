package com.example.infs3605groupproject.objects;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        Plant plant = new Plant("Plant23", "Acacia elata", "Mountain Cedar Wattle", "Lower Campus", "Edible pea flower" +
                "and pod. Leaves can be used for handwashing when placed in water. Chemicals in the leaves can stun fish. Indigenous hunters use leaves placed in the water in dams to stop the gills from working. Some fish are collected," +
                "while the rest are released and left to revive to help maintain the population.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "Coastal Eastern Australia","acacia_elata_diagram");
        plantList.add(plant);
        plant = new Plant("24", "Brachychiton acerifolius", "Illawarra Flame Tree", "Opposite of UNSW Bookshop", "Seeds can be extracted from seed pods, ground and eaten. " +
                "The sturdy fibre of the inner bark can be made into string, dilly bags and fishing nets.", "Large tree of the family Malvaceae and is famous for the bright red bell-shaped flowers that often cover the whole tree when it is leafless.",
                "Qld, NSW", "illawarra_flame_tree");
        plantList.add(plant);
        plant = new Plant("25", "Ficus rubiginosa", "Port Jackson Fig", "In front of Law Library", "The small yellow fruit can be consumed " +
                "raw or preserved in a ‘cake’ but should only be eaten when ripe, soft and pulpy. The twine made from fibres from " +
                "the plant is used for dilly bags and the inner bark for fishing nets.", "Species of flowering plant which matures into a tree 30 m high and nearly as wide with a yellow-brown buttressed trunk.",
                "Qld, NSW","port_jackson_fig");
        plantList.add(plant);
        return plantList;
    }

    // Source: https://mentalhealthmatch.com/articles/anxiety/inspiring-mental-health-quotes
    public static ArrayList<String> generateQuoteList(){
        ArrayList<String> quoteList= new ArrayList<>();
        quoteList.add("Just because no one else can heal or do your inner work for you, doesn't mean you should, or need to do it alone.");
        quoteList.add("Your present circumstances don't determine where you go; they merely determine where you start.");
        quoteList.add("Happiness can be found even in the darkest of times, if one only remembers to turn on the light.");
        quoteList.add("Being able to be your true self is one of the strongest components of good mental health.");
        quoteList.add("‘Positive vibes only’ isn’t a thing. Humans have a wide range of emotions and that’s OK.");
        quoteList.add("Change what you can, manage what you can’t.");
        quoteList.add("If there is no struggle, there is no progress.");
        quoteList.add("Have patience with all things, but chiefly have patience with yourself. Do not lose courage in considering your own imperfections but instantly set about remedying them.");
        quoteList.add("Worrying is carrying tomorrow’s load with today’s strength-carrying two days at once. Worrying doesn’t empty tomorrow of its sorrow, it empties today of its strength.");
        quoteList.add("Start listening to the way you talk to yourself. These interactions will tell you how well you know yourself, how much you respect yourself, and what boundaries you are lacking.");
        return quoteList;
    }

}