import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import java.io.IOException;

@SuppressWarnings("serial")
//A method to store processes carried out on the Cluedo Board
public class BoardPanel extends JPanel {
	
	//An array of integer variables holding the starting coordinates for each character token
	private int Xcoordinates[] = { 236, 343, 538, 538, 44, 193 };
	private int Ycoordinates[] = { 25, 25, 154, 436, 392, 540 };
	
	private int diameter_of_tokens = 16; //Sets the size of each token
	
	//the BufferedImage variables represent the images that will be displayed on the top left part of the main frame
	private BufferedImage boardImage;    
	private BufferedImage Wrench;       
	private BufferedImage Rope;
	private BufferedImage Knife;
	private BufferedImage CandleStick;
	private BufferedImage Revolver;
	private BufferedImage LeadPipe;

	public BoardPanel() {

		try {
			//Retrieves a specific named Resource (in this case our images) from the "resources" file...
			//...retrieves its state at runtime and is read by the program
			boardImage = ImageIO.read(this.getClass().getResource("/resources/cluedo board.jpg")); 
			Wrench = ImageIO.read(this.getClass().getResource("/resources/wrench.png"));
			Rope = ImageIO.read(this.getClass().getResource("/resources/rope.png"));
			Knife = ImageIO.read(this.getClass().getResource("/resources/knife.png"));
			CandleStick = ImageIO.read(this.getClass().getResource("/resources/candlestick.png"));
			Revolver = ImageIO.read(this.getClass().getResource("/resources/revolver.png"));
			LeadPipe = ImageIO.read(this.getClass().getResource("/resources/leadpipe.png"));
		} catch (IOException ignored) {
		}
		this.refresh();
	}
	//Method used to create the structure for the board panel.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; //Incorporates functions from the Graphics2D method.
		g2.drawImage(boardImage, 0, 0, 600, 600, this); //The board is drawn with the image to be used, the x and y coordinates and a size for the witdth and height of the panel.

		//Ellipse2D  creates a circular shape for each character token...
		//...and is held in the variable ellipse with calling values from the 0th location in the array of integer coordinates and the 16 diameter.
		Ellipse2D.Double ellipse = new Ellipse2D.Double(Xcoordinates[0], Ycoordinates[0], diameter_of_tokens, diameter_of_tokens);
		
		
		Graphics2D Ms_Scarlet = (Graphics2D) g; //A new Graphics2D variable is defined...
		Ms_Scarlet.setColor(Color.BLACK);
		Ms_Scarlet.setColor(Color.RED); // set to the colour purple using a mixture of black and red colours...
		Ms_Scarlet.fill(ellipse); //...and the token is filled in with this colour.

		Graphics2D Mr_Green = (Graphics2D) g; //A new Graphics2D variable is defined for Mr Green's token...
		Mr_Green.setColor(Color.GREEN); // set to the colour green...
		Mr_Green.fill(new Ellipse2D.Double(Xcoordinates[1], Ycoordinates[1], diameter_of_tokens, diameter_of_tokens)); //...and the token is filled in with this colour and set to its starting coordinates

		Graphics2D Colonel_Mustard = (Graphics2D) g; //A new Graphics2D variable is defined for Colonel Mustard's token...
		Colonel_Mustard.setColor(Color.YELLOW); //set to the colour yellow...
		Colonel_Mustard.fill(new Ellipse2D.Double(Xcoordinates[2], Ycoordinates[2], diameter_of_tokens, diameter_of_tokens)); //...and the token is filled in with this colour and set to its starting coordinates

		Graphics2D Mrs_White = (Graphics2D) g; //A new Graphics2D variable is defined for Mrs White's token...
		Mrs_White.setColor(Color.WHITE);// set to the colour white...
		Mrs_White.fill(new Ellipse2D.Double(Xcoordinates[3], Ycoordinates[3], diameter_of_tokens, diameter_of_tokens)); //...and the token is filled in with this colour and set to its starting coordinates

		Graphics2D Mrs_Peacock = (Graphics2D) g; //A new Graphics2D variable is defined for Mrs Peacock's token...
		Mrs_Peacock.setColor(Color.BLUE); // set to the colour blue...
		Mrs_Peacock.fill(new Ellipse2D.Double(Xcoordinates[4], Ycoordinates[4], diameter_of_tokens, diameter_of_tokens)); //...and the token is filled in with this colour and set to its starting coordinates

		Graphics2D Prof_Plum = (Graphics2D) g; //A new Graphics2D variable is defined for Professor Plum's token...
		Prof_Plum.setColor(Color.PINK); //set to the colour pink...
		Prof_Plum.fill(new Ellipse2D.Double(Xcoordinates[5], Ycoordinates[5], diameter_of_tokens, diameter_of_tokens)); //...and the token is filled in with this colour and set to its starting coordinates

		
		//The images for the weapons are placed in their specific coordinates on the board and set to a certain size.
		g2.drawImage(Wrench, 70, 294, 40, 40, null);
		g2.drawImage(Rope, 447, 374, 40, 40, null);
		g2.drawImage(Knife, 70, 294, 40, 40, null);
		g2.drawImage(CandleStick, 520, 62, 40, 40, null);
		g2.drawImage(Revolver, 69, 536, 40, 40, null);
		g2.drawImage(LeadPipe, 292, 155, 40, 40, null);

		return;
	}

	public void refresh() { //method for refresh() above
		revalidate(); //Ensures any changes to the board are made aware of and...
		repaint(); //...are repainted onto the board panel.
		return;
	}

	// total number of moves
	
	// total distance moved in 1 move
	private int ONE_MOVE_DISTANCE = 20;

	
	
	public void move(String input) { //A method required to move the tokens across the board.

		if (input.equalsIgnoreCase("L")) { // If the string that the player has typed has the upper (L) or lower (l) case letter...
			Xcoordinates[0] -= ONE_MOVE_DISTANCE; //the integer array of x coordinates sets the initial position of each token to zero and negates it by 1 along the x-axis.
			
		} else if (input.equalsIgnoreCase("R")) { // If the string that the player has typed has the upper (R) or lower (r) case letter...
			Xcoordinates[0] += ONE_MOVE_DISTANCE; //the integer array of x coordinates sets the initial position of each token to zero and increases it by 1 along the x-axis.
		
		} else if (input.equalsIgnoreCase("U")) { // If the string that the player has typed has the upper (U) or lower (u) case letter...
			Ycoordinates[0] -= ONE_MOVE_DISTANCE; //the integer array of y coordinates sets the initial position of each token to zero and increases it by 1 along the x-axis.
			
		} else if (input.equalsIgnoreCase("D")) { // If the string that the player has typed has the upper (D) or lower (d) case letter...
			Ycoordinates[0] += ONE_MOVE_DISTANCE; //the integer array of y coordinates sets the initial position of each token to zero and negates it by 1 along the x-axis.
			
		}
		refresh();
		
	}
	
}
