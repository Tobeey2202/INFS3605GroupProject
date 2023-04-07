package com.example.infs3605groupproject.objects;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Trail {




    public static ArrayList<Plant> generatePlantList(){

        ArrayList<Plant> plantList= new ArrayList<>();
        //Mountain Cedar Wattle
        Plant plant = new Plant("1", "Acacia elata", "Mountain Cedar Wattle", "Next to UNSW’s International House", "Edible pea flower and pod. Leaves can be used for handwashing when placed in water. Chemicals in the leaves can stun fish. Indigenous hunters use leaves placed in the water in dams to stop the gills from working. Some fish are collected, while the rest are released and left to revive to help maintain the population.", "Species of flowering plant which matures into a tree 30 m high and nearly as wide with a yellow-brown buttressed trunk.",
                "Coastal Eastern Australia","a1_fig", "international_house");
        plant.setFacilitiesInfo("International House, founded in 1968, is a multicultural college for more than 166 senior undergraduate and postgraduate residents from over 80 countries, including Australia. International House provides an ideal atmosphere for students seeking a quiet and mature environment as well as the opportunity to meet friendly students from all over the world. \n" +
                "Find out more: \n" +
                "https://accommodation.unsw.edu.au/colleges/international-house ");
        plant.setAudio(new Audio("audio_mountain_cedar_wattle", "Mountain Cedar Wattle Recording"));
        plantList.add(plant);

        //BlueFlax Lily
        plant = new Plant("2", "Dianella caerulea", "Blue Flax Lily / Blueberry Lily", "Located behind UNSW’s Mathews Building", "The sweet fruit can be eaten raw. Leaves are used to make a strong fibre while the purple juice from the berries is used for dying fibres.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC","a2_fig", "matthew_building");
        plant.setFacilitiesInfo("This plant is located behind UNSW’s Mathews Building. \n" +
                "Inside the Mathews Building is the Mathews food court, Mathews theatres and the Pavillion. It includes CATS rooms and open study spaces for students to get work done and chill with friends. ");
        plantList.add(plant);

        //Native Ginger
        plant = new Plant("3", "Alpinia caerulea", "Native Ginger", "Near this plant is UNSW’s Science Theatre", "All parts of the plant are edible, both raw and cooked. The roots and the pulp of the berries have a ginger flavour. Leaves can be wrapped around meat and cooked in an earth oven. The large leaves can be used as thatch on shelters, and also to wrap food.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a3_fig", "science_theatre");
        plant.setFacilitiesInfo("Right near this plant is UNSW’s Science Theatre.  This building is notable as a lecture hall and has numerous quiet study spots.\n" +
                "\n" +
                "Outside the science theatre, we have the Science Lawn which is also adjacent to the Robert Webster building. The lawn is a key spot for various society events and functions.\n" +
                "\n" +
                "The UNSW Science Theatre also  plays host to a wide array of performances, events and concerts. The Science Theatre is a beautiful setting for stage shows, dance recitals, plays and a range of other cultural events and concerts. \n" +
                "\n" +
                "For more information regarding Venue Hire, click below: \n" +
                "https://bookings.hospitality.unsw.edu.au/kensington--new-south-wales/science-theatre.html ");
        plant.setAudio(new Audio("audio_native_ginger", "Native Ginger Recording"));
        plantList.add(plant);

        //Illawarra Flame Tree
        plant = new Plant("4", "Brachychiton", "Illawarra Flame Tree", "Near this plant is UNSW Science Theatre", "Seeds can be extracted from seed pods, ground and eaten. Seeds are about 18 per cent protein, 25% fat and high in zinc and magnesium. The sturdy fibre of the inner bark can be made into string, dilly bags and fishing nets.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a4_fig", "science_theatre");
        plant.setFacilitiesInfo("Nearby the Flame tree we have the UNSW Science Theatre.  This building is notable as a lecture hall and has numerous quiet study spots.\n" +
                "\n" +
                "Outside the science theatre, we have the Science Lawn which is also adjacent to the Robert Webster building. The lawn is a key spot for various society events and functions.\n" +
                "\n" +
                "The UNSW Science Theatre also  plays host to a wide array of performances, events and concerts. The Science Theatre is a beautiful setting for stage shows, dance recitals, plays and a range of other cultural events and concerts. \n" +
                "\n" +
                "For more information regarding Venue Hire, click below: \n" +
                "https://bookings.hospitality.unsw.edu.au/kensington--new-south-wales/science-theatre.html ");
        plantList.add(plant);

        //Grass Tree
        plant = new Plant("5", "Xanthorrhoea australis", "Grass Tree", "Near the Globe Sculpture Lawn and Main Walkway", "Nectar comes from the long flowering spikes and the soft bases of young leaves are edible. The stalks from old flowers and fruits can be used for tinder when making fire. The tall brown stalks can be used to make spear shafts and the soft wood provides a base for a fire drill when making fire. Tough leaves can be used as knives.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "All states","a5_fig", "main_walkway_and_law_lib");
        plant.setFacilitiesInfo("Situated near the Globe Sculpture Lawn and Main Walkway. \n" +
                "The globe lawn is located opposite the Electrical Eng building, bbqs and other society events are usually held here. \n" +
                "\n" +
                "On this lawn, we have UNSW’s Globe sculpture. UNSW boasts a variety of sculptures, paintings and art across our beautiful campus. To find out more information about this click the link below: \n" +
                "\n" +
                "https://www.estate.unsw.edu.au/developments/unsw-public-art-campus ");
        plant.setAudio(new Audio("audio_grass_tree", "Grass Tree Recording"));
        plantList.add(plant);

        //Spiny-headed Mat-rush
        plant = new Plant("6", "Lomandra longifolia", "Spiny-headed Mat-rush", "Lower Campus", "Raw leaf bases are a refreshing snack for the bush rambler. Tufts of leaves pulled from the clump and the white inner bases can be chewed. They taste like fresh peas. The long slender leaves are excellent for making mats, baskets and food-collecting utensils. Flower heads soaked in water produce a sweet drink.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC, TAS, SA","a6_fig", "roundhouse");
        plant.setFacilitiesInfo("N/A");
        plantList.add(plant);

        //Riberry
        plant = new Plant("7", "Syzygium luehmanni", "Riberry", "Lower Campus", "The white pulp of the fruit makes pleasant eating. The red fruits are often added to fruit salads or used to make jams and jellies.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "North coast QLD, NSW","a7_fig", "roundhouse");
        plant.setFacilitiesInfo("N/A");
        plantList.add(plant);

        //Plum Pine / Brown Pine
        plant = new Plant("8", "Podocarpus elatus", "Plum Pine / Brown Pine", "Near the Michael Birt Lawn", "The black juicy sweet fruit with its plum-like flavour is highly regarded by Aboriginal people. The seeds can also be eaten but have a resinous flavour. The fruit can be used for savoury or sweet dishes, such as chutneys, jams and desserts.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a8_fig", "michael_burt_lawn");
        plant.setFacilitiesInfo("This plant is located near the Michael Birt Lawn. These law/gardens are a nice relaxing place to study, have lunch and hang out with your mates. ");
        plantList.add(plant);

        //Saw Banksia / Old Banksia
        plant = new Plant("9", "Banksia serrata", "Saw Banksia / Old Man Banksia", "Located behind UNSW’s Mathews Building", "Flower spikes steeped in water produce a nectar-sweetened drink. Flowers also attract native animals and birds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC, TAS","a9_fig", "matthew_building");
        plant.setFacilitiesInfo("This plant is located behind UNSW’s Mathews Building. \n" +
                "Inside the Mathews Building is the Mathews food court, Mathews theatres and the Pavillion. It includes CATS rooms and open study spaces for students to get work done and chill with friends. ");
        plantList.add(plant);

        //Tossock Grass
        plant = new Plant("10", "Poa labillardieri", "Tussock Grass", "Located near the Michael Birt Lawn", "Roots were used in cooking. Today this grass is used in gardens in rockeries, near ponds and as a ground cover.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC, TAS, SA","a10_fig", "michael_burt_lawn");
        plant.setFacilitiesInfo("This plant is located near the Michael Birt Lawn. These law/gardens are a nice relaxing place to study, have lunch and hang out with your mates.  ");
        plantList.add(plant);

        //Burrawang
        plant = new Plant("11", "Macrozamia communis", "Burrawang", "Located outside the Sir John Clancy Auditorium", "Seeds can be removed from mature cones and leached in water for a week, with daily water changes, to remove toxins. The pulp of the seeds can then be made into cakes and roasted over embers.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a11_fig", "sir_john_clancy_building");
        plant.setFacilitiesInfo("This plant is located outside the Sir Sir John Clancy Auditorium. This building has a single theatre located within the building, located behind the Matthews Theatres. Many lectures are often held there. There are also study tables located inside. \n" +
                "\n" +
                "More Info: \n" +
                "https://www.ttw.com.au/projects/unsw-gate-9 ");
        plantList.add(plant);

        //Sandpaper Fig
        plant = new Plant("12", "Ficus coronata", "Sandpaper Fig", "Located behind the Electrical Engineering Building", "The fruits, which are ripe from october to December, can be eaten whole or made into jam. Be sure to remove the hairy skin first. Traditionally the rough leaves are used as sandpaper to sharpen tools and weapons and to rub medicine into wounds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NT, QLD, NSW, VIC","a12_fig", "electrical_engineering_building");
        plant.setFacilitiesInfo("This plant is located behind the Electrical Engineering Building. \n" +
                "The home of discovery and breakthroughs since the 1960s, the Electrical Engineering Building has multiple lecture theatres and classrooms where students can study and collaborate with their peers. \n" +
                "\n" +
                "The left side of the EE building is Nura Gilli. \n" +
                "Nura Gilli is UNSW’s Hub for Indigenous Programs, is an important hub on campus for First Nations students and staff alike and is now showcased in a fresh and engaging way. \n" +
                "\n" +
                "https://www.indigenous.unsw.edu.au/\n");
        plant.setAudio(new Audio("audio_sandpaper_fig", "Sandpaper Fig Recording"));
        plantList.add(plant);

        //Rock Lily
        plant = new Plant("13", "Dendrobium speciosum", "Rock Lily", "Located behind the Electrical Engineering Building", "The thickened stems and roots can be chewed or sucked.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW, VIC","a13_fig", "electrical_engineering_building");
        plant.setFacilitiesInfo("This plant is located behind the Electrical Engineering Building. \n" +
                "The home of discovery and breakthroughs since the 1960s, the Electrical Engineering Building has multiple lecture theatres and classrooms where students can study and collaborate with their peers. \n" +
                "\n" +
                "The left side of the EE building is Nura Gilli. \n" +
                "Nura Gilli is UNSW’s Hub for Indigenous Programs, is an important hub on campus for First Nations students and staff alike and is now showcased in a fresh and engaging way. \n" +
                "\n" +
                "https://www.indigenous.unsw.edu.au/ ");
        plantList.add(plant);

        //Water Vine
        plant = new Plant("14", "Cissus antarctica", "Water Vine", "Located behind the Electrical Engineering Building", "Mixed with nectar and water, the fruits are edible but have a watery, acidic taste. Unripe fruits have been traditionally used for stomach complaints while the stems can be used to make harnesses for climbing tall trees.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a14_fig", "electrical_engineering_building");
        plant.setFacilitiesInfo("This plant is located behind the Electrical Engineering Building. \n" +
                "The home of discovery and breakthroughs since the 1960s, the Electrical Engineering Building has multiple lecture theatres and classrooms where students can study and collaborate with their peers. \n" +
                "\n" +
                "The left side of the EE building is Nura Gilli. \n" +
                "Nura Gilli is UNSW’s Hub for Indigenous Programs, is an important hub on campus for First Nations students and staff alike and is now showcased in a fresh and engaging way. \n" +
                "\n" +
                "https://www.indigenous.unsw.edu.au/ ");
        plantList.add(plant);

        //Prickly-leaved Ta Tree
        plant = new Plant("15", "Melaleuca styphelioides", "Prickly-leaved Tea Tree", "Located behind the Electrical Engineering Building", "The versatile bark can be used for roofing, blankets, rain capes, bandages, plates, caulking for canoes, rafts, baby slings and as torches to smoke away mosquitoes. Leaves can be crushed and sniffed for colds and headaches. An infusion of leaves makes a wash for skin irritants. The nectar-filled flowers can be soaked in water for a drink.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a15_fig", "electrical_engineering_building");
        plant.setFacilitiesInfo("This plant is located behind the Electrical Engineering Building. \n" +
                "The home of discovery and breakthroughs since the 1960s, the Electrical Engineering Building has multiple lecture theatres and classrooms where students can study and collaborate with their peers. \n" +
                "\n" +
                "The left side of the EE building is Nura Gilli. \n" +
                "Nura Gilli is UNSW’s Hub for Indigenous Programs, is an important hub on campus for First Nations students and staff alike and is now showcased in a fresh and engaging way. \n" +
                "https://www.indigenous.unsw.edu.au/ ");
        plantList.add(plant);

        //Hill's Fig
        plant = new Plant("16", "Ficus hillii", "Hill's Fig", "Near the Tyree Energy Technologies Building", "The succulent figs are a popular and tasty fruit.", "It is generally a very resilient tree, both drought and shade tolerant. It is excellent for hedging or screening or as a pruned specimen to maintain size and shape. Alternatively, it is suitable for ornamental or shade tree applications.",
                "All states","a16_fig", "tyree_energy_technology_building");
        plant.setFacilitiesInfo("Nearby building: Tyree Energy Technologies Building");
        plantList.add(plant);

        //Port Jackson Fig
        plant = new Plant("17", "Ficus rubiginosa", "Port Jackson Fig", "Located right outside the entrance to UNSW Law Library/Building on our main walkway ", "The small yellow fruit can be consumed raw or preserved in a ‘cake’ but should only be eaten when ripe, soft and pulpy. The twine made from fibres from the plant is used for dilly bags and the inner bark for fishing nets. The timber can be used to make items for food collection while the sap can be used as a natural latex for wounds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a17_fig", "main_walkway_and_law_lib");
        plant.setFacilitiesInfo("Located right outside the entrance to UNSW Law Library/Building on our main walkway is the Port Jackson Fig. The Fig trees are iconic to UNSW Kensington campus and are estimated to be up to 120 years old. \n" +
                "In 2018, UNSW students and staff took on an experiment to help protect these heritage listed Fig Trees. To read more about this, click this link: \n" +
                "https://newsroom.unsw.edu.au/news/science-tech/biology-experiment-helps-historic-unsw-fig-trees-put-down-new-roots ");
        plant.setAudio(new Audio("audio_port_jackson_fig", "Mountain Cedar Wattle Recording"));
        plantList.add(plant);

        //Tuckeroo
        plant = new Plant("18", "Cupaniopsis anacardioides", "Tuckeroo", "Near the Alumni Lawn East and behind UNSW’s Business School", "The fruit is a pumpkin-shaped orange-yellow fleshy berry. It is edible but has a very bitter taste.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "Coastal QLD and NSW","a18_fig", "alumni_lawn_east_near_business_school");
        plant.setFacilitiesInfo("This plant is situated near Alumni Lawn East and behind UNSW’s Business School. \n" +
                "\n" +
                "The new Alumni Park was renovated in 2021, to provide a more interactive and engaging experience for the UNSW Sydney community.\n" +
                "The new landscape embraces its past with the inclusion of native plants and tree species along with integrated local indigenous artwork. Consultation with the local Aboriginal Community, the traditional owners of the land on which Alumni Park is situated, has been an important aspect of the project.\n + To find out more info: \n" +
                "https://www.inside.unsw.edu.au/campus-life/alumni-park-revitalisation \n" +
                "\n" +
                "https://www.inside.unsw.edu.au/campus-life/alumni-park-being-brought-life-in-2021 ");
        plantList.add(plant);

        //Native Mint
        plant = new Plant("19", "Prostanthera ovalifolia", "Native Mint", "Next to UNSW’s International House", "Indigenous people have used the leaves to treat colds and headaches. The leaves are crushed and placed on the temple to relieve headaches, or infused in hot water as an inhalant, or used externally. The leaves are antibacterial, antifungal and carminative. Native Mint can also be used with the foods that are traditionally accompanied by mint.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW, VIC, TAS","a19_fig", "international_house");
        plant.setFacilitiesInfo("This plant is situated next to UNSW’s International House. \n" +
                "International House, founded in 1968, is a multicultural college for more than 166 senior undergraduate and postgraduate residents from over 80 countries, including Australia. International House provides an ideal atmosphere for students seeking a quiet and mature environment as well as the opportunity to meet friendly students from all over the world. \n" +
                "Find out more: \n" +
                "https://accommodation.unsw.edu.au/colleges/international-house ");
        plantList.add(plant);

        //Health Banksia
        plant = new Plant("20", "Banksia ericifolia", "Heath Banksia", "Near the pool lawn in front of UNSW's fitness and Aquatic Centre", "Flower spikes can be steeped in water and the nectar-sweetened water drunk. Flowers also attract native animals and birds.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW","a20_fig", "aquatic_centre");
        plant.setFacilitiesInfo("This plant is located near the pool lawn. \n" +
                "The pool lawn is in front of UNSW’s fitness and Aquatic Centre. \n" +
                "The home of UNSW fitness, health and wellbeing. If you are looking to work out in the gym, swim some laps, join a group fitness class, or get active with friends – UNSW Fitness & Aquatic Centre is the number one health and wellbeing destination to help you achieve your goals.\n" +
                "Our facilities are available to not only the students and staff of UNSW but to the public as well and we would love the opportunity to support you on your health and fitness journey. \n" +
                "To find out more: \n" +
                "https://unswfac.com.au/ ");
        plantList.add(plant);

        //Crimson Bottlebrush
        plant = new Plant("21", "Callistemon citrinus", "Crimson Bottlebrush", "Near the pool lawn in front of UNSW's fitness and Aquatic Centre", "The leaves are used as a tea substitute and have a delightfully refreshing flavour. The common use is as a dye for wood. A tan dye is obtained from the flowers and a cinnamon dye from the leaves.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW, VIC","a21_fig", "aquatic_centre");
        plant.setFacilitiesInfo("This plant is located near the pool lawn. \n" +
                "The pool lawn is in front of UNSW’s fitness and Aquatic Centre. \n");
        plantList.add(plant);

        //Broad-leaved Paperback
        plant = new Plant("22", "Melaleuca quinquenervia", "Broad-leaved Paperbark", "Near UNSW’s roundhouse", "The leaves can be steeped for sore throats and as a wash, while young leaves are either chewed as a treatment for head colds or brewed in warm water to make a liquid to treat headaches.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "QLD, NSW","a22_fig", "roundhouse");
        plant.setFacilitiesInfo("The Broad-leaved Paperbark is situated near UNSW’s roundhouse. \n" +
                "The Roundhouse, as one of UNSW Sydney's earliest buildings, was constructed in 1961. (https://www.estate.unsw.edu.au/roundhouse#:~:text=The%20Roundhouse%2C%20as%20one%20of,Madigan%2C%20Torzillo%2C%20Briggs%20Architects) \n" +
                "UNSW Roundhouse is Sydney's premier multi-purpose venue for all events. From live gigs, international conferences, film premieres, to the biggest and best. \n" +
                "To find out more about what's on at Roundhouse, click the link below: \n" +
                "https://www.arc.unsw.edu.au/roundhouse ");
        plantList.add(plant);

        //Gymea Lily
        plant = new Plant("23", "Doryanthes excelsa", "Gymea Lily", "Near the blockhouse and square house", "The stems are roasted. They are cut when young and about half a metre tall, with a thickness similar to a person’s arm. The roots can also be roasted and made into a cake to be eaten cold.", "Long-lived wattle-tree, potentially reaching 30m, with a dense conical to medium domed canopy.",
                "NSW","a23_fig", "square_house_building");
        plant.setFacilitiesInfo("nearby buildings: blockhouse and square house ");
        plantList.add(plant);

        //Bolwarra
        plant = new Plant("24", "Eupomatia laurina", "Bolwarra", "Located behind UNSW’s Mathews Building", "The sticky sweep pulp coating the seeds is edible.", "Large tree of the family Malvaceae and is famous for the bright red bell-shaped flowers that often cover the whole tree when it is leafless.",
                "Coastal QLD, NSW and VIC", "a24_fig", "matthew_building");
        plant.setFacilitiesInfo("This plant is located behind UNSW’s Mathews Building. \n" +
                "Inside the Mathews Building is the Mathews food court, Mathews theatres and the Pavillion. It includes CATS rooms and open study spaces for students to get work done and chill with friends. ");
        plantList.add(plant);
        //Cabbage Palm Tree
        plant = new Plant("25", "Livinstona australis", "Cabbage Tree Palm", "Sir John Clancy Auditorium", "The cabbage tree palm is traditional food for coastal Indigenous.", "It had value for early settlers as ornamental/for shade, copying Indigenous people by eating the hearts, and using the trunks for feeding troughs to cattle.",
                "QLD, VIC", "a25_fig", "sir_john_clancy_building");
        plant.setFacilitiesInfo("Nearby building: Sir John Clancy Auditorium");
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