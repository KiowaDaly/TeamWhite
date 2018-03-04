import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;


public class WeaponCards implements Iterable<Card>, Iterator<Card>  {

	private final static ArrayList<Card> WeaponCards = new ArrayList<>();
	private Iterator<Card> iterator;
	
	public WeaponCards() {
		WeaponCards.add(new Card("Rope",new ImageIcon("/weapons/rope.png")));
		WeaponCards.add(new Card("Candle Stick",new ImageIcon("/weapons/candlestick.png")));
		WeaponCards.add(new Card("Knife",new ImageIcon("/weapons/knife.png")));
		WeaponCards.add(new Card("Revolver",new ImageIcon("/weapons/revolver.png")));
		WeaponCards.add(new Card("Wrench",new ImageIcon("/weapons/wrench.png")));
		WeaponCards.add(new Card("Lead Pipe",new ImageIcon("/weapons/leadpipe.png")));
		
	
		
		
		
	}

    public static Card get(String name) {
        for (Card card : WeaponCards) {
            if (card.hasName(name)) {
                return card;
            }
        }
        return null;
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
        iterator = WeaponCards.iterator();
        return iterator;
    }
	  public Card get(int index) {
	        return WeaponCards.get(index);
	    }
	  public boolean contains(String name) {
	        for(Card card: WeaponCards) {
	            if (card.hasName(name)) {
	                return true;
	            }
	        }
	        return false;
	    }
	  public void removeItem() {
	        Card item = WeaponCards.iterator().next();
	        WeaponCards.remove(item);
	        }
	  public void removeItem(Card item) {
	      
	        WeaponCards.remove(item);
	        }
	//todo//

	public int size() {
        return WeaponCards.size();
    }

	
	
	
	
	
}
