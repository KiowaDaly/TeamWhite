import javax.swing.ImageIcon;

public class Card{

	
	private final String CardName;
	private final ImageIcon CardIcon;
	
	
	
	
	
	
	
	public Card(String CardName,ImageIcon CardIcon){
		this.CardName = CardName;
		this.CardIcon = CardIcon;
		
	}
	
	
	public String getName() {
		return CardName;
	}
	
	public ImageIcon getImage() {
		return CardIcon;
		
	}
	public Card getCard() {
		return this;
	}
    public boolean hasName(String name) {
        return this.CardName.toLowerCase().equals(name.toLowerCase().trim());
    }
	

}
