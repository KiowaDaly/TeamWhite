

public class Player {

	private String name;
	private Token PlayerToken;
	private boolean isPlaying;
	
	
	
	Player(String Name,Token PlayerToken,boolean isPlaying){
		this.name=Name;
		this.PlayerToken=PlayerToken;
		this.isPlaying=isPlaying;
	}
	
	public Token getToken() {
		return Tokens.get(PlayerToken.getName());
	}
	
	public String getName() {
		return name;
	}

	
	public void setPlaying(boolean value) {
        isPlaying = value;
   }
	
	public boolean Playing() {
        return isPlaying;
    }
	
}