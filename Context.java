/* Context class to hold all context relevant to a session.
 */

class Context {
  Space current;
  boolean done = false;
  
  Context (Space node) {
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }

  // Transitions from one room to another.
  public void transition (String direction) {
    Space next = current.followEdge(direction); // Gets next node / room
    if (next==null) {
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye(); // Runs goodbye
      current = next; // Changes to the next room / node
      current.welcome(); // Runs the welcome-method
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

