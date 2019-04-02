import java.util.ArrayList;

public abstract class Creature {
    protected Level.Room currentRoom;
    protected String name;
    protected String description;

    public abstract void move();

    protected Level.Room getRandomAdjacentRoom(){
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room> (currentRoom.getNeighbors().values());
        int randomIndex = (int)Math.random()*rooms.size();
        return  rooms.get(randomIndex);
    }

    protected void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected Level.Room getCurrentRoom(){
        return currentRoom;
    }

}
