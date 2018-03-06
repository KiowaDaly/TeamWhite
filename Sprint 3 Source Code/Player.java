import java.util.ArrayList;



public class Player {

    private final String name;
    private final Token token;
    private ArrayList<Card> myCards;

    Player(String name, Token token,ArrayList<Card>myCards) {
        this.name = name;
        this.token = token;
        this.myCards = myCards;
      
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

    public Token getToken() {
        return token;
    }
    public ArrayList<Card> getCards() {
    	return myCards;
    }
    
    
    @Override
    public String toString() {
        return name + " (" + token.getName() + ")";
    }
}
