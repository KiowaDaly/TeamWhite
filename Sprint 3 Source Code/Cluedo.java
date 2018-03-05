import java.util.Random;

public class Cluedo {

    private static final int MAX_NUM_PLAYERS = 6;

    private final Tokens tokens = new Tokens();
    private final Players players = new Players();
    private final Dice dice = new Dice();
    private final Map map = new Map();
    private final Weapons weapons = new Weapons(map);
    private final UI ui = new UI(tokens,weapons);
    private final WeaponCards weaponCards = new WeaponCards();
    private final RoomCards roomCards = new RoomCards();

    private void inputPlayerNames() {
        int numPlayersSoFar = 0;
        CardAssignment cardAssign = new CardAssignment();
        Object[] cards = cardAssign.cluedoCard(weaponCards, roomCards);
        WeaponCards WeaponCard = (WeaponCards) cards[0];
        RoomCards RoomCards = (RoomCards) cards[1];
        do {
            ui.inputName(players);
            if (!ui.inputIsDone()) {
                ui.inputToken(tokens);
                Token token = tokens.get(ui.getTokenName());
                
                players.add(new Player(ui.getPlayerName(),token,new Card[] {WeaponCard.get(new Random().nextInt(WeaponCard.size()-0+1)+0),RoomCards.get(new Random().nextInt(RoomCards.size()-0+1)+0)}));//added random card assignent//
                token.setOwned();
                numPlayersSoFar++;
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
                    case "done": {
                        turnOver = true;
                        break;
                    }
                    case "quit": {
                        turnOver = true;
                        gameOver = true;
                        break;
                    }
                    case "cards": {
                    	Card[] myCards = currentPlayer.getCards();
                    	ui.displayString("\nMy cards: \n");
                    	ui.displayString(myCards[0].getName()+"\n");
                    	ui.displayString(myCards[1].getName()+"\n");
                    	
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
        game.takeTurns();
        System.exit(0);
    }
}
