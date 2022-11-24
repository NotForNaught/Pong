package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BallSprite implements Sprite {

	private int x = 790;
	private int y = 390;
	private String state;
	private int player1y;
	private int player2y;
	private boolean update1 = false;
	private boolean update2 = false;
		
	public boolean isUpdate2() {
		return update2;
	}

	public void setUpdate2(boolean update2) {
		this.update2 = update2;
	}

	public boolean isUpdate1() {
		return update1;
	}

	public void setUpdate1(boolean update) {
		this.update1 = update;
	}

	public void set1Y(int y) {
		player1y = y;
	}
	
	public void set2Y(int y) {
		player2y = y;
	}
	
	public BallSprite() {
		int stateRandomizer = (int) (Math.random() * 4);
		if (stateRandomizer == 0) {
			state = "upleft";
		} else if (stateRandomizer == 1) {
			state = "upright";
		} else if (stateRandomizer == 2) {
			state = "downleft";
		} else if (stateRandomizer == 3) {
			state = "downright";
		}
	}
	
	@Override
	public void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (state == "upleft") {
			y -= 7;
			x -= 7;
		} else if (state == "upright") {
			y -= 7;
			x += 7;
		} else if (state == "downleft") {
			y += 7;
			x -= 7;
		} else {
			y += 7;
			x += 7;
		}
		
		if (y >= 775 && state == "downright") {
			state = "upright";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			x += (int) Math.random() * 150;
		} else if (y >= 775 && state == "downleft") {
			state = "upleft";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			x += (int) Math.random() * 150;
		} else if (y <= 25 && state == "upleft") {
			state = "downleft";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			x += (int) Math.random() * 150;
		} else if (y <= 25 && state == "upright") {
			state = "downright";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			x += (int) Math.random() * 150;
		} else if (x <= 55 && y >= player1y && y <= player1y + 140 && state == "upleft") {
			state = "upright";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			y += (int) Math.random() * 150;
		} else if (x <= 55 && y >= player1y && y <= player1y + 140 && state == "downleft") {
			state = "downright";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			y += (int) Math.random() * 150;
		} else if (x >= 1530 && y >= player2y && y <= player2y + 140 && state == "upright") {
			state = "upleft";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			y += (int) Math.random() * 150;
		} else if (x >= 1530 && y >= player2y && y <= player2y + 140 && state == "downright") {
			state = "downleft";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("paddlehit.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			y += (int) Math.random() * 150;
		} else if (x >= 1600) {
			update1 = true;
			x = 790;
			y = 390;
			int stateRandomizer = (int) (Math.random() * 4);
			if (stateRandomizer == 0) {
				state = "upleft";
			} else if (stateRandomizer == 1) {
				state = "upright";
			} else if (stateRandomizer == 2) {
				state = "downleft";
			} else if (stateRandomizer == 3) {
				state = "downright";
			}
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("point.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
		} else if (x <= 0) {
			update2 = true;
			x = 790;
			y = 390;
			int stateRandomizer = (int) (Math.random() * 4);
			if (stateRandomizer == 0) {
				state = "upleft";
			} else if (stateRandomizer == 1) {
				state = "upright";
			} else if (stateRandomizer == 2) {
				state = "downleft";
			} else if (stateRandomizer == 3) {
				state = "downright";
			}
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("point.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 19, 19);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, 20, 20);
	}

}
