public class EmptyCommand implements Command {

    public EmptyCommand(){

    }

    @Override
    public void init(String userString) {

    }

    @Override
    public boolean execute() {
        System.out.println("nonexistent command");
        System.out.println("your options are go, look, add, take, drop, and quit");
        return false;
    }
}
