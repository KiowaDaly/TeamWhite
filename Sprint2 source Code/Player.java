import java.util.ArrayList;

public class Player {

	private String name;
	private Token PlayerToken;
	
	
	
	Player(String Name,Token PlayerToken){
		this.name=Name;
		this.PlayerToken=PlayerToken;
	}
	
	public Token getToken() {
		return Tokens.get(PlayerToken.getName());
	}
	
	public String getName() {
		return name;
	}
	
}
