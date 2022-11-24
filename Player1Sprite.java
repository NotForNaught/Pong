package pong;

import java.awt.Graphics;

public class Player1Sprite implements Sprite {

	private int x = 40;
	private int y = 313;
	
	@Override
	public void update() {
	}
	
	public void update(Input input) {
		if (input.isW() && y >= 10) {
			y -= 4;
		}
		if (input.isS() && y <= 650) {
			y += 4;
		}
	}
	
	public int getY() {
		return y;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, 15, 140);
	}

}
