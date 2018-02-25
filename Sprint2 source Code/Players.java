import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;

public class Players implements Iterable<Player>, Iterator<Player>{

	private final static HashSet<Player> people = new HashSet<>();
    private Iterator<Player> iterator;
	
	Players(){
		
	}
	
	
	
	
	
	
	
	
	
	
	  public void addPlayer(String name,Token token) {
		   people.add(new Player(name,token));
	  }
	
	  public boolean hasNext() {
	        return iterator.hasNext();
	    }

	    public Player next() {
	        return iterator.next();
	    }
	    
	  

	    public Iterator<Player> iterator() {
	        iterator = people.iterator();
	        return iterator;
	    }











}
