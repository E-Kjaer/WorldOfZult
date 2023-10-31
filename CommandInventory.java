/* This command let's you view your player's inventory and the items in the room */

public class CommandInventory extends BaseCommand implements Command {
    //Description of the command
    public CommandInventory() {
        description = "Printing the contents of the spaces inventory and the players inventory";
    }

    @Override
    public void execute (Context context, String command, String parameters[]) {
        Space space = context.getCurrent();

        //Get the spaces inventory
        Inventory spaceInventory = space.getInventory();

        //Print items in space
        if (!spaceInventory.getItems().isEmpty()) {
            System.out.println("These items lie in the space");
            for (Item item : spaceInventory.getItems()) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("There are no items in the space");
        }

        //Get the players inventory
        Inventory playerInventory = context.getPlayer().getInventory();

        //Print items in player
        if (!playerInventory.getItems().isEmpty()) {
            System.out.println("These items lie in the players inventory");
            for (Item item : playerInventory.getItems()) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("There are no items in the the players inventory");
        }
    }
}