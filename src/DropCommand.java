public class DropCommand implements Command {
    Player player;
    String itemName;

    public DropCommand(Player player){
        this.player = player;
    }

    @Override
    public void init(String userString) {
        this.itemName = getLastWordIn(userString);
    }

    public String getLastWordIn(String userString) {
        String[] words = userString.split(" ");
        return words[words.length-1];
    }

    @Override
    public boolean execute() {
        boolean success = false;
        Item item = player.removeItem(itemName);
        if(item != null) {
            success = true;
            player.getCurrentRoom().addItem(item);
            System.out.println("you have dropped a " + item.getName() + " to the " + player.getCurrentRoom().getName());
        }
        return success;

    }
}
