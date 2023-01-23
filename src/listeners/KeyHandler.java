package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import logic.GameEngine;

public class KeyHandler implements KeyListener{

	public static boolean wPressed = false;
	public static boolean sPressed = false;
	public static boolean aPressed = false;
	public static boolean dPressed = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			GameEngine.PROGRAM_STATE = GameEngine.GAME_STATE;
			break;
		case KeyEvent.VK_W:
			wPressed = true;
			break;
		case KeyEvent.VK_S:
			sPressed = true;
			break;
		case KeyEvent.VK_A:
			aPressed = true;
			break;
		case KeyEvent.VK_D:
			dPressed = true;
			break;
		case KeyEvent.VK_F1:
			if(GameEngine.debug) {
				GameEngine.debug = false;
			} else {
				GameEngine.debug = true;
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			wPressed = false;
			break;
		case KeyEvent.VK_S:
			sPressed = false;
			break;
		case KeyEvent.VK_A:
			aPressed = false;
			break;
		case KeyEvent.VK_D:
			dPressed = false;
			break;
		}
	}
}
