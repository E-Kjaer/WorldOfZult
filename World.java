/* World class for modeling the entire in-game world
 */

import java.util.ArrayList;

public class World {
    private Space entry;
    private ArrayList<Group> groups;

    // Constructor
    public World () {
        // Adds items
        Item lys = new Item("Lyspære", "Denne pære udsender specifikke bølgelængder af lys, " +
                "ofte blåt og rødt, som er afgørende for fotosyntese og plantevækst." +
                " Dette er også kaldet et vækstlys.");
        Item  vandingssystem = new Item("Vandingssystem","Vandingssystemet opsættes på en farm," +
                " hvor afgrøderne ikke får nok vand fra naturen til at kunne gro." +
                " Dette gør ellers golde områder til frugtbar jord.");
        Item biokul = new Item("Biokul","Biokul modvirker dårlig jordkvalitet," +
                " som er et problem i nogle lande. Bedre jordkvalitet gør, at man kan dyrke flere varianter" +
                " af afgrøder.");
        Item maskine = new Item("Såmaskine", "Anvendes til såning af korn eller frø.");
        Item opbaveringskasse = new Item("Opbevaringskasse", "Denne boks skærmer for vind og vejr," +
                " hvilket forlænger holdbarheden af maden.");


        // Adds groups
        Group groupDrivhus = new Group(lys, "Hej" + Game.getContext().getPlayer().getName() + "Her dyrker vi grøntsager, som f.eks. tomater, agurker og peberfrugter. Vores grøntsager vokser bedst, når der er meget dagslys. Desværre kan vi ikke styre vejret eller hvornår solen går ned, så vi er meget afhængige af sæsonerne. “);
        Group groupGrass = new Group(scythe, "We live by the tall grass");
        Group groupLand = new Group(tractor, "We live by this flat piece of dirt");

        // Adds groups to the list of groups
        this.groups = new ArrayList<Group>();
        groups.add(groupSea);
        //groups.add(groupGrass);
        //groups.add(groupLand);

        // Adds rooms
        Space entry    = new Space("Entry", "This is the entry");
        Space space1 = new Space("Empty land", "This is an empty land");
        Space space2 = new Space("Group land", "This is a land with a group", groupSea);
        Space space3 = new Space("Empty land", "This is an empty land");
        Space space4 = new Space("Group land", "This is a land with a group");
        Space space5 = new Space("Group land", "This is a land with a group");
        Space space6 = new Space("Group land", "This is a land with a group");
        Space space7 = new Space("Empty land", "This is an empty land");
        Space space8 = new Space("Group land", "This is a land with a group");

        space2.addItem(fishingRod);

        entry.addEdge("syd", space2);
        space2.addEdge("nord", entry);
        space2.addEdge("øst", space3);
        space2.addEdge("syd", space6);
        space2.addEdge("vest", space1);
        space1.addEdge("øst", space2);
        space1.addEdge("syd", space5);
        space3.addEdge("vest", space2);
        space3.addEdge("øst", space4);
        space4.addEdge("sydvest", space7);
        space4.addEdge("vest", space3);
        space5.addEdge("nord", space1);
        space5.addEdge("øst", space6);
        space6.addEdge("nord", space2);
        space6.addEdge("øst", space7);
        space6.addEdge("vest", space5);
        space7.addEdge("vest", space6);
        space7.addEdge("nordøst", space4);
        space7.addEdge("syd", space8);
        space8.addEdge("nord", space7);

        /*
        Space sea = new Space("Sea", "This is the sea", groupSea);
        Space grassLand = new Space("Grassland", "This is the grasslands", groupGrass);
        Space dirtLand      = new Space("Dirtland", "This is dirty", groupLand);
        Space outside  = new Space("Outside", "This, unlike the other places, is the outside");


        // Adds items to the spaces
        sea.addItem(tractor);
        grassLand.addItem(fishingRod);
        dirtLand.addItem(scythe);

        // Adds edges, which is the paths between rooms
        entry.addEdge("door", sea);
        sea.addEdge("door", grassLand);
        grassLand.addEdge("north", dirtLand);
        grassLand.addEdge("south", outside);
        grassLand.addEdge("east", sea);
        dirtLand.addEdge("door", grassLand);
        outside.addEdge("door", grassLand);
        */
        this.entry = entry;
    }

    // Get spawnpoint / entry to the world
    public Space getEntry () {
        return entry;
    }

    // Get list of groups
    public ArrayList<Group> getGroups() {
        return groups;
    }
}

