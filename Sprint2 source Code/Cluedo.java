import java.util.ArrayList;

public class Cluedo {

    private final Tokens tokens = new Tokens();
    private final Weapons weapons = new Weapons();
    private final UI ui = new UI(tokens,weapons);
    
    private static ArrayList<String> people= new ArrayList<String>(); //HERE IS THE ARRAY FOR CHARACTER NAMES

    private void testUI() {
    	final int[] BoundaryRow =    {24,23,22,21,21,21,21,21,20,25,24,23,22,21,20,19,18,18,18,18,18,18,19,20,21,22,23,24,24,23,22,21,20,19,19,19,19,19,19,18,25,17,16,15,15,15,15,15,15,15,14,13,12,11,10,10,10,9,9,9,9,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,-1,0,1,2,2,3,4,5,6,7,7,7,7,7,7,7,7,6,5,4,3,2,2,1,0,-1,0,0,1,2,3,4,5,5,5,5,5,6,7,8,8,8,8,8,9,10,11,12,12,12,12,12,13,14,14,14,14,14,15,16,17,18,18,18,18,18,18,19,10,11,12,13,14,15,16,16,16,16,16,15,14,13,12,11,10,10,10,10,21};																																																					
    	final int[] BoundaryColumn = {17,17,17,17,18,19,20,21,23,16,15,14,14,14,14,14,14,13,12,11,10,9,9,9,9,9,9,8,6,6,6,6,6,6,5,4,3,2,1,0,7,-1,0,1,2,3,4,5,6,7,7,7,7,7,7,6,5,4,3,2,1,0,-1,0,1,2,3,4,5,5,5,5,5,6,7,8,9,10,10,9,8,8,8,8,8,8,9,10,11,12,13,14,15,15,15,15,15,15,14,13,13,14,15,16,17,18,18,18,19,20,21,22,23,24,23,22,21,20,19,18,18,18,18,18,19,20,21,22,23,22,21,20,19,18,17,17,17,18,19,20,21,22,23,24,10,10,10,10,10,10,10,11,12,13,14,14,14,14,14,14,14,13,12,11,22};																																
    	int PlayerPositionsRow[] = {0,0,6,19,24,17};
    	int PlayerPositionsColumn[] = {9,14,23,23,7,0};
       
        String command = ui.getCommand(); //INITIALISED
        int numberOfPlayers = 0; 
    	String numberOfPlayersString = null;
        String player;
        
        people.add("Plum"); //ADDING PLUM TO THE ARRAY
        
        Token white = tokens.get("White");
        int moves = 0;
        Weapon dagger = weapons.get("Dagger");
        
        //ALLOWS USER TO QUIT
         if(command.equalsIgnoreCase("quit")) {
        	System.exit(0);
        }
         //START COMMAND TO BEGIN THE GAME
           if(command.equalsIgnoreCase("start") ) {
  	              	
              ui.displayString("\n\nEnter the number of players: ");
              numberOfPlayersString = ui.getCommand();
              numberOfPlayers = Integer.parseInt(numberOfPlayersString); //convert int to string
            
              if((numberOfPlayers == 0) || (numberOfPlayers == 1)) {
              
                ui.displayString("\n\nThis is a multiplayer game. There must be at least 2 players. Please enter a valid numer of players:\n");
            	
             }else if(numberOfPlayers <= 6) {
            	
                ui.displayString("There will be " + numberOfPlayers + " players");
          	  
              for(int i = 0; i < numberOfPlayers; i++) {
          		//BODY
          	    ui.displayString("\n\nPlease enter a name: \n");
          	   	player = ui.getCommand();
           	    ui.displayString(player);
                ui.displayString("\n\nYou are " + people.get(0)); //GETTING PLUM FROM ARRAY
           	    
           	 
             	 
          	  }} else {
   		        ui.displayString("Please enter a valid number");
            } 	
        }
        
        
        do {
            command = ui.getCommand();
            
            ui.displayString(command);
            
             if(command.equalsIgnoreCase("done")) {
            	//TODO: prompts the next user to go when the done command is entered
            }
            
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
            	int column = white.Column()-1;
            	int row = white.Row();
            	
            	int count=0;
            	int j=0;
            	for(int i=0;i<165;i++) {
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
            			white.moveBy(new Coordinates(-1,0));
                    	//dereasing the x value to move left
                    	//this will be changed to "tokens.get("White") etc when the moves are implemented//
                    	moves--;//decrease the moves each time you move//
                    	PlayerPositionsRow[0] = white.Row();
                    	PlayerPositionsColumn[0] = white.Column();
                    	
                    	 ui.displayString("You can move " + moves + " spaces!");
            		}
            	
            	
            	
            }
            if(command.equalsIgnoreCase("R")) {
            	
            	int column = white.Column() + 1;
            	int row = white.Row();
            	int j=0;
            	int count=0;
            	for(int i=0;i<165;i++) {
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
            	white.moveBy(new Coordinates(+1,0));//increasing the x value to move right//
            	PlayerPositionsRow[0] = white.Row();//updates the current players position
            	PlayerPositionsColumn[0] = white.Column();
            	ui.displayString("You can move " + moves + " spaces!");//dispaying how many places you can move//
            	moves--;
            	}
            	
            }
            if(command.equalsIgnoreCase("D")) {
            	
            	
            	int column = white.Column();
            	int row = white.Row() + 1;
            	int j=0;
            	int count=0;
            	for(int i=0;i<165;i++) {
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
            	white.moveBy(new Coordinates(0,+1));//increasing the y value to move down since Y values begn at the top of the screen//
            	PlayerPositionsRow[0] = white.Row();
            	PlayerPositionsColumn[0] = white.Column();
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            	}
            }
            if(command.equalsIgnoreCase("U")) {
            	
            	int column = white.Column();
            	int row = white.Row() -1;
            	int j=0;
            	int count=0;
            	for(int i=0;i<165;i++) {
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
            	white.moveBy(new Coordinates(0,-1));//decreasing to move up the screen//
            	PlayerPositionsRow[0] = white.Row();
            	PlayerPositionsColumn[0] = white.Column();
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            	}
            	
            }
            
            if(command.equalsIgnoreCase("C")) {
            	int column = white.Column();
            	int row = white.Row();
           
            	ui.displayString("Column Num = " + column);//decreasing to move up the screen//
            	
            	ui.displayString("Row Num = " + row);
            	
            }
            
           
            }
            else if(moves<=0){
            	ui.displayString("You are all out of moves, make a suggestion or type 'done' to end your turn!");
            	//if there is no more moves left, make a suggestion or move to the next player//
            }
            
           
            
            dagger.moveBy(new Coordinates(+1,0));
            ui.display();
        } while (!command.equals("quit"));
        
        
    }

    public static void main(String[] args) {
        Cluedo game = new Cluedo();
        game.testUI();
        System.exit(0);
    }
}
