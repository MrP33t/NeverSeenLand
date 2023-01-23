package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import logic.GameEngine;

public class KeyHandler implements KeyListener{

	private char pressedKey = ' ';
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.pressedKey = e.getKeyChar();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			GameEngine.PROGRAM_STATE = GameEngine.GAME_STATE;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.pressedKey = ' ';
	}

	public String getPressedKeyName() {
		return Character.toString(this.pressedKey);
	}
}
