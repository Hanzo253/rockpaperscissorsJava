public class Users extends Player {

    private String name;

    public Users() {

    }

    public Users(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String setChoice(String choice) {
        return this.choice = choice;
    }

    @Override
    public String getChoice() {
        return choice;
    }
}
