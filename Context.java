/* Context class to hold all context relevant to a session.
 */

class Context {

  //Holds current position and therefore current node.
  Space current;

  //Holds boolean for if the game is done
  boolean done = false;

  // Constructor gets given startnode
  Context (Space node) {
    current = node;
  }

  // Gets the current Space, where the player is
  public Space getCurrent() {
    return current;
  }

  // Transitions from one room to another.
  public void transition (String direction) {
    Space next = current.followEdge(direction); // Gets next node / room
    if (next==null) { // Checks if the next edge is present.
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye(); // Runs goodbye
      current = next; // Changes to the next room / node
      current.welcome(); // Runs the welcome-method
      Counter.incrCount();
    }
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

