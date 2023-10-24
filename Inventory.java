
import java.util.ArrayList;

class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();

    int count = items.size();

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        return null;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
