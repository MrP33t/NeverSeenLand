package maps;

import entities.MyPlayer;
import logic.GameCanva;

public class Map {
	public static int[][] type2DTable;
	public static int mapScreenX = 0;
	public static int mapScreenY = 0;
	public static void createMap(MyPlayer myPlayer) {
		mapScreenX += GameCanva.APP_DIMENSION.width / 2 - (GameCanva.TILE_WIDTH / 2) - (myPlayer.tileX * GameCanva.TILE_WIDTH);
		mapScreenY += GameCanva.APP_DIMENSION.height / 2 - (GameCanva.TILE_HEIGHT / 2) - (myPlayer.tileY * GameCanva.TILE_HEIGHT);
		type2DTable = new int[64][64];
		for (int[] x: type2DTable) {
			for (int y: x) {
				y = 0;
			}
		}
	}
}
