import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TeamWhiteSplashScreen extends JWindow {
	private BorderLayout borderLayout;
	private JLabel imgLabel;
	private JPanel southPanel;
	private FlowLayout southFlow;
	private JProgressBar progressBar;
	private ImageIcon imageIcon;
	
	
	public TeamWhiteSplashScreen() {
		try {
			this.imageIcon = new ImageIcon(ImageIO.read(this.getClass().getResource("cluedo board.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		borderLayout = new BorderLayout();
		imgLabel = new JLabel();
		southPanel = new JPanel();
		southFlow = new FlowLayout();
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		try {
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private void init() throws Exception{
		imgLabel.setIcon(imageIcon);
		getContentPane().setLayout(borderLayout);
		southPanel.setLayout(southFlow);
		southPanel.setBackground(Color.BLACK);
		getContentPane().add(imgLabel,BorderLayout.CENTER);
		getContentPane().add(southPanel,BorderLayout.SOUTH);
		southPanel.add(progressBar,null);
		pack();
	}
	public void setMaxProgress(int maxProgress) {
		progressBar.setMaximum(maxProgress);	
	}
	public void setprogress(int progress) {
		float percentage = ((float) progress/(float)progressBar.getMaximum())*100;
	
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				progressBar.setValue(progress);
				progressBar.setString("Loading: "+percentage+"%");
			}
			
		});
		
		
	}
	
}