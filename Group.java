/* Group-class handles the different groups in the game such as their allowed items,
their speech and if they are hungry. It handles the different interactions with them.
 */

import java.util.ArrayList;

public class Group {
    ArrayList<Item> items = new ArrayList<Item>(); // Their allowed items

    private String speech = ""; // Their speech

    private boolean hungry = true; // Their hunger-state. Default is hungry, so true

    public boolean checkItem(Item item) { // checks if item is allowed to be given
        return items.contains(item);
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
