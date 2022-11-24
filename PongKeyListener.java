package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongKeyListener implements KeyListener {

	Input input = new Input();
	
	public PongKeyListener(Input input) {
		this.input = input;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 27) {
			input.setEscape(true);
			System.out.println("escape");
		}
		if (e.getKeyChar() == 32) {
			input.setSpace(true);
			System.out.println("space");
		}
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			input.setEnter(true);
			System.out.println("enter");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'w') {
			input.setW(true);
		}
		if (e.getKeyChar() == 's') {
			input.setS(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			input.setUp(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			input.setDown(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 'w') {
			input.setW(false);
		}
		if (e.getKeyChar() == 's') {
			input.setS(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			input.setUp(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			input.setDown(false);
		}
	}

}
