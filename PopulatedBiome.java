public class PopulatedBiome extends Biome {
    private Item item;
    private Group group;

    public PopulatedBiome (String biomeName, String biomeDescription, String correctItemName, String groupSpeech) {
        super(biomeName, biomeDescription);
        this.item = new Item(correctItemName);
        this.group = new Group(this.item, groupSpeech);
    }

    public Item getItem() {
        return item;
    }

    public Group getGroup() {
        return group;
    }
}
