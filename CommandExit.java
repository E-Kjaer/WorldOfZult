/* Command for exiting program
 */

public class CommandExit extends BaseCommand implements Command {
  //Description for the command
  public CommandExit() {
    description = "Afslutter spillet";
  }

  // Runs CommandExit, which terminates the game with System.exit(0)
  @Override
  public void execute (Context context, String command, String parameters[]) {
    System.exit(0);; // Stops game
  }
}
