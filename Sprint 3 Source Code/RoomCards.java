import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class RoomCards implements Iterable<Card>, Iterator<Card> {

	private final ArrayList<Card> RoomCards = new ArrayList<>();
	private Iterator<Card> iterator;
	
	
	public RoomCards() {
		RoomCards.add(new Card("Ballroom",new ImageIcon("/rooms/Ballroom.png")));
		RoomCards.add(new Card("Billiard Room",new ImageIcon("/rooms/BilliardRoom.png")));
		RoomCards.add(new Card("Conservatory",new ImageIcon("/rooms/Conservatory.png")));
		RoomCards.add(new Card("Dining Room",new ImageIcon("/rooms/DiningRoom.png")));
		RoomCards.add(new Card("Hall",new ImageIcon("/rooms/Hall.png")));
		RoomCards.add(new Card("Kitchen",new ImageIcon("/rooms/Kitchen.png")));
		RoomCards.add(new Card("Library",new ImageIcon("/rooms/Library.png")));
		RoomCards.add(new Card("Lounge",new ImageIcon("/rooms/Lounge.png")));
		
		RoomCards.add(new Card("Study",new ImageIcon("/rooms/Study.png")));
	}
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Card next() {
        return iterator.next();
    }

    @Override
    public Iterator<Card> iterator() {
        iterator = RoomCards.iterator();
        return iterator;
    }
    
	  public Card get(int index) {
	        return RoomCards.get(index);
	    }
	  
	  
	  public boolean contains(String name) {
	        for(Card card: RoomCards) {
	            if (card.hasName(name)) {
	                return true;
	            }
	        }
	        return false;
	    }
	public int size() {
        return RoomCards.size();
    }
	
	  public void removeItem() {
	        Card item = RoomCards.iterator().next();
	        RoomCards.remove(item);
	        }
	  
	  public void removeItem(Card item) {
	      
	       RoomCards.remove(item);
	      
	        }
	
	
	
	
}
