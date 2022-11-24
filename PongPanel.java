package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class PongPanel extends JPanel {
	private List<Sprite> sprites;

	public void setSprites(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1600, 800);
		g.setColor(Color.BLACK);
		g.fillRect(794, 0, 12, 800);
		g.fillRect(0, 0, 1600, 5);
		g.fillRect(0, 0, 5, 800);
		g.fillRect(1595, 0, 5, 800);
		g.fillRect(0, 795, 1600, 5);
		if (sprites != null) {
			for (Sprite sprite : sprites) {
				sprite.paint(g);
				
			}
		}
	}	
}
