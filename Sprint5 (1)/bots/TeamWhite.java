package bots;


import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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

    public TeamWhite (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
        this.player = player;
        this.playersInfo = playersInfo;
        this.map = map;
        this.dice = dice;
        this.log = log;
        this.deck = deck;
    }
    public List<Coordinates> findPath(Coordinates X,Coordinates Y){
    	return AStarAlgorithm.execute(X,Y);
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
    	getMove();
        return "done";
    }

    public String getMove() {
        // Add your code here
    	//can possibly implement getDoor here to find the door the 
    	//current player is at and map the suitable route for the bot to the nearest possible room and its nearest possible door
    	
    	//also can possibly implement getCard here to find which ROOM cards the user already has
    	//this eliminates the bot's routes to those specific rooms.
    	
    	//implement A*//
    	System.out.println("test");
    	for(Coordinates path:findPath(player.getToken().getPosition(),map.getRoom("Ballroom").getDoorCoordinates(1))){
    		System.out.println(path.toString());
    		return getDirection(player.getToken().getPosition(),path);
    		
    	}
        return null;
    }
    
    private String getDirection(Coordinates startingPoint,Coordinates destination) {
    	if(startingPoint.getRow()<destination.getRow()) {
    		return "d";
    	}
    	if(startingPoint.getRow()>destination.getRow()) {
    		return "u";
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
    public void getPath() {
    	
    }
}
class AStarAlgorithm<T>{
	
	//this algorithm find the shortest path between two n 
	public static <T extends Coordinates> List<Coordinates> execute(Coordinates startingPoint,Coordinates destination){
	Set<Coordinates> closed = new HashSet<Coordinates>();
		HashMap<Coordinates,Coordinates> fromMap = new HashMap<Coordinates,Coordinates>();
		List<Coordinates> route = new LinkedList<Coordinates>();
		HashMap<Coordinates,Double> gValue = new HashMap<Coordinates,Double>();
		final HashMap<Coordinates,Double> fValue = new HashMap<Coordinates,Double>();
		PriorityQueue<Coordinates> open = new PriorityQueue<Coordinates>(11,new Comparator<Coordinates>() {
			public int compare(Coordinates nodeA, Coordinates nodeB) {
				return Double.compare(fValue.get(nodeA), fValue.get(nodeB));
			}
		});
		
		gValue.put(startingPoint, 0.0);
		fValue.put(startingPoint,getHeuristic(startingPoint,destination));
		open.offer(startingPoint);
		
		while(!open.isEmpty()) {
			Coordinates current = open.poll();
			if(current.equals(destination)) {
				while(current!=null) {
					route.add(0,current);
					current = fromMap.get(current);
				}
				return route;
			}
			closed.add(current);
			
			for(Coordinates neighbour : getNeighbours(current)) {
				if(closed.contains(neighbour)) {
					continue;
				}
				double tentG = gValue.get(current)+1.0;
				
				boolean contains = open.contains(neighbour);
				if(!contains||tentG<gValue.get(neighbour)) {
					gValue.put(neighbour,tentG);
					fValue.put(neighbour,tentG+getHeuristic(neighbour,destination));
					if(contains) {
						open.remove(neighbour);
					}
					open.offer(neighbour);
					fromMap.put(neighbour, current);
				}
			}
		}
		
		return route;
		
		
		
	}
	 public static double getHeuristic(Coordinates startingPoint,Coordinates destination) {
	    	double distance = Math.abs(startingPoint.getRow()-destination.getRow()) + Math.abs(startingPoint.getCol()-destination.getCol());
	    	
			return distance;
	    	
	    }
	 public static List<Coordinates> getNeighbours(Coordinates current){
		 List<Coordinates> Neighbours = new LinkedList<Coordinates>();
		Neighbours.add(new Coordinates(current.getRow()+1,current.getCol()));
		Neighbours.add(new Coordinates(current.getRow()-1,current.getCol()));
		Neighbours.add(new Coordinates(current.getRow(),current.getCol()+1));
		Neighbours.add(new Coordinates(current.getRow()+1,current.getCol()-1));
		 return Neighbours;
	 }
}




