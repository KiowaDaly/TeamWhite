
public class Cluedo_Character { //method used in storing and printing the character names.
	
		private String characters_name;
		
		public Cluedo_Character(String name) { //constructor for the method
			this.characters_name = name;
		}
		
		public String toString() { //toString method returns character names held within the characters_name String variable
			return characters_name;
		}

}

