
import java.util.ArrayList;

class Inventory {
    ArrayList<Item> inventory = new ArrayList<Item>();

    int count= inventory.size();
    public void addItem(Item item){
        inventory.add(item);
    }
    public void removeItem(Item item){
        inventory.remove(item);
    }
    public String showItems(){
        for (int i =0; i<inventory.size(); i++){
            //mangler metode vil vi bruge for each loop?
        }
        return "";
    }

}
