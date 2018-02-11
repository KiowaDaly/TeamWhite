import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GridLayoutManager extends JFrame{
	

	private Container contents;	
	private JButton[][] tiles = new JButton[22][22];
	
	//upper left corner of board = (0,0)
	private int width_grid = 1;
	
	//constructor
	
	public GridLayoutManager() {
		super("Board");
		Color dark_orange = new Color(204, 102, 0);
		Color light_orange = new Color(255, 153, 51);
		contents = getContentPane();
		contents.setLayout(new GridLayout(22, 22));
		((JComponent) contents).setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		
		for(int i = 0; i < 22; i++) {
			for(int j = 0; j< 22; j++) {
				JLabel grid_lines = new JLabel("Label");
				grid_lines.setBorder(BorderFactory.createMatteBorder(width_grid, 0, width_grid, width_grid, Color.BLACK));
				tiles[i][j] = new JButton();
				if((i+j)%2 != 0) {
					tiles[i][j].setBackground(dark_orange);
				}
				else {
					tiles[i][j].setBackground(light_orange);
				}
				contents.add(tiles[i][j]);
				
			}
		}
		
		//placing images (rooms, starting points, dice) on board using GlassPane (since there are multiple components over the same space
		tiles[2][2].setIcon(new ImageIcon("Kitchen.png"));
		tiles[2][10].setIcon(new ImageIcon("Ballroom.png"));
		tiles[2][19].setIcon(new ImageIcon("Conservatory.png"));
		tiles[10][2].setIcon(new ImageIcon("DiningRoom.png"));
		tiles[10][10].setIcon(new ImageIcon("MurderScene.png"));
		tiles[7][19].setIcon(new ImageIcon("BilliardRoom.png"));
		tiles[12][19].setIcon(new ImageIcon("Library.png"));
		tiles[19][2].setIcon(new ImageIcon("Lounge.png"));
		tiles[19][10].setIcon(new ImageIcon("Hall.png"));
		tiles[19][19].setIcon(new ImageIcon("Study.png"));
	
		
		setSize(800,750);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
	
}
