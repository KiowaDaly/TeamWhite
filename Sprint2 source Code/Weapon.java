public class Weapon {

    private final String name;
    private Coordinates position;

    Weapon(String name, Coordinates position) {
        this.name = name;
        this.position = position;
    }

    public void moveBy(Coordinates move) {
        position.add(move);
    }
    public void moveTo(Coordinates position) {
    	this.posititon = position;
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
}
