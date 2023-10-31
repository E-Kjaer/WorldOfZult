public class CommandUnknown extends BaseCommand implements Command {
  @Override
  public void execute (Context context, String command, String parameters[]) {
    System.out.println("Woopsie, I don't understand '"+command+"' 😕");
  }
}
