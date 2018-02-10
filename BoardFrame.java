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
public class BoardPanel extends JPanel{

	private int Xcoordinates[]={239,354,546,545,52,194};//select the initial coordinates
	private int Ycoordinates[]={28,32,165,442,399,545};
	private Color colors[]={Color.RED,Color.BLUE,Color.YELLOW,Color.BLACK,Color.CYAN,Color.GREEN};//select the color of tokens 
  
	private BufferedImage boardImage;       //sImage
	private BufferedImage Wrench;
	private BufferedImage Rope;
	private BufferedImage Knife;
	private BufferedImage CandleStick;
	private BufferedImage Revolver;
	private BufferedImage LeadPipe;
	

    public BoardPanel() {

        try {
            boardImage = ImageIO.read(new File("cluedo board.jpg"));                                                            // scale the image
            Wrench = ImageIO.read(new File("wrench.png"));
            Rope = ImageIO.read(new File("rope.png"));
            Knife = ImageIO.read(new File("knife.png"));
            CandleStick = ImageIO.read(new File("CandleStick.png"));
            Revolver = ImageIO.read(new File("revolver.png"));
            LeadPipe = ImageIO.read(new File("leadpipe.png"));
        } catch (IOException ignored) {}
                             // create the Board Frame
        this.refresh();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(boardImage, 0, 0, 600, 600, this);
        
	     
        
       
        
        Graphics2D Ms_Scarlet = (Graphics2D) g;
        Ms_Scarlet.setColor(Color.BLACK);
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(239,34,14,14);
        Ms_Scarlet.setColor(Color.RED);
        Ms_Scarlet.fill(ellipse);
        
        
        
        Graphics2D Mr_Green = (Graphics2D) g;
        Mr_Green.setColor(Color.GREEN);
        Mr_Green.fill(new Ellipse2D.Double(355,34,16,16));
        
        
        
        Graphics2D Colonel_Mustard = (Graphics2D) g;
        Colonel_Mustard.setColor(Color.YELLOW);
        Colonel_Mustard.fill(new Ellipse2D.Double(547,166,16,16));
        
        
        
        
        Graphics2D Mrs_White = (Graphics2D) g;
        Mrs_White.setColor(Color.WHITE);
        Mrs_White.fill(new Ellipse2D.Double(547,443,16,16));
        
        
        
        
        
        Graphics2D Mrs_Peacock = (Graphics2D) g;
        Mrs_Peacock.setColor(Color.BLUE);
        Mrs_Peacock.fill(new Ellipse2D.Double(53,400,16,16));
        
        
        
        
        Graphics2D Prof_Plum = (Graphics2D) g;
        Prof_Plum.setColor(Color.PINK);
        Prof_Plum.fill(new Ellipse2D.Double(195,546,16,16));
        
        
        
        
        
       
        	
        	
        	
        	g2.drawImage(Wrench, 70, 294, 40, 40, null);
        	
        	g2.drawImage(Rope, 447, 374, 40, 40, null);
        	g2.drawImage(Knife,70, 294,40,40,null);
        	g2.drawImage(CandleStick,520, 62,40,40,null);
        	g2.drawImage(Revolver,69, 536,40,40,null);
        	g2.drawImage(LeadPipe,292, 155,40,40,null);
        
		return;
    }
    
    public void refresh () {
		revalidate();
		repaint();
		return;
    }}
