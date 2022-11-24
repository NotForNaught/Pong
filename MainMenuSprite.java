package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MainMenuSprite implements Sprite {

	Font font140 = new Font("Victor's Pixel Font", Font.PLAIN, 140);
	Font font = new Font("Victor's Pixel Font", Font.PLAIN, 50);
	Font font30 = new Font("Victor's Pixel Font", Font.PLAIN, 30);


	
	private int paddle1x = 40;
	private int paddle1y = 313;
	private int paddle2x = 1545;
	private int paddle2y = 313;
	private int poy = 170;
	private int ngy = 240;
	private boolean switch1 = false;
	private boolean switch2 = true;
	private int loop = 0;
	
	@Override
	public void update() {
		if (paddle1y <= 100) {
			switch1 = true;
		} 
		if (paddle1y >= 560) {
			switch1 = false;
		}
		if (switch1) {
			paddle1y += 4;
		} else if (!switch1) {
			paddle1y -= 4;
		}
		
		if (paddle2y <= 100) {
			switch2 = true;
		} 
		if (paddle2y >= 560) {
			switch2 = false;
		}
		if (switch2) {
			paddle2y += 4;
		} else if (!switch2) {
			paddle2y -= 4;
		}
		loop++;
		
		if (loop == 30) {
			poy = 240;
			ngy = 170;
		} else if (loop == 60) {
			poy = 170;
			ngy = 240;
			loop = 0;
		}
		
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(paddle1x, paddle1y, 15, 140);
		g.fillRect(paddle2x, paddle2y, 15, 140);
		g.setColor(Color.WHITE);
		g.fillRect(794, 5, 12, 790);
		g.setColor(Color.BLACK);
		g.setFont(font140);
		g.drawString("P", 610, poy);
		g.drawString("O", 710, ngy);
		g.drawString("N", 810, poy);
		g.drawString("G", 910, ngy);
		g.setFont(font);
		g.drawString("START GAME - SPACE", 520, 450);
		g.drawString("EXIT GAME - ESCAPE", 540, 600);
		g.setFont(font30);
		g.drawString("Player 1 is controlled", 80, 80);
		g.drawString("with w and s. Player 2", 80, 115);
		g.drawString("is controlled with the", 80, 150);
		g.drawString("arrow keys.", 80, 185);
		g.drawString("Press escape while", 1125, 80);
		g.drawString("playing to pause the", 1125, 115);
		g.drawString("game.", 1125, 150);
	}

}
