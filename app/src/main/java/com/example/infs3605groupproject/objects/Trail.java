package com.example.infs3605groupproject.objects;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        Plant plant = new Plant("1", "Acacia elata", "Mountain Cedar Wattle", "In front of Law Library", "Edible pea flower and pod. Leaves can be used for handwashing when placed in water. Chemicals in the leaves can stun fish. Indigenous hunters use leaves placed in the water in dams to stop the gills from working. Some fish are collected, while the rest are released and left to revive to help maintain the population.", "Species of flowering plant which matures into a tree 30 m high and nearly as wide with a yellow-brown buttressed trunk.",
                "Coastal Eastern Australia","a1_fig");
        plantList.add(plant);
        plant = new Plant("2", "Dianella caerulea", "Blue Flax Lily / Blueberry Lily", "Lower Campus", "The sweet fruit can be eaten raw. Leaves are used to make a strong fibre while the purple juice from the berries is used for dying fibres.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC","a2_fig");
        plantList.add(plant);
        plant = new Plant("3", "Alpinia caerulea", "Native Ginger", "Lower Campus", "All parts of the plant are edible, both raw and cooked. The roots and the pulp of the berries have a ginger flavour. Leaves can be wrapped around meat and cooked in an earth oven. The large leaves can be used as thatch on shelters, and also to wrap food.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a3_fig");
        plantList.add(plant);
        plant = new Plant("4", "Brachychiton", "Illawarra Flame Tree", "Lower Campus", "Seeds can be extracted from seed pods, ground and eaten. Seeds are about 18 per cent protein, 25% fat and high in zinc and magnesium. The sturdy fibre of the inner bark can be made into string, dilly bags and fishing nets.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a4_fig");
        plantList.add(plant);
        plant = new Plant("5", "Xanthorrhoea australis", "Grass Tree", "Lower Campus", "Nectar comes from the long flowering spikes and the soft bases of young leaves are edible. The stalks from old flowers and fruits can be used for tinder when making fire. The tall brown stalks can be used to make spear shafts and the soft wood provides a base for a fire drill when making fire. Tough leaves can be used as knives.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "All states","a5_fig");
        plantList.add(plant);
        plant = new Plant("6", "Lomandra longifolia", "Spiny-headed Mat-rush", "Lower Campus", "Raw leaf bases are a refreshing snack for the bush rambler. Tufts of leaves pulled from the clump and the white inner bases can be chewed. They taste like fresh peas. The long slender leaves are excellent for making mats, baskets and food-collecting utensils. Flower heads soaked in water produce a sweet drink.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC, TAS, SA","a6_fig");
        plantList.add(plant);
        plant = new Plant("7", "Syzygium luehmanni", "Riberry", "Lower Campus", "The white pulp of the fruit makes pleasant eating. The red fruits are often added to fruit salads or used to make jams and jellies.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "North coast QLD, NSW","a7_fig");
        plantList.add(plant);
        plant = new Plant("8", "Podocarpus elatus", "Plum Pine / Brown Pine", "Lower Campus", "The black juicy sweet fruit with its plum-like flavour is highly regarded by Aboriginal people. The seeds can also be eaten but have a resinous flavour. The fruit can be used for savoury or sweet dishes, such as chutneys, jams and desserts.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a8_fig");
        plantList.add(plant);
        plant = new Plant("9", "Banksia serrata", "Saw Banksia / Old Man Banksia", "Lower Campus", "Flower spikes steeped in water produce a nectar-sweetened drink. Flowers also attract native animals and birds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC, TAS","a9_fig");
        plantList.add(plant);
        plant = new Plant("10", "Poa labillardieri", "Tussock Grass", "Lower Campus", "Roots were used in cooking. Today this grass is used in gardens in rockeries, near ponds and as a ground cover.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC, TAS, SA","a10_fig");
        plantList.add(plant);
        plant = new Plant("11", "Macrozamia communis", "Burrawang", "Lower Campus", "Seeds can be removed from mature cones and leached in water for a week, with daily water changes, to remove toxins. The pulp of the seeds can then be made into cakes and roasted over embers.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a11_fig");
        plantList.add(plant);
        plant = new Plant("12", "Ficus coronata", "Sandpaper Fig", "Lower Campus", "The fruits, which are ripe from october to December, can be eaten whole or made into jam. Be sure to remove the hairy skin first. Traditionally the rough leaves are used as sandpaper to sharpen tools and weapons and to rub medicine into wounds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NT, QLD, NSW, VIC","a12_fig");
        plantList.add(plant);
        plant = new Plant("13", "Dendrobium speciosum", "Rock Lily", "Lower Campus", "The thickened stems and roots can be chewed or sucked.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW, VIC","a13_fig");
        plantList.add(plant);
        plant = new Plant("14", "Cissus antarctica", "Water Vine", "Lower Campus", "Mixed with nectar and water, the fruits are edible but have a watery, acidic taste. Unripe fruits have been traditionally used for stomach complaints while the stems can be used to make harnesses for climbing tall trees.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a14_fig");
        plantList.add(plant);
        plant = new Plant("15", "Melaleuca styphelioides", "Prickly-leaved Tea Tree", "Lower Campus", "The versatile bark can be used for roofing, blankets, rain capes, bandages, plates, caulking for canoes, rafts, baby slings and as torches to smoke away mosquitoes. Leaves can be crushed and sniffed for colds and headaches. An infusion of leaves makes a wash for skin irritants. The nectar-filled flowers can be soaked in water for a drink.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a15_fig");
        plantList.add(plant);
        plant = new Plant("16", "Ficus hillii", "Hill's Fig", "Lower Campus", "The succulent figs are a popular and tasty fruit.", "It is generally a very resilient tree, both drought and shade tolerant. It is excellent for hedging or screening or as a pruned specimen to maintain size and shape. Alternatively, it is suitable for ornamental or shade tree applications.",
                "All states","a16_fig");
        plantList.add(plant);
        plant = new Plant("17", "Ficus rubiginosa", "Port Jackson Fig", "Lower Campus", "The small yellow fruit can be consumed raw or preserved in a ‘cake’ but should only be eaten when ripe, soft and pulpy. The twine made from fibres from the plant is used for dilly bags and the inner bark for fishing nets. The timber can be used to make items for food collection while the sap can be used as a natural latex for wounds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a17_fig");
        plantList.add(plant);
        plant = new Plant("18", "Cupaniopsis anacardioides", "Tuckeroo", "Lower Campus", "The fruit is a pumpkin-shaped orange-yellow fleshy berry. It is edible but has a very bitter taste.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "Coastal QLD and NSW","a18_fig");
        plantList.add(plant);
        plant = new Plant("19", "Prostanthera ovalifolia", "Native Mint", "Lower Campus", "Indigenous people have used the leaves to treat colds and headaches. The leaves are crushed and placed on the temple to relieve headaches, or infused in hot water as an inhalant, or used externally. The leaves are antibacterial, antifungal and carminative. Native Mint can also be used with the foods that are traditionally accompanied by mint.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW, VIC, TAS","a19_fig");
        plantList.add(plant);
        plant = new Plant("20", "Banksia ericifolia", "Heath Banksia", "Lower Campus", "Flower spikes can be steeped in water and the nectar-sweetened water drunk. Flowers also attract native animals and birds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW","a20_fig");
        plantList.add(plant);
        plant = new Plant("21", "Callistemon citrinus", "Crimson Bottlebrush", "Lower Campus", "The leaves are used as a tea substitute and have a delightfully refreshing flavour. The common use is as a dye for wood. A tan dye is obtained from the flowers and a cinnamon dye from the leaves.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC","a21_fig");
        plantList.add(plant);
        plant = new Plant("22", "Melaleuca quinquenervia", "Broad-leaved Paperbark", "Lower Campus", "The leaves can be steeped for sore throats and as a wash, while young leaves are either chewed as a treatment for head colds or brewed in warm water to make a liquid to treat headaches.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a22_fig");
        plantList.add(plant);
        plant = new Plant("23", "Doryanthes excelsa", "Gymea Lily", "Lower Campus", "The stems are roasted. They are cut when young and about half a metre tall, with a thickness similar to a person’s arm. The roots can also be roasted and made into a cake to be eaten cold.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW","a23_fig");
        plantList.add(plant);
        plant = new Plant("24", "Eupomatia laurina", "Bolwarra", "Opposite of UNSW Bookshop", "The sticky sweep pulp coating the seeds is edible.", "Large tree of the family Malvaceae and is famous for the bright red bell-shaped flowers that often cover the whole tree when it is leafless.",
                "Coastal QLD, NSW and VIC", "a24_fig");
        plantList.add(plant);
        plant = new Plant("25", "Livinstona australis", "Cabbage Tree Palm", "Opposite of UNSW Bookshop", "The cabbage tree palm is traditional food for coastal Indigenous.", "It had value for early settlers as ornamental/for shade, copying Indigenous people by eating the hearts, and using the trunks for feeding troughs to cattle.",
                "QLD, VIC", "a25_fig");
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

    public static ArrayList<LatLng> generateMarkerList() {
        ArrayList<LatLng> markerList = new ArrayList<>();
        // plant 1 - hill's fig
        markerList.add(new LatLng(-33.917298, 151.226410));
        // plant 2 - gymea lily
        markerList.add(new LatLng(-33.916627, 151.226242));
        // plant 3 - broad-leaved paperbark
        markerList.add(new LatLng(-33.916239, 151.226673));
        // plant 4 - crimson bottlebrush
        markerList.add(new LatLng(-33.915813, 151.226503));
        // plant 5 - heath banksia
        markerList.add(new LatLng(-33.915613, 151.226610));
        // plant 6 - mountain cedar wattle
        markerList.add(new LatLng(-33.9156603, 151.2268734));
        // plant 7 - native mint
        markerList.add(new LatLng(-33.915810, 151.226889));
        // plant 8 - tuckeroo
        markerList.add(new LatLng(-33.916137, 151.228144));
        // plant 9 - prickly-leaved tea tree
        markerList.add(new LatLng(-33.917090, 151.232118));
        // plant 10 - water vine
        markerList.add(new LatLng(-33.917239, 151.232071));
        // plant 11 - rock lily
        markerList.add(new LatLng(-33.917341, 151.232045));
        // plant 12 - sandpaper fig
        markerList.add(new LatLng(-33.917481, 151.232010));
        // plant 13 - burrawang
        markerList.add(new LatLng(-33.916864, 151.234317));
        // plant 14 - plum pine/ brown pine
        markerList.add(new LatLng(-33.9164057, 151.2343634));
        // plant 15 - tussock grass
        markerList.add(new LatLng(-33.916681, 151.234676));
        // plant 16 - cabbage tree palm
        markerList.add(new LatLng(-33.9168536, 151.2347782));
        // plant 17 - bolwarra
        markerList.add(new LatLng(-33.9179983, 151.2347711));
        // plant 18 - blue flax lily
        markerList.add(new LatLng(-33.917949, 151.234529));
        // plant 19 - saw banksia / old man banksia
        markerList.add(new LatLng(-33.917927, 151.234285));
        // plant 20 - spiny-headed mat-rush
        markerList.add(new LatLng(-33.917801, 151.232152));
        // plant 21 - riberry
        markerList.add(new LatLng(-33.917967, 151.232086));
        // plant 22 - grass tree
        markerList.add(new LatLng(-33.918263, 151.232022));
        // plant 23 - native ginger
        markerList.add(new LatLng(-33.917059, 151.230013));
        // plant 24 - illawarra flame tree
        markerList.add(new LatLng(-33.917237, 151.230294));
        // plant 25 - port jackson fig
        markerList.add(new LatLng(-33.9173428, 151.2278755));
        return markerList;
    }

}