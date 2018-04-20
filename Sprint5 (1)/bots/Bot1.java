package bots;

import gameengine.*;

public class Bot1 implements BotAPI {

    // The public API of Bot must not change
    // This is ONLY class that you can edit in the program
    // Rename Bot to the name of your team. Use camel case.
    // Bot may not alter the state of the board or the player objects
    // It may only inspect the state of the board and the player objects

    private Player player;
    private PlayersInfo playersInfo;
    private Map map;
    private Dice dice;
    private Log log;
    private Deck deck;

    public Bot1 (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
        this.player = player;
        this.playersInfo = playersInfo;
        this.map = map;
        this.dice = dice;
        this.log = log;
        this.deck = deck;
    }

    public String getName() {
        return "Bot1"; // must match the class name
    }

    public String getCommand() {
        // Add your code here
    	//has to be player's turn...
    	//roll, help, log, quit, cheat (can be used anytime)
    	
    	//question (inside any room)
    	
    	//passage (only inside kitchen, study, conservatory lounge)
    	
    	//accuse (inside cellar)
    	
    	//else... if they're finished
        return "done";
    }

    public String getMove() {
        // Add your code here
    	//can possibly implement getDoor here to find the door the 
    	//current player is at and map the suitable route for the bot to the nearest possible room and its nearest possible door
    	
    	//also can possibly implement getCard here to find which ROOM cards the user already has
    	//this eliminates the bot's routes to those specific rooms.
        return "r";
    }

    public String getSuspect() {
        // Add your code here
        return Names.SUSPECT_NAMES[0];
    }

    public String getWeapon() {
        // Add your code here
        return Names.WEAPON_NAMES[0];
    }

    public String getRoom() {
        // Add your code here
        return Names.ROOM_NAMES[0];
    }

    public String getDoor() {
        // Add your code here
    	// getting the certain door which the current player has just used
    	
        return "1";
    }

    public String getCard(Cards matchingCards) {
        // Add your code here
        return matchingCards.get().toString();
    }

    public void notifyResponse(Log response) {
        // Add your code here
    }

}
