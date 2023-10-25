public class Biome {
    private String biomeName;
    private String biomeDescription;

    public Biome (String biomeName, String biomeDescription) {
        this.biomeName = biomeName;
        this.biomeDescription = biomeDescription;
    }

    public String getBiomeName() {
        return biomeName;
    }

    public String getBiomeDescription() {
        return biomeDescription;
    }
}
