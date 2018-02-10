import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Board {
	
	
	
	public static void main(String[] args){
		
		
		
		Font font = new Font("Myriad Black", Font.BOLD, 20); //Cluedo font with bold writing to make everything easier to read
		
		JFrame MainFrame = new JFrame("Cluedo by KRM");//creating the main frame with a title//
		JSplitPane SplitMainPanel=new JSplitPane(); //this allows us to splice the frame into smaller bits//
		//JLabel ImageLabel = new JLabel();
		JSplitPane TopPanel =new JSplitPane();
		Dimension minimumSize = new Dimension(750,650);
		JTabbedPane BottomPanel =new JTabbedPane();
		//BottomPanel.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
		JTextArea textArea=new JTextArea("Output Console:");
		MainFrame.setLayout(new BorderLayout());
		MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//MainFrame.setPreferredSize(new Dimension((int)FRAME_WIDTH,(int)FRAME_HEIGHT));
		MainFrame.add(SplitMainPanel);
		GridLayoutManager grid = new GridLayoutManager();
		
		SplitMainPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);//splits the screen length ways
		SplitMainPanel.setLeftComponent(TopPanel); // sets the contents of the top half of the frame
		SplitMainPanel.setRightComponent(BottomPanel);  // sets position of contents of the bottom half of the frame
		Container content = grid.getContentPane();
		TopPanel.setMinimumSize(minimumSize);
		
		
		BoardPanel imagePane = new BoardPanel();
		imagePane.setSize(600,600);
		
//		JLayeredPane  Layers = new JLayeredPane();
//		Layers.setPreferredSize(new Dimension(600, 600));
//		
//		Layers.add(content,JLayeredPane.DEFAULT_LAYER);
//	
//		Layers.setLayer(imagePane,JLayeredPane.PALETTE_LAYER);//THIS IS THE LAYER THE IMAGE SITS ON//
		
		
		
		TopPanel.setTopComponent(imagePane);
	 	imagePane.addMouseListener(new MouseListener(){
    		public void mouseClicked(MouseEvent e) {
    			double x = e.getX();
    	         double y = e.getY();
    	         System.out.println(x+","+y);
    		}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
		
		//JLabel kitchen = new JLabel();
		//kitchen.setIcon(new ImageIcon("cluedo board.jpg"));
		//TopPanel.add(kitchen);
		
		
		//first panel
		JPanel input_console = new JPanel();
		BottomPanel.addTab("Input Console", input_console);
		JTextField TextField = new JTextField(70); // makes the text field a little big bigger, however need to fix since it is not working at the moment
		input_console.add(TextField);
		JButton Submit = new JButton("Submit");
		input_console.add(Submit);
		input_console.setFont(font);
		Submit.setFont(font);
		
		//second panel
		JPanel characters = new JPanel();
		BottomPanel.addTab("Characters", characters);
		JTextArea character_names = new JTextArea();
		List<Cluedo_Character> Character_list = new ArrayList<Cluedo_Character>();
		Cluedo_Character Mr_Green = new Cluedo_Character("Mr.Green");
		Cluedo_Character Miss_Scarlett = new Cluedo_Character("Miss Scarlett");
		Cluedo_Character Colonel_Mustard = new Cluedo_Character("Colonel Mustard");
		Cluedo_Character Mrs_White = new Cluedo_Character("Mrs.White");
		Cluedo_Character Mrs_Peacock = new Cluedo_Character("Mrs_Peacock");
		Cluedo_Character Prof_Plum = new Cluedo_Character("Professor Plum");
		Character_list.add(Mr_Green);
		Character_list.add(Miss_Scarlett);
		Character_list.add(Colonel_Mustard);
		Character_list.add(Mrs_White);
		Character_list.add(Mrs_Peacock);
		Character_list.add(Prof_Plum);
		character_names.setFont(font);
		characters.add(character_names);
		character_names.append("Here is a list of characters!\n");//this is how we put information onto the text area//
		
		for(int i = 0;i<Character_list.size();i++) {
			character_names.append(Character_list.get(i).toString());
			character_names.append("\t\t");
		}
		
		
		//third panel
		JPanel weapons = new JPanel();
		BottomPanel.addTab("Weapons", weapons);
		List<Cluedo_Weapons>  WeaponList = new ArrayList<Cluedo_Weapons>();
		JTextArea weapon_names = new JTextArea();
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
		weapons.add(weapon_names);
		weapon_names.setFont(font);
		weapon_names.append("Here is a list of Weapons!\n");//this is how we put information onto the text area//
		
		for(int i = 0;i<WeaponList.size();i++) {
			weapon_names.append(WeaponList.get(i).toString());
			weapon_names.append("\t\t");
		}
		
		
		
		//fourth panel
		JPanel dice_roll = new JPanel();
		BottomPanel.addTab("Dice Roll", dice_roll);
		JButton roll_button = new JButton("Roll Those Dice!");
		dice_roll.add(roll_button);
		
		
		//Here are the action listeners//
		roll_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				Random DiceRoll1 = new Random();
				int NumberOfDice1 = DiceRoll1.nextInt(6)+1;
				int NumberOfDice2 = (DiceRoll1.nextInt(6))+1;
				textArea.append("\n\nYou rolled...\n");
				textArea.append("a " + NumberOfDice1 +" and a " +NumberOfDice2 +" !" + "\n");
				textArea.append("You can move " + (NumberOfDice1+NumberOfDice2) + " spaces!");
			}
		});
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input_text = TextField.getText();
				textArea.append("\n\nYou entered:\n");
				textArea.append(input_text);
				textArea.setCaretPosition(textArea.getDocument().getLength());
				TextField.setText("");
			}
		});
		//this listener reads in the text inputed by the player and performs the tasks//
		TextField.addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent ke) {
				if(ke.getKeyCode()==KeyEvent.VK_ENTER) {
					String input_text = TextField.getText();
					textArea.append("\n\nYou entered:\n");
					textArea.append(input_text);
					textArea.setCaretPosition(textArea.getDocument().getLength());
					TextField.setText("");
					
					if(input_text.equalsIgnoreCase("up")) {
						
					}
					if(input_text.equalsIgnoreCase("down")) {
						
					}
					if(input_text.equalsIgnoreCase("left")) {
						
					}
					if(input_text.equalsIgnoreCase("right")) {
						
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

		

		
		});
		
		textArea.setFont(font);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		TopPanel.setBottomComponent(scrollPane);
		
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	
}
