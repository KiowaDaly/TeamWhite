import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TabbedPanel extends JTabbedPane{

	private static final long serialVersionUID = 1L;
	private final Tokens tokens= new Tokens();
	
	TabbedPanel(){
		JPanel input_console = new JPanel(); //Initialises a new panel...
		addTab("Input Console", input_console); //... and adds it as a new named tab to the bottom panel.
		JTextField TextField = new JTextField(10); //Initialises a new area where text can be written...
		add(TextField); //... and adds it to the tab.
		
		JLabel commands = new JLabel(); // Initialises a new label...
		setToolTipText("Press the U (up), D (down) , L (left) , "+ "R (right) keys to move your character token." //...  sets some text to the label to instruct the player on how to move their token
					+ " Press 'Enter' to watch the red token move"); //... and adds this label to the tab.
		
		JPanel characters = new JPanel();  //Initialises a new panel...
		addTab("Characters", characters); //... and adds it as a new named tab to the bottom panel.
		
		JTextArea character_names = new JTextArea(); //Initialises a new area where text can be written...
		//character_names.setFont(font); //... sets the pre-determined Cluedo font...
		characters.add(character_names); //... and adds the text area to tab panel.
		
		character_names.append("Here is a list of characters!\n"); //Makes changes to/appends the text area...
		int i = 0;
		for(Token items: tokens) {
			character_names.append(items.getName());
			character_names.append("\t");
		}
		
		
		JPanel weapons = new JPanel(); //Initialises a new panel...
		addTab("Weapons", weapons); //... and adds it as a new named tab to the bottom panel.
}
	
	
	
 




//	//Initialises a new array list of the weapon names and assigns them a 'List' variable...
//	List<Cluedo_Weapons>  WeaponList = new ArrayList<Cluedo_Weapons>();
//	Cluedo_Weapons CandleStick = new Cluedo_Weapons("CandleStick","CandleStick.jpg");
//	Cluedo_Weapons Knife = new Cluedo_Weapons("Knife","Knife.jpg");
//	Cluedo_Weapons Revolver = new Cluedo_Weapons("Revolver","Revolver.jpeg");
//	Cluedo_Weapons Rope = new Cluedo_Weapons("Rope","rope.jpeg");
//	Cluedo_Weapons Wrench = new Cluedo_Weapons("Wrench","Wrench.jpeg");
//	Cluedo_Weapons leadPipe = new Cluedo_Weapons("Lead Pipe","leadpipe.png");
//	
//	//...and adds the contents of the strings of weapon names to the ArrayList.
//	WeaponList.add(CandleStick);
//	WeaponList.add(Knife);
//	WeaponList.add(Revolver);
//	WeaponList.add(Rope);
//	WeaponList.add(Wrench);
//	WeaponList.add(leadPipe);
//	
//	JTextArea weapon_names = new JTextArea(); //Initialises a new area where text can be written...
//	weapon_names.setFont(font); //... sets the weapon names to have the pre-determined Cluedo font...
//	weapons.add(weapon_names);//... and adds the text area to tab panel.
//	
//	weapon_names.append("Here is a list of Weapons!\n"); //Makes changes to/appends the text area...
//	
//	for(int i = 0;i<WeaponList.size();i++) { //... a for loop adds the ArrayList contents (the weapon names) to the text area...
//		weapon_names.append(WeaponList.get(i).toString());
//		weapon_names.append("\t\t"); //... and creates a section of space in between each name for readability.
//	}
//	
//	
//	
//	//fourth tab of the BottomPanel
//	JPanel dice_roll = new JPanel(); //Initialises a new panel...
//	BottomPanel.addTab("Dice Roll", dice_roll); //... and adds it as a new named tab to the bottom panel.
//	
//	JTextArea text_area = new JTextArea(); //Initialises a new area where text can be written.
//	text_area.setFont(font); //Sets the font of any text in text_area to have the pre made Cluedo font.
//	text_area.setEditable(false); // The text on the output console can not be edited by the player...
//	JScrollPane scrollPane = new JScrollPane(text_area); //... the player has the ability to scroll down the output console to see their dice roll, movement etc when the output does not fit the initial screen
//	TopPanel.setBottomComponent(scrollPane); //...and the scroll pane is added to the right of the top panel.
//	
//	JButton roll_button = new JButton("Roll Those Dice!"); //A new button has been generated...
//	dice_roll.add(roll_button); //...and added to the panel.
//	
}