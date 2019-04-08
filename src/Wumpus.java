public class Wumpus extends Creature {
    Player player;

    public Wumpus(Level.Room currentRoom, String name, String description, Player p) {
        super(currentRoom, name, description);
        player = p;
    }

    @Override
    public void move() {
        if (isPlayerAdjacent(player)) {


        } else {
            System.out.println(this.getName() + " did not move");
        }

    }
}
