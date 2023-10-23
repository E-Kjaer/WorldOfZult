/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.ArrayList;
import java.util.Set;

class Space extends Node {
  ArrayList<Item> items = new ArrayList<Item>();

  //Only name constructor
  Space (String name) {
    super(name);
    //set group to null
  }

  //Name + Group constructor
  Space (String name, Group group){
    this(name);
  }

  public void printItems (){

  }

  // Welcome command, which runs automatically when entering a room
  public void welcome () {
    System.out.println("You are now at "+name);
    Set<String> exits = edges.keySet();
    System.out.println("Current exits are:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }
  
  public void goodbye () {
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
