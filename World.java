/* World class for modeling the entire in-game world
 */

import java.util.ArrayList;

public class World {
    private Space entry;
    private ArrayList<Group> groups;

    // Constructor
    public World () {
        //Populated biomes with groups and their corresponding items
        ArrayList<PopulatedBiome> populatedBiomes = new ArrayList<PopulatedBiome>();

        populatedBiomes.add(new PopulatedBiome(
                "Sea",
                "This is the sea",
                "Fishing_Rod",
                "We live by the sea, but we only use it for bait"));

        populatedBiomes.add(new PopulatedBiome(
                "Dirtland",
                "This is dirty",
                "Tractor",
                "We live by this flat piece of dirt"));

        populatedBiomes.add(new PopulatedBiome(
                "Grassland",
                "This is the grasslands",
                "Scythe",
                "We live by tall grass"));

        populatedBiomes.add(new PopulatedBiome(
                "Greenhouse",
                "This is a nice greenhouse",
                "UV-lights",
                "The greenhouse is nice, but the plants doesn't get enough light"));

        // Empty biomes with no groups
        ArrayList<Biome> emptyBiomes = new ArrayList<Biome>();

        emptyBiomes.add(new Biome("Outside",
                "This is the outside. How nice"));

        emptyBiomes.add(new Biome("Beach",
                "This is by the beach. It is sunny and nice."));

        // Add non-randomized rooms
        Space entry = new Space("Entry", "This is the entry");

        // Create and get random rooms
        ArrayList<Space> randomRooms = BiomeRandomizer.createRandomizedRooms(populatedBiomes, emptyBiomes, 3, 1);

        // Get groups
        this.groups = BiomeRandomizer.getGroupsFromRooms(randomRooms);

        // Adds edges, which is the paths between rooms
        entry.addEdge("door", randomRooms.get(0));
        randomRooms.get(0).addEdge("north", randomRooms.get(1));
        randomRooms.get(1).addEdge("south", randomRooms.get(0));
        randomRooms.get(1).addEdge("west", randomRooms.get(2));
        randomRooms.get(1).addEdge("east", randomRooms.get(3));
        randomRooms.get(2).addEdge("east", randomRooms.get(1));
        randomRooms.get(3).addEdge("west", randomRooms.get(1));

        // TEST
        System.out.println("TEST AF RANDOMIZER");
        for (Space room : randomRooms) {
            System.out.print("Room : " + room.getName());

            if (!room.getInventory().getItems().isEmpty()) {
                System.out.println(", Item : " + room.getInventory().getItems().get(0).getName());
            } else {
                System.out.println(", no item");
            }
        }
        System.out.println();

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