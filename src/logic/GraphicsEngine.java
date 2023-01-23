package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import entities.Entity;
import listeners.KeyHandler;
import listeners.MouseHandler;

public class GraphicsEngine implements Runnable {

	private GameCanva gameCanva;
	private Thread graphicsThread;
	private KeyHandler keyH;
	private MouseHandler mouseH;
	
	public GraphicsEngine(GameCanva gameCanva, KeyHandler keyH, MouseHandler mouseH) {
		this.gameCanva = gameCanva;
		this.keyH = keyH;
		this.mouseH = mouseH;
		
		this.graphicsThread = new Thread(this);
		this.graphicsThread.start();
	}
	@Override
	public void run() {
		while (true) {
			gameCanva.repaint();
		}
	}

	public void draw(Graphics2D g2) {
		if (GameEngine.PROGRAM_STATE == GameEngine.MENU_STATE) {
			drawMenu(g2);
		} else {
			drawGame(g2);
		}
	}
	
	private void drawMenu(Graphics2D g2) {
		
	}
	
	private void drawGame(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		g2.fillRect(100, 100, 100, 100);
		
		g2.drawString(keyH.getPressedKeyName(), 200, 200);
		for(Entity e: GameEngine.entities) {
			e.draw(g2);
		}
	}
}
