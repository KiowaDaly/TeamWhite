public class Teleport {
		private final String name;
		private Coordinates Room;
		private Coordinates Door;
		
		int row;
		int column;
		
		
		
	public Teleport(String name,Coordinates Room, Coordinates Door) {
		this.name = name;
		this.Room=Room;
		this.Door = Door;
		
	}
	
	public Coordinates moveTo() {
		//do
		return Door;
		
	}
	
	public String getName() {
        return name;
    }
	
	public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.toLowerCase().trim());
    }

}
