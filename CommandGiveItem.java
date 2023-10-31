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

        //Get the group in the current space
        Group group = space.getGroup();

        //Get the players inventory
        Inventory playerInventory = context.getPlayer().getInventory();

        //Check if space has a group
        if (group != null) {
            //Try to give specified item to group
            if (group.checkItem(parameters[0])) {
                playerInventory.removeItem(playerInventory.getItem(parameters[0]));
                group.setHunger(false);
                System.out.println(parameters[0] + " was given to group");
                //

                boolean isDone = true;

                for (Group g : context.getGroups()) {
                    if (g.isHungry()) {
                        isDone = false;
                        break;
                    }
                }

                if (isDone) {
                    System.out.println("YAY, you won - in " + Counter.getCount() + " moves");
                    context.makeDone();
                }

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
