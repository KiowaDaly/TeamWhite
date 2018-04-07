import java.util.ArrayList;

import javax.swing.JTextArea;



public class Player {

    private final String name;
    private final Token token;
    private int turnNum;
    private ArrayList<Card> myCard;
    private ArrayList<Card> viewedCard;


    Player(String name, Token token, int turnNum,ArrayList<Card>myCard,ArrayList<Card>viewedCard) {
        this.name = name;
        this.token = token;
        this.turnNum = turnNum;
        this.myCard = myCard;
        this.viewedCard = viewedCard;
    
    }

    public void addCard(Card card) {
    	myCard.add(card);
    }
    public void addViewedCard(Card card) {
    	viewedCard.add(card);
    }
    public void setCards(ArrayList<Card> myCardList){
    	this.myCard=myCardList;
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
    public ArrayList<Card> getMyCard() {
    	return myCard;
    }
    public ArrayList<Card> getViewedCard() {
    	return viewedCard;
    }
    
    
    @Override
    public String toString() {
        return name + " (" + token.getName() + ")";
    }
    
}
