/* World class for modeling the entire in-game world
 */

import java.util.ArrayList;
import java.util.Collections;

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

        // Randomizing rooms and save chosen groups into ArrayList
        ArrayList<Biome> randomizedBiomes = new ArrayList<Biome>();
        this.groups = new ArrayList<Group>();

        Collections.shuffle(populatedBiomes); // Randomize chosen biomes
        Collections.shuffle(emptyBiomes);

        for (int i = 0; i < 3; i++) { // Add biomes with groups
            randomizedBiomes.add(populatedBiomes.get(i));
            this.groups.add(populatedBiomes.get(i).getGroup()); // Add group to list
        }

        for (int i = 0; i < 1; i++) { // Add biomes with no groups
            randomizedBiomes.add(emptyBiomes.get(i));
        }

        // Create randomized rooms / spaces
        ArrayList<Space> randomRooms = new ArrayList<Space>(); // List with all rooms
        Collections.shuffle(randomizedBiomes); // Change room locations

        for (int i = 0; i < 4; i++) {
            randomRooms.add(new Space(randomizedBiomes.get(i)));
        }

        // Adds items to the spaces
        ArrayList<Biome> randomItems = (ArrayList<Biome>) randomizedBiomes.clone();

        /* For-loops runs all the rooms and adds items to them.
        It does this by randomizing the items and then going through the rooms.
        If the random items correspond to the group, it randomizes and tries again.
        It then adds the item if it can and removes the item from the list of items. */
        for (int i = 0; i < 4; i++) {
            while (true) {
                Collections.shuffle(randomItems); // Randomize layout
                // Check not same room
                if (!randomRooms.get(i).getDescription().equals(randomItems.get(0).getBiomeDescription())) {
                    // Check if it can add item
                    if (randomItems.get(0) instanceof PopulatedBiome pBiome) {
                        randomRooms.get(i).addItem(pBiome.getItem());
                    }

                    randomItems.remove(0);
                    break;
                }
            }
        }

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