package data;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.newdawn.slick.util.ResourceLoader;

public class Audio {

	public static void makeAudio(){
		try{
			InputStream in = ResourceLoader.getResourceAsStream("res/dp_frogger.mp3");
			Clip clip = AudioSystem.getClip();
			// getAudioInputStream() also accepts a File or InputStream
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.
						getAudioInputStream(in);
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					// A GUI element to prevent the Clip's daemon Thread
					// from terminating at the end of the main()
					JOptionPane.showMessageDialog(null, "Close to exit!");
				}
			});
		}catch(IOException e){
			e.printStackTrace();
		}catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}