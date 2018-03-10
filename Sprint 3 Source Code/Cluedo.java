import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import java.util.Collections;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;





public class Cluedo {

    private static final int MAX_NUM_PLAYERS = 6;

    private final Tokens tokens = new Tokens();
    private final Players players = new Players();
    private final Dice dice = new Dice();
    private final Map map = new Map();
    private final Weapons weapons = new Weapons(map);
    private final UI ui = new UI(tokens,weapons);
   
    private ArrayList<Card> CardsVisibleToAll = new ArrayList<Card>();
    private CardAssignment cardAssign = new CardAssignment();
    private Object[] cards = cardAssign.cluedoCard();
  
    private Card[] Solutions =  (Card[]) cards[3];
    

    
    
    
    //a function to allocate cards to the game;
    private void AllocateCards(Players players,int numPlayersSoFar) {
    	
       
       ArrayList<Card> ListOfCards = new ArrayList<Card>();
       CharacterCards CharacterCards = (CharacterCards) cards[0];
       WeaponCards WeaponCard = (WeaponCards) cards[1];
       RoomCards RoomCards = (RoomCards) cards[2];
      
        
        
       for(Card card:WeaponCard) {
        	ListOfCards.add(card);
       }
       
       for(Card card:RoomCards) {
        	ListOfCards.add(card);
       }
     
       for(Card card:CharacterCards) {
        	ListOfCards.add(card);
       }
      
        
      long mySeed = System.nanoTime();
      Collections.shuffle(ListOfCards,new Random(mySeed));
      Collections.shuffle(ListOfCards,new Random(mySeed));//shuffles twice to ensure random shuffle//
      
      
      
      while(!((ListOfCards.size()%numPlayersSoFar)==0)) {
    	  	CardsVisibleToAll.add(ListOfCards.get(0));
    	  	ListOfCards.remove(ListOfCards.get(0));	  	
      }
      
    	while(!ListOfCards.isEmpty()) {
    	  	for(int i = 0;i<numPlayersSoFar;i++) { 
    	  		players.get(i).addCard(ListOfCards.get(0));
    			ListOfCards.remove(ListOfCards.get(0));
    		  } 
    	  }	  
    }
      

      
    
    
    private void inputPlayerNames() {
        int numPlayersSoFar = 0;
        
        do {
            ui.inputName(players);
            if (!ui.inputIsDone()) {
                ui.inputToken(tokens);
                Token token = tokens.get(ui.getTokenName());
                
                players.add(new Player(ui.getPlayerName(),token,new ArrayList<Card>()));//added random card assignent//
                token.setOwned();
                numPlayersSoFar++;
            }
            if(ui.inputIsDone()) {
            	  AllocateCards(players,numPlayersSoFar);
            }
          
        } while (!ui.inputIsDone() && numPlayersSoFar<MAX_NUM_PLAYERS);
        
    }


