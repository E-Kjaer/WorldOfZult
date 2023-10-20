public class Item {
    private String name; //Item name
    private int id; //Item ID

    Item(String name, int id){ //contructor for Item
        this.name = name;
        this.id = id;
    }
    public String getName(){ //getter for Name
        return name;
    }
    public int getId(){ //getter for id
        return id;
    }
}
