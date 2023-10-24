public class CommandInventory extends BaseCommand implements Command {
    //Description of the command
    public CommandInventory() {
        description = "Printing the contents of the spaces inventory and the players inventory";
    }

    @Override
    public void execute (Context context, String command, String parameters[]) {
        Space space = context.getCurrent();

        //Print items in space
        if (!space.getInventory().getItems().isEmpty()) {
            System.out.println("These items lie in the space");
            for (Item item : space.getInventory().getItems()) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("There are no items in the space");
        }

        //Print items in player
        if (!context.getPlayer().getInventory().getItems().isEmpty()) {
            System.out.println("These items lie in the players inventory");
            for (Item item : context.getPlayer().getInventory().getItems()) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("There are no items in the the players inventory");
        }
    }
}