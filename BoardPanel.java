import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

// class handles the Board
public class BoardPanel extends JPanel {

	private int Xcoordinates[] = { 236, 343, 538, 538, 44, 193 };// select the
																	// initial
																	// coordinates
	private int Ycoordinates[] = { 25, 25, 154, 436, 392, 540 };
	private int Xcoordinates2[] = { 236, 343, 538, 538, 44, 193 };// select the
	// initial
	// coordinates
	private int Ycoordinates2[] = { 25, 25, 154, 436, 392, 540 };
	private int diameter_of_tokens = 16;
	private BufferedImage boardImage; // sImage
	private BufferedImage Wrench;
	private BufferedImage Rope;
	private BufferedImage Knife;
	private BufferedImage CandleStick;
	private BufferedImage Revolver;
	private BufferedImage LeadPipe;

	public BoardPanel() {

		try {
			boardImage = ImageIO.read(this.getClass().getResource("cluedo board.jpg")); // scale
																						// the
																						// image
			Wrench = ImageIO.read(this.getClass().getResource("wrench.png"));
			Rope = ImageIO.read(this.getClass().getResource("rope.png"));
			Knife = ImageIO.read(this.getClass().getResource("knife.png"));
			CandleStick = ImageIO.read(this.getClass().getResource("CandleStick.png"));
			Revolver = ImageIO.read(this.getClass().getResource("revolver.png"));
			LeadPipe = ImageIO.read(this.getClass().getResource("leadpipe.png"));
		} catch (IOException ignored) {
		}
		// create the Board Frame
		this.refresh();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(boardImage, 0, 0, 600, 600, this);

		Graphics2D Ms_Scarlet = (Graphics2D) g;
		Ms_Scarlet.setColor(Color.BLACK);

		Ellipse2D.Double ellipse = new Ellipse2D.Double(Xcoordinates[0], Ycoordinates[0], diameter_of_tokens,
				diameter_of_tokens);
		Ms_Scarlet.setColor(Color.RED);
		Ms_Scarlet.fill(ellipse);

		Graphics2D Mr_Green = (Graphics2D) g;
		Mr_Green.setColor(Color.GREEN);
		Mr_Green.fill(new Ellipse2D.Double(Xcoordinates[1], Ycoordinates[1], diameter_of_tokens, diameter_of_tokens));

		Graphics2D Colonel_Mustard = (Graphics2D) g;
		Colonel_Mustard.setColor(Color.YELLOW);
		Colonel_Mustard
				.fill(new Ellipse2D.Double(Xcoordinates[2], Ycoordinates[2], diameter_of_tokens, diameter_of_tokens));

		Graphics2D Mrs_White = (Graphics2D) g;
		Mrs_White.setColor(Color.WHITE);
		Mrs_White.fill(new Ellipse2D.Double(Xcoordinates[3], Ycoordinates[3], diameter_of_tokens, diameter_of_tokens));

		Graphics2D Mrs_Peacock = (Graphics2D) g;
		Mrs_Peacock.setColor(Color.BLUE);
		Mrs_Peacock
				.fill(new Ellipse2D.Double(Xcoordinates[4], Ycoordinates[4], diameter_of_tokens, diameter_of_tokens));

		Graphics2D Prof_Plum = (Graphics2D) g;
		Prof_Plum.setColor(Color.PINK);
		Prof_Plum.fill(new Ellipse2D.Double(Xcoordinates[5], Ycoordinates[5], diameter_of_tokens, diameter_of_tokens));

		g2.drawImage(Wrench, 70, 294, 40, 40, null);

		g2.drawImage(Rope, 447, 374, 40, 40, null);
		g2.drawImage(Knife, 70, 294, 40, 40, null);
		g2.drawImage(CandleStick, 520, 62, 40, 40, null);
		g2.drawImage(Revolver, 69, 536, 40, 40, null);
		g2.drawImage(LeadPipe, 292, 155, 40, 40, null);

		return;
	}

	public void refresh() {
		revalidate();
		repaint();
		return;
	}

	// total number of moves
	private int NO_OF_MOVES = 40;
	// total distance moved in 1 move
	private int ONE_MOVE_DISTANCE = 20;
	// array to store the movement of the players
	private char MOVE_PLAYERS[][] = {
			{ 'D', 'L', 'L', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
					'L' },
			{ 'D', 'R', 'R', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'L', 'L',
					'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'R', 'R', 'R', 'R', 'R', 'R', 'R',
					'R' },
			{ 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D',
					'D', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D',
					'D' },
			{ 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D',
					'D', 'D', 'D', 'D', 'D', 'D', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D',
					'D', },
			{ 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'U', 'U', 'U', 'U', 'U',
					'U', 'U', 'U', 'U', 'L', 'L', 'L', 'L', 'L', 'L', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D',
					'D', },
			{ 'U', 'R', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D',
					'D', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D',
					'D', } };
	//this method can be implemented//
	
	
	// method to move the tokens
	public void move(String input) {
//		while (true) {
//			for (int i = 0; i < NO_OF_MOVES; i++) {
//
//				for (int j = 0; j < 6; j++) {
//
//					// checks if the move is left, right, up or down and
//					// increments the coordinates accordingly
//					if (MOVE_PLAYERS[j][i] == 'L') {
//						Xcoordinates[j] -= ONE_MOVE_DISTANCE;
//					} else if (MOVE_PLAYERS[j][i] == 'R') {
//						Xcoordinates[j] += ONE_MOVE_DISTANCE;
//					} else if (MOVE_PLAYERS[j][i] == 'U') {
//						Ycoordinates[j] -= ONE_MOVE_DISTANCE;
//					} else if (MOVE_PLAYERS[j][i] == 'D') {
//						Ycoordinates[j] += ONE_MOVE_DISTANCE;
//					}
//				}
//				
//				//Sleep for a while 
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				//refresh the panel
//				refresh();
//			}
		
		if (input.equalsIgnoreCase("L")) {
			Xcoordinates[0] -= ONE_MOVE_DISTANCE;
			
		} else if (input.equalsIgnoreCase("R")) {
			Xcoordinates[0] += ONE_MOVE_DISTANCE;
		
		} else if (input.equalsIgnoreCase("U")) {
			Ycoordinates[0] -= ONE_MOVE_DISTANCE;
			
		} else if (input.equalsIgnoreCase("D")) {
			Ycoordinates[0] += ONE_MOVE_DISTANCE;
			
		}
		refresh();
		
		
		
		
			//setting back the coordinates to initial values
//			for (int i = 0; i < 6; i++) {
//				Xcoordinates[i] = Xcoordinates2[i];
//				Ycoordinates[i] = Ycoordinates2[i];
//			}
		}

	}
