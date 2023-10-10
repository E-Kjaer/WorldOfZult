/* Baseclass for commands
 */

class BaseCommand {
  // Description of the command.
  String description = "Undocumented";

  // Checks the number of parameters
  protected boolean guardEq (String[] parameters, int bound) {
    return parameters.length!=bound;
  }

  // Gets description of command
  public String getDescription () {
    return description;
  }
}
