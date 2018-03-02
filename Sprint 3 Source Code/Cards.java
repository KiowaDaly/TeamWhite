import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cards extends ArrayList {

	private final static ArrayList<Card> WeaponCards = new ArrayList<>();
	private final static ArrayList<Card> CharacterCards = new ArrayList<>();
	private final static ArrayList<Card> RoomCards = new ArrayList<>();
	
	public Cards() {
		WeaponCards.add(new Card("Rope",new ImageIcon("/weapons/rope.png")));
		WeaponCards.add(new Card("Candle Stick",new ImageIcon("/weapons/candlestick.png")));
		WeaponCards.add(new Card("Knife",new ImageIcon("/weapons/knife.png")));
		WeaponCards.add(new Card("Revolver",new ImageIcon("/weapons/revolver.png")));
		WeaponCards.add(new Card("Wrench",new ImageIcon("/weapons/wrench.png")));
		WeaponCards.add(new Card("Lead Pipe",new ImageIcon("/weapons/leadpipe.png")));
		
		RoomCards.add(new Card("Ballroom",new ImageIcon("/rooms/Ballroom.png")));
		RoomCards.add(new Card("BilliardRoom",new ImageIcon("/rooms/BilliardRoom.png")));
		RoomCards.add(new Card("Conservatory",new ImageIcon("/rooms/Conservatory.png")));
		RoomCards.add(new Card("Dininigroom",new ImageIcon("/rooms/DiningRoom.png")));
		RoomCards.add(new Card("Hall",new ImageIcon("/rooms/Hall.png")));
		RoomCards.add(new Card("Kitchen",new ImageIcon("/rooms/Kitchen.png")));
		RoomCards.add(new Card("Library",new ImageIcon("/rooms/Library.png")));
		RoomCards.add(new Card("Lounge",new ImageIcon("/rooms/Lounge.png")));
		RoomCards.add(new Card("MurderScene",new ImageIcon("/rooms/MurderScene.png")));
		RoomCards.add(new Card("Study",new ImageIcon("/rooms/Study.png")));
		
		
		
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
