

public class Card{

	
	private final String CardName;
	private final String CardImagePath;
	
	
	
	
	
	
	
	public Card(String CardName,String CardImagePath){
		this.CardName = CardName;
		this.CardImagePath = CardImagePath;
		
	}
	
	public String getName() {
		return CardName;
	}
	
	public String getImage() {
		return CardImagePath;
		
	}
	
	
	
}
