import java.util.ArrayList;
import java.util.Iterator;

public class Teleports implements Iterable<Teleport>, Iterator<Teleport> {
	
	private final ArrayList<Teleport> teleports = new ArrayList<>();
	private Iterator<Teleport> iterator;
	
	
	Teleports() {
	teleports.add(null);
	  
	    
	}

	    public Teleport get(String name) {
	        for (Teleport Teleport : teleports) {
	            if (Teleport.hasName(name)) {
	                return Teleport;
	            }
	        }
	        return null;
	    }

	    public boolean hasNext() {
	        return iterator.hasNext();
	    }

	    public Teleport next() {
	        return iterator.next();
	    }

	    public Iterator<Teleport> iterator() {
	        iterator = teleports.iterator();
	        return iterator;
	    }

	}
