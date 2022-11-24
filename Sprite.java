package pong;

import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface Sprite {

	public void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	public void paint(Graphics g);
	
}
