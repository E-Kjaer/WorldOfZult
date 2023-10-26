import java.util.ArrayList;
import java.util.Collections;

public class BiomeRandomizer {
    public static ArrayList<Space> createRandomizedRooms(ArrayList<PopulatedBiome> pBiomes, ArrayList<Biome> eBiomes, int amountPBiome, int amountEBiome) {
        ArrayList<Biome> randomBiomes = randomizeBiomes(pBiomes, eBiomes, amountPBiome, amountEBiome);
        ArrayList<Space> randomRooms = randomizeRooms(randomBiomes);
        addItemsToRooms(randomRooms, randomBiomes);
        return randomRooms;
    }

    public static ArrayList<Group> getGroupsFromRooms(ArrayList<Space> rooms) {
        ArrayList<Group> groups = new ArrayList<Group>();

        for (Space room : rooms) {
            if (room.getGroup() != null) {
                groups.add(room.getGroup());
            }
        }

        return groups;
    }

    private static ArrayList<Biome> randomizeBiomes(ArrayList<PopulatedBiome> pBiomes, ArrayList<Biome> eBiomes, int amountPBiome, int amountEBiome) {
        ArrayList<Biome> randomizedBiomes = new ArrayList<Biome>();

        Collections.shuffle(pBiomes); // Randomize chosen biomes
        Collections.shuffle(eBiomes);

        for (int i = 0; i < amountPBiome; i++) { // Add biomes with groups
            randomizedBiomes.add(pBiomes.get(i));
        }

        for (int i = 0; i < amountEBiome; i++) { // Add biomes with no groups
            randomizedBiomes.add(eBiomes.get(i));
        }

        return randomizedBiomes;
    }

    private static ArrayList<Space> randomizeRooms (ArrayList<Biome> randomizedBiomes) {
        // Create randomized rooms / spaces
        ArrayList<Space> randomRooms = new ArrayList<Space>(); // List with all rooms
        Collections.shuffle(randomizedBiomes); // Change room locations

        for (int i = 0; i < 4; i++) {
            randomRooms.add(new Space(randomizedBiomes.get(i)));
        }

        return randomRooms;
    }

    private static void addItemsToRooms(ArrayList<Space> randomRooms, ArrayList<Biome> biomes) {
        // Adds items to the spaces
        ArrayList<Biome> randomItems = (ArrayList<Biome>) biomes.clone();

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
    }
}
