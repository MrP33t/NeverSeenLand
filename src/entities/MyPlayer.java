package entities;

import logic.GameCanva;
import logic.GameEngine;

public class MyPlayer extends Player{

	public static double playerRotation = 0;
	public MyPlayer(int worldX, int worldY) {
		super(worldX, worldY);
		this.type = 1;
	}

	public static double getRotation() {
		// TODO Auto-generated method stub
		double a, b, tg;
		double centerX = GameCanva.APP_DIMENSION.width / 2;
		double centerY = GameCanva.APP_DIMENSION.height / 2;
		boolean up, left;
		double rotation;
		if (GameEngine.mouseX <= centerX) {
			b = centerX - GameEngine.mouseX;
			left = true;
		} else {
			b = GameEngine.mouseX - centerX;
			left = false;
		}
		if (GameEngine.mouseY <= centerY) {
			a = centerY - GameEngine.mouseY;
			up = true;
		} else {
			a = GameEngine.mouseY - centerY;
			up = false;
		}
		
		rotation = Math.toDegrees(Math.atan((a / b)));
		
		if (left && up) {
			playerRotation = rotation + 270;
			return rotation + 270;
		} else if (left && !up) {
			rotation = Math.toDegrees(Math.atan((b / a)));
			playerRotation = rotation + 180;
			return rotation + 180;
		} else if (!left && !up) {
			playerRotation = rotation + 90;
			return rotation + 90;
		} else {
			rotation = Math.toDegrees(Math.atan((b / a)));
			playerRotation = rotation;
			return rotation;
		}
	}
	
}
