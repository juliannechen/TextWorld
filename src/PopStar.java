import java.util.HashMap;

public class PopStar extends Creature {
    Player player;

    public PopStar(Level.Room currentRoom, String name, String description, Player p) {
        super(currentRoom, name, description);
        player = p;
    }

    @Override
    public void move() {
        moveToNeighboringRoom(roomToPlayer());
    }

    public Level.Room roomToPlayer() {
        Level.Room playerRoom = player.getCurrentRoom();
        HashMap<String, Level.Room> currNeighbors = currentRoom.getNeighbors();

        //if player is 1 step away
        if (currentRoom.getNeighbors().containsValue(playerRoom)) {
            return playerRoom;
        }

        //if player is 2 steps away
        for (Level.Room room : currNeighbors.values()) {
            if (room.getNeighbors().containsValue(playerRoom)) {
                return room;
            }
        }

        return getRandomAdjacentRoom();
    }

}
