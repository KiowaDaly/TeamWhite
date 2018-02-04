import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Board {
	
	
	
	public static void main(String[] args){
		
		Font font = new Font("Myriad Black", Font.BOLD, 20); //Cluedo font with bold writing to make everything easier to read
		
		JFrame MainFrame = new JFrame("Cluedo by KRM");//creating the main frame with a title//
		JSplitPane SplitMainPanel=new JSplitPane(); //this allows us to splice the frame into smaller bits//
		JLabel ImageLabel = new JLabel();
		JSplitPane TopPanel =new JSplitPane();
		
		JPanel BottomPanel =new JPanel();
		JTextArea textArea=new JTextArea("Output Console:");
		MainFrame.setLayout(new BorderLayout());
		MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		MainFrame.add(SplitMainPanel);
		
		ImageLabel.setIcon(new ImageIcon("Board.jpg")); //has to be image_label
		
		TopPanel.setTopComponent(ImageLabel);
		
		SplitMainPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);//splits the screen length ways
		SplitMainPanel.setLeftComponent(TopPanel); // sets the contents of the top half of the frame
		SplitMainPanel.setRightComponent(BottomPanel);  // sets position of contents of the bottom half of the frame
		
		
		
		//Dice Roll//
		JButton Dice = new JButton("Roll Dice");
		Dice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				Random DiceRoll1 = new Random();
				int NumberOfDice1 = DiceRoll1.nextInt(6)+1;
				int NumberOfDice2 = (DiceRoll1.nextInt(6))+1;
				textArea.append("\n\nYou rolled:\n");
				textArea.append(NumberOfDice1 +"-"+NumberOfDice2);
				textArea.append("The total number of movable spaces is: "+(NumberOfDice1+NumberOfDice2));
			}
		});
		
		
		//tab//
		BottomPanel.add(Dice);
		JLabel InputConsole = new JLabel("Input Console"); //fills in content for the bottom half of the frame
		JTextField TextField = new JTextField(60); // makes the text field a little big bigger, however need to fix since it is not working at the moment
		BottomPanel.add(InputConsole);
		BottomPanel.add(TextField);
		JButton Submit = new JButton("Submit");
		BottomPanel.add(Submit);
		InputConsole.setFont(font);
		Submit.setFont(font);
		
		
		
		
		
		textArea.setFont(font);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		TopPanel.setBottomComponent(scrollPane);
		
		//Creating a character list//
				List<Cluedo_Character> Character_list = new ArrayList<Cluedo_Character>();
				List<Cluedo_Weapons>  WeaponList = new ArrayList<Cluedo_Weapons>();
				
				
				//only way i could think of, not a definate part of the code, let me know what you think//
				Cluedo_Character Mr_Green = new Cluedo_Character("Mr.Green");
				Cluedo_Character Miss_Scarlett = new Cluedo_Character("Miss Scarlett");
				Cluedo_Character Colonel_Mustard = new Cluedo_Character("Colonel Mustard");
				Cluedo_Character Mrs_White = new Cluedo_Character("Mrs.White");
				Cluedo_Character Mrs_Peacock = new Cluedo_Character("Mrs_Peacock");
				Cluedo_Character Prof_Plum = new Cluedo_Character("Professor Plum");
				
				//adding each of the new character Class objects to the List//
				Character_list.add(Mr_Green);
				Character_list.add(Miss_Scarlett);
				Character_list.add(Colonel_Mustard);
				Character_list.add(Mrs_White);
				Character_list.add(Mrs_Peacock);
				Character_list.add(Prof_Plum);
				
				
				//creating the weapons//
				Cluedo_Weapons CandleStick = new Cluedo_Weapons("CandleStick","CandleStick.jpg");
				Cluedo_Weapons Knife = new Cluedo_Weapons("Knife","Knife.jpg");
				Cluedo_Weapons Revolver = new Cluedo_Weapons("Revolver","Revolver.jpeg");
				Cluedo_Weapons Rope = new Cluedo_Weapons("Rope","rope.jpeg");
				Cluedo_Weapons Wrench = new Cluedo_Weapons("Wrench","Wrench.jpeg");
				Cluedo_Weapons leadPipe = new Cluedo_Weapons("Lead Pipe","leadpipe.png");
				
				WeaponList.add(CandleStick);
				WeaponList.add(Knife);
				WeaponList.add(Revolver);
				WeaponList.add(Rope);
				WeaponList.add(Wrench);
				WeaponList.add(leadPipe);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//printing out the characters to the text area//
				textArea.append("Here is a list of characters!\n");//this is how we put infor onto the text area//
					
				for(int i = 0;i<Character_list.size();i++) {
					textArea.append(Character_list.get(i).toString());
					textArea.append("\n");
				}
				
				textArea.append("\n\nEnter a command, then hit that submit button!\n");		

				Submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String input_text = TextField.getText();
						textArea.append("\n\nYou entered:\n");
						textArea.append(input_text);
					}
				});
				
		
				
				
				
				textArea.append("Here is a list of Weapons!\n");//this is how we put infor onto the text area//
				
				for(int i = 0;i<WeaponList.size();i++) {
					textArea.append(WeaponList.get(i).toString());
					textArea.append("\n");
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		//GridLayout//
				
		//Dice Roll//
			
		
		
		
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	
}
	

