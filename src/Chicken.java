import java.util.ArrayList;

public class Chicken extends Creature {

    public Chicken(Level.Room currentRoom, String name, String description) {
        this.currentRoom = currentRoom;
        this.name = name;
        this.description = description;
    }

    @Override
    public void move() {
        Level.Room nextRoom = this.getRandomAdjacentRoom();
        currentRoom.removeCreature(name);
        currentRoom = nextRoom;
        nextRoom.addCreature(name);
    }
}
