public class Cluedo {

    private final Tokens tokens = new Tokens();
    private final Weapons weapons = new Weapons();
    private final UI ui = new UI(tokens,weapons);

    private void testUI() {
    	final int[] BoundaryRow =    {24,23,22,21,21,21,21,21,20,25,24,23,22,21,20,19,18,18,18,18,18,18,19,20,21,22,23,24,24,23,22,21,20,19,19,19,19,19,19,18,25,17,16,15,15,15,15,15,15,15,14,13,12,11,10,10,10,9,9,9,9,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,-1,0,1,2,2,3,4,5,6,7,7,7,7,7,7,7,7,6,5,4,3,2,2,1,0,-1,0,0,1,2,3,4,5,5,5,5,5,6,7,8,8,8,8,8,9,10,11,12,12,12,12,12,13,14,14,14,14,14,15,16,17,18,18,18,18,18,18,19,10,11,12,13,14,15,16,16,16,16,16,15,14,13,12,11,10,10,10,10};																																																					
    	final int[] BoundaryColumn = {17,17,17,17,18,19,20,21,23,16,15,14,14,14,14,14,14,13,12,11,10,9,9,9,9,9,9,8,6,6,6,6,6,6,5,4,3,2,1,0,7,-1,0,1,2,3,4,5,6,7,7,7,7,7,7,6,5,4,3,2,1,0,-1,0,1,2,3,4,5,5,5,5,5,6,7,8,9,10,10,9,8,8,8,8,8,8,9,10,11,12,13,14,15,15,15,15,15,15,14,13,13,14,15,16,17,18,18,18,19,20,21,22,23,24,23,22,21,20,19,18,18,18,18,18,19,20,21,22,23,22,21,20,19,18,17,17,17,18,19,20,21,22,23,24,10,10,10,10,10,10,10,11,12,13,14,14,14,14,14,14,14,13,12,11};																																
    	
        String command;
        Token white = tokens.get("White");
        int moves = 0;
        Weapon dagger = weapons.get("Dagger");
        do {
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
            	int column = white.Column()-1;
            	int row = white.Row();
            	
            	int count=0;
            	for(int i=0;i<164;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            	}
            		if(count==0) {
            			white.moveBy(new Coordinates(-1,0));
                    	//dereasing the x value to move left
                    	//this will be changed to "tokens.get("White") etc when the moves are implemented//
                    	moves--;//decrease the moves each time you move//
                    	 ui.displayString("You can move " + moves + " spaces!");
            		}
            	
            	
            	
            }
            if(command.equalsIgnoreCase("R")) {
            	
            	int column = white.Column() + 1;
            	int row = white.Row();
            	
            	int count=0;
            	for(int i=0;i<164;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            	}
            	
            	if(count==0) {
            	white.moveBy(new Coordinates(+1,0));//increasing the x value to move right//
            	ui.displayString("You can move " + moves + " spaces!");//dispaying how many places you can move//
            	moves--;
            	}
            	
            }
            if(command.equalsIgnoreCase("D")) {
            	
            	
            	int column = white.Column();
            	int row = white.Row() + 1;
            	
            	int count=0;
            	for(int i=0;i<164;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            	}
            	
            	if(count==0) {
            	white.moveBy(new Coordinates(0,+1));//increasing the y value to move down since Y values begn at the top of the screen//
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            	}
            }
            if(command.equalsIgnoreCase("U")) {
            	
            	int column = white.Column();
            	int row = white.Row() -1;
            	
            	int count=0;
            	for(int i=0;i<164;i++) {
            		if(row==BoundaryRow[i] && column ==BoundaryColumn[i]) {
            			ui.displayString("This is an invalid move!!!!!!");
            			count++;
            		}
            	}
            	
            	if(count==0) {
            	white.moveBy(new Coordinates(0,-1));//decreasing to move up the screen//
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
