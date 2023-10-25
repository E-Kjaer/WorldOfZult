public class CommandPickupItem extends BaseCommand implements Command {
    //Description of the command
    public CommandPickupItem() {
        description = "Pick up an item from the current space";
    }

    @Override
    public void execute (Context context, String command, String parameters[]) {
        //Ensure that only 1 item is picked up at a time
        if (guardEq(parameters, 1)) {
            System.out.println("Only 1 item can be picked up at a time");
            return; //Stops command
        }

        //Get current space from context
        Space space = context.getCurrent();

        //Get the players inventory
        Inventory playerInventory = context.getPlayer().getInventory();

        //Get the spaces inventory
        Inventory spaceInventory = space.getInventory();

        //Check if user input corresponds to an item in space
        for (Item item : spaceInventory.getItems()) {
            //If it does, place it in inventory and remove from space
            if (item.getName().equalsIgnoreCase(parameters[0])) {
                playerInventory.addItem(item);
                System.out.println("Picked up " + item.getName());
                spaceInventory.removeItem(item);
                return; //Stops command
            }
        }
        //Prints error, if the input doesn't match any item
        System.out.println("Error: Item not found");
    }
}