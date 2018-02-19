import java.util.Random;

public class Dice {

	
	int ResultOfDice = 0;
	public Dice() {
		Random DiceRoll1 = new Random(); // Initialises a new variable to randomly generate a series of numbers...
		ResultOfDice = DiceRoll1.nextInt(6)+1; //...which are integers and returns an random number between 0 and 6 (since 0 isn't a dice number, we increment the random number by 1)
		
	}
	public int getValue() {
		return ResultOfDice;
	}
	
}
