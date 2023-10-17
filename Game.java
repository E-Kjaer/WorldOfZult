/* Main class for launching the game
 */

import java.util.Scanner;

class Game {
  // Creates world with rooms
  static World    world    = new World();

  // Creates context with the start room
  static Context  context  = new Context(world.getEntry());

  // Fallback for misinput from player
  static Command  fallback = new CommandUnknown();

  // Creates registry for commands
  static Registry registry = new Registry(context, fallback);

  // Scanner for getting player input
  static Scanner  scanner  = new Scanner(System.in);

  // Adds new commands with their name and attached command-instance in the Registry
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("quit", cmdExit);
    registry.register("bye", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
  }

  // Main-loop
  public static void main (String args[]) {
    System.out.println("Welcome to the World of Zuul!");
    
    initRegistry(); // Initializes registry
    context.getCurrent().welcome(); // Runs welcome command for first room
    
    while (context.isDone()==false) { // Runs game if not done
      System.out.print("> ");
      String line = scanner.nextLine(); // Get next line from commandline input
      registry.dispatch(line); // Run command from registry
    }
    System.out.println("Game Over 😥");
  }
}
