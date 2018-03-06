//GETS A RANDOM CHARACTER, ROOM AND WEAPON AND STORES THEM INTO AN ARRAY
//TODO: WORKS AT THE MOMENT (CAN BE TESTED USING PRINT), HOWEVER STILL NEEDS TO BE IMPLEMENTED  INTO THE REST OF THE GAME

import java.util.Random;

public class CardAssignment{
	
	static final String[] characters = {"Green","Plum","Mustard","Peacock","White","Scarlett"};
	static final String[] rooms =  {"Ball Room", "Hall", "Kitchen", "Conservatory", "Library", "Lounge", "Dining Room", "Billiard Room"};
	static final String[] weapons = {"Rope", "Dagger", "Wrench", "Pistol", "Candlestick", "Lead Pipe"};
		
	public Object[] cluedoCard() {
	WeaponCards weaponsCards = new WeaponCards();
	RoomCards roomCards = new RoomCards();
	CharacterCards characterCards = new CharacterCards();
	Random rn = new Random();
	
	
	Card theMurderer = (characterCards.get(rn.nextInt(characterCards.size()-1)+0));
	roomCards.removeItem(theMurderer);
	Card theMurderRoom = (roomCards.get(rn.nextInt(roomCards.size()-1)+0));
	roomCards.removeItem(theMurderRoom);
	Card theMurderWeapon = (weaponsCards.get(rn.nextInt(weaponsCards.size()-1) + 0));
	weaponsCards.removeItem(theMurderWeapon);
	
	//Stores the randomly generated murderer, room and weapon into an array
	Card[] theAnswer = {theMurderer,theMurderRoom, theMurderWeapon};
	
	return new Object[] {characterCards,weaponsCards,roomCards,theAnswer};
	
	
	
	}
	
}
