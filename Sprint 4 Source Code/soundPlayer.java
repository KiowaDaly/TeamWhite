import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class soundPlayer {
		soundPlayer(){
			
		}
	 public void playSound(String myFile) {
	    	try {
	    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(myFile).getAbsoluteFile());
	    		Clip clip = AudioSystem.getClip();
	    		clip.open(audioInputStream);
	    		clip.start();
	    	}catch(Exception ex) {
	    		System.out.println("File could not be played");
	    		ex.printStackTrace();
	    	}
	    	
	    }
}
