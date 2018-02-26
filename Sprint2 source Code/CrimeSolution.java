//GETS A RANDOM CHARACTER, ROOM AND WEAPON AND STORES THEM INTO AN ARRAY
//TODO: WORKS AT THE MOMENT (CAN BE TESTED USING PRINT), HOWEVER STILL NEEDS TO BE IMPLEMENTED  INTO THE REST OF THE GAME

import java.util.Random;

public class CrimeSolution{
	
	static final String[] characters = {"Green","Plum","Mustard","Peacock","White","Scarlett"};
	static final String[] rooms =  {"Ball Room", "Hall", "Kitchen", "Conservatory", "Library", "Lounge", "Dining Room", "Billiard Room"};
	static final String[] weapons = {"Rope", "Dagger", "Wrench", "Pistol", "Candlestick", "Lead Pipe"};
		
	public void cluedoCard() {
	
	//Gets random character, room and weapon from strings
	
	String theMurderer = (characters[new Random().nextInt(characters.length)]);
	String theMurderRoom = (rooms[new Random().nextInt(characters.length)]);
	String theMurderWeapon = (weapons[new Random().nextInt(characters.length)]);
	
	//Stores the randomly generated murderer, room and weapon into an array
	String[] theAnswer = {theMurderer, theMurderRoom, theMurderWeapon};
	
	}
	
}
