package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import entities.Entity;
import entities.MyPlayer;
import listeners.KeyHandler;
import listeners.MouseHandler;

public class GraphicsEngine implements Runnable {

	private GameCanva gameCanva;
	private Thread graphicsThread;
	private static final int FPS = 60;
	private static final double drawInterval = 1000000000 / FPS;
	
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
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		
		//TODO: Check if character created if yes then change gameState to 1
		
		while (this.graphicsThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				gameCanva.repaint();
				delta--;
			}
			
			if (timer >= 1000000000) {
				timer = 0;
			}
		}
	}

	public void draw(Graphics2D g2) {
		if (GameEngine.PROGRAM_STATE == GameEngine.MENU_STATE) {
			drawMenu(g2);
		} else {
			drawGame(g2);
			if (GameEngine.debug) {
				drawDebug(g2);
			}
		}
	}
	
	private void drawDebug(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		for(Entity e: GameEngine.entities) {
			if (e instanceof MyPlayer) {
				g2.drawString("worldX: " + e.worldX, 10, 10);
				g2.drawString("worldY: " + e.worldY, 10, 60);
			}
		}
	}
	
	private void drawMenu(Graphics2D g2) {
		
	}
	
	private void drawGame(Graphics2D g2) {
		for(Entity e: GameEngine.entities) {
			e.draw(g2);
		}
	}
}
