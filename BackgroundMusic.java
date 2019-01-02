import java.io.*;
import javax.sound.sampled.*;

/**
	The SimpleSoundPlayer encapsulates a sound that can be opened
	from the file system and later played.
*/
public class BackgroundMusic implements Runnable  {

	private AudioFormat format;
	private byte[] samples;
	private String bgmusicFileName;

	/**
		Opens a sound from a file.
	*/
	
	public BackgroundMusic(String file){
		bgmusicFileName = file;
	}
	
	public void run(){
		while (true){
			// load a sound
			SimpleSoundPlayer sound =
					new SimpleSoundPlayer(bgmusicFileName);

				// create the stream to play
			InputStream stream =
					new ByteArrayInputStream(sound.getSamples());

			// play the sound
			sound.play(stream);
		}
	}

}
