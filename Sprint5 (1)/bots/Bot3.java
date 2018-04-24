package bots;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;



import gameengine.*;

public class Bot3 implements BotAPI {

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
    private List<Coordinates> myPath; 
    int routeLeft;
    boolean firstCom= true;

    public Bot3 (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
        this.player = player;
        this.playersInfo = playersInfo;
        this.map = map;
        this.dice = dice;
        this.log = log;
        this.deck = deck;
    }
   

    public String getName() {
        return "TeamWhite"; // must match the class name
    }
   

    public String getCommand() {
        // Add your code here
    	//has to be player's turn...
    	//roll, help, log, quit, cheat (can be used anytime)
    	
    	//question (inside any room)
    	
    	//passage (only inside kitchen, study, conservatory lounge)
    	
    	//accuse (inside cellar)
    	
    	//else... if they're finished
//    	getMove();
        String command= "done";
    	
    	
    	if(player.getToken().isInRoom() && firstCom == false) {
    		command ="question";
    	}
    	
    	
    	
    	if( firstCom == true) {
    		command ="roll";
    		firstCom=false;
    	}
    	
if( command== "done") {
    		
    		firstCom=true;
    	}
        return command;
        
    }

    public String getMove() {
        // Add your code here
    	//can possibly implement getDoor here to find the door the 
    	//current player is at and map the suitable route for the bot to the nearest possible room and its nearest possible door
    	
    	//also can possibly implement getCard here to find which ROOM cards the user already has
    	//this eliminates the bot's routes to those specific rooms.
    	
    	//implement A*//
    	System.out.println("test");
//    	myPath = findPath(player.getToken().getPosition(),map.getRoom("Ballroom").getDoorCoordinates(1));
    	
    	if(routeLeft==0) {
    		myPath = getPath(player.getToken().getPosition(),map.getRoom("Ballroom").getDoorCoordinates(1));
    		routeLeft = myPath.size();
    	}
    	System.out.println(myPath);
    	
    	String move = getDirection(player.getToken().getPosition(),myPath.remove(1));
    
    	
    	routeLeft--;
        return move;
    }
    
    private String getDirection(Coordinates startingPoint,Coordinates destination) {
    	if(startingPoint.getRow()>destination.getRow()) {
    		return "u";
    	}
    	if(startingPoint.getRow()<destination.getRow()) {
    		return "d";
    	}
    	if(startingPoint.getCol()<destination.getCol()) {
    		return "r";
    	}
    	if(startingPoint.getCol()>destination.getCol()) {
    		return "l";
    	}
    	return null;
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
    public List<Coordinates> getPath(Coordinates X,Coordinates Y) {
    	return AStarAlgorithm.execute(X,Y,map);
    }
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void notifyPlayerName(String playerName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyTurnOver(String playerName, String position) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyQuery(String playerName, String query) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyReply(String playerName, boolean cardShown) {
		// TODO Auto-generated method stub
		
	}
}


	




