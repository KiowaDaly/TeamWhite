import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cards extends ArrayList {

	private final static ArrayList<Card> WeaponCards = new ArrayList<>();
	
	public Cards() {
		WeaponCards.add(new Card("Rope",new ImageIcon("/weapon images/rope.png")));
	}

    public static Card get(String name) {
        for (Card card : WeaponCards) {
            if (card.hasName(name)) {
                return card;
            }
        }
        return null;
    }
	
	
	//todo//
	
	
	
	
}
