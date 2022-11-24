package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PauseMenuSprite implements Sprite {

	Font font = new Font("Victor's Pixel Font", Font.PLAIN, 40);
	
	@Override
	public void update() {
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(500, 250, 600, 300);
		g.setColor(Color.WHITE);
		g.fillRect(506, 256, 588, 288);
		
		g.setColor(Color.BLACK); 
		g.setFont(font);
		g.drawString("RESUME - SPACE", 620, 350);
		g.drawString("MAIN MENU - ENTER", 600, 470);
	}

}
