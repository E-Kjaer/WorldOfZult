/* Context class to hold all context relevant to a session.
 */

import java.util.ArrayList;

public class Context {
  //Holds current position and therefore current node.
  private Space current;

  //Holds all the groups in the game
  private ArrayList<Group> groups;

  // Holds player
  private Player player;

  //Holds boolean for if the game is done
  private boolean done = false;

  // Constructor gets given startnode
  public Context (Space node, ArrayList<Group> groups) {
    current = node;
    this.groups = groups;
  }

  // Gets the current Space, where the player is
  public Space getCurrent() {
    return current;
  }

  // Transitions from one room to another.
  public void transition (String direction) {
    Space next = current.followEdge(direction); // Gets next node / room
    if (next==null) { // Checks if the next edge is present.
      System.out.println("Du er forvirret og går i ring for at finde '"+direction+"'. Til sidst giver du op 😩");
    } else {
      current.goodbye(); // Runs goodbye
      current = next; // Changes to the next room / node
      current.welcome(); // Runs the welcome-method
      Counter.incrCount();
    }
  }

  //Getter for groups
  public ArrayList<Group> getGroups() {
    return groups;
  }

  //Getter for Player
  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  // Sets done to true, so game over
  public void makeDone () {
    done = true;
  }

  // Return done
  public boolean isDone () {
    return done;
  }
}

