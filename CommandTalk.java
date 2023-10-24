public class CommandTalk extends BaseCommand implements Command {
    //Description of the command
    public CommandTalk() {
        description = "Talking with the group in the current space";
    }
    @Override
    public void execute (Context context, String command, String parameters[]) {
        //Get current space from context
        Space space = context.getCurrent();

        //If space has group, print out the groups message
        if (space.getGroup() != null) {
            //Prints out the groups message
            System.out.println(space.getGroup().getSpeech());
        } else {
            //Prints out an error, as there is no group in the space
            System.out.println("Error: There is no group in the current space");
        }
    }
}