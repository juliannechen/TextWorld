import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {
    protected Level.Room currentRoom;
    protected String name;
    protected String description;

    public Creature(Level.Room r, String name, String description) {
        currentRoom = r;
        this.name = name;
        this.description = description;
        currentRoom.addCreature(this);
    }

    public abstract void move();

    public Level.Room getRandomAdjacentRoom() {
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(currentRoom.getNeighbors().values());
        if (rooms.size() == 0) return currentRoom;
        int randomIndex = (int) (Math.random() * rooms.size());
        return rooms.get(randomIndex);
    }

    public boolean moveToNeighboringRoom(Level.Room nextRoom) {
        if(currentRoom.getNeighbor(nextRoom.getName()) != null){
            currentRoom.removeCreature(this);
            nextRoom.addCreature(this);
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

    public boolean isPlayerAdjacent(Player p) {
        Level.Room playerRoom = p.getCurrentRoom();
        HashMap<String, Level.Room> currNeighbors = currentRoom.getNeighbors();
        if (currentRoom.getNeighbors().containsValue(playerRoom.getName())) {
            return true;
        }
        return false;
    }

    public void setCurrentRoom(Level.Room r) {
        System.out.println(this.getName() + " has moved from " + currentRoom.getName() + " to " + r.getName());
        this.currentRoom = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

}
