import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class CharacterCards implements Iterable<Card>, Iterator<Card> {

	
	
	private final ArrayList<Card> CharacterCards = new ArrayList<>();
	private Iterator<Card> iterator;
	
	
	
	
	
	
	public CharacterCards() {
		CharacterCards.add(new Card("Green",new ImageIcon("path goes here")));
		CharacterCards.add(new Card("Plum",new ImageIcon("path goes here")));
		CharacterCards.add(new Card("Mustard",new ImageIcon("path goes here")));
		CharacterCards.add(new Card("Peacock",new ImageIcon("path goes here")));
		CharacterCards.add(new Card("White",new ImageIcon("path goes here")));
		CharacterCards.add(new Card("Scarlett",new ImageIcon("path goes here")));
	}
	
	
	
	
	  public Card get(int index) {
	        return CharacterCards.get(index);
	    }
	  
	  
	  public boolean contains(String name) {
	        for(Card card: CharacterCards) {
	            if (card.hasName(name)) {
	                return true;
	            }
	        }
	        return false;
	    }
	public int size() {
      return CharacterCards.size();
  }
	
	  public void removeItem() {
	        Card item = CharacterCards.iterator().next();
	        CharacterCards.remove(item);
	        }
	  
	  public void removeItem(Card item) {
	      
		  CharacterCards.remove(item);
	      
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
        iterator = CharacterCards.iterator();
        return iterator;
    }

}
