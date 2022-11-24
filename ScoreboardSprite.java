package pong;

import java.awt.Font;
import java.awt.Graphics;

public class ScoreboardSprite implements Sprite {

	Font font = new Font("Victor's Pixel Font", Font.PLAIN, 100);

	private int player1points = 0;
	private int player2points = 0;
	
	@Override
	public void update() {
	}

	public int getPlayer1points() {
		return player1points;
	}

	public void setPlayer1points(int player1points) {
		this.player1points = player1points;
	}

	public int getPlayer2points() {
		return player2points;
	}

	public void setPlayer2points(int player2points) {
		this.player2points = player2points;
	}

	@Override
	public void paint(Graphics g) {
		g.setFont(font);
		g.drawString(Integer.toString(player1points), 700, 80);
		g.drawString(Integer.toString(player2points), 850, 80);
	}

}
