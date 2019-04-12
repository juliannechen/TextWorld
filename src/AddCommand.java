public class AddCommand implements Command {
    Level level;
    String roomName;

    public AddCommand(Level level){
        this.level = level;
    }
    @Override
    public void init(String userString) {
        this.roomName = getLastWordIn(userString);
    }

    private String getLastWordIn(String userString) {
        String[] words = userString.split(" ");
        return words[words.length-1];
    }

    @Override
    public boolean execute() {
        level.addRoom(roomName, "no description added");
        level.addDirectedEdge(level.getPlayer().getCurrentRoom().getName(), roomName);
        System.out.println("you have added a room called " + roomName + " in the level.");
        return true;
    }
}
