package logic;

import java.awt.Color;
import java.awt.Graphics2D;

public class GraphicsEngine implements Runnable {

	private GameCanva gameCanva;
	private Thread graphicsThread;
	
	public GraphicsEngine(GameCanva gameCanva) {
		this.gameCanva = gameCanva;
		
		this.graphicsThread = new Thread(this);
		this.graphicsThread.start();
	}
	@Override
	public void run() {
		gameCanva.repaint();
	}

	public void draw(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		g2.fillRect(100, 100, 100, 100);
	}
}
