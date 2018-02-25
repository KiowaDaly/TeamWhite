public class Room {
		private final String name;
		private Coordinates Room;
		int row;
		int column;
		
		
	public Room(String name,Coordinates Room) {
		this.name = name;
		this.Room=Room;
	}
	
	public Coordinates getCoord() {
		
			row = Room.getRow();
			column = Room.getCol();
		
		return new Coordinates(column,row);
		
	}
	
	public String getName() {
        return name;
    }
	
	public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.toLowerCase().trim());
    }

}
