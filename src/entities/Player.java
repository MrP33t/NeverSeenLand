package entities;

import java.awt.Color;
import java.awt.Rectangle;

public class Player extends Entity {

	protected int movementSpeed = 4;
	protected Color playerColor = Color.BLUE;
	
	public Player(int worldX, int worldY) {
		super(worldX, worldY);
		this.entityTexture = new Rectangle(worldX, worldY, 200, 200);
	}
	
	public void moveUp() {
		this.worldY -= this.movementSpeed;
	}
	public void moveDown() {
		this.worldY += this.movementSpeed;
	}
	public void moveRight() {
		this.worldX += this.movementSpeed;
	}
	public void moveLeft() {
		this.worldX -= this.movementSpeed;
	}
	
	public void update() {
		this.entityTexture.x = worldX;
		this.entityTexture.y = worldY;
	}

}
