public class Cluedo_Weapons { //method used in storing and printing the weapon names.
		private String Weapon;
		
		
		public Cluedo_Weapons(String Weapon,String Icon) { //constructor for the method
			this.Weapon = Weapon;
			
			
		}
		public String toString() { //toString method returns weapons names held within the Weapon String variable
			return Weapon;
		}
}
