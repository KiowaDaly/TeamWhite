import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

// class handles the Board
public class BoardFrame extends JPanel{

	private int coordinates[]={100,125,150,175,200,225,250};//select the initial coordinates
	private Color colors[]={Color.RED,Color.BLUE,Color.YELLOW,Color.BLACK,Color.CYAN,Color.GREEN};//select the color of tokens 
    private String weapon_names[]={"Wrench","Rope","Knife","Candlestick","Revolver","Poison"};
	private BufferedImage boardImage;       //sImage

    public BoardFrame() {

        try {
            boardImage = ImageIO.read(new File("board.jpg"));                                                            // scale the image
        } catch (IOException ignored) {}
                             // create the Board Frame
        this.refresh();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(boardImage, 0, 0, 750, 750, this);
        for (int p=0; p<6; p++){
	        g2.setColor(Color.BLACK);
            Ellipse2D.Double outline = new Ellipse2D.Double(coordinates[p],coordinates[p],2*8,2*8);
            g2.fill(outline);
            Ellipse2D.Double ellipse = new Ellipse2D.Double(coordinates[p]+1,coordinates[p]+1,2*8-2,2*8-2);
            g2.setColor(colors[p]);
            g2.fill(ellipse);
    
        }
        for(int i =0;i<6;i++)
        {
        	g2.setColor(colors[5-i]);
      
        	g2.drawString(weapon_names[i],coordinates[i]+12, coordinates[i]+25);
        }
		return;
    }
    
    public void refresh () {
		revalidate();
		repaint();
		return;
    }}
