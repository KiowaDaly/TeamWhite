import java.util.HashSet;
import java.util.Iterator;

public class Rooms implements Iterable<Room>, Iterator<Room> {


		Coordinates[][] ballRoom = new Coordinates[5][8];
		
		Coordinates[] hall;
		Coordinates[] Kitchen;
		Coordinates[] Conservat0ry;
		Coordinates[] Library;
		Coordinates[] Lounge;
		Coordinates[] DiningRoom;
		Coordinates[] BilliardRoom;
		int column;
		int row;

	    private final HashSet<Room> BoardRooms = new HashSet<>();
	    private Iterator<Room> iterator;

	    Rooms() {
	   
	    	
	    		for (int i = 0;i<ballRoom.length;i++) {
	    			
	    			for(int j=0;j<ballRoom[i].length;j++) {
	    				ballRoom[i][j] = new Coordinates(j+8,i+2);
	    			}
	    			
	    		}
	    				
	    			
	    			
	    		
	    		
	    	
	    	
	  
	    	
	    	
	        BoardRooms.add(new Room("BallRoom",ballRoom));
//	        BoardRooms.add(new Room("BallRoom",ballroom));
	    }

	    public Room get(String name) {
	        for (Room Room : BoardRooms) {
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
	        return iterator = BoardRooms.iterator();
	    }

	}

