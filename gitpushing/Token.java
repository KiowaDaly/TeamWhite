import java.awt.*;

public class Token {

    private final String name;
    private final Color color;
    private final Coordinates position;

    Token(String name, Color color, Coordinates position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public void moveBy(Coordinates move) {
        position.add(move);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Coordinates getPosition() {
        return position;
    }

    public int 	Column() {
    	
    	return position.getCol();
    }
    
public int 	Row() {
    	
    	return position.getRow();
    }
    
    public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.toLowerCase().trim());
    }

}