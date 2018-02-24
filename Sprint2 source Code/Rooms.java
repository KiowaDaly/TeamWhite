import java.util.ArrayList;

import java.util.Iterator;



public class Rooms implements Iterable<Room>, Iterator<Room> {
	
	private final ArrayList<Room> rooms = new ArrayList<>();
	private Iterator<Room> iterator;
	
	Coordinates Kitchen = new Coordinates(2, 3);
	Coordinates ballRoom = new Coordinates(12, 3);
	Coordinates Conservatory = new Coordinates(20, 3);
	Coordinates DiningRoom = new Coordinates(3, 12);
	Coordinates Lounge = new Coordinates(3, 22);
	Coordinates hall = new Coordinates(11, 21);
	Coordinates BilliardRoom = new Coordinates(21, 12);
	Coordinates Library = new Coordinates(20, 16);
	Coordinates Study = new Coordinates(20, 23);
	
	
	
	
	Rooms() {
		rooms.add(new Room("Ball Room", ballRoom));
	    rooms.add(new Room("Hall", hall));
	    rooms.add(new Room("Kitchen", Kitchen));
	    rooms.add(new Room("Conservatory", Conservatory));
	    rooms.add(new Room("Library", Library));
	    rooms.add(new Room("Lounge", Lounge));
	    rooms.add(new Room("Dining Room", DiningRoom));
	    rooms.add(new Room("Billiard Room", BilliardRoom));
	    
	}

	    public Room get(String name) {
	        for (Room Room : rooms) {
	            if (Room.hasName(name)) {
	                return Room;
	            }
	        }
	        return null;
	    }

	    public boolean hasNext() {
	        return iterator.hasNext();
	    }

	    public Room next() {
	        return iterator.next();
	    }

	    public Iterator<Room> iterator() {
	        iterator = rooms.iterator();
	        return iterator;
	    }

	}

