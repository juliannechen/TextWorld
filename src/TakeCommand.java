public class TakeCommand implements Command{
    Level level;
    String itemName;

    public TakeCommand(Level l){
        this.level = level;
    }

    @Override
    public void init(String userString) {
        this.itemName = getLastWordIn(userString);
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split(" ");
        return words[words.length-1];
    }

    @Override
    public boolean execute() {
        Player p = level.getPlayer();
        boolean success = p.getCurrentRoom().removeItem(itemName);
        return success;
    }

}
