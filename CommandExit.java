/* Command for exiting program
 */

class CommandExit extends BaseCommand implements Command {
  // Runs CommandExit, which changes the attribute Done in context to True.
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone(); // Stops game
  }
}
