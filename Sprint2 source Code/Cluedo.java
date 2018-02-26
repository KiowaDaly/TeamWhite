import java.util.ArrayList;


import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Cluedo {

    private final Tokens tokens = new Tokens();
    private final Weapons weapons = new Weapons();
    private Players people = new Players();
    private UI ui;
    String[] choices = {"Green","Plum","Mustard","Peacock","White","Scarlett"};
    String[] numPlayers = {"2","3","4","5","6"};
    private Doors doors = new Doors();
    private Rooms rooms = new Rooms();

    
    
 
	
	
	
	
    private void testUI() {
    	final int[] BoundaryRow =    {24,23,22,21,21,21,21,20,25,24,23,22,21,19,18,18,18,18,19,20,21,22,23,24,24,23,22,21,20,19,19,19,19,19,18,25,17,16,15,15,15,15,15,15,14,13,11,10,10,10,9,9,9,9,8, 7,6,6,6,6,6,5,4,3,2,0,0,-1, 0, 1,2,2,3,4,6,7, 7, 7, 7, 7, 7, 6, 4, 3, 2, 2, 1, 0,-1, 0, 0, 1, 2, 3, 5, 5, 5, 5, 6, 7, 8, 8, 8, 8, 8,10,11,12,12,12,12,13,14,14,14,14,15,17,18,18,18,18,18,18,19,10,11,12,13,14,15,16,16,16,16,16,15,14,13,12,11,10,10,10,10,21};																																																					
    	final int[] BoundaryColumn = {17,17,17,18,19,20,21,23,16,15,14,14,14,14,14,13,10, 9, 9, 9, 9, 9, 9, 8, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 7,-1, 0, 1, 2, 3, 4, 5, 7, 7, 7, 7, 7, 6, 5,4,3,2,1,0,-1,0,1,2,3,5,5,5,5,5,7,8, 9,10,10,9,8,8,8,8,8,10,11,12,13,15,15,15,15,15,14,13,13,14,15,16,17,18,18,19,20,21,23,24,23,22,21,20,19,18,18,18,18,19,20,21,23,22,21,19,18,17,17,18,19,20,21,22,23,24,10,10,10,10,10,10,10,11,12,13,14,14,14,14,14,14,14,13,12,11,22};																																
    	int PlayerPositionsRow[] = {0,0,6,19,24,17};
    	int PlayerPositionsColumn[] = {9,14,23,23,7,0};
    	int numberOfPlayers = 0; 
     	String numberOfPlayersString = null;
        String player;
        int PlayerNum=0;
        
    	 
             	
//             
            
        
           
        	JComboBox<String> Number = new JComboBox<String>(numPlayers);
        	JOptionPane.showMessageDialog( null, Number, "Characters", JOptionPane.QUESTION_MESSAGE);
        	numberOfPlayers = Integer.parseInt((String) Number.getSelectedItem());
        	final List<String> list =  new ArrayList<String>();
       	 Collections.addAll(list, choices);
       	
             for(int i = 0; i < 6; i++) {
         	
         	  if(i<numberOfPlayers) {
         	   String player1 = JOptionPane.showInputDialog("Enter Player Name");
          	    
          	    for(int j = 0; player1.length() < 2; j++ ) {
            	  	    player1 = JOptionPane.showInputDialog("Name must contain at least two letters. Please enter a valid name.");
         	    }	
//               ui.displayString("\n\nYou are " + people.get(0)); //GETTING PLUM FROM ARRAY
          	    JComboBox<String> cb = new JComboBox<String>(choices);
          	    JOptionPane.showMessageDialog( null, cb, "Characters", JOptionPane.QUESTION_MESSAGE);
            	String chosen =  (String) cb.getSelectedItem();
            	
            	people.addPlayer(player1,Tokens.get(chosen),true);
            	
            	 list.remove(chosen);
            	 choices = list.toArray(new String[list.size()]);
            	      
            	 
         	  }else {
         		  JComboBox<String> cb = new JComboBox<String>(choices);
         		 String chosen =  (String) cb.getSelectedItem();
         		 people.addPlayer(null,Tokens.get(chosen), false);
         		 list.remove(chosen);
            	 choices = list.toArray(new String[list.size()]);
            	 
              
         	  }
         	  
             }
            
            
             ui = new UI(people,weapons);	
             
             for(Player p: people ) {
              if(p.Playing()) {
           	  ui.displayString("\n"+p.getName()+", Your character is: "+p.getToken().getName()+"\n");
              }
            	
             }
             
         
      
        String command = ui.getCommand(); //INITIALISED
       
        
//        people.add("Plum"); //ADDING PLUM TO THE ARRAY
        
//        Token white = tokens.get("White");
        int moves = 0;
       
     
        //ALLOWS USER TO QUIT
         if(command.equalsIgnoreCase("quit")) {
        	System.exit(0);
        }
         //START COMMAND TO BEGIN THE GAME
          
         Iterator<Player> iter = people.iterator();
       	 Player currentPlayer = iter.next();
         
        
       	while(!currentPlayer.Playing()) {
       		currentPlayer = iter.next();
       	}

         ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
         
    
        do {
        
        	
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
        		if(iter.hasNext())
    			{
        		    
        			currentPlayer = iter.next();
               		PlayerNum++;
        		while(!currentPlayer.Playing()) {
        			
        			if(iter.hasNext()) {
               		currentPlayer = iter.next();
               		PlayerNum++;
        			}else {
        				iter = people.iterator();//resets iterator
        				currentPlayer = iter.next();
        				//ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
        				PlayerNum=0;
        			}
               	}
    				ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
    			}else {
    				iter = people.iterator();//resets iterator
    				currentPlayer = iter.next();
    				ui.displayString(currentPlayer.getName()+", It is your turn. Roll the dice and make a move!\n");
    				PlayerNum=0;
    			}
    		
    			
    				
    		}
        
        	
        		
            command = ui.getCommand();
            
            ui.displayString(command);
            
            
            
             
            if(command.equalsIgnoreCase("roll")) {
            	Dice dice1 = new Dice();
            	Dice dice2 = new Dice();
            	
            	 
            	 ui.displayString("\n\nYou rolled...\n"); // the text area is edited to display text informing the player of their dice rolling outcome...
            	 ui.displayString("a " + dice1.getValue() +" and a " +dice2.getValue() +" !" + "\n"); //...the numbers that the two dice produced
            	 ui.displayString("You can move " + (dice1.getValue()+dice2.getValue()) + " spaces!");
            	 moves=dice1.getValue()+dice2.getValue();
            	
            } 
            	 
            
      
            
            if(moves>0) {
            if(command.equalsIgnoreCase("L")) {
            	int column = currentPlayer.getToken().Column()-1;
            	int row = currentPlayer.getToken().Row();
            	
            	int count=0;
            	int j=0;
            	for(int i=0;i<BoundaryRow.length
            			;i++) {
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
            			currentPlayer.getToken().moveBy(new Coordinates(-1,0));
                    	//dereasing the x value to move left
                    	//this will be changed to "tokens.get("White") etc when the moves are implemented//
                    	moves--;//decrease the moves each time you move//
                    	PlayerPositionsRow[PlayerNum] = currentPlayer.getToken().Row();
                    	PlayerPositionsColumn[PlayerNum] = currentPlayer.getToken().Column();
                    	
                    	 ui.displayString("You can move " + moves + " spaces!");
            		}
            	
            	
            	
            }
            if(command.equalsIgnoreCase("R")) {
            	
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
            
            if(command.equalsIgnoreCase("C")) {
            	int column = currentPlayer.getToken().Column();
            	int row = currentPlayer.getToken().Row();
           
            	ui.displayString("Column Num = " + column);//decreasing to move up the screen//
            	
            	ui.displayString("Row Num = " + row);
            	
            }
            
           
            }
            else if(moves<=0){
            	ui.displayString("\nYou are all out of moves, make a suggestion or type 'done' to end your turn!\n");
            	//if there is no more moves left, make a suggestion or move to the next player//
            }
            
           
            
            
            ui.display();
        	
        } while (!command.equals("quit"));
        
        
    }

    public static void main(String[] args) {
        Cluedo game = new Cluedo();
        game.testUI();
        System.exit(0);
    }
}
