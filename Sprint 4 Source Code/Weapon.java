public class Weapon {

    private final String name;
    private Coordinates position;
    private Room room;

    Weapon(String name, Room room) {
        this.name = name;
        position = room.addItem ();
    }

    public String getName() {
        return name;
    }

    public Coordinates getPosition() {
        return position;
    }

    public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.toLowerCase().trim());
    }
    public void enterRoom(Room room) {
        this.room = room;
        position = this.room.addItem();
       
    }
    public void setPosition(Coordinates position) {
        this.position = position;
    }

}
