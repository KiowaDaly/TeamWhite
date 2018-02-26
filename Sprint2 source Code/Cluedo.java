import java.util.ArrayList;


import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Cluedo {

    private final Tokens tokens = new Tokens();
    private final Weapons weapons = new Weapons();
    private Players players = new Players();
    private Doors doors = new Doors();
    private Rooms rooms = new Rooms();
    private UI ui; // linking the Tokens, Weapons, Players, Doors, Rooms and UI classes by initialising variables which hold the variable type of each class
    String[] choices_of_characters = {"Green","Plum","Mustard","Peacock","White","Scarlett"}; //an array of Strings holding the character names
    String[] choices_of_playernumber = {"2","3","4","5","6"}; //an array of Strings holding the number of players
    
    
    private void testUI() {
    	//The boundaries of the edges of the board and the edges of each room are set and held in two 1 dimensional arrays of integer values (i.e. one for x coordinates and one for the y coordinates
    	final int[] BoundaryRow =    {24,23,22,21,21,21,21,20,25,24,23,22,21,19,18,18,18,18,19,20,21,22,23,24,24,23,22,21,20,19,19,19,19,19,18,25,17,16,15,15,15,15,15,15,14,13,11,10,10,10,9,9,9,9,8, 7,6,6,6,6,6,5,4,3,2,0,0,-1, 0, 1,2,2,3,4,6,7, 7, 7, 7, 7, 7, 6, 4, 3, 2, 2, 1, 0,-1, 0, 0, 1, 2, 3, 5, 5, 5, 5, 6, 7, 8, 8, 8, 8, 8,10,11,12,12,12,12,13,14,14,14,14,15,17,18,18,18,18,18,18,19,10,11,12,13,14,15,16,16,16,16,16,15,14,13,12,11,10,10,10,10,21};																																																					
    	final int[] BoundaryColumn = {17,17,17,18,19,20,21,23,16,15,14,14,14,14,14,13,10, 9, 9, 9, 9, 9, 9, 8, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 7,-1, 0, 1, 2, 3, 4, 5, 7, 7, 7, 7, 7, 6, 5,4,3,2,1,0,-1,0,1,2,3,5,5,5,5,5,7,8, 9,10,10,9,8,8,8,8,8,10,11,12,13,15,15,15,15,15,14,13,13,14,15,16,17,18,18,19,20,21,23,24,23,22,21,20,19,18,18,18,18,19,20,21,23,22,21,19,18,17,17,18,19,20,21,22,23,24,10,10,10,10,10,10,10,11,12,13,14,14,14,14,14,14,14,13,12,11,22};																																
    	//the x and y coordinates for the starting positions of each token on the board are initialised using two integer arrays
    	int PlayerPositionsRow[] = {0,0,6,19,24,17};
    	int PlayerPositionsColumn[] = {9,14,23,23,7,0};
    	int numberOfPlayers = 0; 
        int PlayerNum=0;
        
        //a pop up tab is initialised and contains the string array of the number of players as a drop down list
        JComboBox<String> Number = new JComboBox<String>(choices_of_playernumber);
        
        JOptionPane.showMessageDialog( null, Number, "How many players?", JOptionPane.QUESTION_MESSAGE);
        //the result that the user has picked from the drop down list is converted from String to integer value
        numberOfPlayers = Integer.parseInt((String) Number.getSelectedItem());
        // a new array list called 'list' is initialised
        final List<String> list =  new ArrayList<String>();
        //adds the new list and the string array of character names to 'Collections'
       	Collections.addAll(list, choices_of_characters);
       	
       	//a for loop iterating through the number of characters available for the user
       	for(int i = 0; i < choices_of_characters.length; i++) {
       		JComboBox<String> cb = new JComboBox<String>(choices_of_characters);
       		//takes the user's selected character and stores it within a string
       		String chosen =  (String) cb.getSelectedItem();
       		//an if statement which performs a set of commands until the number of players chosen by the user is reached
       		if(i< numberOfPlayers) {
       			//asks the user for their name and stores it in a string
       			String player_name = JOptionPane.showInputDialog("Enter Player Name");
       			// if the player name is less than two characters long, a tab pops up to take the user name again and store it in the string until it is 2 or more letters long
       			for(int j = 0; player_name.length() < 2; j++ ) {
            	  	    player_name = JOptionPane.showInputDialog("Name must contain at least two letters. Please enter a valid name.");
         	    }	
       			//a pop up tab is initialised and contains the string array of the character names as a drop down list
       			JOptionPane.showMessageDialog( null, cb, "Which character would you like?", JOptionPane.QUESTION_MESSAGE);
       			// the variable of type 'Players' adds the user's name along with his/her associated character token 
          	    players.addPlayer(player_name,Tokens.get(chosen),true);
            	//the character that the user has chosen will be removed so that any further players to be entered will not be able to pick the same character
          	    list.remove(chosen);
            	//the string array of character names gets added to the array list 'list'
          	    choices_of_characters = list.toArray(new String[list.size()]);
          	    
       		}else{
       			players.addPlayer(null,Tokens.get(chosen), false);
         		list.remove(chosen);
         		choices_of_characters = list.toArray(new String[list.size()]);
         		
       		}
       		
       	}
       	
       	ui = new UI(players,weapons);	
       	
       	for(Player p: players){
       		if(p.Playing()) {
           	  ui.displayString("\n"+p.getName()+", Your character is: "+p.getToken().getName()+"\n");
           	}
       	}
       	//initialising a string storing the commands that the player inputs
       	String command = ui.getCommand();
       	int moves = 0;
       	
       	// allows the user to quit the game
       	if(command.equalsIgnoreCase("quit")) { 
        	System.exit(0);
        }
	    
	    
	    int n = 0;
	    // stores the rows and columns of the tokens (which are being used by the players) individually as two separate integer arrays - loop for initial icon collision
        for(Player p: players ) {
        	PlayerPositionsRow[n] = p.getToken().Row();
        	PlayerPositionsColumn[n] = p.getToken().Column();
        	n++;
        }
        //START COMMAND TO BEGIN THE GAME
        
        Iterator<Player> iter = players.iterator();
       	Player currentPlayer = iter.next();
         
       
       	while(!currentPlayer.Playing()) {
       		currentPlayer = iter.next();  // iterates through players to find who's turn it is next
       	}
       	//displays the player's name which is supposed to take their turn
        ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
         
        do{ //if the user types in the word 'done', the program should end the user's turn immediately
        	if(command.equalsIgnoreCase("done")) {
        		for(Door door:doors) {
                 	if(currentPlayer.getToken().getPosition().equals(door.getCoord())) {
                 		String Entrance = door.getName();
                 		for(Room room:rooms) {
                 			if(Entrance.contains(room.getName())) {
                 				currentPlayer.getToken().moveTo(room.getCoord());
                 			}
                 		}
                 	}
                 }
        		//allows the program to iterate through the hash set
        		if(iter.hasNext()){
        			// increase the player number to move onto the next player's turn
        			currentPlayer = iter.next();
               		PlayerNum++;
               		while(!currentPlayer.Playing()) {
               			if(iter.hasNext()) {
               				currentPlayer = iter.next();
               				PlayerNum++;
               			}
               			else{
               				iter = players.iterator();//resets iterator
               				currentPlayer = iter.next();
               				PlayerNum=0;
               			}
               		}
    				ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
    			}else {
    				iter = players.iterator();//resets iterator
    				currentPlayer = iter.next();
    				ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
    				PlayerNum=0;
    			}
        		
        	}
        	command = ui.getCommand();
            ui.displayString(command);
            
            // when the user types in 'roll' it allows the user to perform certain interactions with the program
            if(command.equalsIgnoreCase("roll")) {
            	//creates two new dice
            	Dice dice1 = new Dice();
            	Dice dice2 = new Dice();
            	
            	ui.displayString("\n\nYou rolled...\n"); // the text area is edited to display text informing the player of their dice rolling outcome...
            	ui.displayString("a " + dice1.getValue() +" and a " +dice2.getValue() +" !" + "\n"); //...the numbers that the two dice produced
            	ui.displayString("You can move " + (dice1.getValue()+dice2.getValue()) + " spaces!"); //...are added together to show the player how many moves they can make
            	moves=dice1.getValue()+dice2.getValue();
            	
            } 
            //checks if the dice roll produced a number of moves greater than 0, then the player can press certain keys to move their token across the board
            if(moves>0){
            	//checks whether the key typed in is the letter 'L'
            	if(command.equalsIgnoreCase("L")) {
            		//it decreases the column value by 1 (i.e. moves it to the left
            		int column = currentPlayer.getToken().Column()-1;
            		int row = currentPlayer.getToken().Row();
            		int count=0, j=0;
            		
            		//checks whether the token is being moved into a room border or the border of the board, produces an error message if this is true
            		for(int i=0;i<BoundaryRow.length;i++) {
            			if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            				ui.displayString("This is an invalid move!!!!!!");
            				count++;
            			}
            			// avoids collision between tokens by producing an error message
            			if(j<6 && (row==PlayerPositionsRow[j] && column==PlayerPositionsColumn[j])) {
            				ui.displayString("This is an invalid move!!!!!!");
            				count++;
            			}
            			j++;
            		}
            		if(count==0) {
            			currentPlayer.getToken().moveBy(new Coordinates(-1,0));
                    	//dereasing the x value to move left
                    	//this will be changed to "tokens.get("White") etc when the moves are implemented
                    	moves--;//decrease the moves each time you move
                    	PlayerPositionsRow[PlayerNum] = currentPlayer.getToken().Row();
                    	PlayerPositionsColumn[PlayerNum] = currentPlayer.getToken().Column();
                    	
                    	 ui.displayString("You can move " + moves + " spaces!");
            		}
            	
            	
            	
            }
            if(command.equalsIgnoreCase("R")) {
            	// increases the value of the column by 1, (i.e. increases the x value by one thus moving to the right
            	int column = currentPlayer.getToken().Column() + 1;
            	int row = currentPlayer.getToken().Row();
            	int j=0;
            	int count=0;
            	for(int i=0;i<BoundaryRow.length;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            		
            		if(j<6 && (row==PlayerPositionsRow[j] && column==PlayerPositionsColumn[j])) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
                		}
            		j++;
            	}
            	
            	if(count==0) {
            	currentPlayer.getToken().moveBy(new Coordinates(+1,0));//increasing the x value to move right//
            	PlayerPositionsRow[PlayerNum] = currentPlayer.getToken().Row();//updates the current players position
            	PlayerPositionsColumn[PlayerNum] = currentPlayer.getToken().Column();
            	ui.displayString("You can move " + moves + " spaces!");//dispaying how many places you can move//
            	moves--;
            	}
            	
            }
            if(command.equalsIgnoreCase("D")) {
            	
            	//increases the value of the current row coordinate (i.e. increases the y value thus the token moves down the board once
            	int column = currentPlayer.getToken().Column();
            	int row = currentPlayer.getToken().Row() + 1;
            	int j=0;
            	int count=0;
            	for(int i=0;i<BoundaryRow.length;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            		if(j<6 && (row==PlayerPositionsRow[j] && column==PlayerPositionsColumn[j])) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            			
            		}
            		j++;
            	}
            	
            	if(count==0) {
            	currentPlayer.getToken().moveBy(new Coordinates(0,+1));//increasing the y value to move down since Y values begn at the top of the screen//
            	PlayerPositionsRow[PlayerNum] = currentPlayer.getToken().Row();
            	PlayerPositionsColumn[PlayerNum] = currentPlayer.getToken().Column();
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            	}
            }
            if(command.equalsIgnoreCase("U")) {
            	
            	int column = currentPlayer.getToken().Column();
            	//decreases the value of the row coordinate by 1 (i.e. decreases the y value, thus the token can move up the board once
            	int row = currentPlayer.getToken().Row() -1;
            	int j=0;
            	int count=0;
            	for(int i=0;i<BoundaryRow.length;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            		
            		if(j<6 && (row==PlayerPositionsRow[j] && column==PlayerPositionsColumn[j])) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            			
            		}
            		j++;
            	}
            	
            	if(count==0) {
            	currentPlayer.getToken().moveBy(new Coordinates(0,-1));//decreasing to move up the screen//
            	PlayerPositionsRow[PlayerNum] = currentPlayer.getToken().Row();
            	PlayerPositionsColumn[PlayerNum] = currentPlayer.getToken().Column();
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            	}
            	
            }
            
            }
            else if(moves<=0){
            	ui.displayString("\nYou are all out of moves, make a suggestion or type 'done' to end your turn!\n");
            	//if there is no more moves left, make a suggestion or move to the next player//
            }
            ui.display();
            
        }while (!command.equals("quit"));
        
    }
    public static void main(String[] args) { //main method
        Cluedo game = new Cluedo(); //creating a variable of type Cluedo class
        game.testUI(); //which calls upon the method we implemented above
        System.exit(0);
    }
}
