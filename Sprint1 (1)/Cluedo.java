public class Cluedo {

    private final Tokens tokens = new Tokens();
    private final Weapons weapons = new Weapons();
    private final UI ui = new UI(tokens,weapons);

    private void testUI() {
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
            	white.moveBy(new Coordinates(-1,0));
            	//dereasing the x value to move left
            	//this will be changed to "tokens.get("White") etc when the moves are implemented//
            	moves--;//decrease the moves each time you move//
            	 ui.displayString("You can move " + moves + " spaces!");
            	
            }
            if(command.equalsIgnoreCase("R")) {
            	white.moveBy(new Coordinates(+1,0));//increasing the x value to move right//
            	ui.displayString("You can move " + moves + " spaces!");//dispaying how many places you can move//
            	moves--;
            	
            }
            if(command.equalsIgnoreCase("D")) {
            	white.moveBy(new Coordinates(0,+1));//increasing the y value to move down since Y values begn at the top of the screen//
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            }
            if(command.equalsIgnoreCase("U")) {
            	white.moveBy(new Coordinates(0,-1));//decreasing to move up the screen//
            	ui.displayString("You can move " + moves + " spaces!");
            	moves--;
            	
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
