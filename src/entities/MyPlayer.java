package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MyPlayer extends Player{

	public MyPlayer(int worldX, int worldY) {
		super(worldX, worldY);
		this.playerColor = Color.RED;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		if(entityTexture instanceof Rectangle) {
			g2.setColor(playerColor);
			g2.fill(entityTexture);
		}
	}
}
