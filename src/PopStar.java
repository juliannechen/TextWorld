public class PopStar extends Creature {
    Player player;

    public PopStar(Level.Room currentRoom, String name, String description, Player p) {
        super(currentRoom, name, description);
        player = p;
    }

    @Override
    public void move() {
        Level.Room nextRoom = lookForPlayer();

    }

}
