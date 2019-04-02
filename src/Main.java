import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Level g = new Level();
        g.addRoom("hall", "a long dank hallway");
        g.addRoom("closet", "a dark closet");
        g.addRoom("dungeon", "a deserted dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        Player player = new Player("Julianne", "");
        player.setCurrentRoom(g.getRoom("hall"));

        g.getRoom("hall").addItem(new Item("pineapple", "a ripe pineapple"));
        g.getRoom("dungeon").addItem(new Item("almond", "a roasted almond"));
        g.getRoom("closet").addItem(new Item("cake", "a vanilla cake"));

        g.getRoom("hall").addCreature(new Chicken( g.getRoom("hall")));

        String response = "";
        Scanner s = new Scanner(System.in);

        System.out.println("your options are go, look, add, take, drop, and quit");

        do {
            System.out.println("You are in the " + player.getCurrentRoom().getName());
            System.out.println("What do you want to do?");
            response = s.nextLine();
            String[] words = response.split(" ");
            String firstWord = words[0];

            if (firstWord.equals("go")) {
                boolean moved = player.moveToRoom(words[1]);
                if (moved == true) {
                    System.out.println("you have entered " + player.getCurrentRoom().getName());
                } else {
                    System.out.println("non-existent room, try typing look");
                }
            } else if (firstWord.equals("look")) {
                System.out.println("the items currently in the room are " + player.getCurrentRoom().displayItems());
                System.out.println("the creatures currently in the room are " + player.getCurrentRoom().displayCreatures());
            } else if (firstWord.equals("add")) {
                String newRoom = words[1];
                g.addRoom(newRoom, "");
                g.addDirectedEdge(player.getCurrentRoom().getName(), newRoom);
            } else if (firstWord.equals("quit")) {
                response = "quit";
            } else if (firstWord.equals("take")) {
                Item item = player.getCurrentRoom().removeItem(words[1]);
                System.out.println("you have taken a " + item.getName());
                player.addItem(item);
            } else if (firstWord.equals("drop")) {
                Item item = player.removeItem(words[1]);
                player.getCurrentRoom().addItem(item);
                System.out.println("you have dropped a " + item.getName() + " to the " + player.getCurrentRoom().getName());
            } else {
                System.out.println("your options are go, look, add, take, drop, and quit");
            }

        } while (!response.equals("quit"));
    }
}

