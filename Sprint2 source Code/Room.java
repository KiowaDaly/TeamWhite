
public class Room {
		private final String RoomName;
		private Coordinates[][] Room;
		int row;
		int column;
		
		
	public Room(String RoomName,Coordinates[][] ballRoom) {
		this.RoomName=RoomName;
		this.Room=ballRoom;
	}
	
	
	
	
	
	public Coordinates toRoom() {
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	public Coordinates getCoord() {
		for(Coordinates[] tile:Room) {
			for(Coordinates Coord:tile) {
				column = Coord.getCol();
			    row = Coord.getRow();
			}
	
		
	}
			
		
		return new Coordinates(column,row);
		
		
		
	}

	  public boolean hasName(String name) {
        return this.RoomName.toLowerCase().equals(name.toLowerCase().trim());
    }

}
