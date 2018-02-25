import java.util.ArrayList;
import java.util.Iterator;

public class Doors implements Iterable<Door>, Iterator<Door> {
	
	private final ArrayList<Door> doors = new ArrayList<>();
	private Iterator<Door> iterator;
	
	Coordinates Kitchen_South = new Coordinates(4, 6);
	Coordinates Kitchen_Secret = new Coordinates(5, 1);
	Coordinates Ballroom_West = new Coordinates(8, 5);
	Coordinates Ballroom_South_1 = new Coordinates(9, 7);
	Coordinates Ballroom_South_2 = new Coordinates(14, 7);
	Coordinates Ballroom_East = new Coordinates(15, 5);
	Coordinates Conservatory_South = new Coordinates(18, 4);
	Coordinates Conservatory_Secret = new Coordinates(22, 5);
	Coordinates BilliardRoom_West = new Coordinates(18, 9);
	Coordinates BilliardRoom_South = new Coordinates(22, 12);
	Coordinates Library_North = new Coordinates(20, 14);
	Coordinates Library_West = new Coordinates(17, 16);
	Coordinates Study_North = new Coordinates(17, 21);
	Coordinates Study_Secret = new Coordinates(23, 21);
	Coordinates Hall_North_1 = new Coordinates(11, 18);
	Coordinates Hall_North_2 = new Coordinates(12, 18);
	Coordinates Hall_East = new Coordinates(14, 20);
	Coordinates Lounge_North = new Coordinates(6, 19);
	Coordinates Lounge_Secret = new Coordinates(0, 19);
	Coordinates DiningRoom_East = new Coordinates(7, 12);
	Coordinates DiningRoom_South = new Coordinates(6, 15);
	
	
	Doors() {
		doors.add(new Door("Kitchen_South", Kitchen_South));
		doors.add(new Door("Kitchen_Secret", Kitchen_Secret));
		doors.add(new Door("Ballroom_West", Ballroom_West));
		doors.add(new Door("Ballroom_South_1", Ballroom_South_1));
		doors.add(new Door("Ballroom_South_2", Ballroom_South_2));
		doors.add(new Door("Ballroom_East", Ballroom_East));
		doors.add(new Door("Conservatory_South", Conservatory_South));
		doors.add(new Door("Conservatory_Secret", Conservatory_Secret));
		doors.add(new Door("BilliardRoom_West", BilliardRoom_West));
		doors.add(new Door("BilliardRoom_South", BilliardRoom_South));
		doors.add(new Door("Library_North", Library_North));
		doors.add(new Door("Library_West", Library_West));
		doors.add(new Door("Study_North", Study_North));
		doors.add(new Door("Study_Secret", Study_Secret));
		doors.add(new Door("Hall_North_1", Hall_North_1));
		doors.add(new Door("Hall_North_2", Hall_North_2));
		doors.add(new Door("Hall_East", Hall_East));
		doors.add(new Door("Lounge_North", Lounge_North));
		doors.add(new Door("Lounge_Secret", Lounge_Secret));
		doors.add(new Door("DiningRoom_East", DiningRoom_East));
		doors.add(new Door("DiningRoom_South", DiningRoom_South));
		
		
	    
	}

	    public Door get(String name) {
	        for (Door Door : doors) {
	            if (Door.hasName(name)) {
	                return Door;
	            }
	        }
	        return null;
	    }

	    public boolean hasNext() {
	        return iterator.hasNext();
	    }

	    public Door next() {
	        return iterator.next();
	    }

	    public Iterator<Door> iterator() {
	        iterator = doors.iterator();
	        return iterator;
	    }

	}

