public class CommandGiveItem extends BaseCommand implements Command{
    //Description of the command
    public CommandGiveItem() {
        description = "Giving an item to the group in the current space";
    }

    @Override
    public void execute (Context context, String command, String parameters[]) {
        //Check if exactly one item is selected
        if (guardEq(parameters, 1)){
            System.out.println("Error exactly 1 item must be given");
            return; //Stops command
        }

        //Get current space from context
        Space space = context.getCurrent();

        //Check if space has a group
        if (space.group != null) {
            //Try to give specified item to group
            if (space.getGroup().checkItem(parameters[0])) {
                context.getPlayer().getInventory().removeItem(context.getPlayer().getInventory().getItem(parameters[0]));
                space.getGroup().setHunger(false);
                System.out.println(parameters[0] + " was given to group");
            } else {
                //if group refuses item, print wrong item
                System.out.println("Error: " + parameters[0] + " doesn't belong with the group");
            }
        } else {
            //if there is no group in the current space, print no group in this space
            System.out.println("Error: Current space has no group");
        }
    }
}
