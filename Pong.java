package pong;

import java.awt.Graphics;
import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Pong extends JFrame {
	
	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		Input input = new Input();
		List<Sprite> gameSprites = new ArrayList<Sprite>();
		Player1Sprite player1 = new Player1Sprite();
		gameSprites.add(player1);
		Player2Sprite player2 = new Player2Sprite();
		gameSprites.add(player2);
		BallSprite ball = new BallSprite();
		gameSprites.add(ball);
		ScoreboardSprite scoreboard = new ScoreboardSprite();
		gameSprites.add(scoreboard);
		
		List<Sprite> pauseMenuSprites = new ArrayList<Sprite>();
		PauseMenuSprite pauseMenu = new PauseMenuSprite();
		pauseMenuSprites.add(pauseMenu);
		
		List<Sprite> mainMenuSprites = new ArrayList<Sprite>();
		MainMenuSprite mainMenu = new MainMenuSprite();
		mainMenuSprites.add(mainMenu);
		
		String gameState = "mainmenu";
		
		JFrame window = new JFrame("Pong");
		window.setSize(1600, 800);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setUndecorated(true);
		window.setVisible(true);
		PongPanel panel = new PongPanel();
		panel.addKeyListener(new PongKeyListener(input));
		panel.setFocusable(true);
		panel.requestFocus();
		window.getContentPane().add(panel);
		window.revalidate();
		
		
		long last = 0;
		while (true) {
			if (System.currentTimeMillis() - last > 17) {
				last = System.currentTimeMillis();
				if (gameState == "game") {
					// update world
					for (Sprite s : gameSprites) {
						s.update();
					}
					
					player1.update(input);
					player2.update(input);
					
					ball.set1Y(player1.getY());
					ball.set2Y(player2.getY());
					
					if (ball.isUpdate1()) {
						scoreboard.setPlayer1points(scoreboard.getPlayer1points() + 1);
						ball.setUpdate1(false);
					} else if (ball.isUpdate2()) {
						scoreboard.setPlayer2points(scoreboard.getPlayer2points() + 1);
						ball.setUpdate2(false);
					}
							
					if (input.isEscape()) {
						gameState = "pausemenu";
						input.setEscape(false);
					}
					
					// draw
					panel.setSprites(gameSprites);
					panel.repaint();
				} else if (gameState == "pausemenu") {
					
					for (Sprite s : pauseMenuSprites) {
						s.update();
					}
					
					if (input.isEscape()) {
						input.setEscape(false);
					}
					
					if (input.isSpace()) {
						gameState = "game";
						input.setSpace(false);
					}
					if (input.isEnter()) {
						gameState = "mainmenu";
						input.setEnter(false);
					}
					
					panel.setSprites(pauseMenuSprites);
					panel.repaint();
					
				} else if (gameState == "mainmenu") {
					for (Sprite s : mainMenuSprites) {
						s.update();
					}
					
					if (input.isEscape()) {
						window.setVisible(false);
						System.exit(ABORT);
					}
					if (input.isSpace()) {
						gameState = "game";
						input.setSpace(false);
					}
					
					panel.setSprites(mainMenuSprites);
					panel.repaint();
				}
			} else {
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException iExc) {
					// suppress, we don't care
				}
			}
		}
	}

}
