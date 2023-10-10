/* Command for transitioning between spaces
 */

class CommandGo extends BaseCommand implements Command {
  //Description of command
  CommandGo () {
    description = "Follow an exit";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) { // Checks for the right amount of parameters, so 1 room
      System.out.println("I don't seem to know where that is 🤔"); // If too many parameters, give error
      return;
    }
    context.transition(parameters[0]); // Transistions only if given one parameter
  }
}
