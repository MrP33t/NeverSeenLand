package entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import logic.GameCanva;

public class Entity {
	public int worldX;
	public int worldY;
	public int tileX;
	public int tileY;
	public int screenX;
	public int screenY;
	
	// Image or Rectangle
	protected Rectangle entityTexture;
	
	public Entity(int tileX, int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.worldX = tileX * GameCanva.TILE_WIDTH;
		this.worldY = tileY * GameCanva.TILE_HEIGHT;
	}
	
	public void draw(Graphics2D g2) {
		if(entityTexture instanceof Rectangle) {
			g2.fill(entityTexture);
		}
	}
}
