package logic;

import java.util.ArrayList;

import entities.Entity;
import entities.MyPlayer;
import listeners.KeyHandler;
import listeners.MouseHandler;

public class GameEngine implements Runnable{

	public static final int MENU_STATE = 0;
	public static final int GAME_STATE = 1;
	public static int PROGRAM_STATE = MENU_STATE;
	
	private Thread gameThread;
	private static final int FPS = 60;
	private static final double drawInterval = 1000000000 / FPS;
	
	
	
	private KeyHandler keyH;
	private MouseHandler mouseH;
	
	private MyPlayer myPlayer;
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public GameEngine(KeyHandler keyH, MouseHandler mouseH) {
		
		this.keyH = keyH;
		this.mouseH = mouseH;
		
		this.myPlayer = new MyPlayer(300, 300);
		entities.add(myPlayer);
		
		this.gameThread = new Thread(this);
		this.gameThread.start();
	}
	
	public void update() {
		this.myPlayer.update();
		switch(keyH.getPressedKeyName()) {
		case "w":
			this.myPlayer.moveUp();
			break;
		case "s":
			this.myPlayer.moveDown();
			break;
		case "a":
			this.myPlayer.moveLeft();
			break;
		case "d":
			this.myPlayer.moveRight();
			break;
		}
	}
	@Override
	public void run() {
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		
		//TODO: Check if character created if yes then change gameState to 1
		
		while (this.gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				delta--;
			}
			
			if (timer >= 1000000000) {
				timer = 0;
			}
		}
	}

}
