import java.util.ArrayList;
import java.util.HashMap;


public class Level {
    private HashMap<String, Room> rooms;

    public Level() {
        rooms = new HashMap<String, Room>();
    }

    public void addRoom(String name, String description) {
        Room room = new Room(name, description);
        rooms.put(name, room);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);
        n1.addNeighbor(n2);
    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);

    }

    public Room getRoom(String name) {
        return rooms.get(name);

    }

    public class Room {
        private String name;
        private HashMap<String, Room> neighbors;
        private String description;
        private ArrayList<Item> items;
        private ArrayList<Creature> creatures;

        private Room(String name, String description) {
            this.name = name;
            neighbors = new HashMap<String, Room>();
            this.description = description;
            items = new ArrayList<Item>();
            creatures = new ArrayList<Creature>();
        }

        public ArrayList<Creature> getCreatures() {
            return creatures;
        }

        public Creature removeCreature(String name){
            for (Creature c: creatures) {
                 if(c.getName().equals(name)) {
                     creatures.remove(c);
                     return c;
                 }
            }
            return null;
        }

        public void addCreature(Creature creature){
            creatures.add(creature);
        }

        public String displayCreatures(){
            String output = "";
            for (Creature creature : creatures) {
                output += creature.getName() + ", ";

            }
            return output;
        }

        public String getName() {
            return name;
        }

        private void addNeighbor(Room n) {
            String name = n.getName();
            neighbors.put(name, n);
        }

        public String getNeighborNames() {
            String output = "";
            for (String name : neighbors.keySet()) {
                output = output + ", " + name;
            }
            return output;
        }

        public HashMap<String, Room> getNeighbors(){
            return neighbors;
        }

        public Room getNeighbor(String name) {
            for (String n : neighbors.keySet()) {
                if (n.equals(name)) return neighbors.get(n);
            }
            return null;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public String displayItems() {
            String output = "";
            for (Item item : items) {
                output += item.getName() + ", ";

            }
            return output;
        }

        public void addItem(String name) {
            Item item = new Item(name, "");
            items.add(item);
        }

        public void addItem(String name, String description) {
            Item item = new Item(name, description);
            items.add(item);
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public Item removeItem(String name) {
            for (Item item : items) {
                if (item.getName().equals(name)) {
                    items.remove(item);
                    return item;
                }

            }
            return null;
        }

        public boolean destroyItem(String name) {
            for (Item item : items) {
                if (item.getName().equals(name)) {
                    items.remove(item);
                    return true;
                }
            }
            return false;
        }

    }
}
