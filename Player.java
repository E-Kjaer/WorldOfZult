public class Player {
    private String name; //Player Name
    private Inventory inventory; //Player Inventory

    Player(String name){ //contructor for Player
        this.name = name;
        this.inventory = new Inventory();
    }

    public String getName() { // getter for Player name
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
