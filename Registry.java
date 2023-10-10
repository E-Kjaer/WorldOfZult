/* Command registry
 */

import java.util.HashMap;
import java.util.Map;

class Registry {
  Context context;
  Command fallback;

  // Map, which contains string-keyword and their associated command
  Map<String, Command> commands = new HashMap<String, Command>();
  
  Registry (Context context, Command fallback) {
    this.context = context;
    this.fallback = fallback;
  }
  
  public void register (String name, Command command) {
    commands.put(name, command);
  }

  // Handles and runs commands
  public void dispatch (String line) {
    String[] elements = line.split(" "); //Splits string into string-array. go door -> {go, door}
    String command = elements[0]; // Command first
    String[] parameters = getParameters(elements); // Get parameters
    Command handler = getCommand(command); // Retrieves command
    (handler==null ? fallback : handler).execute(context, command, parameters); // Runs command if there is no error
  }
  
  public Command getCommand (String commandName) {
    return commands.get(commandName);
  }
  
  public String[] getCommandNames () {
    return commands.keySet().toArray(new String[0]);
  }
  
  // helpers
  
  private String[] getParameters (String[] input) {
    String[] output = new String[input.length-1];
    for (int i=0 ; i<output.length ; i++) {
      output[i] = input[i+1];
    }
    return output;
  }
}