    private void takeTurns() {
        boolean moveOver, turnOver, gameOver = false;
        do {
            turnOver = false;
            moveOver = false;
            do {
                Player currentPlayer = players.getCurrentPlayer();
                Token currentToken = currentPlayer.getToken();
                ui.inputCommand(currentPlayer);
                switch (ui.getCommand()) {
                    case "roll": {
                        if (!moveOver) {
                            dice.roll();
                            ui.displayDice(currentPlayer, dice);
                            int squaresMoved = 0;
                            if (currentToken.isInRoom()) {
                                if (currentToken.getRoom().getNumberOfDoors()>1) {
                                    boolean exitDone = false;
                                    do {
                                        ui.inputDoor(currentPlayer);
                                        if (ui.getDoor()>= 1 || ui.getDoor()<=currentToken.getRoom().getNumberOfDoors()) {
                                            currentToken.leaveRoom(ui.getDoor()-1);
                                            exitDone = true;
                                        } else {
                                            ui.displayErrorNotADoor();
                                        }
                                    } while (!exitDone);
                                } else {
                                    currentToken.leaveRoom();
                                }
                                ui.display();
                            }
                            do {
                                ui.inputMove(currentPlayer, squaresMoved+1, dice.getTotal());
                                Coordinates currentPosition = currentToken.getPosition();
                                Coordinates newPosition;
                                if (map.isValidMove(currentPosition, ui.getMove())) {
                                    newPosition = map.getNewPosition(currentPosition, ui.getMove());
                                    if (map.isDoor(currentPosition, newPosition)) {
                                        Room room = map.getRoom(newPosition);
                                        currentToken.enterRoom(room);
                                    } else {
                                        currentToken.setPosition(newPosition);
                                    }
                                    squaresMoved++;
                                    if (squaresMoved==dice.getTotal() || currentPlayer.getToken().isInRoom()) {
                                        moveOver = true;
                                    }
                                    ui.display();
                                } else {
                                    ui.displayErrorInvalidMove();
                                }
                            } while (!moveOver);
                        } else {
                            ui.displayErrorAlreadyMoved();
                        }
                        break;
                    }
                    case "passage": {
                        if (!moveOver) {
                            if (currentToken.isInRoom() && currentToken.getRoom().hasPassage()) {
                                Room destination = currentToken.getRoom().getPassageDestination();
                                currentToken.leaveRoom();
                                currentToken.enterRoom(destination);
                                moveOver = true;
                                ui.display();
                            } else {
                                ui.displayErrorNoPassage();
                            }
                        } else {
                            ui.displayErrorAlreadyMoved();
                        }
                        break;
                    }        
                    case "done": {
                        turnOver = true;
                        break;
                    }
                    case "quit": {
                        turnOver = true;
                        gameOver = true;
                        break;
                    }
                   
                    case "cheat":{
                    	
                    	ui.displayString("\nSolutions:");
                    	for(int i = 0;i<cards.length-1;i++) {
                    		ui.displayString(Solutions[i].getName());
                    	}
                    	 break;
                    }
                
                    case "help": {
                    	 JOptionPane.showMessageDialog(null, 
                          	      "\n'roll' to roll the dice\n" +
                          	      "\n'quit' to quit the game\n" +
                          	      "\n'cheat' to look at game solution\n" +
                          	      "\n'cards' to look at your cards\n" +
                                  "\n'L' to go left when it is your turn\n" +
                                  "\n'R' to go right when it is your turn\n" +
                                  "\n'U' to go up when it is your turn\n" +
                                  "\n'D' to go down when it is your turn\n" 
                              		);      	
                         break;
                    }
                     case "cards": {
                    	ui.displayString("\nMy cards: \n");
                    	for(Card card:currentPlayer.getCards()) {
                    		ui.displayString(card.getName());
                    	}
                    	
                    	if(CardsVisibleToAll.size()==0) {
                    		ui.displayString("");
                    	}else {
                    	ui.displayString("\nExtra Cards:\n");
                    	for(Card card:CardsVisibleToAll) {
                		ui.displayString(card.getName());
                    	}
                    	}  	
                    	break;
                    }
                    case "notes":{
                     	
                     	String[] column_names = {"Characters", "Weapons", "Rooms"};
                     	Object[][] info = {
                     			{"Plum", "Rope", "Kitchen"},
                     			{"White", "Dagger", "Ballroom"},
                     			{"Scarlett", "Wrench", "Conservatory"},
                     			{"Green", "Revolver", "Billiard Room"},
                     			{"Mustard", "Candle Stick", "Library"},
                     			{"Peacock", "Lead Pipe", "Study"},
                     			{"", "", "Hall"},
                     			{"", "", "Lounge"},
                     			{"", "", "Dining Room"},
                     			{"", "", "Cellar"}
                     	};
                     	JTable table = new JTable(info, column_names);
                     	table.setBackground(Color.gray);
                     	table.setFont((new Font("monospaced", Font.PLAIN, 16)));
                     	table.setPreferredScrollableViewportSize(table.getPreferredSize());
                 		table.setFillsViewportHeight(true);
                 		table.setVisible(true);
                 		
                 		
                 			
                 		
                 		
                 		JFrame frame_table = new JFrame(currentPlayer.getName() + "'s notes");
                 		frame_table.setSize(800, 250);
                 		frame_table.add(new JScrollPane(table));
                 	
                 		frame_table.setVisible(true);
                 		
                 		for(Card card:currentPlayer.getCards()) {
                 			for(Card cards:CardsVisibleToAll) {
                         		for(int i=0; i < 10; i++) {
                         			for(int j=0; j < 3; j++) {
                         				if(info[i][j].equals(card.getName())) {
                         					table.setValueAt((card.getName() +" 'X' "), i, j);
                         				}	
                         				if(info[i][j].equals(cards.getName())) {
                         					table.setValueAt(cards.getName() + " 'A' ", i, j);
                         				}
                         			}
                     			
                         		}
                 			}
                 		}
                 		
                 		
                 		break;
                     }
                 }
                    
                  
                
            } while (!turnOver);
            if (!gameOver) {
                players.turnOver();
            }
        } while (!gameOver);
    }
    
    
    public static void main(String[] args) {
        Cluedo game = new Cluedo();
        game.inputPlayerNames();
//        game.AllocateCards(players, 0);
        game.takeTurns();
        System.exit(0);
    }
}
