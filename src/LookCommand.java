public class LookCommand implements Command {
    Player player;

    public LookCommand(Player player){
        this.player = player;
    }

    @Override
    public void init(String userString) {

    }

    @Override
    public boolean execute() {
        System.out.println("the items currently in the room are " + player.getCurrentRoom().displayItems());
        System.out.println("the creatures currently in the room are " + player.getCurrentRoom().displayCreatures());
        return true;

    }
}
