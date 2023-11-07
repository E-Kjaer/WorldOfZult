/* Main class for launching the game
 */

import java.util.Scanner;

public class Game {
  // Creates world with rooms
  private static World    world    = new World();

  // Creates context with the start room
  private static Context  context  = new Context(world.getEntry(), world.getGroups());

  // Fallback for misinput from player
  private static Command  fallback = new CommandUnknown();

  // Creates registry for commands
  private static Registry registry = new Registry(context, fallback);

  // Scanner for getting player input
  private static Scanner  scanner  = new Scanner(System.in);

  // Adds new commands with their name and attached command-instance in the Registry
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("Afslut", cmdExit);
    registry.register("Gå", new CommandGo());
    registry.register("Hjælp", new CommandHelp(registry));

    //Add our own commands
    registry.register("Giv", new CommandGiveItem());
    registry.register("Opsaml", new CommandPickupItem());
    registry.register("Læg", new CommandPutDownItem());
    registry.register("Tal", new CommandTalk());
    registry.register("Inventar", new CommandInventory());
  }

  // Main-loop
  public static void main (String args[]) {
    initRegistry(); // Initializes registry

    Startscreen startscreen = new Startscreen();
    String name = startscreen.displayStartscreen(scanner);

    Player player = new Player(name);
    context.setPlayer(player);

    startscreen.printWelcomeMessage(registry);

    context.getCurrent().welcome(); // Runs welcome command for first room

    while (context.isDone()==false) { // Runs game if not done
      System.out.print("> ");
      String line = scanner.nextLine(); // Get next line from commandline input
      registry.dispatch(line); // Run command from registry
    }
    System.out.println("Game Over 😥");
  }
}
