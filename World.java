/* World class for modeling the entire in-game world
 */

import java.util.ArrayList;

class World {
    private Space entry;
    private ArrayList<Group> groups;

    // Constructor
    World () {
        // Adds items
        Item fishingRod = new Item("Fishing_Rod");
        Item scythe = new Item("Scythe");
        Item tractor = new Item("Tractor");


        // Adds groups
        Group groupSea = new Group(fishingRod, "We live by the sea, but we only use it for bathing");
        Group groupGrass = new Group(scythe, "We live by the tall grass");
        Group groupLand = new Group(tractor, "We live by this flat piece of dirt");

        // Adds groups to the list of groups
        this.groups = new ArrayList<Group>();
        groups.add(groupSea);
        groups.add(groupGrass);
        groups.add(groupLand);

        // Adds rooms
        Space entry    = new Space("Entry", "This is the entry");
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
        dirtLand.addEdge("door", grassLand);
        outside.addEdge("door", grassLand);

        this.entry = entry;
    }

    // Get spawnpoint / entry to the world
    Space getEntry () {
        return entry;
    }

    // Get list of groups
    ArrayList<Group> getGroups() {
        return groups;
    }
}

