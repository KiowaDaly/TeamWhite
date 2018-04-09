
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Cluedo {

    private static final int MAX_NUM_PLAYERS = 6;
    int max =0;
    private final Tokens tokens = new Tokens();
    private Players players = new Players();
    private final Dice dice = new Dice();
    private final Map map = new Map();
    private final Weapons weapons = new Weapons(map);
    private final UI ui = new UI(tokens,weapons);
    private soundPlayer sound = new soundPlayer();
    private ArrayList<Card> CardsVisibleToAll = new ArrayList<Card>();
    private CardAssignment cardAssign = new CardAssignment();
    private Object[] cards = cardAssign.cluedoCard();
    private Card[] Solutions =  (Card[]) cards[3];
    private String murderSolutions;
    static String[] tempArray = new String[3];
	
    //a function to allocate cards to the game;
    private void AllocateCards(Players players,int numPlayersSoFar) {
    	
       ArrayList<Card> ListOfCards = new ArrayList<Card>();//this list will hold all the cards we create in their respective classes.
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
      
      
      //this first while loop makes sure the cards can be evenly divided between the players//
      while(!((ListOfCards.size()%numPlayersSoFar)==0)) {
    	  	CardsVisibleToAll.add(ListOfCards.get(0));
    	  	ListOfCards.remove(ListOfCards.get(0));	  	
      }
      //so long as the list of cards isnt empty we allocate cards to each player//
    	while(!ListOfCards.isEmpty()) {
    	  	for(int i = 0;i<numPlayersSoFar;i++) { 
    	  		players.get(i).addCard(ListOfCards.get(0));
    			ListOfCards.remove(ListOfCards.get(0));
    		  } 
    	  }	  
    }
 
    private void SelectWhoGoesFirst(int numPlayersSoFar) {
 
        int i = 0;
        int[] array=new int[numPlayersSoFar];
        int[] newArray=new int[numPlayersSoFar];
        ui.displayString("  ROLLING TO SEE WHO GOES FIRST......");
        do {
        	
        	dice.roll();
        	 Player currentPlayer = players.getCurrentPlayer();
        	 currentPlayer.setTurnNum(dice.getTotal());
        	 array[i]=currentPlayer.getTurnNum();
        	 
        	 
        	 //for loop to check if they have rolled the same number as somebody else
        	/*  for(int j=0;j<array.length;) {
        		 
        		  if(currentPlayer.getTurnNum()==array[j] && j!=i) {
        			//if they have re-roll and restart the loop    
        		  dice.roll();
            	 currentPlayer.setTurnNum(dice.getTotal());
            	System.out.println( currentPlayer.getTurnNum() +  currentPlayer.getName());
            	 array[i]=currentPlayer.getTurnNum();
            	 j=0;
        		  }else {
        			  j++;
        		  }
        		 
        	  }*/
        	 ui.displayString("\n" +currentPlayer.getName()+" has rolled a " + currentPlayer.getTurnNum());
        	  players.turnOver();
          i++;
        } while (i!=numPlayersSoFar);
        
        //calls sort in players.java
     //  players.sort();
       
        //gets the max of the created array from above
        int count = 1;
        for (int counter = 0; counter < array.length; counter++)
        {
             if (array[counter] > max)
             {
              max = array[counter];
             }
             	
             
        }
        
        
        ui.displayString("\n" + "The max roll was " + max);
        
        int numberofrolls=0;
        
		
        
        do {
       
    	i=0;
    	count=3;
    	//this if and nested loop will only print out the re-rolls of dices if more than one player got the max
    	if(numberofrolls>0) {
    		
    	for(int j=0;j<6;j++) {
   		  Player currentPlayer = players.getCurrentPlayer();
  		  if(currentPlayer.getTurnNum()>0) {
  		
  			 ui.displayString("\n" +currentPlayer.getName()+" has re-rolled a " + currentPlayer.getTurnNum()); 
  		
  		  }
  	
  		  
  		players.turnOver();
    	}
    	
    	ui.displayString("\n" + "The new max roll is " + max);
    	
    	}
    	
    	numberofrolls=0;
    	  for(int j=0;j<newArray.length;j++) {
    		  newArray[j]=0;
    	  }//sets all values of this array to 0
    	  
    	  
    	  /*if the current player rolled a the max previously, then the will re-roll, but if they didn't roll the max, they will be set to 0*/
        for(int j=0;j<array.length;j++) {
   		  Player currentPlayer = players.getCurrentPlayer();
  		  if(currentPlayer.getTurnNum()==max) {
  		
  		
  		  dice.roll();
      	 currentPlayer.setTurnNum(dice.getTotal());
      	 newArray[i]=currentPlayer.getTurnNum();
      	 i++;
         count--;
         numberofrolls++;
         
  		  }else {
  			currentPlayer.setTurnNum(0);
  		  }
  		    
  		  players.turnOver();
  	  }
        
        
        for(int j=0;j<array.length;j++) {
      		 //resets the max to the first element of the newArray and then if a larger value is present in the array, that will become the max 
        	if(j==0 || max < newArray[j]) {
           	 max = newArray[j];
           
            }
    		  }
     
        }while(count<2);//this will keep running until we have only needed to re-roll one dice. i.e. the guy who gets to go first.
    }
      
    
    
    private void inputPlayerNames() {
        int numPlayersSoFar = 0;
        
        do {
            ui.inputName(players);
            if (!ui.inputIsDone()) {
                ui.inputToken(tokens);
                Token token = tokens.get(ui.getTokenName());
                
                players.add(new Player(ui.getPlayerName(),token,0, new ArrayList<Card>(),new ArrayList<Card>()));//added random card assignment//
                token.setOwned();
                numPlayersSoFar++;
            }

          
        } while (!ui.inputIsDone() && numPlayersSoFar<MAX_NUM_PLAYERS);
        
        AllocateCards(players,numPlayersSoFar);
        SelectWhoGoesFirst(numPlayersSoFar);
        
       
      
               
    }

    private void takeTurns() {
        boolean moveOver, turnOver,  gameOver = false;
        boolean finishedQ = false;
        int count=0;
        do {  
            turnOver = false;
            moveOver = false;
            do { 
            	
            	Player currentPlayer = players.getCurrentPlayer();
            	Token currentToken = currentPlayer.getToken();
            	/* Basically because above I set the value of the players TurnNum to 0 if they were not going to re-roll. eventually the only guy who will
            	 * have a value greater than 0 will be the person going first, so this if statement skips to that person, but only for the first turn, after the first person has gone, count will be >0
            	 * and thus we will never enter that if statement again.  */
            	if(currentPlayer.getTurnNum()==0 && count==0) {
            		turnOver = true;
            		break;
               
            	}else {count=1;}
            	
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
                                        sound.playSound("open_creaky_door.wav");
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
                    	ui.resetInfo();
                        turnOver = true;
                        break;
                    }
                    case "quit": {
                        turnOver = true;
                        gameOver = true;
                        break;
                    }
                   
                    case "cheat":{
                    	
                    	 int i = 0;
                    
                    ui.displayString("\nSolutions:");
                   	
                    	for( i = 0;i<cards.length-1;i++) {
                 	
                    		murderSolutions = Solutions[i].getName();
                    		ui.displayString(""+murderSolutions+"");
                    		tempArray[i] = murderSolutions;
                 	}
                 	
                   //  ui.displayString(Arrays.toString(tempArray));
			   
                    	 break;
                    }
                    
                    case "log":{
                    	
                    	SwingUtilities.invokeLater(new Runnable() {

                			@Override
                			public void run() {
                				//this part needs fixing since it is really basic//
                		JFrame Logframe = new JFrame();
                    	Logframe.setSize(800, 250);
          
                         Logframe.setTitle("LOG");
                         Logframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                         Logframe.add(ui.getLog(), BorderLayout.LINE_START);
                         Logframe.setResizable(true);
                         Logframe.setVisible(true);
                			}
                			
                		});
                    	break;
                         
                    }
                    case "help": {
                    	 JOptionPane.showMessageDialog(null, 
                         	      "\n'roll' to roll the dice\n" +
                         	      "\n'quit' to quit the game\n" +
                         	      "\n'cheat' to look at game solution\n" +
                         	      "\n'cards' to look at your cards\n" +
                            	  "\n'notes' to look at your notes\n" +
                                  "\n'L' to go left when it is your turn\n" +
                                  "\n'R' to go right when it is your turn\n" +
                                  "\n'U' to go up when it is your turn\n" +
                                  "\n'D' to go down when it is your turn\n" 
                             		);        	
                         break;
                    }
                    //this case is for sprint 4, ignore!//
                    case "question":{
                   	 if (currentToken.isInRoom()) {
                   		 
                   	
                   		 String murderer = ui.inputMurderer(currentPlayer,tokens);
                   		 ui.displayString(murderer);
                   		 String WeaponUsed = ui.inputMurderWeapon(currentPlayer,weapons);
                   		 ui.displayString(WeaponUsed);
				 
                   		 
                   		 Token Murderer = tokens.get(murderer);
                   		 Weapon Weapon = weapons.get(WeaponUsed);
                   		 Room MurderRoom =  currentToken.getRoom();
                   		 ui.displayString(Murderer.getName());
                   		 ui.displayString(Weapon.getName());
                   		 ui.displayString(MurderRoom.toString());
                   		 
                   		Murderer.enterRoom(MurderRoom);
                   		Weapon.enterRoom(MurderRoom);
                   		ui.display();
                   		players.turnOver();
                   		
                   		Player currentPlayerTemp = players.getCurrentPlayer();
                   		Player currentPlayerTemp2 = players.getCurrentPlayer();
                    	
                    	
                    	int temp = 0;
                    	
                    	Card[]  tempArray=new Card[10];
                    	 ui.resetInfo();
                    	do {
                    		finishedQ=false;
                        	
                    	do {
                    		for(int i=0;i<10;i++)
                    		{
                    			tempArray[i] = null;
                    		}
                    		int i=0;
                    		ui.displayString("Has the computer been given to " + currentPlayerTemp.getName() + "???\n" );
                    		ui.displayString("If it has type yes otherwise type no!!!" );
                    		ui.YesNoChecker(currentPlayerTemp);
                    	 switch(ui.getYesNoChecker()) {
                   
                    	 case "yes":{
                    		 
                    		 
                    		 ui.resetInfo();
                    		 ui.displayString("Hello " + currentPlayerTemp.getName() + "\nThe question asked:" );
                    		 ui.displayString("Murderer: "+Murderer.getName());
                       		 ui.displayString("Weapon: "+Weapon.getName());
                       		 ui.displayString("Room: " + MurderRoom.toString());
                       		 ui.displayString("\nCards you have:\n");
                       		 for(Card card:currentPlayerTemp.getMyCard()) {
                       			
                       			
                        		ui.displayString(card.getName()+"\n");
                        		
                       			}
                        	
                       		
                    	 ui.displayString("Matching cards:\n");
                       		for(Card card:currentPlayerTemp.getMyCard()) {
                       			
                       			if(card.getName()==Murderer.getName().trim() || card.getName()==Weapon.getName().trim() || card.getName()== MurderRoom.toString()) {
                       				tempArray[i]=card;
                        		ui.displayString(i + " " + card.getName());
                        		i++;
                       			}
                        	}
                    	 
                       		
                       		do {
                       			
                       		if(tempArray[0]!= null) {
                       			
                       			
                       			ui.inputCardNum(currentPlayerTemp);
                       			temp = Integer.parseInt(ui.getCardNum());
                       			
                       			
                       				
                       				if(tempArray[temp]==null) {
                       				ui.displayString("Sorry not a valid number please choose again");
                       			
                       				}else{
                       					
                       							ui.displayString("You have selected the card: " + tempArray[temp].getName()+ "\n Please pass the computer to " + currentPlayer.getName() );
                       							finishedQ=true;
                       							ui.displayString("Please type 'done' to end the questioning");
                       							
                       							ui.QuestionFinish(currentPlayerTemp);
                       							
                       							while(currentPlayer.getName()!=currentPlayerTemp.getName()){
                       								players.turnOver();
                       								currentPlayerTemp = players.getCurrentPlayer();
                       							}
                       						 ui.resetInfo();
                       						}
                       				
                       			
                       			
                       		}else {
                       			currentPlayerTemp2 = players.getCurrentPlayer();
                       			players.turnOver();
                       			currentPlayerTemp = players.getCurrentPlayer();
                       			ui.displayString("You do not have any of the cards from the question asked \n please pass the computer to  " + currentPlayerTemp.getName() );
                       			ui.displayString("and type 'done' to end the questioning");
       							
       							
       							ui.QuestionFinish(currentPlayerTemp2);
       							
                       			finishedQ=true;
                       			
                       		 ui.resetInfo();
                       		}
                       		
                       		}while(finishedQ==false);
                       		
                       	 
                       	 
                    		 
                    		 break;
                    	 }
                    	 
                    	 case "no":{
                    		 ui.displayString("Please ensure that  " + currentPlayerTemp.getName() + " gets the computer" );
                    		
                    		 break;
                    	 }
                    	 
                    	 
                    	 }
                    	 
                    	 
                    	}while(finishedQ==false);
                    	
                    	
                    	}while(currentPlayer!=currentPlayerTemp);
                   		 
                    	
                    	
                    	do {
                    	ui.displayString("Has the computer been given to " + currentPlayerTemp.getName() + "???\n" );
                		
                		ui.YesNoChecker(currentPlayerTemp);
                	 switch(ui.getYesNoChecker()) {
               
                	 case "yes":{
                		 ui.displayString("Hello " + currentPlayer.getName() );
                		 
                		 if(tempArray[temp]!=null) {
                			 ui.displayString("The following card was found: " + tempArray[temp].getName() );
                			 ui.displayString("This card has been added to your notes section\n");
                			 currentPlayer.addViewedCard(tempArray[temp]);
                			 
                		 }else {
                			 
                			 ui.displayString("\n None of the other players had any of the cards in question");
                			 ui.addTextToLog("\n no one has any of the cards asked");
                		 }
                		 break;
                	 }
                	
                	 case "no":{
                		 ui.displayString("Please ensure that  " + currentPlayer.getName() + " gets the computer" );
                		 
                		 break;
                	 }
                    	
                    	
                	 }
                    	
                    	}while(ui.getYesNoChecker().equals("no"));	
                    	
                    	
                   	 }
                   	 else {
                   		 ui.displayErrorNotInRoom();
                   	 }
                   	 
               		 
                   	 break;
                    }
                    
                     case "accusation": {
                    	 if(currentToken.isInRoom()) {
                    		 if(!currentToken.getRoom().toString().equalsIgnoreCase("cellar")) {
                    			 ui.displayAccuseError();
                   }
                    		 
                    		else {
                	   players = ui.accuse(players,currentPlayer);
                	   moveOver = true;
                   } 
                    		 
                    	 }
                    	 else {
                    		 ui.displayErrorNotInRoom();
                    	 }
                   
			         
                    	       
                     break;
                    }
                    
                     case "cards": {
                    	ui.displayString("\nMy cards: \n");
                    	for(Card card:currentPlayer.getMyCard()) {
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
                 		
                 		for(Card card:currentPlayer.getMyCard()) {
                 			
                         		for(int i=0; i < 10; i++) {
                         			for(int j=0; j < 3; j++) {
                         				for(Card cards:CardsVisibleToAll) {
                         					if(info[i][j].equals(cards.getName())) {
                         						table.setValueAt(cards.getName() + " 'A' ", i, j);
                         					}
                         				}
                         				for(Card cards2:currentPlayer.getViewedCard()) {
                         					if(info[i][j].equals(cards2.getName())) {
                         						table.setValueAt(cards2.getName() + " 'V' ", i, j);
                         					}
                         				}
                         				if(info[i][j].equals(card.getName())) {
                         					table.setValueAt((card.getName() +" 'X' "), i, j);
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
    	new SplashScreenDriver();
        Cluedo game = new Cluedo();
        game.inputPlayerNames();
//        game.AllocateCards(players, 0);
        game.takeTurns();
        System.exit(0);
    }
}
