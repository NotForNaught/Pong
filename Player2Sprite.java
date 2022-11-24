package pong;

import java.awt.Graphics;

public class Player2Sprite implements Sprite {

	private int x = 1545;
	private int y = 313;
	
	@Override
	public void update() {
	}
	
	public void update(Input input) {
		if (input.isUp() && y >= 10) {
			y -= 4;
		}
		if (input.isDown() && y <= 650) {
			y += 4;
		}
	}
	
	public int getY() {
		return y;
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 15, 140);
	}

}
