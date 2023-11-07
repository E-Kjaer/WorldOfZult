/* Command for exiting program
 */

public class CommandExit extends BaseCommand implements Command {
  //Description for the command
  public CommandExit() {
    description = "Afslutter spillet";
  }

  // Runs CommandExit, which changes the attribute Done in context to True.
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone(); // Stops game
  }
}
