
public class Room {
		private final String RoomName;
		private Coordinates[] Room;
		int row;
		int column;
		
		
	public Room(String RoomName,Coordinates[]Room) {
		this.RoomName=RoomName;
		this.Room=Room;
	}
	
	public Coordinates getCoord() {
		for(Coordinates tile:Room) {
			row = tile.getRow();
			column = tile.getCol();
		}
		return new Coordinates(column,row);
		
		
		
	}

	  public boolean hasName(String name) {
        return this.RoomName.toLowerCase().equals(name.toLowerCase().trim());
    }

}
