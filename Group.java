/* Group-class handles the different groups in the game such as their allowed items,
their speech and if they are hungry. It handles the different interactions with them.
 */

import java.util.ArrayList;

public class Group {
    ArrayList<Item> items = new Arraylist<Item>(); // Their allowed items

    private String speech = ""; // Their speech

    private boolean hungry = true; // Their hunger-state. Default is hungry, so true

    public boolean checkItem(Item item) { // checks if item is allowed to be given
        for (Item referenceItem : items) { // Foreach loop with the allowed items
            if (item.equals(referenceItem)) { // checks if they are equal
                return true; // Return if true and terminates
            }
        }
        return false; // Return false if no one is equal and terminate
    }

    public void setHunger(boolean state) { // Set the hunger state to given parameter
        this.hungry = state;
    }

    public boolean isHungry() { // Checks if group is hungry
        return hungry;
    }

    public String getSpeech() { // Get the group's speech
        return speech;
    }

}
