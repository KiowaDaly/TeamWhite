public class Door {
	private final String name;
	private Coordinates Door;
	int row;
	int column;
	
	
public Door(String name,Coordinates Door) {
	this.name = name;
	this.Door = Door;
}

public Coordinates getCoord() {
	
		row = Door.getRow();
		column = Door.getCol();
	
	return new Coordinates(column,row);
	
}

public String getName() {
    return name;
}

public boolean hasName(String name) {
    return this.name.toLowerCase().equals(name.toLowerCase().trim());
}
}
