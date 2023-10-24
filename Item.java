public class Item {
    private String name; //Item name

    Item(String name){ //contructor for Item
        this.name = name;
    }

    public String getName(){ //getter for Name
        return name;
    }
    
    public boolean equals(Item item) {
        return item.getName().equalsIgnoreCase(this.name);
    }

    //public boolean equals(String itemName) {
    //    return this.name.equalsIgnoreCase(itemName);
    //}
}
