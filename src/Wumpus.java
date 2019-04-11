public class Wumpus extends Creature {
    Player player;

    public Wumpus(Level.Room currentRoom, String name, String description, Player p) {
        super(currentRoom, name, description);
        player = p;
    }

    @Override
    public void move() {
        if (!nextRoom.equals(player.getCurrentRoom())) {
            Level.Room nextRoom = player.getCurrentRoom().getRandomNeighbor();
            moveToNeighboringRoom(nextRoom);
        }

    }
}
