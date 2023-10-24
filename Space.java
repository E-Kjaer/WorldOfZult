/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.ArrayList;
import java.util.Set;

public class Space extends Node {
  private Inventory inventory;
  private Group group;
  private String description;

  //Only name constructor
  public Space (String name, String description) {
    super(name);
    this.inventory = new Inventory();
    this.description = description;
    //set group to null
  }

  //Name + Group constructor
  public Space (String name, String description, Group group){
    this(name, description);
    this.group = group;
  }

  public void printItems (){

  }

  // Welcome command, which runs automatically when entering a room
  public void welcome () {
    System.out.println("You are now at "+ this.getName());

    if (description != "") {
      System.out.println(description);
    }

    if (group != null) {
      System.out.println("There is a group of locals in this space.\nIf you wish to talk to them, you can use the 'talk' command");
    }

    Set<String> exits = this.getEdges().keySet();
    System.out.println("Current exits are:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void addItem(Item item) {
    this.inventory.addItem(item);
  }

  public Group getGroup() {
    return group;
  }

  public void goodbye () {
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
