import java.util.ArrayList;



public class Player {

    private final String name;
    private final Token token;
    private int turnNum;
    private ArrayList<Card> myCards;
    private ArrayList<Card> viewedCards;

    Player(String name, Token token, int turnNum,ArrayList<Card>myCards,ArrayList<Card> viewedCard) {
        this.name = name;
        this.token = token;
        this.turnNum = turnNum;
        this.myCards = myCards;
        this.viewedCards = viewedCards;
      
    }

    public void addCard(Card myCard) {
    	myCards.add(myCard);
    }
    public void setCards(ArrayList<Card> myCardList){
    	this.myCards=myCardList;
    	
    }
    public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.trim());
    }

    public String getName() {
        return name;
    }
    
    public void setTurnNum(int turnNum) {
    	  this.turnNum = turnNum;
    }

    public int getTurnNum() {
        return turnNum;
    }
    
    public Token getToken() {
        return token;
    }
    public ArrayList<Card> getMyCards() {
    	return myCards;
    }
    public ArrayList<Card> getViewedCards() {
    	return viewedCards;
    }
    
    
    @Override
    public String toString() {
        return name + " (" + token.getName() + ")";
    }
    
}
