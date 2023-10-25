public class CommandPutDownItem extends BaseCommand implements Command {
    //Description of the command
    public CommandPutDownItem() {
        description = "Put down an item from the inventory in the current space";
    }

    @Override
    public void execute (Context context, String command, String parameters[]) {
        //Ensure that only 1 item is put down at a time
        if (guardEq(parameters, 1)) {
            System.out.println("Only 1 item can be put down at a time");
            return; //Stops command
        }

        //Get current space from context
        Space space = context.getCurrent();

        //Get the players inventory
        Inventory playerInventory = context.getPlayer().getInventory();

        //Get the spaces inventory
        Inventory spaceInventory = space.getInventory();

        //Check if any items name in inventory matches specified input from user
        for (Item item : playerInventory.getItems()) {
            if (item.getName().equalsIgnoreCase(parameters[0])) {
                //Remove specified item from inventory and add item in space
                spaceInventory.addItem(item);
                System.out.println("Put down " + item.getName());
                playerInventory.removeItem(item);
                return;
            }
        }
        System.out.println("Error: Item not found");
    }
}