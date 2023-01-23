package logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import listeners.KeyHandler;
import listeners.MouseHandler;

public class GameCanva extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Screen Width and Height
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	// Dimension of this app (Of this JPanel)
	public static final Dimension APP_DIMENSION = new Dimension(SCREEN_WIDTH - 100, SCREEN_HEIGHT - 100);
	
	// Tile Width and Height
	public static final int TILE_WIDTH = APP_DIMENSION.width / 16;
	public static final int TILE_HEIGHT = APP_DIMENSION.height / 9;

	// Graphics engine
	private GraphicsEngine graphicsEngine;
	// Game engine
	private GameEngine gameEngine;
	
	// Input Handlers
	private KeyHandler keyH = new KeyHandler();
	private MouseHandler mouseH = new MouseHandler();
	
	public GameCanva() {
		this.setPreferredSize(APP_DIMENSION);
		
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		
		this.setVisible(true);
		
		this.graphicsEngine = new GraphicsEngine(this, keyH, mouseH);
		this.gameEngine = new GameEngine(keyH, mouseH);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		graphicsEngine.draw(g2);
		g2.dispose();
	}
}
