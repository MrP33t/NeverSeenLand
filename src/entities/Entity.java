package entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import logic.GameCanva;

public class Entity {
	public int worldX;
	public int worldY;
	public int tileX;
	public int tileY;
	public int screenX;
	public int screenY;
	
	protected int type = 0;
	
	protected BufferedImage entityImage;
	
	// Image or Rectangle
	protected Rectangle entityRectangle;
	
	public Entity(int tileX, int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.worldX = tileX * GameCanva.TILE_WIDTH;
		this.worldY = tileY * GameCanva.TILE_HEIGHT;
	}
	
	public void draw(Graphics2D g2) {
		if(this.entityRectangle instanceof Rectangle) {
			if (this.entityImage != null) {
				double rotation = 0;
				if (this.type == 1) {
					rotation = MyPlayer.getRotation();
					g2.rotate(Math.toRadians(rotation), GameCanva.APP_DIMENSION.width / 2, GameCanva.APP_DIMENSION.height / 2);
				}
				g2.drawImage(this.entityImage, this.entityRectangle.x, this.entityRectangle.y, this.entityRectangle.width, this.entityRectangle.height, null);
				g2.rotate(Math.toRadians(-rotation), GameCanva.APP_DIMENSION.width / 2, GameCanva.APP_DIMENSION.height / 2);
			}
		}
	}
}
