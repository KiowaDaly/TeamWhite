import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TabbedPanel extends JTabbedPane{

	private static final long serialVersionUID = 1L;
	private final Tokens tokens= new Tokens();
	private final Weapons weapons = new Weapons();
	private final Rooms rooms = new Rooms();
	
	
	TabbedPanel(){
		JPanel characters = new JPanel();  //Initialises a new panel...
		addTab("Suspects", characters); //... and adds it as a new named tab to the bottom panel.
		
		JTextArea character_names = new JTextArea(); //Initialises a new area where text can be written...
		//character_names.setFont(font); //... sets the pre-determined Cluedo font...
		characters.add(character_names); //... and adds the text area to tab panel.
		
		character_names.append("Here is a list of characters!\n"); //Makes changes to/appends the text area...
		
		for(Token items: tokens) {
			character_names.append(items.getName()+"\n");
		
			character_names.append("\t");
			
		}
	
		
		JPanel weapon = new JPanel(); //Initialises a new panel...
		addTab("Weapons", weapon); //... and adds it as a new named tab to the bottom panel.
		JTextArea weapon_names = new JTextArea(); //Initialises a new area where text can be written...
		weapon.add(weapon_names); //... and adds the text area to tab panel.
		
		weapon_names.append("Here is a list of Weapon!\n"); //Makes changes to/appends the text area...
		
		for(Weapon items: weapons) {
			weapon_names.append(items.getName());
			weapon_names.append("\t");
		}
		
		//player sheets for each player so as to keep their information discrete
		JPanel playersheet1 = new JPanel();
		addTab("Player 1", playersheet1);
		JTextArea player_1 = new JTextArea();
		for(Token items: tokens) {
			player_1.append(items.getName());
			player_1.append("\n");
		}
		for(Weapon items: weapons) {
			player_1.append(items.getName());
			player_1.append("\n");
		}
		for(Room items: rooms) {
			player_1.append(items.getName());
			player_1.append("\n");
		}
		playersheet1.add(player_1);
		
		
		
		
		JPanel playersheet2 = new JPanel();
		addTab("Player 2", playersheet2);

		JPanel playersheet3 = new JPanel();
		addTab("Player 3", playersheet3);
		
		JPanel playersheet4 = new JPanel();
		addTab("Player 4", playersheet4);
		
		JPanel playersheet5 = new JPanel();
		addTab("Player 5", playersheet5);
		
		JPanel playersheet6 = new JPanel();
		addTab("Player 6", playersheet6);
		
		
		
}
	
}