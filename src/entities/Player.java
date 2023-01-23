package entities;

import java.awt.Color;
import java.awt.Rectangle;

import logic.GameCanva;
import maps.Map;

public class Player extends Entity {

	protected int movementSpeed = 4;
	protected Color playerColor = Color.BLUE;
	
	protected float forceUp = 0f;
	protected float forceDown = 0f;
	protected float forceLeft = 0f;
	protected float forceRight = 0f;
	
	public Player(int tileX, int tileY) {
		super(tileX, tileY);
		this.entityTexture = new Rectangle(GameCanva.APP_DIMENSION.width / 2 - (GameCanva.TILE_WIDTH / 2), GameCanva.APP_DIMENSION.height / 2 - (GameCanva.TILE_HEIGHT / 2), GameCanva.TILE_WIDTH, GameCanva.TILE_HEIGHT);
	}
	
	private void resetForces() {
		this.forceUp = 0f;
		this.forceDown = 0f;
		this.forceLeft = 0f;
		this.forceRight = 0f;
	}
	public void moveUp() {
		resetForces();
		this.forceUp = this.movementSpeed;
	}
	public void moveDown() {
		resetForces();
		this.forceDown = this.movementSpeed;
	}
	public void moveLeft() {
		resetForces();
		this.forceLeft = this.movementSpeed;
	}
	public void moveRight() {
		resetForces();
		this.forceRight = this.movementSpeed;
	}
	
	public void update() {
		if (this.forceUp != 0) {
			this.worldY -= this.forceUp;
			Map.mapScreenY += this.forceUp;
			this.forceUp -= 0.5f;
		}
		if (this.forceDown != 0) {
			this.worldY += this.forceDown;
			Map.mapScreenY -= this.forceDown;
			this.forceDown -= 0.5f;
		}
		if (this.forceLeft != 0) {
			this.worldX -= this.forceLeft;
			Map.mapScreenX += this.forceLeft;
			this.forceLeft -= 0.5f;
		}
		if (this.forceRight != 0) {
			this.worldX += this.forceRight;
			Map.mapScreenX -= this.forceRight;
			this.forceRight -= 0.5f;
		}
		
		this.tileX = (this.worldX + (GameCanva.TILE_WIDTH / 2)) / GameCanva.TILE_WIDTH;
		this.tileY = (this.worldY + (GameCanva.TILE_HEIGHT / 2)) / GameCanva.TILE_HEIGHT;
		
	}

}
