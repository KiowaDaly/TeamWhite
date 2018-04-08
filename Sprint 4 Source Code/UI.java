
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;



public class UI {

    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 800;

    private final BoardPanel boardPanel;
    private final InfoPanel infoPanel = new InfoPanel();
    private final Log log = new Log();
    private final CommandPanel commandPanel = new CommandPanel();
    private String input, input1, input2, input3, playerName, tokenName, command, move,cardNum,Qfin,YesOrNo;
    private int door;
    private boolean inputIsDone;
    ImageIcon image = new ImageIcon();
    JLabel label = new JLabel();
    JPanel card = new JPanel();
    private final Players players = new Players();

    UI(Tokens characters, Weapons weapons) {
    	
        boardPanel = new BoardPanel(characters, weapons);
        
        
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Cluedo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(boardPanel, BorderLayout.LINE_START);
        frame.add(infoPanel, BorderLayout.LINE_END);
        frame.add(commandPanel,BorderLayout.PAGE_END);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    /* Display Methods */

    public void display() {
        boardPanel.refresh();
    }

    public void displayString(String string) {
        infoPanel.addText(string);
       
       
        
    }
    
    public Log getLog() {
    	return log;
    }
    
    public void displayDice(Player player, Dice dice) {
        displayString(player + " rolls " + dice + ".");
    }
    
    public void resetInfo() {
    	infoPanel.resetText("");
	
    }

    /* Display Error Messages */

    private void displayError(String message) {
        displayString("Error: " + message + ".");
    }
    public void displayAccuseError() {
    	displayError("You are not in the cellar, you cannot make an accusation yet!");
    }
    public void displayErrorNotADoor() {
        displayError("Not a door");
    }

    public void displayErrorInvalidMove() {
        displayError("Invalid move");
    }

    public void displayErrorAlreadyMoved() {
        displayError("Already moved this turn");
    }

    public void displayErrorNoPassage() {
        displayError("Not in a room with a passage");
    }
    public void displayErrorNotInRoom() {
    	displayError("You cannot accuse if oyu are not inside a room");
    }

    /* User Input Methods */

    private void inputString() {
        input = commandPanel.getCommand();
    }

    public void inputName(Players playersSoFar) {
        boolean valid = false;
        inputIsDone = false;
        do {
            if (playersSoFar.size() < 2) {
                displayString("Enter new player name:");
            } else {
                displayString("Enter new player name or done:");
            }
            inputString();
            displayString("> " + input);
            playerName = input.trim();
            if (playerName.isEmpty()) {
                displayError("Name is blank");
            } else if (playersSoFar.contains(playerName)) {
                displayError("Same name used twice");
            } else if (playersSoFar.size() >= 2 && playerName.toLowerCase().equals("done")) {
                valid = true;
                inputIsDone = true;
            } else {
                valid = true;
            }
        } while (!valid);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void inputToken(Tokens tokens) {
        boolean valid = false;
        do {
            displayString("Enter your character name:");
            inputString();
            displayString("> " + input);
            tokenName = input.trim().toLowerCase();
            if (tokens.contains(tokenName)) {
                if (!tokens.get(tokenName).isOwned()) {
                    valid = true;
                } else {
                    displayError("Character name already in use");
                }
            } else {
                displayError("Not a valid character name");
            }
        } while (!valid);
    }

    public String getTokenName() {
        return tokenName;
    }

    public boolean inputIsDone() {
        return inputIsDone;
    }

    public void inputCommand(Player player) {
        boolean valid = false;
        do {
            displayString("\n"+ player + " type your command:");
            inputString();
            displayString("> " + input);
            command = input.trim().toLowerCase().replaceAll("( )+", " ");
            if (command.equals("quit") ||command.equals("log")||command.equals("question")|| command.equals("accuse")||command.equals("cheat") || command.equals("done") || command.equals("cards")||command.equals("roll") || command.equals("passage") || command.equals("help") || command.equals("notes") || command.equals("accusation")||command.equals("yes") ||command.equals("no")) {
                valid = true;
            } else {
                displayError("No such command");
            }
        } while (!valid);
    }

    
    
    
    
    
    public String getCommand() {
        return command;
    }

    public void inputMove(Player player, int moveNumber, int movesAvailable) {
        boolean valid = false;
        do {
            displayString(player + " enter move " + moveNumber + " of " + movesAvailable + ":");
            inputString();
            displayString("> " + input);
            move = input.trim().toLowerCase();
            if (move.matches("[udlr]")) {
                valid = true;
            } else {
                displayError("Move must be u, d, l or r");
            }
        } while (!valid);
    }

    public String getMove() {
        return move;
    }

    public void inputDoor(Player player) {
        boolean valid = false;
        do {
            displayString(player + " enter door number:");
            inputString();
            displayString("> " + input);
            input = input.trim();
            if (input.matches("[1234]")) {
                door = Integer.valueOf(input);
                valid = true;
            } else {
                displayError("Input must be a number");
            }
        } while (!valid);
    }
    
    public String inputMurderer(Player player,Tokens tokens) {
   	 	displayString("Enter the murderer in question:");
   	 	input = commandPanel.getCommand();
   	 	if(!tokens.contains(input)) {
   	 		displayError("Not a valid character name");
   	 		return inputMurderer(player,tokens);
   	 	}
   	 	log.addText("\n"+player.getName()+" Asked if" +input+" was the murderer");
   	 	return input;
	
	 
    }
    public String inputMurderWeapon(Player player,Weapons weapons){
    	 displayString("Enter the murder Weapon:");
    	 input = commandPanel.getCommand();
    	 if(!weapons.contains(input)) {
    	 		displayError("Not a valid weapon");
    	 		return inputMurderWeapon(player,weapons);
    	 		
    	 	}
    	 log.addText("\n"+player.getName()+" Asked if" +input+" was the Weapon");
    	 return input;
    }
    @SuppressWarnings("unused")
	public String inputMurderRoom(Player player,Map map){
    	boolean isValid = false;
   	 displayString("Enter the murder Room:");
   	 
   	 input = commandPanel.getCommand();
   	 for(Room room:map.rooms) {
   		 if(!room.toString().equals(input)) {
   			 isValid = false;
   		 }
   		 else {
   			 isValid = true; 
   			log.addText("\n"+player.getName()+" Asked if the murder occured in the " +input);
   			 return input;
   			 
   		 }
   	 }
   	
   		displayError("Not a valid Room");
   		
   	 
   	 return inputMurderRoom(player,map);
   	
   }
	public void addTextToLog(String string) {
		log.addText(string);
	}
    public void inputCardNum(Player player) {
        boolean valid = false;
        do {
            displayString("\n"+ player + " type the number of the card you wish to show corresponding with the list above");
            inputString();
            displayString("> " + input);
            cardNum = input.trim().toLowerCase().replaceAll("( )+", " ");
            if (cardNum.equals("1") || cardNum.equals("0")|| cardNum.equals("2") || cardNum.equals("3") || cardNum.equals("4") || cardNum.equals("5")||cardNum.equals("6") ||cardNum.equals("7") ||cardNum.equals("8") ||cardNum.equals("9") ||cardNum.equals("10")) {
                valid = true;
            } else {
                displayError("Sorry not a valid number please choose againsdcascxcx");
            }
        } while (!valid);
    }

    public String getCardNum() {
        return cardNum;
    }
    
    public void YesNoChecker(Player player) {
        boolean valid = false;
        do {
            displayString("\n"+ player + " If it has type yes otherwise type no!!!");
            inputString();
            displayString("> " + input);
            YesOrNo = input.trim().toLowerCase().replaceAll("( )+", " ");
            if (YesOrNo.equals("yes") || YesOrNo.equals("no")) {
                valid = true;
            } else {
                displayError("Sorry not a valid command please choose again");
            }
        } while (!valid);
    }

    public String getYesNoChecker() {
        return YesOrNo;
    }
    
    public void QuestionFinish(Player player) {
        boolean valid = false;
        do {
            displayString("\n"+ player + "Please type 'done' to finish");
            inputString();
            displayString("> " + input);
            Qfin = input.trim().toLowerCase().replaceAll("( )+", " ");
            if (Qfin.equals("done")) {
                valid = true;
            } else {
                displayError("Sorry not a valid number please choose again");
            }
        } while (!valid);
    }

    public String getQuestionFinish() {
        return Qfin;
    }
   
        public void accuse(Player player) {  
    	
    //	displayString(Arrays.toString(Cluedo.tempArray));
    	
   	 	displayString("Enter the murderer:\n");
   	 	input1 = commandPanel.getCommand();	 
   	 
   		displayString("Enter the murder room:\n");
   	 	input2 = commandPanel.getCommand();	 	
    
   	 	displayString("Enter the murder weapon:\n");
   	 	input3 = commandPanel.getCommand();	
  
	
       String[] test = new String[]{input1, input2, input3};
       displayString(Arrays.toString(test));
       
       if (Arrays.equals(test, Cluedo.tempArray)) {
    	    displayString("You have guessed correctly." + player.getName() + " has won the game, congratulations!");
    	    displayString("Game will close in 3 second!");
       		
    	    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    System.exit(0);
       		}

    else if(!Arrays.equals(test, Cluedo.tempArray)) {
       	
   	  	if(players.size() == 2 ) {
   	  		
   	  		
   	  		displayString("You are wrong.");
   	  		players.turnOver();
   	    	//DECLARE OTHER PLAYER AS THE WINNER
   	  		displayString("" +players.getCurrentPlayer().getName() + " has won the game.");
			displayString("Game will close in 3 second!");
       		
    	    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    System.exit(0);
   	  		//END THE GAME
		  		
   	  	}
   	  	/**
   	  	else if(players.size() > 2 ) {
   	  		displayString("You have guessed incorrectly." + player.getName() + " you are now out of the game.");
   	//  	   
   	  	   players.remove();
   	  	   
   	     	displayString("" +players.getCurrentPlayer().getName() + " is the current player.");
				
   	  	
   	  		
   	  	
   	  		
   	  	} **/
   	  	
   	  	
   	  	}
       
         	
    } 
    
   

    
    
    
    
    public int getDoor() {
        return door;
    }

}
