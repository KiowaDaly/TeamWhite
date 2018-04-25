package bots;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;



import gameengine.*;

public class TeamWhite implements BotAPI {

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
    boolean askQ= false;
    String[] directions = {"u","d","l","r"};

    public TeamWhite (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
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
    	
    	
    	if(player.getToken().isInRoom() && askQ == false) {
    		command ="question";
    		askQ = true;
		
    	}
    	if(player.getToken().isInRoom()) {
    		routeLeft = 0;
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
//    	final int NUM_ROOMS = 1 + (int)(Math.random() * 9);
//    	final int NUM_DOORS = 1+ (int)(Math.random() + 4);
//    	final Room[] rooms = new Room[NUM_ROOMS];
    	String[] rooms = {"Kitchen", "Ballroom", "Conservatory", "Billiard Room", "Library",
                "Study", "Hall", "Lounge", "Dining Room", "Cellar"};
    	if(!map.isCorridor(player.getToken().getPosition())) {
    		routeLeft = 0;
    		myPath = getPath(player.getToken().getPosition(),map.getRoom(rooms[new Random().nextInt(9)]).getDoorCoordinates(0));
			routeLeft = myPath.size();
    	}
    	if(routeLeft==0) {
    		
    //		for(int i=0;i<NUM_ROOMS;i++) {
    			myPath = getPath(player.getToken().getPosition(),map.getRoom(rooms[new Random().nextInt(9)]).getDoorCoordinates(0));
    			routeLeft = myPath.size();
    	
    	}
    //	}
    	if(myPath.size()==0) {
    		Coordinates north = map.getNewPosition(player.getToken().getPosition(), "u");
    		Coordinates south = map.getNewPosition(player.getToken().getPosition(), "d");
    		Coordinates west = map.getNewPosition(player.getToken().getPosition(), "l");
    		Coordinates east = map.getNewPosition(player.getToken().getPosition(), "r");
    		if(map.isDoor(north, player.getToken().getPosition())) {
    			myPath.add(player.getToken().getPosition());
    			myPath.add(north);
    		}
    		if(map.isDoor(south, player.getToken().getPosition())) {
    			myPath.add(player.getToken().getPosition());
    			myPath.add(south);
    		}
    		if(map.isDoor(west, player.getToken().getPosition())) {
    			myPath.add(player.getToken().getPosition());
    			myPath.add(west);
    		}
    		if(map.isDoor(east, player.getToken().getPosition())) {
    			myPath.add(player.getToken().getPosition());
    			myPath.add(east);
    		}
    	}
    		
    	
    	System.out.println(player.getToken().getPosition());
    	System.out.println(myPath);
    
    	String  move = getDirection(player.getToken().getPosition(),myPath.remove(1));
    	
    
    	
    	routeLeft--;
    	
        return move;
    	}

    
    private static String getDirection(Coordinates startingPoint,Coordinates destination) {
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
       
	    	/**
    	 int suspectArraySize = Names.SUSPECT_NAMES.length;
  	    
	    	//Loop through the Suspect Array
	    	for (int i = 0; i <= suspectArraySize; i++) {
	    		// If player has the card, or the card is a shared card or the card has been seen, then iterate the for loop
	    		if(player.hasCard(Names.SUSPECT_NAMES[i]) == true || deck.isSharedCard(Names.SUSPECT_NAMES[i]) == true || player.hasSeen(Names.SUSPECT_NAMES[i]) == true) {
	    			i++;
	    		}
	    		// If player does not have the card, or the card is not a shared card, or the player has not seen the card then execute if statement
	    		else if (player.hasCard(Names.SUSPECT_NAMES[i]) == false || deck.isSharedCard(Names.SUSPECT_NAMES[i]) == false || player.hasSeen(Names.SUSPECT_NAMES[i]) == false) {
	    			// Return the weapon that the player does not have as a suggestion
	    		    return Names.SUSPECT_NAMES[i];
	    	}
	    		//TODO: What happens when there is only one card left?
	    		break; //end loop
			        }   **/
    	
        return Names.SUSPECT_NAMES[0];
    }

    public String getWeapon() {
      
	      /**
    	  int weaponArraySize = Names.WEAPON_NAMES.length;
  	    
	    	//Loop through the Weapons Array
	    	for (int i = 0; i <= weaponArraySize; i++) {
	    		// If player has the card, or the card is a shared card or the card has been seen, then iterate the for loop
	    		if(player.hasCard(Names.WEAPON_NAMES[i]) == true || deck.isSharedCard(Names.WEAPON_NAMES[i]) == true || player.hasSeen(Names.WEAPON_NAMES[i]) == true) {
	    			i++;
	    		}
	    		// If player does not have the card, or the card is not a shared card, or the player has not seen the card then execute if statement
	    		else if (player.hasCard(Names.WEAPON_NAMES[i]) == false || deck.isSharedCard(Names.WEAPON_NAMES[i]) == false || player.hasSeen(Names.WEAPON_NAMES[i]) == false) {
	    			// Return the weapon that the player does not have as a suggestion
	    		    return Names.WEAPON_NAMES[i];
	    	}
	    		//TODO: What happens when there is only one card left?
	    		break;
			        }   **/
	    
        return Names.WEAPON_NAMES[0];
    }

    public String getRoom() {
        //Suspects room that token is in
	    
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

class AStarAlgorithm<T>{
	//this algorithm finds the shortest path between two nodes
	public static  List<Coordinates> execute(Coordinates startingPoint,Coordinates destination,Map map){
		Set<Coordinates> closed = new HashSet<Coordinates>();
		HashMap<Coordinates,Coordinates> hashmap = new HashMap<Coordinates,Coordinates>();
		List<Coordinates> route = new LinkedList<Coordinates>();
		HashMap<Coordinates,Double> starttocurrent = new HashMap<Coordinates,Double>();
		final HashMap<Coordinates,Double> starttofinish = new HashMap<Coordinates,Double>();
		
		PriorityQueue<Coordinates> closest_node = new PriorityQueue<Coordinates>(11,new Comparator<Coordinates>() {
			public int compare(Coordinates first, Coordinates last) {
				return Double.compare(starttofinish.get(first), starttofinish.get(last));
			}
		});
		
		starttocurrent.put(startingPoint, 0.0);
		starttofinish.put(startingPoint, getHeuristic(startingPoint,destination));
		closest_node.offer(startingPoint);
		
		while(!closest_node.isEmpty()) {
			Coordinates current = closest_node.poll();
			
			if(current.equals(destination)){
				while(current!=null) {
					route.add(0,current);
					current = hashmap.get(current);
				}	
				return route;
			}
		
			closed.add(current);
			
			for(Coordinates neighbour:getNeighbours(current,map)){
				
				if(closed.contains(neighbour)) {
					continue;
				}
				if(!map.isCorridor(current)) {
					continue;
				}
				

				
				double tempdistance_plus_one = starttocurrent.get(current)+1.0;
				boolean contains = closest_node.contains(neighbour);
				
				if(!contains||tempdistance_plus_one<starttocurrent.get(neighbour)) {
					starttocurrent.put(neighbour,tempdistance_plus_one);
					starttofinish.put(neighbour,tempdistance_plus_one+getHeuristic(neighbour,destination));
					
					if(contains) {
						closest_node.remove(neighbour);
					}
					
					closest_node.offer(neighbour);
					hashmap.put(neighbour, current);
					
				}


			}
			
		}
		return null;
	}
	
	 public static double getHeuristic(Coordinates startingPoint,Coordinates destination) {
	    	double distance = Math.abs(startingPoint.getRow()-destination.getRow()) + Math.abs(startingPoint.getCol()-destination.getCol());
	    	
			return distance;
	    	
	    }
	 public static List<Coordinates> getNeighbours(Coordinates current,Map map){
		 List<Coordinates> Neighbours = new LinkedList<Coordinates>();
		Neighbours.add(new Coordinates(current.getCol(),current.getRow()+1));
		
		Neighbours.add(new Coordinates(current.getCol(),current.getRow()-1));
		
		Neighbours.add(new Coordinates(current.getCol()+1,current.getRow()));
		
		Neighbours.add(new Coordinates(current.getCol()-1,current.getRow()));
		
		 return Neighbours;
	 }
	 
}

	





