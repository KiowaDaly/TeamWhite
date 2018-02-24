//import java.util.HashSet;
//import java.util.Iterator;
//
//public class Rooms implements Iterable<Room>, Iterator<Room> {
//
//
//		Coordinates[] ballRoom;
//		Coordinates[] hall;
//		Coordinates[] Kitchen;
//		Coordinates[] Conservat0ry;
//		Coordinates[] Library;
//		Coordinates[] Lounge;
//		Coordinates[] DiningRoom;
//		Coordinates[] BilliardRoom;
//		
//
//	    private final HashSet<Room> BoardRooms = new HashSet<>();
//	    private Iterator<Room> iterator;
//
//	    Rooms() {
//	   
//	    	
//	    	for(int i =0;i<48;i++) {
//	    		int row=2;
//	    		int Column=8;
//	    		ballRoom = new Coordinates
//	    	}
//	    	
//	    	
//	  
//	    	
//	    	
//	        BoardRooms.add(new Room("BallRoom",ballRoom));
////	        BoardRooms.add(new Room("BallRoom",ballroom));
//	    }
//
//	    public Room get(String name) {
//	        for (Room Room : BoardRooms) {
//	            if (Room.hasName(name)) {
//	                return Room;
//	            }
//	        }
//	        return null;
//	    }
//
//	    public boolean hasNext() {
//	        return iterator.hasNext();
//	    }
//
//	    public Room next() {
//	        return iterator.next();
//	    }
//
//	    public Iterator<Room> iterator() {
//	        iterator = BoardRooms.iterator();
////	        return iterator;
//	    }
//
//	}
//
