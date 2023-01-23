package entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Entity {
	public int worldX;
	public int worldY;
	
	// Image or Rectangle
	protected Rectangle entityTexture;
	
	public Entity(int worldX, int worldY) {
		this.worldX = worldX;
		this.worldY = worldY;
	}
	
	public void draw(Graphics2D g2) {
		if(entityTexture instanceof Rectangle) {
			g2.fill(entityTexture);
		}
	}
}
