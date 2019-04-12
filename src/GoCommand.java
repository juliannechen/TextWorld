public class GoCommand implements Command {
    Player player;
    String roomName;

    public GoCommand(Player player){
        this.player = player;
    }

    @Override
    public void init(String userString) {
        roomName = getLastWordIn(userString);
    }

    public String getLastWordIn(String userString) {
        String[] words = userString.split(" ");
        return words[words.length-1];
    }

    @Override
    public boolean execute() {
        boolean moved = player.moveToRoom(roomName);
        if (moved == true) {
            System.out.println("you have entered " + player.getCurrentRoom().getName());
            return true;
        } else {
            System.out.println("non-existent room, try typing look");
            return false;
        }
    }
}
