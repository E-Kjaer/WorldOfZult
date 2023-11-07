public class CommandTalk extends BaseCommand implements Command {
    //Description of the command
    public CommandTalk() {
        description = "Brug til at tale med de forskellige grupper i verden. Udføres ved at skrive “tal” i et rum der indeholder en gruppe";
    }
    @Override
    public void execute (Context context, String command, String parameters[]) {
        //Get current space from context
        Space space = context.getCurrent();

        //Get the group from the current space
        Group group = space.getGroup();

        //If space has group, print out the groups message
        if (group != null) {
            //Prints out the groups message
            System.out.println(group.getSpeech());
        } else {
            //Prints out an error, as there is no group in the space
            System.out.println("Fejl: Der er ingen gruppe i rummet");
        }
    }
}