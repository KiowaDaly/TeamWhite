import javax.swing.ImageIcon;

public class Player {

    private final String name;
    private final Token token;
    private final Card[] myCards;

    Player(String name, Token token,Card[] myCards) {
        this.name = name;
        this.token = token;
        this.myCards = myCards;
      
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
    public Card[] getCards() {
    	return myCards;
    }
    
    
    @Override
    public String toString() {
        return name + " (" + token.getName() + ")";
    }
}
